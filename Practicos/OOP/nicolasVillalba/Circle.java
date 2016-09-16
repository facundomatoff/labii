package org.utn.labii.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by nico on 9/13/16.
 */
public class Circle {
    private double radius = 1.0;

    public Circle(){

    }

    public Circle(double radius){
        this.radius = radius;
    }

    /**
     *
     * @return the radius of circle
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * set a new radius value
     * @param radius
     */
    public void setRadius(double radius) throws IllegalArgumentException {
        if(radius < 0d)
            throw new IllegalArgumentException("Negative argument not permitted");
        this.radius = radius;
    }

    /**
     *
     * @return the area of circle whit 2 signifan signatures
     */
    public double getArea(){
        double area = (Math.PI * Math.pow(this.radius, 2));
        return roundWithSigFig(area, 2);
    }

    /**
     *
     * @return
     */
    public double getCircunference(){
        double circunference = (2 * Math.PI * this.radius);
        return roundWithSigFig(circunference, 2);
    }

    /**
     *
     * @param value
     * @param places
     * @return
     */
    private static double roundWithSigFig(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Circle[radius=%.1f]", getRadius());
    }
}
