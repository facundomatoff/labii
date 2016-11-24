package org.utn.labii.oop;

/**
 * Created by nico on 9/19/16.
 */
public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(){

    }

    public MyComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
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

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        String realString = hasNoSignificantFigures(real) ? "%.0f" : "%.1f";
        String imagString = hasNoSignificantFigures(imag) ? "%+.0f" : "%+.1f";
        return String.format("(" + realString + imagString + "i)" ,real, imag);
    }

    private boolean hasNoSignificantFigures(double var){
        int c = (int)var;
        return var % c == 0;
    }

    public boolean isReal(){
        return this.imag == 0;
    }

    public boolean isImaginary(){
        return this.real == 0;
    }

    //-----------------------------------------------ask
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//comparing by reference
        if (o == null || getClass() != o.getClass()) return false;

        MyComplex myComplex = (MyComplex) o;

        return equals(myComplex);
    }

    public boolean equals(MyComplex myComplex) {

        if (Double.compare(myComplex.real, real) != 0) return false;
        return Double.compare(myComplex.imag, imag) == 0;

    }

    public boolean equals(double real, double imag) {
        MyComplex myComplex = new MyComplex(real, imag);
        return equals(myComplex);

    }

    //-----------------------------------------------ask

    public double magnitude(){//abs value
        return Math.sqrt(this.multiply(this.conjugate()).getReal());
    }

    public double argument(){
        return Math.atan(this.imag/this.real);
    }

    public MyComplex add(MyComplex right){
        this.real = this.real + right.getReal();
        this.imag = this.imag + right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right){
        double real = this.real + right.getReal();
        double imag = this.imag + right.getImag();
        return new MyComplex(real,imag);
    }

    public MyComplex subtract(MyComplex right){
        double real = this.real, imag = this.imag;
        this.real = real - right.getReal();
        this.imag = imag - right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        double real = this.real - right.getReal();
        double imag = this.imag - right.getImag();
        return new MyComplex(real,imag);
    }

    public MyComplex multiply(MyComplex right){// Math.pow(i, 2) == -1
        double r = this.real, i = this.imag;//assigning once
        double r2 = right.getReal(), i2 = right.getImag();//assigning once
        this.real = (r * r2) + (i * i2 * -1);//real part
        this.imag = (i * r2) + (r * i2) ;//imaginary part
        return this;
    }
    public MyComplex divide(MyComplex right){//multiply is a destructive op
        //clone because multiply an conjugate affects directly to the object itself
        MyComplex rightClone = new MyComplex(right.getReal(), right.getImag());//1+i
        //conjugated copy
        MyComplex rightConj = new MyComplex(right.getReal(), right.getImag()).conjugate();//1-i
        //numerator, by multiplying the object for his conjugate the outcome of imaginary is cero
        rightClone.multiply(rightConj);//2
        this.multiply(rightConj);//9+5i
        this.real =  this.real / rightClone.getReal();
        this.imag = this.imag / rightClone.getReal();
        return this;
    }

    public MyComplex conjugate(){
        return new MyComplex(this.real, this.imag * -1);
    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
