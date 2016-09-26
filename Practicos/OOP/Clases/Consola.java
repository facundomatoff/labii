package main.java.com.frre.tsp.oop;

import java.util.Scanner;

/**
 * Ejemplos de clase static que se usa como un "helper" para llamar a los metedos
 * de System.in y System.out.
 * Esta clase permite leer valores del teclado e imprimirlos por consola.
 */
public class Consola {

    private static final Scanner scanner = new Scanner(System.in);

    static void imprimir(String texto) {
        System.out.println(texto);
    }

    static int leerEntero() {
        return scanner.nextInt();
    }

    static String leerString() {
        return scanner.next();
    }

}
