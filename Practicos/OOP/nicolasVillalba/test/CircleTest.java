package org.utn.labii.oop.test;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
/**
 * Created by nico on 9/13/16.
 */
import org.utn.labii.oop.Circle;

public class CircleTest {

    Circle circle = new Circle();
    Circle circle2 = new Circle(5.0);

    @Test
    public void getRadius() throws Exception {
        assertThat(
                circle.getRadius(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Double.class),
                                equalTo(1.0)
                        )
                )
        );

        assertThat(
                circle2.getRadius(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Double.class),
                                equalTo(5.0)
                        )
                )
        );
    }

    @Test
    public void setRadius() throws Exception {
        circle.setRadius(2.3);
        assertThat(
                circle.getRadius(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Double.class),
                                equalTo(2.3)
                        )
                )
        );
    }

    @Test
    public void getArea() throws Exception {
        assertThat(
                circle.getArea(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Double.class),
                                equalTo(3.14)
                        )
                )
        );
    }

    @Test
    public void getCircunference() throws Exception {
        assertThat(
                circle.getCircunference(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Double.class),
                                equalTo(6.28)
                        )
                )
        );
    }

    @Test
    public void toStringOutput() throws Exception {
        assertThat(
                circle.toString(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo("Circle[radius=1.0]")
                        )
                )
        );
    }

}