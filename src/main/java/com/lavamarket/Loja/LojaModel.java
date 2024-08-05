/**
 * Classe Modelo da loja
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Loja;

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

    /**
     * Metodo construtor da classe modelo da loja
     * 
     * @param nome
     * @param review
     * @param precomedioCarro
     * @param precomedioMoto
     * @param precomedioCaminhao
     * @param id
     */
    public LojaModel(String nome, float review, float precomedioCarro, float precomedioMoto, float precomedioCaminhao, int id) {
        this.nome = new SimpleStringProperty(nome);
        this.review = new SimpleFloatProperty(review);
        this.precomedioCarro = new SimpleFloatProperty(precomedioCarro);
        this.precomedioMoto = new SimpleFloatProperty(precomedioMoto);
        this.precomedioCaminhao = new SimpleFloatProperty(precomedioCaminhao);
        this.id = new SimpleIntegerProperty(id);
    }

    /**
     * Metodo construtor padrão da classe modelo da loja
     * 
     */
    public LojaModel() {
        this.nome = new SimpleStringProperty();
        this.review = new SimpleFloatProperty();
        this.precomedioCarro = new SimpleFloatProperty();
        this.precomedioMoto = new SimpleFloatProperty();
        this.precomedioCaminhao = new SimpleFloatProperty();
        this.id = new SimpleIntegerProperty();
    }

    /**
     * Getter do nome da loja
     * 
     * @return
     */
    public String getNome() {
        return nome.get();
    }

    /**
     * Metodo que altera o nome da loja
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    /**
     * Metodoq ue retorna a classificação de uma loja
     * 
     * @return
     */
    public float getReview() {
        return review.get();
    }

    /**
     * Metodo que altera a avaliação da loja
     * 
     * @param review
     */
    public void setReview(float review) {
        this.review.set(review);
    }

    /**
     * Metodo que altera o precomedio dos carros
     * 
     * @return
     */
    public float getPrecomedioCarro() {
        return precomedioCarro.get();
    }

    /**
     * Metodo que altera os precomedios do carro
     * 
     * @param precomedioCarro
     */
    public void setPrecomedioCarro(float precomedioCarro) {
        this.precomedioCarro.set(precomedioCarro);
    }

    /**
     * Metodo que retorna os nome
     * 
     * @return
     */
    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    /**
     * Metodo que retorna as propriedades da avialiações
     * 
     * @return
     */
    public SimpleFloatProperty reviewProperty() {
        return review;
    }

    /**
     * Metodo que retorna as propriedades do percomedio carros
     * 
     * @return
     */
    public SimpleFloatProperty precomedioCarroProperty() {
        return precomedioCarro;
    }

    /**
     * Getter do id da loja
     * 
     * @return
     */
    public int getId() {
        return id.get();
    }

    /**
     * Metodo que retorna a propriedade do id
     * 
     * @return
     */
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    /**
     * Setter que altera o id da loja
     * 
     * @param id
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * Metodo que altera o precomedio da moto
     * 
     * @return
     */
    public float getPrecomedioMoto() {
        return precomedioMoto.get();
    }

    /**
     * Metodo que altera a propriedade do precomedio da moto
     * 
     * @return
     */
    public SimpleFloatProperty precomedioMotoProperty() {
        return precomedioMoto;
    }

    /**
     * Metodo que altera o precomeio das motos
     * 
     * @param precomedioMoto
     */
    public void setPrecomedioMoto(float precomedioMoto) {
        this.precomedioMoto.set(precomedioMoto);
    }

    /**
     * Metodo que retorna o precomedio de caminhões
     * 
     * @return
     */
    public float getPrecomedioCaminhao() {
        return precomedioCaminhao.get();
    }

    /**
     * Metodo que retorna as propriedades do precomdeio de caminhões
     * 
     * @return
     */
    public SimpleFloatProperty precomedioCaminhaoProperty() {
        return precomedioCaminhao;
    }

    /**
     * MEtodo que altera o precomedio dos caminhoes
     * 
     * @param precomedioCaminhao
     */
    public void setPrecomedioCaminhao(float precomedioCaminhao) {
        this.precomedioCaminhao.set(precomedioCaminhao);
    }
}
