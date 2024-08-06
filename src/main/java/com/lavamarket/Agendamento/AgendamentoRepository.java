/**
 * Classe gerenciadora do banco de dados dos agendamentos
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Agendamento;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import com.lavamarket.Database.Database;

import java.util.List;
import java.util.ArrayList;

public class AgendamentoRepository
{
    private static Dao<Agendamento, Integer> dao;
    private List<Agendamento> loadedAgendamentos;
    private Agendamento loadedAgendamento; 
    
    /**
     * Metodo construtor da classe 
     * 
     * @param database
     */
    public AgendamentoRepository(Database database) {
        AgendamentoRepository.setDatabase(database);
        loadedAgendamentos = new ArrayList<Agendamento>();
    }
    
    /**
     * Metodo Setter do banco de dados
     * 
     * @param database
     */
    public static void setDatabase(Database database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Agendamento.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Agendamento.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    /**
     * Metodo usado para criar o banco de dados de agendamentos
     * 
     * @param cliente
     * @return
     */
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

    /**
     * Metodo de atualização do banco de dados
     * 
     * @param cliente
     */
    public void update(Agendamento cliente) {
        try {
            dao.update(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo de deletar itens do banco de dados
     * 
     * @param cliente
     */
    public void delete(Agendamento cliente) {
        try{
            dao.delete(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo de carregamento de banco de dados
     * 
     * @param id
     * @return
     */
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
    
    /**
     * Metodo de carregamento pelo usuario
     * 
     * @param usuario
     * @return
     */
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

    /**
     * Metodo de carregamento pelo ID da loja
     * 
     * @param id
     * @return
     */
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

    /**
     * Metodo de carregamento pelo Id do cliente
     * 
     * @param id
     * @return
     */
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
    
    /**
     * Metodo que carrega todo o banco de dados
     * 
     * @return
     */
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

