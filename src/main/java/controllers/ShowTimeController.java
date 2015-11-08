package controllers;

import com.mongodb.MongoClient;
import models.Movie;
import models.ShowTime;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by zjarsen on 8/11/15.
 */
public class ShowTimeController {
    public ShowTimeController() {
    }

    public void newShowTime(String time, ObjectId cinemaId, ObjectId movieId) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");

        ShowTime showTime = new ShowTime(time, cinemaId, movieId);
        datastore.save(showTime);
    }
}
