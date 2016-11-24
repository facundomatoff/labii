package EjerciciosOOP;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by umantram on 16/11/16.
 */
public class Circle {

    private double radius = 1.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){

        return Math.PI * (this.radius * this.radius);
    }

    public double getCircumference(){

        return 2 * Math.PI * this.radius;

    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

}

