package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 *
 * 14. Calcular la suma de los cuadrados de los números pares entre el 0 y el 100.
 */

public class ej14 {

    public static void main(String[] args){

        int suma = 0;

        for (int i = 0; i <= 100; i++) {

            if(i%2==0){

                suma += Math.pow(i,2);

            }
        }

        System.out.println("Suma: " + suma);

    }

}
