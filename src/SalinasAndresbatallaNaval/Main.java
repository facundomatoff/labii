package SalinasAndresbatallaNaval;

import java.util.Scanner;

/**
 * Created by umantram on 06/09/16.
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    //static boolean iniciado;

    public static void main(String[] args) {

        int casillas = 0;
        int fila;
        char col;

        BatallaNaval batalla = new BatallaNaval();

        System.out.println("Ingrese el Tamano del tablero, Ej: 5");

        batalla.iniciar(sc.nextInt());
        batalla.dibujartablero();

        //System.out.println(batalla.columnas);
        //System.out.println(batalla.filas);

        System.out.println("Marques sus Casilleros");

        while(casillas!= 4 ) {

            System.out.println("Fila, debe ser mayor a 0 y menor a " + batalla.tablero.length);
            fila = sc.nextInt();

            System.out.println("Columna, debe Ingresa una Letra Mayuscula y hasta la Letra " + (char) ('A' + batalla.tablero[0].length - 1));
            col = sc.next().charAt(0);

            batalla.marcar(fila,col);

            casillas++;
        }

        System.out.println("Todo Listo a Jugar");

        casillas = 0;

        while(batalla.getCasillas() != 4){

            System.out.println("Fila, debe ser mayor a 0 y menor a " + batalla.tablero.length);
            fila = sc.nextInt();

            System.out.println("Columna, debe Ingresa una Letra Mayuscula y hasta la Letra " + (char) ('A' + batalla.tablero[0].length - 1));
            col = sc.next().charAt(0);

            batalla.jugar(fila, col);

        }

        System.out.println("Game Over");


    }

}
