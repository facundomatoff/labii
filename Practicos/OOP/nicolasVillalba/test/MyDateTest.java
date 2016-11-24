package org.utn.labii.oop.test;

import org.junit.Before;
import org.junit.Test;
import org.utn.labii.oop.MyDate;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;



/**
 * Created by nico on 9/24/16.
 */

public class MyDateTest {
    private MyDate date1, date2, date3, date4, date5, date6, date7;
    private MyDate date8, date9, date10, date11, date12, date13, date14, date15, date16;
    private int year1, month1, day1;

    @Before
    public void setUp() throws Exception {
        //2012-02-14
        date1 = new MyDate(2012, 2, 14);
        //2000-1-1
        date2 = new MyDate(2000, 1, 1);
        //2013-9-26
        date3 = new MyDate(2013, 9, 26);
        //2012-9-26
        date4 = new MyDate(2012, 9, 26);
        //2012-2-26
        date5 = new MyDate(2012, 2, 26);
        //2012-2-5
        date6 = new MyDate(2012, 2, 5);

        //2008-12-31 LEAP
        date7 = new MyDate(2008, 12, 31);
        //2008-10-31 LEAP
        date8 = new MyDate(2008, 7, 8);
        //2001-11-1
        date9 = new MyDate(1999, 2, 28);
        //1997-1-31
        date10 = new MyDate(1997, 1, 31);//
        //1996-2-29 LEAP
        date11 = new MyDate(1996, 2, 29);

        //1997-2-29 INVALID
        date12 = new MyDate(1997, 2, 29);
        //2001-2-29 INVALID
        date13 = new MyDate(2001, 2, 29);
        date14 = new MyDate(1996, 12, 31);
        date15 = new MyDate(1996, 1, 31);
        date16 = new MyDate(2000, 3, 1);

        year1 = 2013;
        month1 = 10;
        day1 = 15;
    }

    @Test
    public void isLeapYear() throws Exception {
        assertThat(MyDate.isLeapYear(2000), is(equalTo(true)));
        assertThat(MyDate.isLeapYear(1996), is(equalTo(true)));
        assertThat(MyDate.isLeapYear(2012), is(equalTo(true)));
        assertThat(MyDate.isLeapYear(2003), is(equalTo(false)));
        assertThat(MyDate.isLeapYear(1998), is(equalTo(false)));

    }

    @Test
    public void isValidDate() throws Exception {
        assertThat(MyDate.isValidDate(date10.getYear(), date10.getMonth(), date10.getDay()), is(equalTo(true)));
        assertThat(MyDate.isValidDate(date11.getYear(), date11.getMonth(), date11.getDay()), is(equalTo(true)));
        assertThat(MyDate.isValidDate(date12.getYear(), date12.getMonth(), date12.getDay()), is(equalTo(false)));
        assertThat(MyDate.isValidDate(2001, 2, 29), is(equalTo(false)));
        assertThat(MyDate.isValidDate(1998, 2, 29), is(equalTo(false)));
    }

    @Test
    public void getDayOfWeek() throws Exception {
        assertThat(MyDate.getDayOfWeek(year1, month1, day1), is(equalTo(2)));
    }

    @Test
    public void getYear() throws Exception {
        assertThat(date11.getYear(), is(equalTo(1996)));
        assertThat(date13.getYear(), is(equalTo(2001)));
        assertThat(date9.getYear(), is(equalTo(1999)));
    }

    @Test
    public void nextDay() throws Exception {
        MyDate nextDay = date14.nextDay();//1996-12-31
        assertThat(nextDay.getYear(), is(equalTo(1997)));
        assertThat(nextDay.getMonth(), is(equalTo(1)));
        assertThat(nextDay.getDay(), is(equalTo(1)));
        MyDate nextDay2 = date11.nextDay();
        assertThat(nextDay2.getDay(), is(equalTo(1)));
        assertThat(nextDay2.getMonth(), is(equalTo(3)));
        assertThat(nextDay2.getYear(), is(equalTo(1996)));
    }

    @Test
    public void nextMonth() throws Exception {
        MyDate nextMonth = date14.nextMonth();//1996-12-31
        assertThat(nextMonth.getYear(), is(equalTo(1997)));
        assertThat(nextMonth.getMonth(), is(equalTo(1)));
        assertThat(nextMonth.getDay(), is(equalTo(31)));

        MyDate nextMonth2 = date15.nextMonth();//1996-1-31
        // date11 == 1996-2-29
        assertThat(nextMonth2.compareTo(date11), is(equalTo(0)));
    }

    @Test
    public void nextYear() throws Exception {
        MyDate nextYear1 = date11.nextYear();

        assertThat( nextYear1.getDay(), is(equalTo(28)));
        assertThat( nextYear1.getMonth(), is(equalTo(2)));
        assertThat( nextYear1.getYear(), is(equalTo(1997)));

        MyDate nextYear2 = date10.nextYear();
        assertThat( nextYear2.getDay(), is(equalTo(31)));
        assertThat( nextYear2.getMonth(), is(equalTo(1)));
        assertThat( nextYear2.getYear(), is(equalTo(1998)));

        MyDate nextYear3 = date2.nextYear();
        assertThat( nextYear3.getDay(), is(equalTo(1)));
        assertThat( nextYear3.getMonth(), is(equalTo(1)));
        assertThat( nextYear3.getYear(), is(equalTo(2001)));
    }

    @Test
    public void previousDay() throws Exception {
        //date5 = new MyDate(2012, 2, 26);
        assertThat(date5.previousDay().getDay(), is(equalTo(25)));
        //date6 = new MyDate(2012, 2, 5);
        assertThat(date6.previousDay().getDay(), is(equalTo(4)));
        //date2 = new MyDate(2000, 1, 1);
        assertThat(date2.previousDay().getDay(), is(equalTo(31)));
        assertThat(date2.previousDay().getMonth(), is(equalTo(12)));
        assertThat(date2.previousDay().getYear(), is(equalTo(1999)));
        //date13 = new MyDate(2001, 2, 29);
        assertThat(date13.previousDay().getDay(), is(equalTo(28)));
        assertThat(date13.previousDay().getMonth(), is(equalTo(2)));
        assertThat(date13.previousDay().getYear(), is(equalTo(2001)));

        //date16 = new MyDate(2000, 3, 1);
        assertThat(date16.previousDay().getDay(), is(equalTo(29)));
        assertThat(date16.previousDay().getMonth(), is(equalTo(2)));
        assertThat(date16.previousDay().getYear(), is(equalTo(2000)));

    }

    @Test
    public void previousMoth() throws Exception {
        //date12 = new MyDate(1997, 2, 29);
        assertThat(date12.previousMoth().getMonth(), is(equalTo(1)));//INVALID
        //date3 = new MyDate(2013, 9, 26);
        assertThat(date3.previousMoth().getMonth(), is(equalTo(8)));
        //date2 = new MyDate(2000, 1, 1);
        assertThat(date2.previousMoth().getMonth(), is(equalTo(12)));
    }

    @Test
    public void previousYear() throws Exception {
        //date9 = new MyDate(1999, 2, 28);
        assertThat(date9.previousYear().getYear(), is(equalTo(1998)));
        assertThat(date9.previousYear().getMonth(), is(equalTo(2)));
        assertThat(date9.previousYear().getDay(), is(equalTo(28)));

        assertThat(
                new MyDate(2012, 2, 29).previousYear().getDay(),
                is(equalTo(28))
        );

        assertThat(
                new MyDate(2016, 2, 29).previousYear().getDay(),
                is(equalTo(28))
        );
        assertThat(
                new MyDate(2016, 12, 31).previousYear().getDay(),
                is(equalTo(31))
        );
    }

    @Test
    public void getMonth() throws Exception {

    }

    @Test
    public void getDay() throws Exception {
        assertThat(date11.getDay(), is(equalTo(29)));
    }

    //guarda con los setters cuando es año viciesto y la fecha
    //29 de febrero
    //--------------------------------------------------
    @Test
    public void setYear() throws Exception {
        MyDate d = new MyDate(2016, 2, 29);
        MyDate d2 = new MyDate(2000, 2, 28);
        MyDate d3 = new MyDate(2000, 2, 29);
        d.setYear(2015);
        d2.setYear(1999);
        d3.setYear(2001);
        assertThat(d.getDay(), is(equalTo(28)));
        assertThat(d2.getDay(), is(equalTo(28)));
        assertThat(d3.getDay(), is(equalTo(28)));
    }

    @Test
    public void setMonth() throws Exception {
        MyDate d = new MyDate(2015, 1, 29);
        MyDate d2 = new MyDate(2000, 2, 28);
        MyDate d3 = new MyDate(2000, 5, 31);
        d.setMonth(2);
        d2.setMonth(3);
        d3.setMonth(6);
        assertThat(d.getDay(), is(equalTo(28)));
        assertThat(d2.getDay(), is(equalTo(28)));
        assertThat(d3.getDay(), is(equalTo(30)));
    }

    @Test
    public void setDay() throws Exception {
        MyDate d = new MyDate(2015, 1, 29);
        d.setDay(0);
        assertThat(d.getDay(), is(equalTo(1)));
        d.setDay(30);
        assertThat(d.getDay(), is(equalTo(30)));
        d.setDay(43);
        assertThat(d.getDay(), is(equalTo(31)));
    }
    //-------------------------------------------------
    @Test
    public void compareTo() throws Exception {
        assertThat(date1.compareTo(date2), is(equalTo(1)));
        assertThat(date1.compareTo(date3), is(equalTo(-1)));
        assertThat(date1.compareTo(date4), is(equalTo(-1)));
        assertThat(date1.compareTo(date5), is(equalTo(-1)));
        assertThat(date1.compareTo(date6), is(equalTo(1)));
    }

    @Test
    public void toString_() throws Exception {
        assertThat(date1.toString(), is(equalTo("Tuesday 14 Feb 2012")));
        assertThat(date3.toString(), is(equalTo("Thursday 26 Sep 2013")));
        assertThat(date2.toString(), is(equalTo("Saturday 1 Jan 2000")));
    }

}
