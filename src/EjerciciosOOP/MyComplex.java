package EjerciciosOOP;

/**
 * Created by umantram on 18/11/16.
 */
public class MyComplex {

    double real = 0.0;
    double imag = 0.0;

    public MyComplex(){

    }

    public MyComplex(double real, double imag) {
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

    }

    @Override
    public String toString() {
        return "MyComplex{" +
                "real=" + real +
                "+" + imag + "i" +
                '}';
    }

    public boolean isReal(){

        return true;

    }

    public boolean isImaginary(){

        return true;

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
