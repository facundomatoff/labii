package main.java.com.frre.tsp.exceptions;

/**
 * Expone metodos matematicos
 */
public class Matematica {
    
    //it cactches the exception
    //and them return and integer, like a code style
    public int dividir(int dividendo, int divisor) {

        try {
            return dividendo / divisor;

        } catch(ArithmeticException e) {
            return -1;
        }
    }
    //no se trata la excepción de ninguna forma
    public double dividir(double dividendo, double divisor) {
        return dividendo / divisor;
    }
    
    //simply catching
    public int dividir2(int dividendo, int divisor) {

        try {
            return dividendo / divisor;

        } catch(ArithmeticException e) {
            throw e;
        }
    }
    //catching and
    //rethrowing the exception to other kind
    public int dividir3(int dividendo, int divisor) throws DivisionByZeroException {

        try {
            return dividendo / divisor;

        } catch(ArithmeticException e) {
            throw new DivisionByZeroException(e);
        }
    }
}
