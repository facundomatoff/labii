package batallaNaval;

import java.util.Scanner;

/**
 * Created by umantram on 06/09/16.
 */
public class Main {

    static int[][] tablero ;
    static Scanner sc = new Scanner(System.in);

    static boolean iniciado ;

    public static void main(String[] args){

        iniciar();
        dibujartablero();
        marcar();
        jugar();

    }

    /*
    5
    1
    D
    1
    E
    4
    C
    4
    D
     */

    public static void jugar(){

        boolean fin = false;

        while(fin == false){

            System.out.println("Fila: ");
            System.out.println("Columna: ");

            int fila = sc.nextInt();
            String col = sc.next();
            int colum = 0;

            for (int j = 0; j < tablero.length; j++) {

                if (col.charAt(0) == (char) ('A' + j)) {

                    colum = j;
                    break;

                }
            }

            if (tablero[fila][colum] == 1){

                System.out.println("Genial le diste");
                tablero[fila][colum] = 8;
                dibujartablero();

            }else{

                System.out.println("ohhh vulve a intentarlo");

            }

            fin = true;

        }

    }

    public static void iniciar(){

        int tam = sc.nextInt();
        tablero = new int[tam][tam];
    }
    public static void dibujartablero(){

        //if (iniciado) {



        //}

        System.out.print("--");

        for (int i = 0; i < tablero.length; i++) {

            System.out.print((char) ('A' + i) + "-");
        }

        System.out.println();

        for (int i = 1; i < tablero.length; i++) {

            System.out.print(i + "-");

            for (int j = 0; j < tablero.length; j++) {

                System.out.print(tablero[i][j] + "-");
            }

            System.out.println("");
        }

        //iniciado = false;

    }

    public static void marcar(){

        for (int i = 0; i < 2; i++) {

            System.out.println("Fila: ");
            System.out.println("Columna: ");

            int fila = sc.nextInt();
            String col = sc.next();

            int colum = 0;
            //char valor;

            for (int j = 0; j < tablero.length; j++) {

                //valor = ((char) ('A' + j));
                //System.out.println(col.charAt(0) + " " + valor);

                if (col.charAt(0) == (char) ('A' + j)) {

                    colum = j;
                    break;

                }

            }

            tablero[fila][colum] = 1;
            dibujartablero();

        }



    }

}

/*
class tablero {

    int tam = new Scanner(System.in).nextInt();
    Integer[][] tablero = new Integer[tam][tam];


}
*/

/*
public char[] createArray {
char[] s;
s=new char[26];
for ( int i=0; i<26; i++) {
s[i] = (char) ('A' + i );
}
return s;
}
*/