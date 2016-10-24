package org.utn.labii.oop;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by nico on 9/23/16.
 */
public class MyDate implements Comparable<MyDate> {

    private int year;
    private Months month;
    private int day;

    /**
     * Internal representation for months with some additional
     * data to perform several calculations
     */
    private enum Months{
        ALL(12,365,0),
        Jan(1, 31, 0), Feb(2, 28, 3), Mar(3, 31, 3),
        Apr(4, 30, 6), May(5, 31, 1), Jun(6, 30, 4),
        Jul(7, 31, 6), Aug(8, 31, 2), Sep(9, 30, 5),
        Oct(10, 31, 0), Nov(11, 30, 3), Dec(12, 31, 5);

        private final int number;
        private final int DaysAmount;
        private final int code;

        Months(int number, int Days, int code){
            this.number = number;
            this.DaysAmount = Days;
            this.code = code;
        }

        public int numberOfDays(){
            return this.DaysAmount;
        }

        public int monthCode(){
            return this.code;
        }

        public int getNumber(){
            return this.number;
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

    /**
     * This object is an accessory to be used in day of week calculation
     * method
     */
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

    /**
     * Constuctor method
     * @param year
     * @param month
     * @param day
     */
    public MyDate(int year, int month, int day){
        this.year = year;
        if(assignMonth(month) == null){
            throw new IllegalArgumentException("invalid argument");
        }
        this.month = assignMonth(month);
        this.day =  day;
    }

    /**
     * Set the year
     * @param year
     * @param month
     * @param day
     */
    public void setDate(int year, int month, int day){
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

    /**
     * Performs the calculation of the date corresponding
     * to the next day of the current MyDate object
     * @return the next day {@code MyDate} Object
     */
    public MyDate nextDay(){
        //any day between 1 and until last day
        if(this.day < this.month.numberOfDays()){//add a day
            int nextDay = this.day + 1;
            return new MyDate(this.year, this.month.getNumber(),  nextDay);
        }else if(!this.month.equals(Months.Dec)){//if last day of the a given month except DEC is reached
            //if is a leap year and the last day of Feb is 29
            if(isLeapYear(this.year) && this.month.equals(Months.Feb) && this.day == Months.Feb.numberOfDays()){
                int nextDay = this.day + 1;
                return new MyDate(this.year, this.month.getNumber(),  nextDay);
            }else {
                //not a leap year
                int nextMonth = this.month.getNumber() + 1;
                return new MyDate(this.year,  nextMonth ,  1);
            }
        }
        //last day of year
        int nextYear = this.year + 1;
        return new MyDate( nextYear,  Months.Jan.getNumber() ,  1);
    }

    /**
     * Returns the next year of a given
     *
     * SOME EXPLANATIONS:
     * if Dec it need to move to the next, year to
     * if the day is grater than number of days of next month
     * then you need to take the numbers of days of next month
     *
     * @return {@code MyDate} next year
     */
    public MyDate nextMonth(){
        Months[] m = Months.values();
        int leap = (isLeapYear(this.year) && this.month.equals(Months.Jan))? 1 : 0;
        if(this.month.equals(Months.Dec)){
            int nextYear = this.year + 1;
            return new MyDate( nextYear,  Months.Jan.getNumber(), this.day);
        }else{
            int numberOfDaysNextMonth = m[this.month.getNumber() + 1].numberOfDays() + leap;

            if(this.day > numberOfDaysNextMonth) {
                int nextMonth = this.month.getNumber() + 1;
                int day = m[nextMonth].numberOfDays() + leap;//OBSERVATION
                return new MyDate(this.year, nextMonth, day);
            }
        }

        int nextMonth = this.month.getNumber() + 1;
        return new MyDate(this.year,  nextMonth, this.day);
    }

    /**
     * si estas en el ultimo dia de febrero si el siuiente es año
     * biciesto o estan en año biciente al año ste el ultimo día
     * de febrero es 28
     *
     * @return next year
     */
    public MyDate nextYear(){
        int nextYear = this.year + 1;
        boolean daysOfMonthAgaistToday = this.day > this.month.numberOfDays() && this.month.equals(Months.Feb);
        //si estas en año biciesto y el dia dado es mayor a numero de
        //dias(Feb) entonces el siguiente año va con el nuemro de días(28)
        if(isLeapYear(this.year) && daysOfMonthAgaistToday){
            return new MyDate(  nextYear,  this.month.getNumber(),  Months.Feb.numberOfDays());
        }
        return new MyDate(  nextYear,  this.month.getNumber(), this.day);
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
        return this.month.getNumber();
    }

    public int getDay() {
        return day;
    }

    //metercomparaciones

    public void setYear(int year) {
        this.year = year;
    }
    //metercomparaciones
    public void setMonth(int month) {
        this.month = assignMonth(month);
    }
    //metercomparaciones
    public void setDay(int day) {
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

    /**
     * Verify if a given date is valid
     * @param year
     * @param month
     * @param day
     * @return {@code true} if the date is valir otherwise {@code false}
     */
    public static boolean isValidDate(int year, int month, int day){
        Months m = assignMonth( month);//obtain month from enum

        if(m == null){
            return false;//no valid month
        }
        if(isLeapYear(year) && m.equals(Months.Feb) && day == 29){
            return true;
        }

        boolean notProperRange = day < 1 || day > m.numberOfDays();
        if(notProperRange){
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
        Months month = assignMonth( monthNumber);
        int leap =
                (month == Months.Jan || month == Months.Feb)
                        ? isLeapYear(year) ? 1 : 0
                        : 0;
        int lastTd = yearItem(year);
        Table100sOfYears c = findCentury(year);
        return (lastTd + month.monthCode() + day + c.centuryNumber - leap) % 7;
    }

    /**
     * Match a given month position
     * to his internal enum representation
     * @param pos
     * @return
     */
    private static Months assignMonth(int pos){
        if(pos < 1 && pos > Months.ALL.getNumber()){
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
        Months month = assignMonth(monthNumber);
        int leap = (isLeapYear(year) && month.equals(Months.Feb))? 1 : 0;
        if(dateNumber < 1 && dateNumber > month.numberOfDays() + leap){
            return null;
        }
        Days[] days = Days.values();
        int pos = getDayOfWeek(year, month.getNumber(), dateNumber);
        return days[pos];
    }

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
    public int compareTo(MyDate that) {
        Months[] m = Months.values();

        boolean isSameMonth = this.month.compareTo(m[that.getMonth()]) == 0;
        boolean isSameYear = this.year == that.getYear();
        boolean isSameDay = this.day == that.getDay();
        if(isSameYear && isSameMonth && isSameDay){
            return 0;
        }

        boolean isYearGraterThan = this.year >= that.getYear();
        boolean isMonthGraterThan = this.month.compareTo(m[that.getMonth()]) >= 0;
        boolean isDayGraterThan = this.day >= that.getDay();
        if(isYearGraterThan && isMonthGraterThan && isDayGraterThan){
            return 1;
        }

        return -1;
    }

    @Override
    public String toString() {
        return String.format(
                "%1$s %2$d %3$s %4$d",
                assignDayOfWeek(year, month.getNumber(), day),
                day,
                month,
                year
        );
    }


}