package org.utn.labii.oop.test;

import org.junit.Before;
import org.junit.Test;
import org.utn.labii.oop.MyComplex;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by nico on 9/20/16.
 */
public class MyComplexTest {
    private MyComplex number1;
    private MyComplex number2;
    private MyComplex number3;
    private MyComplex number4;
    private MyComplex number5;
    private MyComplex number6;
    private MyComplex number7;
    private MyComplex number8;
    private MyComplex number9;

    @Before
    public void setUp() throws Exception {
        number1 = new MyComplex(2.0, 7.0);//dividendo
        number2 = new MyComplex(1.0, 1.0);//divisor
        number3 = new MyComplex(5d, 2d);
        number4 = new MyComplex(2d, -3d);
        number5 = new MyComplex(-1d, -9d);
        number6 = new MyComplex(5d, 2d);
        number7 = new MyComplex(21d, -35d);
        number8 = new MyComplex(4d, 3d);
        number9 = new MyComplex(4d, 0d);

    }

    @Test
    public void getReal() throws Exception {

    }

    @Test
    public void setReal() throws Exception {

    }

    @Test
    public void getImag() throws Exception {

    }

    @Test
    public void setImag() throws Exception {

    }

    @Test
    public void setValue() throws Exception {

    }

    @Test
    public void toString_() throws Exception {
        assertThat(
                number4.toString(),
                allOf(
                        notNullValue(),
                        instanceOf(String.class),
                        equalTo("(2-3i)")
                )
        );

        assertThat(
                number1.toString(),
                allOf(
                        notNullValue(),
                        instanceOf(String.class),
                        equalTo("(2+7i)")
                )
        );

        assertThat(
                number5.toString(),
                allOf(
                        notNullValue(),
                        instanceOf(String.class),
                        equalTo("(-1-9i)")
                )
        );
    }

    @Test
    public void isReal() throws Exception {
        assertThat(number9.isReal(), is(equalTo(true)));
    }

    @Test
    public void isImaginary() throws Exception {
        assertThat(number9.isImaginary(), is(not(equalTo(true))));
    }

    @Test
    public void equals() throws Exception {
        Object newNumber = new MyComplex(2.0, 7.0);
        assertThat(number1.equals(newNumber), equalTo(true));

    }

    @Test
    public void equals1() throws Exception {
        assertThat(number1.equals(new MyComplex(2.0, 7.0)), equalTo(true));
    }

    @Test
    public void equals2() throws Exception {
        assertThat(number1.equals(2.0, 7.0), equalTo(true));
    }

    @Test
    public void magnitude() throws Exception {
        //rounding to compare the result
        BigDecimal bd = new BigDecimal(number7.magnitude());
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        double roundValue1figure = bd.doubleValue();
        assertThat(
                roundValue1figure,
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(40.8)
                )
        );

        assertThat(
                number8.magnitude(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(5.0)
                )
        );
    }

    @Test
    public void argument() throws Exception {
        //https://www.google.com.ar/search?client=ubuntu&espv=2&q=36%2C9+grados+to+radians&oq=36%2C9+grados+to+radians&gs_l=serp.3...177162.197291.0.197878.30.24.3.0.0.0.423.4967.0j7j2j8j1.18.0....0...1c.1.64.serp..9.7.1975...0j0i67k1j0i22i30k1j33i21k1j30i10k1.uCfic0iRuSQ
        BigDecimal bd = new BigDecimal(number8.argument());
        bd = bd.setScale(3, RoundingMode.UP);
        double roundValWhit2figures = bd.doubleValue();
        assertThat(roundValWhit2figures, is(equalTo(0.644)));
    }

    @Test
    public void add() throws Exception {
        assertThat(
                number3.add(number4),
                is(
                        equalTo(
                                new MyComplex(7d, -1d))
                )
        );
    }

    @Test
    public void addNew() throws Exception {
        MyComplex newNumber = number3.addNew(number4);
        assertThat(
                newNumber.equals(new MyComplex(7d, -1d)),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Boolean.class),
                                equalTo(true))

                )
        );
    }

    @Test
    public void subtract() throws Exception {
        assertThat(
                number3.subtract(number4),
                is(
                        equalTo(
                                new MyComplex(3d, 5d))
                )
        );
    }

    @Test
    public void subtractNew() throws Exception {
        MyComplex newNumber = number3.subtractNew(number4);
        assertThat(
                newNumber.equals(new MyComplex(3d, 5d)),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Boolean.class),
                                equalTo(true)
                        )

                )
        );
    }

    @Test
    public void multiply() throws Exception {
        number1.multiply(number2);

        assertThat(
                number1.getReal(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(-5.0)
                )
        );

        assertThat(
                number1.getImag(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(9.0)
                )
        );
        number3.multiply(number4);
        assertThat(
                number3.getReal(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(16.0)
                )
        );

        assertThat(
                number3.getImag(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(-11.0)
                )
        );

        number6.multiply(number6.conjugate());
        assertThat(
                number6.getReal(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(29.0)
                )
        );

        assertThat(
                number6.getImag(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(0.0)
                )
        );
    }

    @Test
    public void divide() throws Exception {
        assertThat(
                number1.divide(number2).toString(),
                allOf(
                        notNullValue(),
                        instanceOf(String.class),
                        is(
                                equalTo("(4.5+2.5i)")
                        )
                )
        );
    }

    @Test
    public void conjugate() throws Exception {
        assertThat(number2.conjugate().toString(), equalTo("(1-1i)"));
    }

    @Test
    public void hashCode_() throws Exception {

    }

}