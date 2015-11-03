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
    @Reference
    private Cinema cinema;

    public Seat() {
    }

    public Seat(int seatId, Cinema cinema) {
        this.seatId = seatId;
        this.cinema = cinema;
    }


}
