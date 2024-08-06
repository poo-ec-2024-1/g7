/**
 * Classe que guarda as avaliações 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Review;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import com.lavamarket.Database.Database;

import java.util.List;
import java.util.ArrayList;

public class ReviewRepository
{
    private static Dao<Review, Integer> dao;
    private List<Review> loadedReviews;
    private Review loadedReview; 
    
    /**
     * Construtor da classe
     * 
     * @param database
     */
    public ReviewRepository(Database database) {
        ReviewRepository.setDatabase(database);
        loadedReviews = new ArrayList<Review>();
    }
    
    /**
     * Metodo que altera o banco de dados
     * 
     * @param database
     */
    public static void setDatabase(Database database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Review.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Review.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    /**
     * Metodo que cria o banco de dados
     * 
     * @param funcionario
     * @return
     */
    public Review create(Review funcionario) {
        int nrows = 0;
        try {
            nrows = dao.create(funcionario);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedReview = funcionario;
            loadedReviews.add(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return funcionario;
    }    

    /**
     * Metodo que atualiza o banco de dados
     * 
     * @param funcionario
     */
    public void update(Review funcionario) {
        try {
            dao.update(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo que deleta informações do banco de dados da avaliações
     * 
     * @param funcionario
     */
    public void delete(Review funcionario) {
        try{
            dao.delete(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Metodo que carrega as informações com base no id
     * 
     * @param id
     * @return
     */
    public Review loadFromId(int id) {
        try {
            this.loadedReview = dao.queryForId(id);
            if (this.loadedReview != null)
                this.loadedReviews.add(this.loadedReview);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReview;
    }
    
    /**
     * Metodo que carrega as informações da avaliação com base no usuario
     * 
     * @param usuario
     * @return
     */
    public Review loadFromUsuario(String usuario) {
        try {
            this.loadedReview = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedReview != null)
                this.loadedReviews.add(this.loadedReview);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReview;
    }
    
    /**
     * Metodo que carrega as avaliações pelo id da loja
     * 
     * @param id
     * @return
     */
    public List<Review> loadAllFromLojaId(int id){
        try {
            this.loadedReviews = dao.queryForEq("lavajato_id", id);
            if (this.loadedReviews.size() != 0)
                this.loadedReview = this.loadedReviews.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReviews;
    }
    
    /**
     * Metodo que carrega a partir do id do agendamento
     * 
     * @return
     */
    public Review loadFromAgendamentoId(int id) {
        try {
            this.loadedReview = dao.queryForEq("agendamento_id", id).get(0);
            if (this.loadedReview != null)
                this.loadedReviews.add(this.loadedReview);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReview;
    }
    
    /**
     * Metodo que carrega todas as informações
     * 
     * @return
     */
    public List<Review> loadAll() {
        try {
            this.loadedReviews =  dao.queryForAll();
            if (this.loadedReviews.size() != 0)
                this.loadedReview = this.loadedReviews.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReviews;
    }  
}

