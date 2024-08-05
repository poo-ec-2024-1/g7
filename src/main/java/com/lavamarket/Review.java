/**
 * Classe com atributos da avaliação das lojas
 * 
 * @author Maryxlu, Erick_Fleury, Raingredi
 * @version 0.0.1
 */
package com.lavamarket;

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

    /**
     * Metodor construtor da classe review
     * 
     * @param lavajato_id
     * @param review
     */
    public Review(int lavajato_id, int review) {
        this.lavajato_id = lavajato_id;
        this.review = review;
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
}
