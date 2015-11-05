package controllers;

import com.mongodb.MongoClient;
import models.Movie;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

/**
 * Created by zjarsen on 6/11/15.
 */
public class MovieController {
    public MovieController() {
    }

    public void newMovie(Movie movie) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
        datastore.save(movie);
    }
}
