package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("movies")

/**
 * Created by zjarsen on 2/11/15.
 */
public class Movie {
    @Id
    private ObjectId id;
    private String title;
    private String descripion;
    private int status;
    private String director;
    private int content_rating;
    private double average_rating;
    private double base_price;
    private String type;
    private int length;
    private double discountRate;
    private List<ObjectId> hasShowTimes = new ArrayList<ObjectId>();
    private List<ObjectId> hasReviews = new ArrayList<ObjectId>();

    public Movie() {
    }

    public Movie(String title, String descripion, int status, String director, int content_rating, double base_price, String type, int length, double discountRate) {
        this.title = title;
        this.descripion = descripion;
        this.status = status;
        this.director = director;
        this.content_rating = content_rating;
        this.base_price = base_price;
        this.type = type;
        this.length = length;
        this.discountRate = discountRate;
        this.average_rating = 0;
    }

    public ObjectId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescripion() {
        return descripion;
    }

    public int getStatus() {
        return status;
    }

    public String getDirector() {
        return director;
    }

    public int getContent_rating() {
        return content_rating;
    }

    public double getAverage_rating() {
        return average_rating;
    }

    public double getBase_price() {
        return base_price;
    }

    public String getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public List<ObjectId> getHasShowTimes() {
        return hasShowTimes;
    }

    public List<ObjectId> getHasReviews() {
        return hasReviews;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setContent_rating(int content_rating) {
        this.content_rating = content_rating;
    }

    public void setAverage_rating(double average_rating) {
        this.average_rating = average_rating;
    }

    public void setBase_price(double base_price) {
        this.base_price = base_price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void setHasShowTimes(List<ObjectId> hasShowTimes) {
        this.hasShowTimes = hasShowTimes;
    }

    public void setHasReviews(List<ObjectId> hasReviews) {
        this.hasReviews = hasReviews;
    }

    public void addShowTime(ObjectId showTime) {
        this.hasShowTimes.add(showTime);
    }

    public void addReviews(ObjectId review) {
        this.hasReviews.add(review);
    }
}
