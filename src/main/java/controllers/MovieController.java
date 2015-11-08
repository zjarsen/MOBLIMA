package controllers;

import com.mongodb.MongoClient;
import models.Movie;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

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

    public List<Movie> getAllMovies() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
        List<Movie> movies = datastore.createQuery(Movie.class).asList();
        return movies;
    }

    public void deleteMovieFromServer(ObjectId movieId) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
        Query<Movie> toBeDeleted = datastore.createQuery(Movie.class).field("id").equal(movieId);
        datastore.delete(toBeDeleted);
    }


}
