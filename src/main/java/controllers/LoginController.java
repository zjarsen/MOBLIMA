package controllers;
import com.mongodb.MongoClient;
import models.Customer;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import models.Staff;
import java.util.List;
import java.util.logging.LogManager;

/**
 * Created by zjarsen on 3/11/15.
 */
public class LoginController {
    public LoginController() {
    }

    public Object doLogin(String username, String password) {
        LogManager.getLogManager().reset();

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
        for (int i = 0; i < existingStaffs.size(); i++) {
            if (existingStaffs.get(i).getUsername().equals(username)) {
                if (existingStaffs.get(i).getPassword().equals(password)) {
                    return existingStaffs.get(i);
                }
            }
        }

        return null;
    }
}
