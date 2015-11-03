package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("customers")
/**
 * Created by zjarsen on 2/11/15.
 */
public class Customer extends User {
    private int age;
    @Reference
    private List<Purchase> hasPurchases = new ArrayList<Purchase>();

    public Customer() {
    }

    public Customer(String username, String password, int age) {
        super(username, password);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    /**
     *
     * @return
     */
    public List<Purchase> getHasPurchases() {
        return hasPurchases;
    }
////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @param hasPurchases
     */
    public void setHasPurchases(List<Purchase> hasPurchases) {
        this.hasPurchases = hasPurchases;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                "username" + this.getUsername() +
                '}';
    }
}
