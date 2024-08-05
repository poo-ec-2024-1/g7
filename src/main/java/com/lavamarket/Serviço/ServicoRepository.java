/**
 * Classe Que controla o banco de dados de serviços 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */

 package com.lavamarket.Serviço;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import com.lavamarket.Database;

import java.util.List;
import java.util.ArrayList;

public class ServicoRepository
{
    private static Dao<Servico, Integer> dao;
    private List<Servico> loadedServicos;
    private Servico loadedServico; 
    
    /**
     * Metodo construtor da classe de serviços
     * 
     * @param database
     */
    public ServicoRepository(Database database) {
        ServicoRepository.setDatabase(database);
        loadedServicos = new ArrayList<Servico>();
    }
    
    /**
     * Metodo que altera o banco de dados dos serviços
     * 
     * @param database
     */
    public static void setDatabase(Database database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Servico.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Servico.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    /**
     * Metodo que cria o banco de dados dos serviços
     * 
     * @param veiculo
     * @return
     */
    public Servico create(Servico veiculo) {
        int nrows = 0;
        try {
            nrows = dao.create(veiculo);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedServico = veiculo;
            loadedServicos.add(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return veiculo;
    }    

    /**
     * Metodo que atualiza o banco de dados de veiculos
     * 
     * @param veiculo
     */
    public void update(Servico veiculo) {
        try {
            dao.update(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo que deleta serviços
     * 
     * @param veiculo
     */
    public void delete(Servico veiculo) {
        try{
            dao.delete(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Metodo que carrega serviços pelo id
     * 
     * @param id
     * @return
     */
    public Servico loadFromId(int id) {
        try {
            this.loadedServico = dao.queryForId(id);
            if (this.loadedServico != null)
                this.loadedServicos.add(this.loadedServico);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedServico;
    }
    
    /**
     * Metodo que carrega serviçoes pelo usuario
     * 
     * @param usuario
     * @return
     */
    public Servico loadFromUsuario(String usuario) {
        try {
            this.loadedServico = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedServico != null)
                this.loadedServicos.add(this.loadedServico);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedServico;
    }
    
    /**
     * Metodo que retorna tudo pelo id da loja
     * 
     * @param id
     * @return
     */
    public List<Servico> loadAllFromLojaId(int id){
        try {
            this.loadedServicos = dao.queryForEq("lavajato_id", id);
            if (this.loadedServicos.size() != 0)
                this.loadedServico = this.loadedServicos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedServicos;
    }
    
    /**
     * Metodo que carrega todos os dados do banco de dados dos serviços
     * 
     * @return
     */
    public List<Servico> loadAll() {
        try {
            this.loadedServicos =  dao.queryForAll();
            if (this.loadedServicos.size() != 0)
                this.loadedServico = this.loadedServicos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedServicos;
    }  
}

