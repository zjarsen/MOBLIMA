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
    @Reference
    private Cinema cinema;
    @Reference
    private Movie movie;

    public ShowTime() {
    }

    public ShowTime(String start_time, Cinema cinema, Movie movie) {
        this.start_time = start_time;
        this.cinema = cinema;
        this.movie = movie;
    }

    public String getStart_time() {
        return start_time;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Movie getMovie() {
        return movie;
    }
}
