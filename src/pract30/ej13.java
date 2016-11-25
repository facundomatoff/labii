package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 *
 * v13. Introducir un número por teclado menor que 500. Imprimir, sumar y contar los números que están
 separadas entre si 8 posiciones, desde ese número al 500

 */
public class ej13 {

    public static void main(String[] args){

        int num = new Scanner(System.in).nextInt();

        int cont8= 0;
        int cont = 0;
        int suma = 0;

        for (int i = num+1; i <= 500; i++) {

            cont8++;
            if(cont8==8){

                System.out.println(i);
                cont++;
                suma +=i;
                cont8=0;
            }
        }

        System.out.println("cant de Mul 2: " + cont);
        System.out.println("Suma: " + suma);

    }

}
