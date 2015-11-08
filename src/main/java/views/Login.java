package views;

import controllers.LoginController;
import models.Customer;
import models.Staff;

import java.util.Scanner;

/**
 * Created by zjarsen on 3/11/15.
 */
public class Login {
    private static Login login = new Login();

    public Login() {
    }

    public static Login getLogin() {
        return login;
    }

    public void doLogin(){
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter your username:");
        String username = sc.nextLine();
        System.out.println("Please Enter your password:");
        String password = sc.nextLine();
        LoginController loginController = new LoginController();
        Object user = loginController.doLogin(username, password);

        if (user == null) {
            System.out.println("");
            System.out.println("login failed. Check your username or password and retry");
            System.out.println("");
            System.out.println("");
        } else {
            if (user instanceof Customer) {
                CustomerView customerView = CustomerView.getCustomerView();
                customerView.showCustomerView((Customer)user);
            }

            if (user instanceof Staff) {
                StaffView staffView = StaffView.getStaffView();
                staffView.showStaffView((Staff)user);
            }
        }
    }
}
