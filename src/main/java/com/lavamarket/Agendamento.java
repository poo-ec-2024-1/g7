/**
 * Classe agendamento responsavel por gerir atributos e mudar os mesmos.
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "agendamento")
public class Agendamento {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int idCliente;
    @DatabaseField
    private int idLoja;
    @DatabaseField
    private int idVeiculo;
    @DatabaseField
    private int idServicos;
    @DatabaseField
    private Date data;
    @DatabaseField
    private float valor;

    /**
     * Construtor da classe agendamento.
     * 
     * @param idCliente
     * @param idLoja
     * @param idVeiculo
     * @param idServicos
     * @param data
     * @param valor
     */
    public Agendamento(int idCliente, int idLoja, int idVeiculo, int idServicos, Date data, float valor) {
        this.idCliente = idCliente;
        this.idLoja = idLoja;
        this.idVeiculo = idVeiculo;
        this.idServicos = idServicos;
        this.data = data;
        this.valor = valor;
    }

    /**
     * Construtor padrão para evitar problemas de codigo
     * 
     */
    public Agendamento() {
        this.idCliente = 0;
        this.idLoja = 0;
        this.idVeiculo = 0;
        this.idServicos = 0;
        this.data = new Date(0);
        this.valor = 0;
    }

    /**
     * Getter para Id
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter para id do cliente
     * 
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Getter para o id da loja
     * 
     * @return
     */
    public int getIdLoja() {
        return idLoja;
    }

    /**
     * Getter para o id do veiculo
     * 
     * @return
     */
    public int getIdVeiculo() {
        return idVeiculo;
    }

    /**
     * Getter para o id dos serviços
     * 
     * @return
     */
    public int getIdServicos() {
        return idServicos;
    }

    /**
     * getter para a data (horario etc..)
     * 
     * @return
     */
    public Date getData() {
        return data;
    }

    /**
     * Setter do id do cliente
     * 
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Setter do Id da loja
     * 
     * @param idLoja
     */
    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    /**
     * Setter do Id do veiculo
     * 
     * @param idVeiculo
     */
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    /**
     * Setter do Id dos serviços
     * 
     * @param idServicos
     */
    public void setIdServicos(int idServicos) {
        this.idServicos = idServicos;
    }

    /**
     * Setter da Data
     * 
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Getter do valor do agendamento
     * 
     * @return
     */
    public float getValor() {
        return valor;
    }

    /**
     * Metodo de mudar o valor do agendamento
     * 
     * @param valor
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
}
