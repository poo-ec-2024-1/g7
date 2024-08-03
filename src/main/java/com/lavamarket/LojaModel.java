package com.lavamarket;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LojaModel {
    private final SimpleStringProperty nome;
    private final SimpleFloatProperty review;
    private final SimpleFloatProperty precomedio;
    private final SimpleIntegerProperty id;

    public LojaModel(String nome, float review, float precomedio, int id) {
        this.nome = new SimpleStringProperty(nome);
        this.review = new SimpleFloatProperty(review);
        this.precomedio = new SimpleFloatProperty(precomedio);
        this.id = new SimpleIntegerProperty(id);
    }

    public LojaModel() {
        this.nome = new SimpleStringProperty();
        this.review = new SimpleFloatProperty();
        this.precomedio = new SimpleFloatProperty();
        this.id = new SimpleIntegerProperty();
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public float getReview() {
        return review.get();
    }

    public void setReview(float review) {
        this.review.set(review);
    }

    public float getPrecomedio() {
        return precomedio.get();
    }

    public void setPrecomedio(float precomedio) {
        this.precomedio.set(precomedio);
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public SimpleFloatProperty reviewProperty() {
        return review;
    }

    public SimpleFloatProperty precomedioProperty() {
        return precomedio;
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
