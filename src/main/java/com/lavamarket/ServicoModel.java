package com.lavamarket;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServicoModel {
    private final SimpleStringProperty nomePacote;
    private final SimpleFloatProperty valor;
    private final SimpleIntegerProperty id;

    public ServicoModel(int id, String nomePacote, Float valor) {
        this.id = new SimpleIntegerProperty(id);
        this.nomePacote = new SimpleStringProperty(nomePacote);
        this.valor = new SimpleFloatProperty(valor);
    }

    public String getNomePacote() {
        return nomePacote.get();
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote.set(nomePacote);
    }

    public float getValor() {
        return valor.get();
    }

    public void setValor(float valor) {
        this.valor.set(valor);
    }

    public SimpleStringProperty nomePacoteProperty() {
        return nomePacote;
    }

    public SimpleFloatProperty valorProperty() {
        return valor;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }
}
