/**
 * Classe que possui os atributos dos veiculos 
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "veiculo")
public class Veiculo {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(unique = true)
    private String apelido;

    @DatabaseField(unique = true)
    private String placa;

    @DatabaseField
    private String marca;

    @DatabaseField
    private String modelo;

    @DatabaseField
    private String cor;
    
    @DatabaseField
    private String tipo;

    @DatabaseField
    private int cliente_id;

    /**
     * Metodo construtor da classe dos veiculos
     * 
     * @param apelido
     * @param placa
     * @param marca
     * @param modelo
     * @param cor
     * @param tipo
     * @param cliente_id
     */
    public Veiculo(String apelido, String placa, String marca, String modelo, String cor, String tipo, int cliente_id) {
        this.apelido = apelido;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.tipo = tipo;
        this.cliente_id = cliente_id;
    }

    /**
     * Metodo construtor padrão da classe de veiculos
     * 
     */
    public Veiculo() {
        this.apelido = "";
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.cor = "";
        this.tipo = "";
        this.cliente_id = 0;
    }

    /**
     * Retorna a placa do veiculo
     * 
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Altera a placa do veiculo
     * 
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Retorna a marca do veiculo
     * 
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Altera a marca do veiculo
     * 
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna o modelo do veiculo
     * 
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Altera o modelo do veiculo
     * 
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Retorna a cor do veiculo
     * 
     * @return
     */
    public String getCor() {
        return cor;
    }

    /**
     * Altera a cor do veiculo
     * 
     * @param cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Retorna o tipo de veiculo
     * 
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Altera o tipo de veiculo
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o id do cliente
     * 
     * @return
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * Altera o id do cliente do veiculo
     * 
     * @param cliente_id
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * Retorna o id do veiculo
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o id do veiculo
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna apelido do veiculo
     * 
     * @return
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * Altera o apelido do veiculo
     * 
     * @param apelido
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}

