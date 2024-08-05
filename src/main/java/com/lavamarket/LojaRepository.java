/**
 * Classe Repositorio da loja 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class LojaRepository
{
    private static Dao<Loja, Integer> dao;
    private List<Loja> loadedLojas;
    private Loja loadedLoja; 
    
    /**
     * Metodo construtor da classe
     * 
     * @param database
     */
    public LojaRepository(Database database) {
        LojaRepository.setDatabase(database);
        loadedLojas = new ArrayList<Loja>();
    }
    
    /**
     * Setter do banco de dados
     * 
     * @param database
     */
    public static void setDatabase(Database database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Loja.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Loja.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    /**
     * Metodoq que cria o repositorio da loja
     * 
     * @param loja
     * @return
     */
    public Loja create(Loja loja) {
        int nrows = 0;
        try {
            nrows = dao.create(loja);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedLoja = loja;
            loadedLojas.add(loja);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return loja;
    }    

    /**
     * Metodo que atualiza os dados da loja
     * 
     * @param loja
     */
    public void update(Loja loja) {
        try {
            dao.update(loja);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo que deleta a loja
     * 
     * @param loja
     */
    public void delete(Loja loja) {
        try{
            dao.delete(loja);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Metodo que carrega a loja pelo id
     * 
     * @param id
     * @return
     */
    public Loja loadFromId(int id) {
        try {
            this.loadedLoja = dao.queryForId(id);
            if (this.loadedLoja != null)
                this.loadedLojas.add(this.loadedLoja);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedLoja;
    }

    /**
     * Metodo que carrega loja pelo usuario
     * 
     * @param usuario
     * @return
     */
    public Loja loadFromUsuario(String usuario) {
        try {
            this.loadedLoja = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedLoja != null)
                this.loadedLojas.add(this.loadedLoja);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedLoja;
    }
    
    /**
     * Metodo que carrega todas as lojas
     * 
     * @return
     */
    public List<Loja> loadAll() {
        try {
            this.loadedLojas =  dao.queryForAll();
            if (this.loadedLojas.size() != 0)
                this.loadedLoja = this.loadedLojas.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedLojas;
    }  
}

