import java.util.Scanner;

/**
 * Created by umantramdebian on 02/09/16.
 */
public class CodeForce556A {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int cant = sc.nextInt();
        //String[] binarios = new String[cant];
        String binarios = sc.next();

        int unos = 0;
        int ceros = 0;

        for (int i = 0; i < binarios.length(); i++) {


            if (binarios.charAt(i) == '1'){

                unos++;

            }else if(binarios.charAt(i) == '0' ){

                ceros++;

            }

        }

        cant = Math.abs(unos - ceros);

        System.out.println(cant);

    }
}
