package main.java.com.frre.tsp.oop;

/**
 * Ejemplos de pasaje de argumentos a un metodo y como se modifican dichos valores dentro
 * del metodo.
 */
public class PasajeArgumentos {

    public static void main(String[] args) {

        Mamifero m1 = new Mamifero("perro");

        System.out.println(m1.getNombre());

        //cambiarNombre(m1);
        cambiarNombre2(m1);

        System.out.println(m1.getNombre());
    }

    public static void cambiarNombre(Mamifero m) {
        m.setNombre("gato");
    }

    public static void cambiarNombre2(Mamifero m) {
        m = new Mamifero("gato");
    }
}
