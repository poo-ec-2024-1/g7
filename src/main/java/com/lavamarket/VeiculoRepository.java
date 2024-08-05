/**
 * Classe Que gerencia o repositorio dos veiculos 
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

public class VeiculoRepository
{
    private static Dao<Veiculo, Integer> dao;
    private List<Veiculo> loadedVeiculos;
    private Veiculo loadedVeiculo; 
    
    /**
     * Metodo construtor da classe de repositorio
     * 
     * @param database
     */
    public VeiculoRepository(Database database) {
        VeiculoRepository.setDatabase(database);
        loadedVeiculos = new ArrayList<Veiculo>();
    }
    
    /**
     * Metodo que altera o banco de dados de veiculos
     * 
     * @param database
     */
    public static void setDatabase(Database database) {
        try {
            dao = DaoManager.createDao(database.getConnection(), Veiculo.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Veiculo.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    /**
     * Metodo que cria o veiculo
     * 
     * @param veiculo
     * @return
     */
    public Veiculo create(Veiculo veiculo) {
        int nrows = 0;
        try {
            nrows = dao.create(veiculo);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedVeiculo = veiculo;
            loadedVeiculos.add(veiculo);
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
    public void update(Veiculo veiculo) {
        try {
            dao.update(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo que deleta veiculos do banco de dados
     * 
     * @param veiculo
     */
    public void delete(Veiculo veiculo) {
        try{
            dao.delete(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Metodo que carrega veiculos pelo id
     * 
     * @param id
     * @return
     */
    public Veiculo loadFromId(int id) {
        try {
            this.loadedVeiculo = dao.queryForId(id);
            if (this.loadedVeiculo != null)
                this.loadedVeiculos.add(this.loadedVeiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculo;
    }
    
    /**
     * Metodo que carrega os veiculos com base em usuario
     * 
     * @param usuario
     * @return
     */
    public Veiculo loadFromUsuario(String usuario) {
        try {
            this.loadedVeiculo = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedVeiculo != null)
                this.loadedVeiculos.add(this.loadedVeiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculo;
    }
    
    /**
     * Metodo que carrega tudo pelo id do cliente
     * 
     * @param id
     * @return
     */
    public List<Veiculo> loadAllFromClienteId(int id){
        try {
            this.loadedVeiculos = dao.queryForEq("cliente_id", id);
            if (this.loadedVeiculos.size() != 0)
                this.loadedVeiculo = this.loadedVeiculos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculos;
    }

    /**
     * Carrega veiculo pelo apelido
     * 
     * @param apelido
     * @return
     */
    public Veiculo loadFromApelido(String apelido) {
        try {
            this.loadedVeiculo = dao.queryForEq("apelido", apelido).get(0);
            if (this.loadedVeiculo != null)
                this.loadedVeiculos.add(this.loadedVeiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculo;
    }

    /**
     * Carrega veiculos pela placa
     * 
     * @param placa
     * @return
     */
    public Veiculo loadFromPlaca(String placa) {
        try {
            this.loadedVeiculo = dao.queryForEq("placa", placa).get(0);
            if (this.loadedVeiculo != null)
                this.loadedVeiculos.add(this.loadedVeiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculo;
    }

    /**
     * Carrega todos os veiculos
     * 
     * @return
     */
    public List<Veiculo> loadAll() {
        try {
            this.loadedVeiculos =  dao.queryForAll();
            if (this.loadedVeiculos.size() != 0)
                this.loadedVeiculo = this.loadedVeiculos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedVeiculos;
    }  
}

