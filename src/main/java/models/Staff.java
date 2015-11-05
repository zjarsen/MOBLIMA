package models;

import controllers.MovieController;
import org.mongodb.morphia.annotations.Entity;

import java.util.Scanner;

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
        System.out.println("Please key in the details of the new movie");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the title: ");
        String title = sc.nextLine();
        System.out.println("Input the description ");
        String descripion = sc.nextLine();
        System.out.println("Input the showing status: (0: coming soon / 1: now showing / -1: over)");
        int status = sc.nextInt();
        sc.nextLine();
        System.out.println("Input the director's name: ");
        String director = sc.nextLine();
        System.out.println("Input the rating of the content: (age requirement)");
        int content_rating = sc.nextInt();
        System.out.println("Input the base price: ");
        double base_price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Input the type: ");
        String type = sc.nextLine();
        System.out.println("Input the length (minute): ");
        int length = sc.nextInt();

        Movie movie = new Movie(title, descripion, status, director, content_rating, base_price, type, length);
        MovieController movieController = new MovieController();
        movieController.newMovie(movie);
        System.out.println("Movie created.");
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
