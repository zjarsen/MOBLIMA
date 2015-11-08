package models;

import controllers.CinemaController;
import controllers.MovieController;
import controllers.ShowTimeController;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.query.Query;

import java.util.List;
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
        System.out.println("Input the discount rate: ");
        double discountRate = sc.nextDouble();

        Movie movie = new Movie(title,descripion,status,director,content_rating,base_price,type,length,discountRate);
        MovieController movieController = new MovieController();
        movieController.newMovie(movie);
        System.out.println("Movie created.");
    }

    public void updateListing() {
        System.out.println("");
        System.out.println("the movies in the database: ");
        System.out.println("");
        MovieController movieController = new MovieController();
        List<Movie> movies = movieController.getAllMovies();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + ". Title: " + movies.get(i).getTitle() + " // Description: " +movies.get(i).getDescripion() + " // Base Price: " + movies.get(i).getBase_price() + " // Discount Rate: " + movies.get(i).getDiscountRate() + " // Showing Status: " + movies.get(i).getStatus());
        }
        System.out.println("");
        System.out.println("Select the movie to update: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Your choice: ");
        int choice = sc.nextInt();
        System.out.println("");
        System.out.println("the movie you selected is: ");
        System.out.println(choice + ". Title: " + movies.get(choice).getTitle() + " // Description: " +movies.get(choice).getDescripion() + " // Base Price: " + movies.get(choice).getBase_price() + " // Discount Rate: " + movies.get(choice).getDiscountRate() + " // Showing Status: " + movies.get(choice).getStatus());
        System.out.println("");
        System.out.println("Select your choice: ");
        System.out.println("1. Update the showing status");
        System.out.println("2. Update the description");
        System.out.println("3. Update the base price");
        System.out.println("4. Update the discount rate");
        System.out.println("");
        System.out.println("Your choice: ");

        int choiceOfAction = sc.nextInt();
        System.out.println("");
        switch (choiceOfAction) {
            case 1:
                System.out.println("enter the new showing status: (0: coming soon / 1: now showing / -1: over): ");
                movies.get(choice).setStatus(sc.nextInt());
                movieController.deleteMovieFromServer(movies.get(choice).getId());
                movieController.newMovie(movies.get(choice));
                break;
            case 2:
                System.out.println("enter the new description: ");
                movies.get(choice).setDescripion(sc.nextLine());
                movieController.deleteMovieFromServer(movies.get(choice).getId());
                movieController.newMovie(movies.get(choice));
                break;
            case 3:
                System.out.println("enter the new base price: ");
                movies.get(choice).setBase_price(sc.nextDouble());
                movieController.deleteMovieFromServer(movies.get(choice).getId());
                movieController.newMovie(movies.get(choice));
                break;
            case 4:
                System.out.println("enter the new discount rate: ");
                movies.get(choice).setDiscountRate(sc.nextDouble());
                movieController.deleteMovieFromServer(movies.get(choice).getId());
                movieController.newMovie(movies.get(choice));
                break;
            default:
                break;
        }
        System.out.println("");
        System.out.println("Update succeeded");
    }

    public void updateShowtime() {
        MovieController movieController = new MovieController();
        CinemaController cinemaController = new CinemaController();
        List<Cinema> cinemas = cinemaController.getAllCinemas();
        List<Movie> movies = movieController.getAllMovies();
        System.out.println("the movies in the database: ");
        System.out.println("");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + ". " + movies.get(i).getTitle());
        }
        System.out.println("");
        System.out.println("Enter the index of movie to update: ");
        Scanner sc = new Scanner(System.in);
        int choiceOfMovie = sc.nextInt();
        System.out.println("the cinemas in the database: ");
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println(i + ". " + cinemas.get(i).getName());
        }
        System.out.println("");
        System.out.println("Enter the index of cinema to update: ");
        int choiceOfCinema = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        System.out.println("Enter the show time: (example: 23_7 as 23th of July, 4_12 as 4th of December)");
        String showTime = sc.nextLine();
        ShowTimeController showTimeController = new ShowTimeController();
        showTimeController.newShowTime(showTime, cinemas.get(choiceOfCinema).getId(), movies.get(choiceOfMovie).getId());
        System.out.println("");
        System.out.println("Update succeeded");
    }

    public void configureSettings() {
        System.out.println("configure settings");
    }
}
