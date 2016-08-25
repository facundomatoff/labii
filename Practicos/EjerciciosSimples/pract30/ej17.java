package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 *
 * 17. Introducir un número por teclado. Que nos diga si es par o impar.
 */
public class ej17 {

    public static void main(String[] args){

        int num = new Scanner(System.in).nextInt();

        if (num%2== 0 ){

            System.out.println("Par");

        }else {

            System.out.println("Impar");

        }
    }
}
