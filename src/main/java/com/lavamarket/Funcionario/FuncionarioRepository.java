/**
 * Classe Repositorio do funcionario 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Funcionario;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import com.lavamarket.Database.Database;

import java.util.List;
import java.util.ArrayList;

public class FuncionarioRepository
{
    private static Dao<Funcionario, Integer> dao;
    private List<Funcionario> loadedFuncionarios;
    private Funcionario loadedFuncionario; 
    
    /**
     * Metodo construtor 
     * 
     * @param database
     */
    public FuncionarioRepository(Database database) {
        FuncionarioRepository.setDatabase(database);
        loadedFuncionarios = new ArrayList<Funcionario>();
    }
    
    /**
     * Metodo que altera o banco de dados
     * 
     * @param database
     */
    public static void setDatabase(Database database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Funcionario.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Funcionario.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    /**
     * Metodo que cria o repositorio do funcionario
     * 
     * @param funcionario
     * @return
     */
    public Funcionario create(Funcionario funcionario) {
        int nrows = 0;
        try {
            nrows = dao.create(funcionario);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedFuncionario = funcionario;
            loadedFuncionarios.add(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return funcionario;
    }    

    /**
     * Metodo que atuazlia o repositorio do funcionario
     * 
     * @param funcionario
     */
    public void update(Funcionario funcionario) {
        try {
            dao.update(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo que deleta informações do fanco de dados
     * 
     * @param funcionario
     */
    public void delete(Funcionario funcionario) {
        try{
            dao.delete(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Carrega as informações do funcionanio com base em um id
     * 
     * @param id
     * @return
     */
    public Funcionario loadFromId(int id) {
        try {
            this.loadedFuncionario = dao.queryForId(id);
            if (this.loadedFuncionario != null)
                this.loadedFuncionarios.add(this.loadedFuncionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedFuncionario;
    }
    
    /**
     * Carrega informações do funcionario pelo usuario
     * 
     * @param usuario
     * @return
     */
    public Funcionario loadFromUsuario(String usuario) {
        try {
            this.loadedFuncionario = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedFuncionario != null)
                this.loadedFuncionarios.add(this.loadedFuncionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedFuncionario;
    }
    
    /**
     * Carrega informações pelo id da loja
     * 
     * @param id
     * @return
     */
    public List<Funcionario> loadAllFromLojaId(int id){
        try {
            this.loadedFuncionarios = dao.queryForEq("lavajato_id", id);
            if (this.loadedFuncionarios.size() != 0)
                this.loadedFuncionario = this.loadedFuncionarios.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedFuncionarios;
    }
    
    /**
     * Carrega todos os dados dos funcionarios
     * 
     * @return
     */
    public List<Funcionario> loadAll() {
        try {
            this.loadedFuncionarios =  dao.queryForAll();
            if (this.loadedFuncionarios.size() != 0)
                this.loadedFuncionario = this.loadedFuncionarios.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedFuncionarios;
    }  
}

