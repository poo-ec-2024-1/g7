package com.lavamarket;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class AgendamentoRepository
{
    private static Database database;
    private static Dao<Agendamento, Integer> dao;
    private List<Agendamento> loadedAgendamentos;
    private Agendamento loadedAgendamento; 
    
    public AgendamentoRepository(Database database) {
        AgendamentoRepository.setDatabase(database);
        loadedAgendamentos = new ArrayList<Agendamento>();
    }
    
    public static void setDatabase(Database database) {
        AgendamentoRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Agendamento.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Agendamento.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Agendamento create(Agendamento cliente) {
        int nrows = 0;
        try {
            nrows = dao.create(cliente);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedAgendamento = cliente;
            loadedAgendamentos.add(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cliente;
    }    

    public void update(Agendamento cliente) {
        try {
            dao.update(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(Agendamento cliente) {
        try{
            dao.delete(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Agendamento loadFromId(int id) {
        try {
            this.loadedAgendamento = dao.queryForId(id);
            if (this.loadedAgendamento != null)
                this.loadedAgendamentos.add(this.loadedAgendamento);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedAgendamento;
    }
    
    public Agendamento loadFromUsuario(String usuario) {
        try {
            this.loadedAgendamento = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedAgendamento != null)
                this.loadedAgendamentos.add(this.loadedAgendamento);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedAgendamento;
    }

    public List<Agendamento> loadAllFromLojaId(int id){
        try {
            this.loadedAgendamentos = dao.queryForEq("idLoja", id);
            if (this.loadedAgendamentos.size() != 0)
                this.loadedAgendamento = this.loadedAgendamentos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedAgendamentos;
    }

    public List<Agendamento> loadAllFromClienteId(int id){
        try {
            this.loadedAgendamentos = dao.queryForEq("idCliente", id);
            if (this.loadedAgendamentos.size() != 0)
                this.loadedAgendamento = this.loadedAgendamentos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedAgendamentos;
    }
    
    public List<Agendamento> loadAll() {
        try {
            this.loadedAgendamentos =  dao.queryForAll();
            if (this.loadedAgendamentos.size() != 0)
                this.loadedAgendamento = this.loadedAgendamentos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedAgendamentos;
    }  
}

