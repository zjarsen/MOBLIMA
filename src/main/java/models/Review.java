package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("reviews")
/**
 * Created by zjarsen on 2/11/15.
 */
public class Review {
    @Id
    private ObjectId id;
    private String content;
    private int rating;
    @Reference
    private Movie movie;
    @Reference
    private Customer customer;

    public Review() {
    }

    public Review(String content, int rating, Movie movie, Customer customer) {
        this.content = content;
        this.rating = rating;
        this.movie = movie;
        this.customer = customer;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }
}
