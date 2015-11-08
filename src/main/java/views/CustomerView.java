package views;


import controllers.LoginController;
import controllers.MovieController;
import models.Customer;
import models.Movie;

import java.util.List;
import java.util.Scanner;

/**
 * Created by zjarsen on 4/11/15.
 */
public class CustomerView {
    private static CustomerView customerView = new CustomerView();

    public CustomerView() {
    }

    public static CustomerView getCustomerView() {
        return customerView;
    }

    public void showCustomerView(Customer customer) {
        LoginController loginController = new LoginController();
        customer = loginController.getCustomer(customer.getUsername());
        Scanner sc = new Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("");
            System.out.println("Hi " + customer.getUsername() + "! You are logged in as a customer. Enter the index to choose from the following options");
            System.out.println("1. Search a movie");
            System.out.println("2. List movies");
            System.out.println("3. Check booking history");
            System.out.println("4. List the Top 5 movies by ratings");
            System.out.println("5. Log out");
            System.out.println("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            switch (choice) {
                case 1:
                    System.out.println("Please input the movie's name");
                    String movieName = sc.nextLine();
                    MovieController movieController = new MovieController();
                    List<Movie> moviesInDatabase = movieController.getAllMovies();
                    boolean isFound = false;
                    double price;
                    for (int i = 0; i < moviesInDatabase.size(); i++) {
                        if (moviesInDatabase.get(i).getTitle().equals(movieName)) {
                            isFound = true;
                            System.out.println("Title: " + moviesInDatabase.get(i).getTitle() + " // Description: " + moviesInDatabase.get(i).getDescripion() + " // Showing Status: " + moviesInDatabase.get(i).getStatus() + " // Director: " + moviesInDatabase.get(i).getDirector() + " // Age required: " + moviesInDatabase.get(i).getContent_rating() + " // Rating: " + moviesInDatabase.get(i).getAverage_rating() + " // Base Price: " + moviesInDatabase.get(i).getBase_price() + " // Type: " + moviesInDatabase.get(i).getType() + " // Length:" + moviesInDatabase.get(i).getLength() + " // Discount Rate: " + moviesInDatabase.get(i).getDiscountRate());
                            if (customer.getAge() < moviesInDatabase.get(i).getContent_rating()) {
                                System.out.println("");
                                System.out.println("Sorry! You are toooooo young for this movie. Try another one");
                                break;
                            }
                            price = moviesInDatabase.get(i).getBase_price();
                            if ((customer.getAge() <= 18) || (customer.getAge() >= 60)) {
                                price = price * moviesInDatabase.get(i).getDiscountRate();
                                System.out.println("You are eligible for the discount of this movie, and your price for this movie is: " + price);
                            }
                            int toBook = -1;
                            while (toBook != 1 && toBook != 2) {
                                System.out.println("Do you want to book this ticket?");
                                System.out.println("1. yes");
                                System.out.println("2. no");
                                System.out.println("Your choice: ");
                                toBook = sc.nextInt();
                                switch(toBook) {
                                    case 1:
                                        System.out.println("book ticket");
                                        System.out.println("to be continued");
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("wrong choice");
                                }
                            }
                        }
                        if (isFound == false) {
                            System.out.println("cannot find the movie " + movieName);
                        }
                    }
                    break;
                case 2:
                    System.out.println("hello");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        }



    }
}
