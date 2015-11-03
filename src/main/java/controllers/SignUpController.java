package controllers;

import com.mongodb.MongoClient;
import models.Customer;
import org.mongodb.morphia.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjarsen on 3/11/15.
 */
public class SignUpController {
    public SignUpController() {
    }

    public void saveNewCustomer(Customer customer) {

        Morphia morphia = new Morphia();

        // tell morphia where to find your classes
        // can be called multiple times with different packages or classes

        morphia.mapPackage("models");

        // create the Datastore connecting to the database running on the default port on the local host
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");

        List<Customer> existingCustomers = datastore.createQuery(Customer.class).asList();
        boolean isExisting = false;
        for (int i = 0; i < existingCustomers.size(); i++) {
            Customer temp = existingCustomers.get(i);
            if (temp.getUsername().equals(customer.getUsername())) {
                isExisting = true;
            }
        }

        if (isExisting == true) {
            System.out.println("the username exists. Change another one");
        } else {
            datastore.save(customer);
            System.out.println("Sign up succeeded! \n");
        }


    }
}
