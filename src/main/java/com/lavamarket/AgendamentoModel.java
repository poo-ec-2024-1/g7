package com.lavamarket;

import java.sql.Date;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class AgendamentoModel {
    private final Date data;
    private final SimpleStringProperty veiculo;
    private final SimpleFloatProperty valor;
    private final SimpleStringProperty loja;

    public AgendamentoModel(Date data, String veiculo, float valor, String loja) {
        this.data = data;
        this.veiculo = new SimpleStringProperty(veiculo);
        this.valor = new SimpleFloatProperty(valor);
        this.loja = new SimpleStringProperty(loja);
    }

    public AgendamentoModel() {
        this.data = new Date(0);
        this.veiculo = new SimpleStringProperty();
        this.valor = new SimpleFloatProperty();
        this.loja = new SimpleStringProperty();
    }
    
    public Date getData() {
        return data;
    }

    public SimpleStringProperty veiculoProperty() {
        return veiculo;
    }

    public SimpleFloatProperty valorProperty() {
        return valor;
    }

    public String getVeiculo() {
        return veiculo.get();
    }

    public float getValor() {
        return valor.get();
    }

    public void setVeiculo(String veiculo) {
        this.veiculo.set(veiculo);
    }

    public void setValor(float valor) {
        this.valor.set(valor);
    }

    public void setData(Date data) {
        this.data.setTime(data.getTime());
    }

    public SimpleStringProperty lojaProperty() {
        return loja;
    }

    public String getLoja() {
        return loja.get();
    }

    public void setLoja(String loja) {
        this.loja.set(loja);
    }
}
