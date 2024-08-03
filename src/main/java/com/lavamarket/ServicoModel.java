package com.lavamarket;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServicoModel {
    private final SimpleStringProperty nomePacote;
    private final SimpleStringProperty valor;
    private final SimpleIntegerProperty id;

    public ServicoModel(int id, String nomePacote, String valor) {
        this.id = new SimpleIntegerProperty(id);
        this.nomePacote = new SimpleStringProperty(nomePacote);
        this.valor = new SimpleStringProperty(valor);
    }

    public String getNomePacote() {
        return nomePacote.get();
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote.set(nomePacote);
    }

    public String getValor() {
        return valor.get();
    }

    public void setValor(String valor) {
        this.valor.set(valor);
    }

    public SimpleStringProperty nomePacoteProperty() {
        return nomePacote;
    }

    public SimpleStringProperty valorProperty() {
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
