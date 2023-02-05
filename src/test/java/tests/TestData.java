package tests;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    public String[] gender = {"Male", "Female", "Other"};
    public String[] hobbies = {"Sports", "Reading", "Music"};
    public String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};




    public String switchToMonth(String month) {
        String fullMonth = null;
        switch (month) {
            case "01":
                fullMonth = "January";
                break;
            case "02":
                fullMonth = "February";
                break;
            case "03":
                fullMonth = "March";
                break;
            case "04":
                fullMonth = "April";
                break;
            case "05":
                fullMonth = "May";
                break;
            case "06":
                fullMonth = "June";
                break;
            case "07":
                fullMonth = "July";
                break;
            case "08":
                fullMonth = "August";
                break;
            case "09":
                fullMonth = "September";
                break;
            case "10":
                fullMonth = "October";
                break;
            case "11":
                fullMonth = "November";
                break;
            case "12":
                fullMonth = "December";

        }
        return fullMonth;
    }


    public static String getСity(String state) {
        String[] ncr = {"Delhi", "Gurgaon", "Noida"},
                uttarPradesh = {"Agra", "Lucknow", "Merrut"},
                haryana = {"Karnal", "Panipat"},
                rajasthan = {"Jaipur", "Jaiselmer"};
        String city = null;
        switch (state) {
            case "NCR":
                city = randomItem(ncr);
                break;
            case "Uttar Pradesh":
                city = randomItem(uttarPradesh);
                break;
            case "Haryana":
                city = randomItem(haryana);
                break;
            case "Rajasthan":
                city = randomItem(rajasthan);
                break;
        }
        return city;

    }


    public static String randomItem(String[] values) {
        int index = randomInt(0, values.length - 1);

        return values[index];
    }

    private static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


}
