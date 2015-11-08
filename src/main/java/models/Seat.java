package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("seats")
/**
 * Created by zjarsen on 2/11/15.
 */
public class Seat {
    @Id
    private ObjectId id;
    private int seatId;
    private boolean isTaken;
    private ObjectId hasCinemaId;

    public Seat() {
    }

    public Seat(int seatId, ObjectId cinemaId) {
        this.seatId = seatId;
        this.hasCinemaId = cinemaId;
        this.isTaken = false;
    }

    public ObjectId getId() {
        return id;
    }

    public int getSeatId() {
        return seatId;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public ObjectId getHasCinemaId() {
        return hasCinemaId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public void setHasCinemaId(ObjectId hasCinemaId) {
        this.hasCinemaId = hasCinemaId;
    }
}
