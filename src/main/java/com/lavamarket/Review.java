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

    public Review(int lavajato_id, int review) {
        this.lavajato_id = lavajato_id;
        this.review = review;
    }

    public Review() {
        this.lavajato_id = 0;
        this.review = 0;
    }

    public int getLavajato_id() {
        return lavajato_id;
    }

    public void setLavajato_id(int lavajato_id) {
        this.lavajato_id = lavajato_id;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getId() {
        return id;
    }
}
