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
    private List<ObjectId> hasPurchases = new ArrayList<ObjectId>();

    public Customer() {
    }

    public Customer(String username, String password, int age) {
        super(username, password);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ObjectId> getHasPurchases() {
        return hasPurchases;
    }

    public void setHasPurchases(List<ObjectId> hasPurchases) {
        this.hasPurchases = hasPurchases;
    }

    public void addPurchase(ObjectId purchaseID) {
        this.hasPurchases.add(purchaseID);
    }
}
