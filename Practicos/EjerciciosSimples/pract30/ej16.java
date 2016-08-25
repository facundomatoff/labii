package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 *
 * 16. Introducir un número por teclado que nos diga si es positivo o negativo .
 */
public class ej16 {

    public static void main(String[] args){

        int num = new Scanner(System.in).nextInt();

        if (num > 0 ){

            System.out.println("Positivo");

        }else {

            System.out.println("Negativo");

        }
    }
}
