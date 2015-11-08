package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("cineplexes")
/**
 * Created by zjarsen on 2/11/15.
 */
public class Cineplex {
    @Id
    private ObjectId id;
    private String name;
    private String location;
    private List<ObjectId> hasCinemaId = new ArrayList<ObjectId>();

    public Cineplex() {
    }

    public Cineplex(String name, String location) {
        this.name = name;
        this.location = location;
        this.hasCinemaId = new ArrayList<ObjectId>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<ObjectId> getHasCinemaId() {
        return hasCinemaId;
    }

    public ObjectId getId() {
        return id;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHasCinemaId(List<ObjectId> hasCinemaId) {
        this.hasCinemaId = hasCinemaId;
    }

    public void addCinemaId(ObjectId objectId) {
        this.hasCinemaId.add(objectId);
    }
}
