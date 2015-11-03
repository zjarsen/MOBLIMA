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
}
