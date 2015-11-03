package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("cinemas")
/**
 * Created by zjarsen on 2/11/15.
 */
public class Cinema {
    @Id
    private ObjectId id;
    private String type;
    @Reference
    private Cineplex cineplex;
    @Reference
    private List<Seat> hasSeats = new ArrayList<Seat>();
    @Reference
    private List<ShowTime> hasShowTime = new ArrayList<ShowTime>();

    public Cinema() {
    }

    public Cinema(Cineplex cineplex, String type) {
        this.cineplex = cineplex;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public List<Seat> getHasSeats() {
        return hasSeats;
    }

    public List<ShowTime> getHasShowTime() {
        return hasShowTime;
    }
////////////////////////////////////////////////////////////////////////////////////////////////
    public void setType(String type) {
        this.type = type;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public void setHasSeats(List<Seat> hasSeats) {
        this.hasSeats = hasSeats;
    }

    public void setHasShowTime(List<ShowTime> hasShowTime) {
        this.hasShowTime = hasShowTime;
    }
}
