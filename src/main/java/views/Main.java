package views;

import sun.rmi.runtime.Log;

import java.util.Scanner;

/**
 * Created by zjarsen on 3/11/15.
 */
public class Main {
    private static Main main = new Main();

    private Main() {
    }

    public static Main getMain() {
        return main;
    }

    public void enterMain() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("<<<<< Main >>>>>");
            System.out.println("welcome to MOBLIMA");
            System.out.println("Enter the index to choose from the following options");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Quit\n");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Login login = Login.getLogin();
                    login.doLogin();
                    break;
                case 2:
                    SignUp signUp = SignUp.getSignUp();
                    signUp.doSignUp();
                    break;
                case 3:
                    System.exit(0);
                    break;
                case 4:
                    TempAddStuff addStuff = TempAddStuff.getAddStuff();
                    addStuff.addStaff();
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }

    }


}
