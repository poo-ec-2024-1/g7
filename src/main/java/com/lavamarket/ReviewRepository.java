package com.lavamarket;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class ReviewRepository
{
    private static Database database;
    private static Dao<Review, Integer> dao;
    private List<Review> loadedReviews;
    private Review loadedReview; 
    
    public ReviewRepository(Database database) {
        ReviewRepository.setDatabase(database);
        loadedReviews = new ArrayList<Review>();
    }
    
    public static void setDatabase(Database database) {
        ReviewRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Review.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Review.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Review create(Review funcionario) {
        int nrows = 0;
        try {
            nrows = dao.create(funcionario);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedReview = funcionario;
            loadedReviews.add(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return funcionario;
    }    

    public void update(Review funcionario) {
        try {
            dao.update(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(Review funcionario) {
        try{
            dao.delete(funcionario);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Review loadFromId(int id) {
        try {
            this.loadedReview = dao.queryForId(id);
            if (this.loadedReview != null)
                this.loadedReviews.add(this.loadedReview);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReview;
    }
    
    public Review loadFromUsuario(String usuario) {
        try {
            this.loadedReview = dao.queryForEq("usuario", usuario).get(0);
            if (this.loadedReview != null)
                this.loadedReviews.add(this.loadedReview);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReview;
    }
    
    public List<Review> loadAllFromLojaId(int id){
        try {
            this.loadedReviews = dao.queryForEq("lavajato_id", id);
            if (this.loadedReviews.size() != 0)
                this.loadedReview = this.loadedReviews.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReviews;
    }
    
    public List<Review> loadAll() {
        try {
            this.loadedReviews =  dao.queryForAll();
            if (this.loadedReviews.size() != 0)
                this.loadedReview = this.loadedReviews.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedReviews;
    }  
}

