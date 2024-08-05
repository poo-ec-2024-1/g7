/**
 * Classe que controla os bancos de dados do projeto 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket;

import java.sql.*;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

public class Database
{
    private String databaseName = null;
    private JdbcConnectionSource connection = null;
    
    /**
     * Classe construtora do database
     * 
     * @param databaseName
     */
    public Database(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * Classe construtora padrão do banco de dados
     * 
     */
    public Database() {
        this.databaseName = "default.db";
    }
   
    /**
     * Classe que estabelece concexão com o banco de dados
     * 
     * @return
     * @throws SQLException
     */
    public JdbcConnectionSource getConnection() throws SQLException {
        if ( databaseName == null ) {
            throw new SQLException("database name is null");
        }
        if ( connection == null ) {
            try {
                connection = new JdbcConnectionSource("jdbc:sqlite:"+databaseName);             
                } catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.exit(0);
                }
                System.out.println("Opened database successfully");
        }
        return connection;
    }
    
    /**
     * Classe que fecha a conexao com o banco de dados
     * 
     */
    public void close() {
        if ( connection != null ) {
            try {
                connection.close();
                this.connection = null;
            } catch (java.lang.Exception e) {
                System.err.println(e);
            }
        }
    }
}

