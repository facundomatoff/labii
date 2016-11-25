package ExcepLab;

import EjerciciosOOP.MyComplex;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

/**
 * Created by umantram on 24/11/16.
 */
public class Main extends RuntimeException {

    public static void main(String[] args) throws AtrapaError {

        //int num = 10;
        //int num2 = 0;
/*
        try {

            System.out.println(num/num2);

        }catch (ArithmeticException e){

            System.out.println(e.getMessage());
            //throw new ArithmeticException("Error");
            throw e;

        }
*/

  //      Scanner sc = new Scanner(System.in);

        try {

            MyTime tiempo = new MyTime(1, 10);
            System.out.println(tiempo);

            tiempo.nextHora();
            System.out.println(tiempo);

        }catch (AtrapaError e){

            System.out.println(e.getMessage());
        }
    }
}
