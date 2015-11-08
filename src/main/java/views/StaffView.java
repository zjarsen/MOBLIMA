package views;
import models.Staff;

import java.util.Scanner;

/**
 * Created by zjarsen on 5/11/15.
 */
public class StaffView {
    private static StaffView staffView = new StaffView();

    public StaffView() {
    }

    public static StaffView getStaffView() {
        return staffView;
    }

    public void showStaffView(Staff staff) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int choiceForListing = 0;
        while(choice != 4) {

            System.out.println("");
            System.out.println("");
            System.out.println("<<<<< Admin >>>>>");
            System.out.println("Hi " + staff.getUsername() + " ! You are logged in as a staff. Enter the index to choose from the following options");
            System.out.println("1. Create/Update/Remove movie listing");
            System.out.println("2. Update a cinema showtimes");
            System.out.println("3. Configure system settings");
            System.out.println("4. Log out\n");

            System.out.println("Your choice: ");


            choice = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    while (choiceForListing != 4) {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("<<<<< Admin-Listing >>>>>");
                        System.out.println("Enter the index to choose from the following options");
                        System.out.println("1. Create a new movie listing");
                        System.out.println("2. Update a movie listing");
                        System.out.println("3. Configure settings");
                        System.out.println("4. Back\n");
                        System.out.println("Your choice: ");
                        choiceForListing = sc.nextInt();
                        switch (choiceForListing) {
                            case 1:
                                staff.createListing();
                                break;
                            case 2:
                                staff.updateListing();
                                break;
                            case 3:
                                System.out.println("tobecontined");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("wrong choice");
                        }
                    }
                    break;
                case 2:
                    staff.updateShowtime();
                    break;
                case 3:
                    staff.configureSettings();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }

    }
}
