import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Figure {
    private int day, fips, cases, deaths;

    public Figure(int day, int fips, int cases, int deaths){
        this.day = day;
        this.fips = fips;
        this.cases = cases;
        this.deaths = deaths;
    }

    public int getDeaths(){
        return this.deaths;
    }

    public int getDay() {
        return day;
    }

    public int getFips() {
        return fips;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public String toString() {
        return "Day: " + day + " Fips: " + fips + " Cases: " + cases + " Deaths: " + deaths;
    }

    public static int ifromdate(String[] date) {
        int retval = 0;
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        for(int i = year - 1; i >= 2020; i--){
            if(isLeapYear(i)){
                retval += 366;
            } else {
                retval += 365;
            }
        }

        for(int i = month - 1; i >= 1; i--){
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
                retval += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11){
                retval += 30;
            } else if (i == 2){
                if (isLeapYear(year)){
                    retval += 29;
                } else {
                    retval += 28;
                }
            }
        }

        retval += day;

        return retval;
    }

    private static boolean isLeapYear(int year) {
        boolean retval;
        if(year % 4 == 0){
            if(year % 100 == 0){
                if (year % 400 == 0){
                    retval = true;
                } else {
                    retval = false;
                }
            } else {
                retval = true;
            }
        } else {
            retval = false;
        }
        return retval;
    }

    public static int getTotalDeathsOnDay(ArrayList<Figure> data, int day){
        int totalDeaths = 0;
        for (Figure e: data) {
            if (e.getDay() == day){
                totalDeaths += e.getDeaths();
            }
        }
        return totalDeaths;
    }
}
