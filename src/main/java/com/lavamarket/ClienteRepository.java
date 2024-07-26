package com.lavamarket;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class ClienteRepository
{
    private static Database database;
    private static Dao<Cliente, Integer> dao;
    private List<Cliente> loadedClientes;
    private Cliente loadedCliente; 
    
    public ClienteRepository(Database database) {
        ClienteRepository.setDatabase(database);
        loadedClientes = new ArrayList<Cliente>();
    }
    
    public static void setDatabase(Database database) {
        ClienteRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Cliente.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Cliente.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
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

    public void update(Cliente cliente) {
        try {
            dao.update(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(Cliente cliente) {
        try{
            dao.delete(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
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
    
    public Cliente loadFromUsuario(String usuario) {
        try {
            this.loadedCliente = dao.queryForEq("usuario", usuario).getFirst();
            if (this.loadedCliente != null)
                this.loadedClientes.add(this.loadedCliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCliente;
    }
    
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

