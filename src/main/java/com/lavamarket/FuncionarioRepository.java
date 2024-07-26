package com.lavamarket;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioRepository
{
    private static Database database;
    private static Dao<Funcionario, Integer> dao;
    private List<Funcionario> loadedFuncionarios;
    private Funcionario loadedFuncionario; 
    
    public FuncionarioRepository(Database database) {
        FuncionarioRepository.setDatabase(database);
        loadedFuncionarios = new ArrayList<Funcionario>();
    }
    
    public static void setDatabase(Database database) {
        FuncionarioRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Funcionario.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Funcionario.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
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

    public void update(Funcionario funcionario) {
        try {
            dao.update(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(Funcionario funcionario) {
        try{
            dao.delete(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
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
    
    public Funcionario loadFromUsuario(String usuario) {
        try {
            this.loadedFuncionario = dao.queryForEq("usuario", usuario).getFirst();
            if (this.loadedFuncionario != null)
                this.loadedFuncionarios.add(this.loadedFuncionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedFuncionario;
    }
    
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

