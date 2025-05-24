package IncomeTracker;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        // instantiate Income Tracker object
        IncomeTracker tracker = new IncomeTracker();

        // start menu loop
        do {
            displayMenu();
            choice = input.nextInt();

            // switch case to manage menu option choices
            switch (choice) {
                case 1: // add todays earnings
                    tracker.addEntry();
                    break;

                case 2: // view earnings by pay period
                    tracker.viewEntriesByPayPeriod();
                    break;

                case 3: // calculate totals according to pay period
                    tracker.calculateTotals();
                    break;

                case 0:
                    System.out.println("Exiting the menu...");
                    break;

                default:
                    System.out.println("Invalid choice, try again");
            }

        } while (choice != 0);


    }

    // create menu
    public static void displayMenu() {
        System.out.println("**** INCOME TRACKER MENU ****");
        System.out.println("\n\n"); // create spacing
        System.out.println("Enter a choice");
        System.out.println("1: Enter Today's Earnings");
        System.out.println("2: View Entries by Pay Period");
        System.out.println("3: Calculate Totals by Pay Period");
        System.out.println("0: Exit");

    }
}
