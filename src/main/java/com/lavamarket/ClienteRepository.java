/**
 * Classe repositorio do cliente
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

public class ClienteRepository
{
    private static Dao<Cliente, Integer> dao;
    private List<Cliente> loadedClientes;
    private Cliente loadedCliente; 
    
    /**
     * metodo construtor do repositorio do cliente
     * @param database
     */
    public ClienteRepository(Database database) {
        ClienteRepository.setDatabase(database);
        loadedClientes = new ArrayList<Cliente>();
    }
    
    /**
     * Metodo que seta o banco de dados do cliente
     * 
     * @param database
     */
    public static void setDatabase(Database database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Cliente.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Cliente.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    /**
     * Metodo que cria o cliente
     * 
     * @param cliente
     * @return
     */
    public Cliente create(Cliente cliente) {
        int nrows = 0;
        try {
            nrows = dao.create(cliente);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedCliente = cliente;
            loadedClientes.add(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cliente;
    }    

    /**
     * Metodo que atualiza o cliente
     * 
     * @param cliente
     */
    public void update(Cliente cliente) {
        try {
            dao.update(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo que deleta o cliente
     * 
     * @param cliente
     */
    public void delete(Cliente cliente) {
        try{
            dao.delete(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Metodo que carrega o cliente pelo id
     * 
     * @param id
     * @return
     */
    public Cliente loadFromId(int id) {
        try {
            this.loadedCliente = dao.queryForId(id);
            if (this.loadedCliente != null)
                this.loadedClientes.add(this.loadedCliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCliente;
    }
    
    /**
     * Metodo que carrega o cliente pelo usuario dele
     * 
     * @param usuario
     * @return
     */
    public Cliente loadFromUsuario(String usuario) {
        try {
            this.loadedCliente = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedCliente != null)
                this.loadedClientes.add(this.loadedCliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCliente;
    }
    
    /**
     * Metodo que carrega todo o banco de dados do cliente
     * 
     * @return
     */
    public List<Cliente> loadAll() {
        try {
            this.loadedClientes =  dao.queryForAll();
            if (this.loadedClientes.size() != 0)
                this.loadedCliente = this.loadedClientes.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedClientes;
    }  
}

