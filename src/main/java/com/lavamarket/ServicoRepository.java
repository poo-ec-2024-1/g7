package com.lavamarket;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class ServicoRepository
{
    private static Database database;
    private static Dao<Servico, Integer> dao;
    private List<Servico> loadedServicos;
    private Servico loadedServico; 
    
    public ServicoRepository(Database database) {
        ServicoRepository.setDatabase(database);
        loadedServicos = new ArrayList<Servico>();
    }
    
    public static void setDatabase(Database database) {
        ServicoRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Servico.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Servico.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
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

    public void update(Servico veiculo) {
        try {
            dao.update(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(Servico veiculo) {
        try{
            dao.delete(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
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
    
    public Servico loadFromUsuario(String usuario) {
        try {
            this.loadedServico = dao.queryForEq("usuario", usuario).getFirst();
            if (this.loadedServico != null)
                this.loadedServicos.add(this.loadedServico);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedServico;
    }
    
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

