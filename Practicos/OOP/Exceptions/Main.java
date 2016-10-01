package main.java.com.frre.tsp.exceptions;

/**
 * Test exception types.
 */
public class Main {

    public static void main(String[] args) {

        divisionEntera();
        //divisionEntera2();
        //divisionEntera3();
        //divisionDecimal();
    }

    public static void divisionEntera() {
        int dividendo = 12;
        int divisor = 0;

        Matematica mat = new Matematica();

        System.out.println("solucion -> " + mat.dividir(dividendo, divisor));
    }

    public static void divisionEntera2() {
        int dividendo = 12;
        int divisor = 0;

        Matematica mat = new Matematica();

        System.out.println("solucion -> " + mat.dividir2(dividendo, divisor));
    }

    public static void divisionEntera3() {
        int dividendo = 12;
        int divisor = 0;

        Matematica mat = new Matematica();

        // No compila porque el compilador detecta una unhandled exception
        //System.out.println("solucion -> " + mat.dividir3(dividendo, divisor));

        try {
            int resultado = mat.dividir3(dividendo, divisor);
            System.out.println(resultado);

        } catch (DivisionByZeroException e) {
            System.out.println("Solucion -> Infinito");
        }

    }

    public static void divisionDecimal() {

        double dividendo = 12;
        double divisor = 0;

        Matematica mat = new Matematica();

        System.out.println("solucion -> " + mat.dividir(dividendo, divisor));
    }

}
