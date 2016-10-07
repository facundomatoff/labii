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
    private MyDate date1;
    private MyDate date2;
    private MyDate date3;
    private MyDate date4;
    private MyDate date5;
    private MyDate date6;
    private MyDate date7;
    @Before
    public void setUp() throws Exception {
        date1 = new MyDate(
                (short)2012,
                (short)2,
                (short)14
        );
        date2 = new MyDate(
                (short)2000,
                (short)1,
                (short)1
        );
        date3 = new MyDate(
                (short)2013,
                (short)9,
                (short)26
        );
        //date4 = new MyDate();
    }

    @Test
    public void isLeapYear() throws Exception {

    }

    @Test
    public void isValidDate() throws Exception {

    }

    @Test
    public void getDayOfWeek() throws Exception {

    }

    @Test
    public void getYear() throws Exception {

    }

    @Test
    public void nextDay() throws Exception {

    }

    @Test
    public void nextMonh() throws Exception {

    }

    @Test
    public void nextYear() throws Exception {

    }

    @Test
    public void previousDay() throws Exception {

    }

    @Test
    public void previousMoth() throws Exception {

    }

    @Test
    public void previousYear() throws Exception {

    }

    @Test
    public void getMonth() throws Exception {

    }

    @Test
    public void getDay() throws Exception {

    }

    @Test
    public void setYear() throws Exception {

    }

    @Test
    public void setMonth() throws Exception {

    }

    @Test
    public void setDay() throws Exception {

    }

    @Test
    public void toString_() throws Exception {
        assertThat(date1.toString(), is(equalTo("Tuesday 14 Feb 2012")));
        assertThat(date3.toString(), is(equalTo("Thursday 26 Sep 2013")));
        assertThat(date2.toString(), is(equalTo("Saturday 1 Jan 2000")));
    }

}
