package IncomeTracker;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;

public class IncomeTracker {

    // create an array to update its list with each user entry from the IncomeEntry class
    private ArrayList<IncomeEntry> entryList = new ArrayList<>(); // stays private so it cant be touched by other classes


    // public getter so others can read but not write list content
    public ArrayList<IncomeEntry> getEntryList() {
        return entryList;
    }



    // addEntry() method prompts user to fill in Income Entry fields

    public void addEntry() {
        Scanner input = new Scanner(System.in);
        int year, month, day;
        // get date input from user
        System.out.println("Enter the year - (ex. 2022): ");
        year = input.nextInt();

        System.out.println("Enter the month - (ex. 8): ");
        month = input.nextInt();

        System.out.println("Enter the day - (ex. 19): ");
        day = input.nextInt();

        // validate user date input
        int daysInMonth = YearMonth.of(year, month).lengthOfMonth();
        if (day > daysInMonth || day <= 0) {
            System.out.println("That day is invalid, please try again.");
            // prompt user to re-enter
            System.out.println("Enter the day - (ex. 19): ");
            day = input.nextInt();
        }

        // format date
        LocalDate date = LocalDate.of(year, month, day);
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        // prompt user to begin inputting earnings for formattedDate
        System.out.println("Enter total service earnings for " + formattedDate);
        double serviceEarnings = input.nextDouble();

        System.out.println("Enter total Credit Card Tips for " + formattedDate);
        double tips = input.nextDouble();

        System.out.println("Enter the cleaning fee for " + formattedDate);
        int cleaningFee = input.nextInt();

        // calculate net tips (after 2% charge)
        double netTips = tips * 0.98;

        // calculate take home pay, my 60% cut and deduct cleaning fee for the day
        double takeHomePay = (serviceEarnings * 0.60) + netTips - cleaningFee;

        // calculate total income
        double totalIncome = serviceEarnings + tips;

        // store entry as new entry in the array list
        IncomeEntry entry = new IncomeEntry(formattedDate, serviceEarnings, tips, cleaningFee, takeHomePay, totalIncome);
        entryList.add(entry);

        // confirm entry to user
        System.out.println("Entry for " + formattedDate + " added successfully!\n" +
                "Take home pay: $" + takeHomePay);
    } // END addEntry();


    // viewEntriesByPayPeriod() method allows the user to input which pay period (1 or 2) they'd like to view entries for
    public void viewEntriesByPayPeriod() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter which pay period you'd like to view (Enter 1 or 2): ");
        int choice = input.nextInt();

        String period = " ";

        // if/else statements to validate choice input
        if (choice == 1) {
            period = "Pay Period 1 (1st - 15th)";
        } else if (choice == 2) {
            period = "Pay Period 2 (16th - End)";
        } else {
            System.out.println("Invalid choice. Enter 1 or 2");
            return; // END
        }
    } // END viewEntriesByPayPeriod()

    // getEntriesByPayPeriod() will display results based on entry
    public ArrayList<IncomeEntry> getEntriesByPayPeriod(String period) {
        ArrayList<IncomeEntry> resultList = new ArrayList<>();

        for (IncomeEntry entry : entryList) {
            if (entry.getPayPeriod().equals(period)) {
                resultList.add(entry);
            }
        }

        // Get matching entries from the list
        ArrayList<IncomeEntry> results = getEntriesByPayPeriod(period);

// Check if results are empty
        if (results.isEmpty()) {
            System.out.println("No entries found for that pay period.");
        } else {
            System.out.println("Entries for " + period + ":");
            for (IncomeEntry entry : results) {
                System.out.println("Date: " + entry.getDate() +
                        " | Service: $" + entry.getServiceEarnings() +
                        " | Tips: $" + entry.getTips() +
                        " | Fee: $" + entry.getCleaningFee() +
                        " | Take-Home: $" + entry.getTakeHomePay());
            }
        }

        return resultList;
    } // END getEntriesByPayPeriod()

    // calculate totals. loop through each element and increment the elements.
    public void calculateTotals() {
        Scanner input = new Scanner(System.in);

        // prompt user for the date so you can calculate the totals by period
        System.out.println("Enter which pay period you'd like to view (Enter 1 or 2): ");
        int choice = input.nextInt();

        String period = " ";

        // if/else statements to validate choice input
        if (choice == 1) {
            period = "Pay Period 1 (1st - 15th)";
        } else if (choice == 2) {
            period = "Pay Period 2 (16th - End)";
        } else {
            System.out.println("Invalid choice. Enter 1 or 2");
            return; // END
        }

        double totalServiceEarnings = 0.0;
        double totalNetTips = 0.0;
        int totalCleaningFee = 0;
        double totalTakeHomePay = 0.0;

        for (IncomeEntry entry : entryList) {
            if (entry.getPayPeriod().equals(period)) {
                totalServiceEarnings += entry.getServiceEarnings();
                totalNetTips += entry.getTips() * 0.98;
                totalCleaningFee += entry.getCleaningFee();
                totalTakeHomePay += entry.getTakeHomePay();
            }
        }

        // print results
        System.out.println("**** Entries for " + period + ": ***** \n" +
                " | Total Services: $" + totalServiceEarnings + "\n" +
                " | Total Tips: $" + totalNetTips + "\n" +
                " | Total Cleaning Fee: $" + totalCleaningFee + "\n" +
                " | Total Take Home Pay: $" + totalTakeHomePay);


    } // END calculateTotals()



}
