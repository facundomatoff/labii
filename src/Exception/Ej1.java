package Exception;

import java.util.Scanner;

/**
 * Created by umantram on 18/11/16.
 */
public class Ej1 extends Throwable{

    public static void main(String[] args) {


        int div = 20;
        int div2 = 0;
        //div = 2/0;

        String exep = "rererer";


        try {

            System.out.println(div/div2);

        }catch (Exception e){

          Erro.errors(exep);

            //throw new Exception("pepeee");

        }finally {
            System.out.println("bloque de código ejecutado siempre");
        }
    }


}

class Erro {

    public static void errors(String msg){

        throw new ArithmeticException(msg);
    }

}
