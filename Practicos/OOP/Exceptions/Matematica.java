package main.java.com.frre.tsp.exceptions;

/**
 * Expone metodos matematicos
 */
public class Matematica {

    public int dividir(int dividendo, int divisor) {

        try {
            return dividendo / divisor;

        } catch(ArithmeticException e) {
            return -1;
        }
    }

    public double dividir(double dividendo, double divisor) {
        return dividendo / divisor;
    }

    public int dividir2(int dividendo, int divisor) {

        try {
            return dividendo / divisor;

        } catch(ArithmeticException e) {
            throw e;
        }
    }

    public int dividir3(int dividendo, int divisor) throws DivisionByZeroException {

        try {
            return dividendo / divisor;

        } catch(ArithmeticException e) {
            throw new DivisionByZeroException(e);
        }
    }
}
