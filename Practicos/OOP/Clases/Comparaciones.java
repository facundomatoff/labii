package main.java.com.frre.tsp.oop;

/**
 * Ejemplos de == y equals
 */
public class Comparaciones {

    public static void main(String[] args) {

        comparacionesString();
        //comparacionesObjetos();
        //comparacionesObjectosSobrecarga();
        //comparacionesObjectosSobrecarga2();
    }

    static void comparacionesString() {

        String s1 = "hola"; // literal initialization
        String s2 = "hola"; // literal initialization

        System.out.println("p1.hascode() -> " + s1.hashCode());
        System.out.println("p2.hascode() -> " + s2.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(s1 == s2));            // string interning
        System.out.println("p1.equals(p2) -> " + Boolean.toString(s1.equals(s2)));  // string interning

        String s11 = new String("hola");
        String s22 = new String("hola");

        System.out.println("p1.hascode() -> " + s11.hashCode());
        System.out.println("p2.hascode() -> " + s22.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(s11 == s22));
        System.out.println("p1.equals(p2) -> " + Boolean.toString(s11.equals(s22)));
    }

    static void comparacionesObjetos() {
        Perro p1 = new Perro();
        Perro p2 = new Perro();

        System.out.println("p1.hascode() -> " + p1.hashCode());
        System.out.println("p2.hascode() -> " + p2.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(p1 == p2));
        System.out.println("p1.equals(p2) -> " + Boolean.toString(p1.equals(p2)));

        p1 = p2;
        System.out.println("p1 = p2");
        System.out.println("p1.hascode() -> " + p1.hashCode());
        System.out.println("p2.hascode() -> " + p2.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(p1 == p2));
        System.out.println("p1.equals(p2) -> " + Boolean.toString(p1.equals(p2)));
    }

    static void comparacionesObjectosSobrecarga() {
        Mamifero p1 = new Mamifero("p1");
        Mamifero p2 = new Mamifero("p2");

        System.out.println("p1.hascode() -> " + p1.hashCode());
        System.out.println("p2.hascode() -> " + p2.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(p1 == p2));
        System.out.println("p1.equals(p2) -> " + Boolean.toString(p1.equals(p2)));

        p1 = p2;
        System.out.println("p1 = p2");
        System.out.println("p1.hascode() -> " + p1.hashCode());
        System.out.println("p2.hascode() -> " + p2.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(p1 == p2));
        System.out.println("p1.equals(p2) -> " + Boolean.toString(p1.equals(p2)));
    }

    static void comparacionesObjectosSobrecarga2() {
        Mamifero p1 = new Mamifero("p1");
        Mamifero p2 = new Mamifero("p1");

        System.out.println("p1.hascode() -> " + p1.hashCode());
        System.out.println("p2.hascode() -> " + p2.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(p1 == p2));
        System.out.println("p1.equals(p2) -> " + Boolean.toString(p1.equals(p2)));

        p1 = p2;
        System.out.println("p1 = p2");
        System.out.println("p1.hascode() -> " + p1.hashCode());
        System.out.println("p2.hascode() -> " + p2.hashCode());
        System.out.println("p1 == p2 -> " + Boolean.toString(p1 == p2));
        System.out.println("p1.equals(p2) -> " + Boolean.toString(p1.equals(p2)));
    }
}
