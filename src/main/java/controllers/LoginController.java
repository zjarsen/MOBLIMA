package controllers;
import com.mongodb.MongoClient;
import models.Customer;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import models.Staff;
import java.util.List;

/**
 * Created by zjarsen on 3/11/15.
 */
public class LoginController {
    public LoginController() {
    }

    public Object doLogin(String username, String password) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
        List<Customer> existingCustomers = datastore.createQuery(Customer.class).asList();

        for (int i = 0; i < existingCustomers.size(); i++) {
            if (existingCustomers.get(i).getUsername().equals(username)) {
                if (existingCustomers.get(i).getPassword().equals(password)) {
                    return existingCustomers.get(i);
                }
            }
        }

        List<Staff> existingStaffs = datastore.createQuery(Staff.class).asList();
        System.out.println(existingStaffs.size());
        for (int i = 0; i < existingStaffs.size(); i++) {
            System.out.println(existingStaffs.get(i).getUsername());
            if (existingStaffs.get(i).getUsername().equals(username)) {
                if (existingStaffs.get(i).getPassword().equals(password)) {
                    return existingStaffs.get(i);
                }
            }
        }

        return null;
    }
}
