package controllers;

import com.mongodb.MongoClient;
import models.Cinema;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

/**
 * Created by zjarsen on 8/11/15.
 */
public class CinemaController {
    public CinemaController() {
    }

    public List<Cinema> getAllCinemas() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
        List<Cinema> cinemas = datastore.createQuery(Cinema.class).asList();
        return cinemas;
    }
}
