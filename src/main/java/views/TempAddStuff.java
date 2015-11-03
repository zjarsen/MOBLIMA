package views;

import com.mongodb.MongoClient;
import models.Customer;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;
import java.util.Scanner;
import models.Staff;

/**
 * Created by zjarsen on 3/11/15.
 */
public class TempAddStuff {
    private static TempAddStuff addStuff = new TempAddStuff();

    public TempAddStuff() {
    }

    public static TempAddStuff getAddStuff() {
        return addStuff;
    }

    public void addStaff() {
        System.out.println("Choose what to add");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. admin");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:

                Staff staff = new Staff("staff1", "qpqpqpqp");
                Morphia morphia = new Morphia();
                morphia.mapPackage("models");
                Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
                datastore.save(staff);
                System.out.println("staff added");
                break;
            default:
                return;
        }
    }
}
