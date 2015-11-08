package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("showTimes")
/**
 * Created by zjarsen on 2/11/15.
 */
public class ShowTime {
    @Id
    private ObjectId id;
    private String start_time;
    private ObjectId cinema;
    private ObjectId movie;

    public ShowTime() {
    }

    public ShowTime(String start_time, ObjectId cinema, ObjectId movie) {
        this.start_time = start_time;
        this.cinema = cinema;
        this.movie = movie;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public ObjectId getCinema() {
        return cinema;
    }

    public void setCinema(ObjectId cinema) {
        this.cinema = cinema;
    }

    public ObjectId getMovie() {
        return movie;
    }

    public void setMovie(ObjectId movie) {
        this.movie = movie;
    }
}
