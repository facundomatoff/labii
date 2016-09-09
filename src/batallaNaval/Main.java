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

    public static void jugar(){

        boolean fin = false;

        System.out.println("Todo Listo a Jugar");

        int casillas = 0;

        while(casillas != 4){

            System.out.println("Fila: ");
            int fila = sc.nextInt()-1;

            System.out.println("Columna: ");
            String col = sc.next();

            int colum = 0;

            for (int j = 0; j < tablero.length; j++) {

                if (col.charAt(0) == (char) ('A' + j)) {

                    colum = j;
                    System.out.println("Columna: " + colum);

                    break;

                }
            }

            if (tablero[fila][colum] == 1){

                System.out.println("Genial le diste");
                tablero[fila][colum] = 8;
                dibujartablero();
                casillas++;

            }else{

                System.out.println("ohhh vulve a intentarlo");

            }


        }

        System.out.println("Game Over");
    }

    public static void iniciar(){

        System.out.println("Ingrese el Tamano del tablero, Ej: 5");

        int tam = sc.nextInt();
        tablero = new int[tam][tam];

        System.out.println(tablero.length);
    }

    public static void dibujartablero(){

        System.out.print("--");

        for (int i = 0; i < tablero.length; i++) {

            System.out.print((char) ('A' + i) + "-");
        }

            System.out.println();

        for (int i = 0; i < tablero.length; i++) {

            System.out.print(i+1 + "-");

            for (int j = 0; j < tablero.length; j++) {

                System.out.print(tablero[i][j] + "-");
            }

            System.out.println("");
        }

        //iniciado = false;

    }

    public static void marcar(){

        System.out.println("Marques sus Casilleros");

        int casillas = 0;

        while(casillas!= 2 ) {

                System.out.println("1 - Vertical u 2 - Horizontal");
                int op = sc.nextInt();

                System.out.println("Fila, debe ser mayor a 0: ");
                int fila = sc.nextInt() - 1;

                System.out.println("Columna: ");
                String col = sc.next();

                int colum = 0;

                for (int j = 0; j < tablero.length; j++) {

                    if (col.charAt(0) == (char) ('A' + j)) {

                        colum = j;
                        break;

                    }

                }


            if (fila >= 0 && fila < tablero.length) {

                if (tablero[fila][colum] == 0) {

                    if (op == 2 ) {

                        tablero[fila][colum] = 1;
                        tablero[fila][colum+1] = 1;
                        dibujartablero();
                        System.out.println("Siguiente: ");

                    }else{

                        tablero[fila][colum] = 1;
                        tablero[fila+1][colum] = 1;
                        dibujartablero();
                        System.out.println("Siguiente: ");

                    }


                    casillas++;

                } else {

                    System.out.println("Este Casillero ya se Encuentra Marcado, seleccione otro");

                }

            }

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