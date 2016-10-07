package org.utn.labii.oop;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by nico on 9/23/16.
 */
public class MyDate {
    private short year;
    private Months month;
    private short day;

    private enum Months{
        Jan(31, 0), Feb(28, 3), Mar(31, 3),
        Apr(30, 6), May(31, 1), Jun(30, 4),
        Jul(31, 6), Aug(31, 2), Sep(30, 5),
        Oct(31, 0), Nov(30, 3), Dec(31, 5);

        private final int DaysAmount;
        private final int code;

        Months(int Days, int code){
            this.DaysAmount = Days;
            this.code = code;
        }

        public int numberOfDays(){
            return this.DaysAmount;
        }

        public int monthCode(){
            return this.code;
        }
    }

    private enum Days{
        Sunday, Monday, Tuesday, Wednesday,
        Thursday, Friday, Saturday
    }
   /* private enum Days{
        Saturday,Sunday, Monday, Tuesday, Wednesday,
        Thursday, Friday
    }*/

    private enum Table100sOfYears{/**/
        C16s(16, 0),
        C17s(17, 4),
        C18s(18, 2),
        C19s(19, 0),
        C20s(20, 6);
        /*C16s(16, 0),
        C17s(17, 5),
        C18s(18, 3),
        C19s(19, 1),
        C20s(20, 0);*/

        private final int centuryNumber;
        private final int century;

        Table100sOfYears(int century, int number){
            this.centuryNumber = number;
            this.century = century;
        }

        public int getCenturyNumber(){
            return this.centuryNumber;
        }

        public int getCentury(){
            return this.century;
        }

    }

    public static boolean isLeapYear(int year){
        return year % 4 == 0;
    }

    public static boolean isValidDate(int year, int month, int day){
        return true;
    }

    public static int getDayOfWeek(int year, int month, int day){
        int lastTd = yearLastTwoD(year);
        Table100sOfYears c = findCentury(year);
        int pos = (year + month + day + (lastTd / 4) + c.centuryNumber) % 7;
        return pos;
    }

    public MyDate(short year, short month, short day){
        this.year = year;
        this.month = assignMonth(month);
        this.day =  day;
    }

    private Months assignMonth(short pos) throws IllegalArgumentException{
        if(IntStream.rangeClosed(1, 12).noneMatch(value -> value == pos))
            throw new IllegalArgumentException("out of range");
        Months[] monthArr = Months.values();
        return monthArr[pos - 1];
    }

    private Days assignDayOfWeek(short dateNumber) throws IllegalArgumentException{
        if(IntStream.rangeClosed(1, this.month.numberOfDays()).noneMatch(value -> value == dateNumber))
            throw new IllegalArgumentException("out of range");
        Days[] days = Days.values();
        int pos = getDayOfTheWeek(dateNumber);
        return days[pos];
    }

    private int getDayOfTheWeek(short dateNumber){
        int leap = (this.month == Months.Jan || this.month == Months.Feb)
                ? isLeapYear(this.year) ? 1 : 0
                : 0;
        int lastTd = yearItem(this.year);
        Table100sOfYears c = findCentury(this.year);
        return (lastTd + this.month.monthCode() + dateNumber + c.centuryNumber - leap) % 7;

    }

    public int yearItem(int year){
        int lastTd = yearLastTwoD(year);
        return  (lastTd + (lastTd / 4)) % 7;
    }

    private static Table100sOfYears findCentury(int year){
        return Arrays.stream(Table100sOfYears.values())
                        .filter(v -> v.getCentury() == Math.round(year /100))
                        .findAny()
                        .get();
    }

    private static int yearLastTwoD(int year){
        return (int) year % 100;
    }

    private boolean validDay(){
        return false;
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

    public Months getMonth() {
        return month;
    }

    public short getDay() {
        return day;
    }


    public void setYear(short year) {
        this.year = year;
    }

    public void setMonth(short month) {
        this.month = assignMonth(month);
    }

    public void setDay(short day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%1$s %2$d %3$s %4$d", assignDayOfWeek(day), day, month, year);
    }


}