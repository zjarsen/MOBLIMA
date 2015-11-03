package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("showTimes")
/**
 * Created by zjarsen on 2/11/15.
 */
public class Cineplex {
    @Id
    private ObjectId id;
    private String name;
    private String location;

    @Reference
    private List<Cinema> hasCinemas = new ArrayList<Cinema>();

    public Cineplex() {
    }

    public Cineplex(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Cinema> getHasCinemas() {
        return hasCinemas;
    }
////////////////////////////////////////////////////////////////////////////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHasCinemas(List<Cinema> hasCinemas) {
        this.hasCinemas = hasCinemas;
    }
}
