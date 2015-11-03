package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("purchases")
/**
 * Created by zjarsen on 2/11/15.
 */
public class Purchase {
    @Id
    private ObjectId id;
    private double price;
    @Reference
    private Seat seat;
    @Reference
    private ShowTime showTime;
    @Reference
    private Customer customer;

    public Purchase(double price, Seat seat, ShowTime showTime, Customer customer) {
        this.price = price;
        this.seat = seat;
        this.showTime = showTime;
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public Seat getSeat() {
        return seat;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public Customer getCustomer() {
        return customer;
    }
}
