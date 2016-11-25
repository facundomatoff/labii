package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 *
 * 19. Hacer un programa que imprima los números del 1 al 100 .que calcule la suma de todos los números
 pares por un lado y otro la de todos los impares.
 */
public class ej19 {

    public static void main(String[] args){

        int suma = 0;

        for (int i = 0; i <= 100; i++) {

            if(i%2==0){

                System.out.println(i);
                suma +=i;
            }
        }

        System.out.println("Suma Pares: " + suma);

        suma = 0;

        for (int i = 0; i <= 100; i++) {

            if(i%3==0){

                System.out.println(i);
                suma +=i;
            }
        }

        System.out.println("SumaImpar: " + suma);

    }
}
