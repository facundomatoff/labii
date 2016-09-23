package org.utn.labii.oop;

/**
 * Created by nico on 9/23/16.
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    private enum Months{
        JAN, FEB, MAR,
        APR, MAY, JUN,
        JUL, AUG, SEP,
        OCT, NOV, DEC
    }

    private enum Day{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public static boolean isLeapYear(int year){
        return true;
    }

    public static boolean isValidDate(int year, int month, int day){
        return true;
    }

    public static int getDayOfWeek(int year, int month, int day){
        return 0;
    }

    public int getYear() {
        return year;
    }

    public MyDate nextDay(){
        return this;
    }
    public MyDate nextMonh(){
        return this;
    }
    public MyDate nextYear(){
        return this;
    }
    public MyDate previousDay(){
        return this;
    }
    public MyDate previousMoth(){
        return this;
    }
    public MyDate previousYear(){
        return this;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


}
