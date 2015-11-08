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
    private String name;
    private String type;
    private ObjectId hasCineplexId;
    private List<ObjectId> hasSeatsId = new ArrayList<ObjectId>();
    private List<ObjectId> hasShowTimeId = new ArrayList<ObjectId>();

    public Cinema() {
    }

    public Cinema(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObjectId getHasCineplexId() {
        return hasCineplexId;
    }

    public void setHasCineplexId(ObjectId hasCineplexId) {
        this.hasCineplexId = hasCineplexId;
    }

    public List<ObjectId> getHasSeatsId() {
        return hasSeatsId;
    }

    public void setHasSeatsId(List<ObjectId> hasSeatsId) {
        this.hasSeatsId = hasSeatsId;
    }

    public void setHasShowTimeId(List<ObjectId> hasShowTimeId) {
        this.hasShowTimeId = hasShowTimeId;
    }

    public void addSeatsId(ObjectId objectId) {
        this.hasSeatsId.add(objectId);
    }
}


