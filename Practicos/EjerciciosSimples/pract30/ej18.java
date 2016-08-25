package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 *
 * 18. Imprimir y contar los múltiplos de 3 desde la unidad hasta un número que introducimos por teclado
 *
 */
public class ej18 {

    public static void main(String[] args){

        int num = new Scanner(System.in).nextInt();
        int cont = 0;

        for (int i = 0; i <= num; i++) {

            if(i%3==0){

                System.out.println(i);
                cont++;
            }
        }

        System.out.println("cant de Mul 3: " + cont);

    }

}
