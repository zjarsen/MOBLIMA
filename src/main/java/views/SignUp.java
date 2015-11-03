package views;

import controllers.SignUpController;
import models.Customer;

import java.util.Scanner;

/**
 * Created by zjarsen on 3/11/15.
 */
public class SignUp {
    private static SignUp signUp = new SignUp();

    public SignUp() {
    }

    public static SignUp getSignUp() {
        return signUp;
    }

    public void doSignUp() {
        System.out.println("\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = sc.nextLine();
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();
        System.out.println("Please enter your age: ");
        int age = sc.nextInt();
        Customer customer = new Customer(username, password, age);
        SignUpController signUpController = new SignUpController();
        signUpController.saveNewCustomer(customer);

    }
}
