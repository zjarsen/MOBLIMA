package views;


import models.Customer;

import java.util.Scanner;

/**
 * Created by zjarsen on 4/11/15.
 */
public class CustomerView {
    private CustomerView customerView = new CustomerView();

    public CustomerView() {
    }

    public CustomerView getCustomerView() {
        return customerView;
    }

    public void showCustomerView(Customer customer) {
        System.out.println("Hi Jiahui Zhu! You are logged in as a customer. Enter the index to choose from the following options");
        System.out.println("1. Search a movie");
        System.out.println("2. List movies");
        System.out.println("3. Check booking history");
        System.out.println("4. List the Top 5 movies by ratings");
        System.out.println("5. Log out");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("to be continued");
        }

    }
}
