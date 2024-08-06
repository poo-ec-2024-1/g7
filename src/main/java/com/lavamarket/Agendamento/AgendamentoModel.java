/**
 * Classe gerenciadora do modelo da janela agendamento
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Agendamento;

import java.sql.Date;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AgendamentoModel {
    private final Date data;
    private final SimpleStringProperty veiculo;
    private final SimpleFloatProperty valor;
    private final SimpleStringProperty loja;
    private final SimpleStringProperty nomeCliente;
    private final SimpleStringProperty tipoVeiculo;
    private final SimpleStringProperty placaVeiculo;
    private final SimpleIntegerProperty id;

    /**
     * Classe construtora do modelo de agendamento
     * 
     * @param data
     * @param veiculo
     * @param valor
     * @param loja
     */
    public AgendamentoModel(int id, Date data, String veiculo, float valor, String loja) {
        this.data = data;
        this.id = new SimpleIntegerProperty(id);
        this.veiculo = new SimpleStringProperty(veiculo);
        this.valor = new SimpleFloatProperty(valor);
        this.loja = new SimpleStringProperty(loja);
        this.nomeCliente = new SimpleStringProperty();
        this.tipoVeiculo = new SimpleStringProperty();
        this.placaVeiculo = new SimpleStringProperty();
    }

    public AgendamentoModel(int id, String nomeCliente, String tipoVeiculo, String placaVeiculo, Date dataAgendamento) {
        this.id = new SimpleIntegerProperty(id);
        this.nomeCliente = new SimpleStringProperty(nomeCliente);
        this.tipoVeiculo = new SimpleStringProperty(tipoVeiculo);
        this.placaVeiculo = new SimpleStringProperty(placaVeiculo);
        this.data = dataAgendamento;
        this.veiculo = new SimpleStringProperty();
        this.valor = new SimpleFloatProperty();
        this.loja = new SimpleStringProperty();
    }


    /**
     * Metodo construtor padrão do modelo de agendamento
     * 
     */
    public AgendamentoModel() {
        this.id = new SimpleIntegerProperty();
        this.data = new Date(0);
        this.veiculo = new SimpleStringProperty();
        this.valor = new SimpleFloatProperty();
        this.loja = new SimpleStringProperty();
        this.nomeCliente = new SimpleStringProperty();
        this.tipoVeiculo = new SimpleStringProperty();
        this.placaVeiculo = new SimpleStringProperty();
    }
    
    /**
     * Getter do atributo data
     * 
     * @return
     */
    public Date getData() {
        return data;
    }

    /**
     * getter da query da propriedade do Veiculo
     * 
     * @return
     */
    public SimpleStringProperty veiculoProperty() {
        return veiculo;
    }

    /**
     * Getter do query valor propriedade
     * 
     * @return 
     */
    public SimpleFloatProperty valorProperty() {
        return valor;
    }

    /**
     * Getter do veiculo
     * 
     * @return
     */
    public String getVeiculo() {
        return veiculo.get();
    }

    /**
     * Getter do valor
     * 
     * @return
     */
    public float getValor() {
        return valor.get();
    }

    /**
     * Setter do veiculo 
     * 
     * @param veiculo
     */
    public void setVeiculo(String veiculo) {
        this.veiculo.set(veiculo);
    }

    /**
     * setter do valor do veiculo
     * 
     * @param valor
     */
    public void setValor(float valor) {
        this.valor.set(valor);
    }

    /**
     * Setter da data 
     * 
     * @param data
     */
    public void setData(Date data) {
        this.data.setTime(data.getTime());
    }

    /**
     * Getter do query de lojas
     * 
     * @return
     */
    public SimpleStringProperty lojaProperty() {
        return loja;
    }

    /**
     * Getter do nome da loja
     * 
     * @return
     */
    public String getLoja() {
        return loja.get();
    }

    /**
     * Setter da Loja
     * 
     * @param loja
     */
    public void setLoja(String loja) {
        this.loja.set(loja);
    }

    /**
     * Getter do nome do cliente
     * 
     * @return
     */
    public String getNomeCliente() {
        return nomeCliente.get();
    }

    /**
     * Getter do tipo de veiculo
     * 
     * @return
     */
    public String getTipoVeiculo() {
        return tipoVeiculo.get();
    }

    /**
     * Getter da placa do veiculo
     * 
     * @return
     */
    public String getPlacaVeiculo() {
        return placaVeiculo.get();
    }

    /**
     * Setter do nome do cliente
     * 
     * @param nomeCliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente.set(nomeCliente);
    }

    /**
     * Setter do tipo de veiculo
     * 
     * @param tipoVeiculo
     */
    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo.set(tipoVeiculo);
    }

    /**
     * Setter da placa do veiculo
     * 
     * @param placaVeiculo
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo.set(placaVeiculo);
    }

    /**
     * Getter do id do agendamento
     * 
     * @return
     */
    public int getId() {
        return id.get();
    }

    /**
     * Setter do id do agendamento
     * 
     * @param id
     */
    public void setId(int id) {
        this.id.set(id);
    }

    
    
}
