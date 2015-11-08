package views;

import com.mongodb.MongoClient;
import models.Cinema;
import models.Cineplex;
import models.Seat;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Staff;
import org.mongodb.morphia.query.UpdateOperations;


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

    public void addStuff() {
        System.out.println("Choose what to add");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. admin");
        System.out.println("2. add Cineplex");
        System.out.println("3. add Cinemas");
        System.out.println("4. add Seats");
        int choice = sc.nextInt();
        Morphia morphia = new Morphia();
        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "MOBLIMA");
        datastore.ensureIndexes();



        switch (choice) {
            case 1:
                Staff staff = new Staff("staff1", "qpqpqpqp");
                datastore.save(staff);
                System.out.println("staff added");
                break;
            case 2:
                Cineplex cineplex1 = new Cineplex("HelloworldPlex", "Jurong");
                Cineplex cineplex2 = new Cineplex("SomeRandomPlex", "Marina");
                Cineplex cineplex3 = new Cineplex("YetAnotherPlex", "HabourFront");
                Cineplex cineplex4 = new Cineplex("PbnjPlex", "Orchard");

                datastore.save(cineplex1);
                datastore.save(cineplex2);
                datastore.save(cineplex3);
                datastore.save(cineplex4);
                System.out.println("cineplexes saved");
                break;
            case 3:
                List<Cineplex> cineplexes = datastore.createQuery(Cineplex.class).asList();
                Cinema[] cinemas = new Cinema[3];
                for (int i = 0; i < cineplexes.size(); i++) {
                    cinemas[0] = new Cinema((cineplexes.get(i).getLocation() + 0), "class1");
                    cinemas[0].setHasCineplexId(cineplexes.get(i).getId());
                    cinemas[1] = new Cinema((cineplexes.get(i).getLocation() + 1), "class2");
                    cinemas[1].setHasCineplexId(cineplexes.get(i).getId());
                    cinemas[2] = new Cinema((cineplexes.get(i).getLocation() + 2), "class3");
                    cinemas[2].setHasCineplexId(cineplexes.get(i).getId());
                    datastore.save(cinemas[0]);
                    datastore.save(cinemas[1]);
                    datastore.save(cinemas[2]);
                }

                List<Cineplex> storedCineplexes = datastore.createQuery(Cineplex.class).asList();
                List<Cinema> storedCinemas = datastore.createQuery(Cinema.class).asList();

                for (int i = 0; i < storedCinemas.size(); i++) {
                    for (int j = 0; j < storedCineplexes.size(); j++) {
                        if (storedCinemas.get(i).getHasCineplexId().equals(storedCineplexes.get(j).getId())){
                            Query<Cineplex> overPaidQuery = datastore.createQuery(Cineplex.class).field("id").equal(storedCineplexes.get(j));
                            datastore.delete(overPaidQuery);
                            storedCineplexes.get(j).addCinemaId(storedCinemas.get(i).getId());
                            datastore.save(storedCineplexes.get(j));
                        }
                    }
                }
                break;
            case 4:
                List<Cinema> existingCinemas = datastore.createQuery(Cinema.class).asList();

                Seat[] seats = new Seat[20];
                for (int i = 0; i < existingCinemas.size(); i++) {
                    for (int j = 0; j < 20; j++) {
                        seats[j] = new Seat(j, existingCinemas.get(i).getId());
                        datastore.save(seats[j]);
                    }
                }

                List<Seat> seatsInServer = datastore.createQuery(Seat.class).asList();

                for (int i = 0; i < seatsInServer.size(); i++) {
                    for (int j = 0; j < existingCinemas.size(); j++) {
                        if (seatsInServer.get(i).getHasCinemaId().equals(existingCinemas.get(j).getId())) {
                            existingCinemas.get(j).addSeatsId(seatsInServer.get(i).getId());
                        }
                    }
                }

                Query<Cinema> cinemasInServer = datastore.createQuery(Cinema.class);
                datastore.delete(cinemasInServer);

                for (int i = 0; i < existingCinemas.size(); i++) {
                    datastore.save(existingCinemas.get(i));
                }

                break;
            case 5:

                break;
            default:
                return;
        }
    }
}
