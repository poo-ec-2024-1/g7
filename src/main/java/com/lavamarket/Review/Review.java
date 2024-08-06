/**
 * Classe com atributos da avaliação das lojas
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket.Review;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "review")
public class Review {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int lavajato_id;
    @DatabaseField
    private int review = 0;
    @DatabaseField
    private int cliente_id;
    @DatabaseField
    private int agendamento_id;

    /**
     * Metodor construtor da classe review
     * 
     * @param lavajato_id
     * @param review
     */
    public Review(int lavajato_id, int cliente_id, int agendamento_id, int review) {
        this.lavajato_id = lavajato_id;
        this.review = review;
        this.cliente_id = cliente_id;
        this.agendamento_id = agendamento_id;
    }

    /**
     * Metodo construtor padrao da classse de avaliações
     * 
     */
    public Review() {
        this.lavajato_id = 0;
        this.review = 0;
    }

    /**
     * Metodo getter do id do lava jato
     * 
     * @return
     */
    public int getLavajato_id() {
        return lavajato_id;
    }

    /**
     * Metodo setter do id do lava jato
     * 
     */
    public void setLavajato_id(int lavajato_id) {
        this.lavajato_id = lavajato_id;
    }

    /**
     * Metodo de retornar a avaliação
     * 
     * @return
     */
    public int getReview() {
        return review;
    }

    /**
     * Metodo que altera a avaliação
     * 
     * @param review
     */
    public void setReview(int review) {
        this.review = review;
    }

    /**
     * Metodo que retorna o id da avaliação
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que altera o id da avaliação
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que retorna o id do cliente
     * 
     * @return
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * Metodo que altera o id do cliente
     * 
     * @param cliente_id
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * Metodo que retorna o id do agendamento
     * 
     * @return
     */
    public int getAgendamento_id() {
        return agendamento_id;
    }

    /**
     * Metodo que altera o id do agendamento
     * 
     * @param agendamento_id
     */
    public void setAgendamento_id(int agendamento_id) {
        this.agendamento_id = agendamento_id;
    }
}
