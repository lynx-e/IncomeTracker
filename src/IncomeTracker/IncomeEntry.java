package IncomeTracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IncomeEntry {

    // PRIVATE VARIABLES

    private String date;
    private double serviceEarnings;
    private double tips;
    private int cleaningFee;
    private double takeHomePay;
    private double totalIncome;

    // GETTERS AND SETTERS

    /**
     * Get date
     * @return date
     */

    public String getDate() {
        return date;
    }

    /**
     * Set date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get Service earnings
     * @return service earnings
     */
    public double getServiceEarnings() {
        return serviceEarnings;
    }

    /**
     * Set service earnings
     * @param serviceEarnings
     */
    public void setServiceEarnings(double serviceEarnings) {
        this.serviceEarnings = serviceEarnings;
    }

    /**
     * Get tips
     * @return tips
     */
    public double getTips() {
        return tips;
    }

    /**
     * Set tips
     * @param tips
     */
    public void setTips(double tips) {
        this.tips = tips;
    }

    /**
     * Get cleaning fee
     * @return cleaning fee
     */
    public int getCleaningFee() {
        return cleaningFee;
    }

    /**
     * Set cleaning fee
     * @param cleaningFee
     */

    public void setCleaningFee(int cleaningFee) {
        this.cleaningFee = cleaningFee;
    }

    /**
     * Get take home pay
     * @return take home pay
     */
    public double getTakeHomePay() {
        return takeHomePay;
    }

    /**
     * Set take home pay
     * @param takeHomePay
     */
    public void setTakeHomePay(double takeHomePay) {
        this.takeHomePay = takeHomePay;
    }

    /**
     * Get total income
     * @return total income
     */
    public double getTotalIncome() {
        return totalIncome;
    }

    /**
     * Set total income
     * @param totalIncome
     */
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    // DEFAULT CONSTRUCTOR
    /**
     * Construct a new {@code IncomeEntry} with default values
     * <ul>
     *     <li>Date: "Unknown date"</li>
     *     <li>Service Earnings: 0.0</li>
     *     <li>Tips: 0.0</li>
     *     <li>Cleaning Fee: 0</li>
     *     <li>Take Home Pay: 0.0</li>
     *     <li>Total Income: 0.0</li>
     * </ul>
     */
    public IncomeEntry() {
        this.date = "Unknown date";
        this.serviceEarnings = 0.0;
        this.tips = 0.0;
        this.cleaningFee = 0;
        this.takeHomePay = 0.0;
        this.totalIncome = 0.0;
    }

    // PARAMETERIZED CONSTRUCTOR
    /**
     * Construct a new {@code IncomeEntry} with specified values
     */
    public IncomeEntry(String date, double serviceEarnings, double tips, int cleaningFee, double takeHomePay, double totalIncome) {
        this.date = date;
        this.serviceEarnings = serviceEarnings;
        this.tips = tips;
        this.cleaningFee = cleaningFee;

        // CALCULATE TAKE HOME PAY - 60% of serviceEarnings
        this.takeHomePay = serviceEarnings * 0.60;

        // CALCULATE AND SUBTRACT 2% TIP CHARGE (credit card tips)
        double ccTipFee = tips * 0.02;
        double netTips = tips - ccTipFee;
    }

    // GET PAY PERIOD METHOD
    public String getPayPeriod() {
        // Assumes date format is "dd-MM-yyyy"
        String[] parts = this.date.split("-");
        int day = Integer.parseInt(parts[1]); // Get the "dd" part

        if (day >= 1 && day <= 15) {
            return "Pay Period 1 (1st - 15th)";
        } else if (day >= 16 && day <= 31) {
            return "Pay Period 2 (16th - End)";
        } else {
            return "Invalid date, try again";
        }
    }



}
