package pract30;

import java.util.Scanner;

/**
 * Created by umantram on 25/08/16.
 */
public class ej12 {

    public static void main(String[] args){

        int num = new Scanner(System.in).nextInt();

        int cont = 0;
        int suma = 0;

        for (int i = 0; i <= num; i++) {

            if(i%10==0){

                System.out.println(i);
                cont++;
                suma +=i;
            }
        }

        System.out.println("cant de Mul 10: " + cont);
        System.out.println("Suma: " + suma);

    }

}
