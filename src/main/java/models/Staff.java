package models;

import org.mongodb.morphia.annotations.Entity;

/**
 * Created by zjarsen on 3/11/15.
 */
@Entity("staffs")
public class Staff extends User {
    public Staff() {
    }

    public Staff(String username, String password) {
        super(username, password);
    }

    public void createListing() {
        System.out.println("create listing");
    }

    public void updateListing() {
        System.out.println("update listing");
    }

    public void updateShowtime() {
        System.out.println("update Showtime");
    }

    public void configureSettings() {
        System.out.println("configure settings");
    }
}
