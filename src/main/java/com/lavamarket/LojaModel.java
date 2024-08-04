package com.lavamarket;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LojaModel {
    private final SimpleStringProperty nome;
    private final SimpleFloatProperty review;
    private final SimpleFloatProperty precomedioCarro;
    private final SimpleFloatProperty precomedioMoto;
    private final SimpleFloatProperty precomedioCaminhao;
    private final SimpleIntegerProperty id;

    public LojaModel(String nome, float review, float precomedioCarro, float precomedioMoto, float precomedioCaminhao, int id) {
        this.nome = new SimpleStringProperty(nome);
        this.review = new SimpleFloatProperty(review);
        this.precomedioCarro = new SimpleFloatProperty(precomedioCarro);
        this.precomedioMoto = new SimpleFloatProperty(precomedioMoto);
        this.precomedioCaminhao = new SimpleFloatProperty(precomedioCaminhao);
        this.id = new SimpleIntegerProperty(id);
    }

    public LojaModel() {
        this.nome = new SimpleStringProperty();
        this.review = new SimpleFloatProperty();
        this.precomedioCarro = new SimpleFloatProperty();
        this.precomedioMoto = new SimpleFloatProperty();
        this.precomedioCaminhao = new SimpleFloatProperty();
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

    public float getPrecomedioCarro() {
        return precomedioCarro.get();
    }

    public void setPrecomedioCarro(float precomedioCarro) {
        this.precomedioCarro.set(precomedioCarro);
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public SimpleFloatProperty reviewProperty() {
        return review;
    }

    public SimpleFloatProperty precomedioCarroProperty() {
        return precomedioCarro;
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

    public float getPrecomedioMoto() {
        return precomedioMoto.get();
    }

    public SimpleFloatProperty precomedioMotoProperty() {
        return precomedioMoto;
    }

    public void setPrecomedioMoto(float precomedioMoto) {
        this.precomedioMoto.set(precomedioMoto);
    }

    public float getPrecomedioCaminhao() {
        return precomedioCaminhao.get();
    }

    public SimpleFloatProperty precomedioCaminhaoProperty() {
        return precomedioCaminhao;
    }

    public void setPrecomedioCaminhao(float precomedioCaminhao) {
        this.precomedioCaminhao.set(precomedioCaminhao);
    }
}
