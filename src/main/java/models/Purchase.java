package models;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
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
    private String TID;
    private double price;
    private ObjectId cinemaId;
    private ObjectId cineplexId;
    private ObjectId seatId;
    private ObjectId showTimeId;
    private ObjectId customerId;
    private ObjectId ReviewId;

    public Purchase() {
    }

    public Purchase(String TID, double price, ObjectId seatId, ObjectId showTimeId, ObjectId customerId) {
        this.TID = TID;
        this.price = price;
        this.seatId = seatId;
        this.showTimeId = showTimeId;
        this.customerId = customerId;

        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
    }


}
