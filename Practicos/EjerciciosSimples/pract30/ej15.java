package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 *
 * 15. Introducir un número por teclado menor que 100.imprimir la suma de los cuadrados de los números que
 están separados entre sí 4 posiciones.

 */
public class ej15 {

    public static void main(String[] args){

        int num = new Scanner(System.in).nextInt();

        int suma = 0;
        int cont = 0;

        for (int i = 0; i <= num; i++) {

            cont++;
            if(cont==4){

                suma += Math.pow(i,2);
                cont = 0;

            }
        }

        System.out.println("Suma: " + suma);

    }

}
