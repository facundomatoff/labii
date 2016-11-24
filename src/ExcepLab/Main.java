package ExcepLab;

import EjerciciosOOP.MyComplex;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

/**
 * Created by umantram on 24/11/16.
 */
public class Main extends RuntimeException {

    public static void main(String[] args) {

        int num = 10;
        int num2 = 0;

        try {

            System.out.println(num/num2);

        }catch (ArithmeticException e){

            System.out.println(e.getMessage());
            //throw new ArithmeticException("Error");
            throw e;

        }


        Scanner sc = new Scanner(System.in);

        MyTime tiempo = new MyTime(sc.nextInt(), sc.nextInt());

        System.out.println(tiempo);

    }
}
