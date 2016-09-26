package main.java.com.frre.tsp.oop.ejerciciosGuia;

/**
 * Ejercicio 6 - Guia de OOP.
 */
public class Ejercicio6 {

    public static void main(String[] args) {

        myComplex();
    }

    static void myComplex() {

        MyComplex c1 = new MyComplex(3, 4);
        MyComplex c2 = new MyComplex(5, 4);
        MyComplex c3 = new MyComplex(8, 8);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());

        //c1.add(c2);
        //System.out.println(c1.toString());

        //c1.add(c2).substract(c3);
        //System.out.println(c1.toString());

        MyComplex aux = c1.addNew(c2);
        System.out.println(c1.toString());
        System.out.println(aux.toString());
    }
}

/*
* Clase para trabajar con números complejos.
*/
class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public MyComplex add(MyComplex right) {
        this.real += right.getReal();
        this.imag += right.getImag();

        return this;
    }

    public MyComplex addNew(MyComplex right) {
        MyComplex c1 = new MyComplex(this.real, this.imag);
        c1.add(right);
        return c1;
    }

    public MyComplex substract(MyComplex right) {
        this.real -= right.getReal();
        this.imag -= right.getImag();

        return this;
    }

    @Override
    public String toString() {
        return "(" + this.real + "," + this.imag + "i)";
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
}
