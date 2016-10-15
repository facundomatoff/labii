package org.utn.labii.oop;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by nico on 9/23/16.
 */
public class MyDate implements Comparable<MyDate> {

    private short year;
    private Months month;
    private short day;

    private enum Months{
        NONE(0,0,0),
        Jan(1, 31, 0), Feb(2, 28, 3), Mar(3, 31, 3),
        Apr(4, 30, 6), May(5, 31, 1), Jun(6, 30, 4),
        Jul(7, 31, 6), Aug(8, 31, 2), Sep(9, 30, 5),
        Oct(10, 31, 0), Nov(11, 30, 3), Dec(12, 31, 5);

        private final int position;
        private final int DaysAmount;
        private final int code;

        Months(int position, int Days, int code){
            this.position = position;
            this.DaysAmount = Days;
            this.code = code;
        }

        public int numberOfDays(){
            return this.DaysAmount;
        }

        public int monthCode(){
            return this.code;
        }

        public int monthPosition(){
            return this.position;
        }
    }

    /**
     * Days of the week are matched with numbers
     * starting from 0 for Sunday
     */
    private enum Days{
        Sunday, Monday, Tuesday, Wednesday, Thursday,
        Friday, Saturday
    }

    private enum Table100sOfYears{
        C16s(16, 0), C17s(17, 4), C18s(18, 2),
        C19s(19, 0), C20s(20, 6);

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

    public MyDate(short year, short month, short day){
        this.year = year;
        if(assignMonth(month) == null){
            throw new IllegalArgumentException("invalid argument");
        }
        this.month = assignMonth(month);
        this.day =  day;
    }

    /*public MyDate(String date, DateFormat df){
        String[] numbers = date.split(df.getSeparator());
        this.year =(short) Integer.parseInt(numbers[0]);
        this.day =(short) Integer.parseInt(numbers[0]);
        this.month =assignMonth((short) Integer.parseInt(numbers[0]));
    }*/

    public void setDate(short year, short month, short day){
        this.year = year;
        if(assignMonth(month) == null){
            throw new IllegalArgumentException("invalid argument");
        }
        this.month = assignMonth(month);
        this.day =  day;
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

    //metercomparaciones

    public void setYear(short year) {
        this.year = year;
    }
    //metercomparaciones
    public void setMonth(short month) {
        this.month = assignMonth(month);
    }
    //metercomparaciones
    public void setDay(short day) {
        this.day = day;
    }

    /**
     * Verify if the given year is a leap year
     * @param year
     * @return {@code true} for leap year otherwise {@code false}
     */
    public static boolean isLeapYear(int year){
        if(year % 400 == 0) return true;
        if(year % 100 == 0) return false;
        return (year % 4 == 0);
    }

    /*public static boolean isValidDate2(int year, int month, int day){
        Months m = assignMonth((short) month);//obtain month from enum
        if(m == null) return false;//no valid month
        int leap = //Feb in a leap year not the same
                (isLeapYear(year) && m.equals(Months.Feb))? 1 : 0;
        boolean notProperRange = //proper range?
                IntStream.rangeClosed(1, m.numberOfDays() + leap).noneMatch(value -> value == day);
        if(notProperRange){
            return false;
        }
        return year < 3000;
    }*/

    /**
     * Verify if a given date is valid
     * @param year
     * @param month
     * @param day
     * @return {@code true} if the date is valir otherwise {@code false}
     */
    public static boolean isValidDate(int year, int month, int day){
        Months m = assignMonth((short) month);//obtain month from enum
        if(m == null){
            return false;//no valid month
        }
        if(isLeapYear(year) && m.equals(Months.Feb) && day == 28){
            return false;
        }
        boolean notProperRange2 = day < 1 && day > m.numberOfDays();
        if(notProperRange2){
            return false;
        }
        return true;
    }

    /**
     * Accesory method that returns a the position in a scale
     * from 0(Sunday) to 6(Saturday) corresponding to the day of the week
     * @param year
     * @param monthNumber
     * @param day
     * @return an integer that matches a day of the week
     */
    public static int getDayOfWeek(int year, int monthNumber, int day){
        Months month = assignMonth((short) monthNumber);
        int leap =
                (month == Months.Jan || month == Months.Feb)
                        ? isLeapYear(year) ? 1 : 0
                        : 0;
        int lastTd = yearItem(year);
        Table100sOfYears c = findCentury(year);
        return (lastTd + month.monthCode() + day + c.centuryNumber - leap) % 7;
    }

    /*private static Months assignMonth(short pos){
        if(IntStream.rangeClosed(1, 12).noneMatch(value -> value == pos)){
            return null;
        }
        Months[] monthArr = Months.values();
        return monthArr[pos];
    }*/

    /**
     * Match a given month position
     * to his internal enum representation
     * @param pos
     * @return
     */
    private static Months assignMonth(short pos){
        if(pos < 1 && pos > 12){
            return null;
        }
        Months[] monthArr = Months.values();
        return monthArr[pos];
    }

    /**
     * Method that matches an integer witch represents the day of
     * the week for a given date with the internal representation enum
     * @param year
     * @param monthNumber
     * @param dateNumber
     * @return {@code Days}
     */
    private static Days assignDayOfWeek(int year, int monthNumber, int dateNumber){
        Months month = assignMonth((short) monthNumber);
        int leap = (isLeapYear(year) && month.equals(Months.Feb))? 1 : 0;
        if(dateNumber < 1 && dateNumber > month.numberOfDays() + leap){
            return null;
        }
        Days[] days = Days.values();
        int pos = getDayOfWeek(year, month.monthPosition(), dateNumber);
        return days[pos];
    }

    /*private static Days assignDayOfWeek(int year, int monthNumber, int dateNumber){
        Months month = assignMonth((short) monthNumber);
        int leap = (isLeapYear(year) && month.equals(Months.Feb))? 1 : 0;
        if(IntStream.rangeClosed(1, month.numberOfDays() + leap).noneMatch(value -> value == dateNumber)){
            return null;
        }
        Days[] days = Days.values();
        int pos = getDayOfWeek(year, month.monthPosition(), dateNumber);
        return days[pos];
    }*/

    /*private int getDayOfTheWeek(short dateNumber){
        int leap =
                (this.month == Months.Jan || this.month == Months.Feb)
                    ? isLeapYear(this.year) ? 1 : 0
                    : 0;
        int lastTd = yearItem(this.year);
        Table100sOfYears c = findCentury(this.year);
        return (lastTd + this.month.monthCode() + dateNumber + c.centuryNumber - leap) % 7;
    }*/

    private static int yearItem(int year){
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


    @Override
    public int compareTo(MyDate o) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(
                "%1$s %2$d %3$s %4$d",
                assignDayOfWeek(year, month.monthPosition(), day),
                day,
                month,
                year
        );
    }


}