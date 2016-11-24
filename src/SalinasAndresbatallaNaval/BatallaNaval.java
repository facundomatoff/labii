package SalinasAndresbatallaNaval;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by umantram on 23/11/16.
 */
public class BatallaNaval {

    Scanner sc = new Scanner(System.in);
    Queue<Character> columnas = new LinkedList();
    Queue<Integer> filas = new LinkedList();
    int casillas = 0;

    public int getCasillas() {
        return casillas;
    }

    public void setCasillas(int casillas) {
        this.casillas = casillas;
    }

    int[][] tablero ;


    public void jugar(int fila, char col){

        boolean fin = false;

            //System.out.println("Fila: ");
            //int fila = sc.nextInt()-1;

            //System.out.println("Columna: ");
            //String col = sc.next();

        while(!filas.contains(fila)) {
            System.out.println("Fila, debe ser mayor a 0 y menor a " + this.tablero.length);
            fila = sc.nextInt() - 1;
        };

        while(!columnas.contains(col)) {
            System.out.println("Columna, debe Ingresa una Letra Mayuscula y hasta la Letra " + (char) ('A' + this.tablero[0].length - 1));
            col = sc.next().charAt(0);
        };


            int colum = 0;

            for (int j = 0; j < tablero.length; j++) {

                if (col == (char) ('A' + j)) {

                    colum = j;
                    //System.out.println("Columna: " + colum);

                    break;

                }
            }

            if (tablero[fila-1][colum] == 1){

                System.out.println("Genial le diste");
                tablero[fila-1][colum] = 8;
                dibujartablero();
                casillas++;

            }else{

                System.out.println("ohhh vulve a intentarlo");

            }


        }

        //System.out.println("Game Over");
    //}


    public void iniciar(int tamaño){

        //int tam = sc.nextInt();
        this.tablero = new int[tamaño][tamaño];
        //System.out.println(this.tablero.length);

    }

    public void dibujartablero(){

        System.out.print("--");

        for (int i = 0; i < this.tablero.length; i++) {

            columnas.add((char) ('A' + i));

            System.out.print((char) ('A' + i) + "-");

        }

        System.out.println();

        for (int i = 0; i < this.tablero.length; i++) {

            filas.add(i+1);

            System.out.print(i+1 + "-");

            for (int j = 0; j < this.tablero.length; j++) {

                System.out.print(this.tablero[i][j] + "-");
            }

            System.out.println("");
        }

    }

    public void marcar(int fila, char col){

        //int casillas = 0;
        //int fila;
        //String col;

        //while(casillas!= 2 ) {

            //System.out.println("1 - Vertical u 2 - Horizontal");
            //int op = sc.nextInt();

            while(!filas.contains(fila)) {
                System.out.println("Fila, debe ser mayor a 0 y menor a " + this.tablero.length);
                fila = sc.nextInt() - 1;
            };

            while(!columnas.contains(col)) {
                System.out.println("Columna, debe Ingresa una Letra Mayuscula y hasta la Letra " + (char) ('A' + this.tablero[0].length - 1));
                col = sc.next().charAt(0);
            };

        int colum = 0;

            for (int j = 0; j < tablero.length; j++) {

                if (col == (char) ('A' + j)) {

                    colum = j;
                    break;

                }

            }


            //if (fila >= 0 && fila < tablero.length) {

                //if (tablero[fila][colum] == 0) {

                    //if (op == 2 ) {

                        this.tablero[fila-1][colum] = 1;
                        //tablero[fila][colum+1] = 1;
                        dibujartablero();
                        System.out.println("Siguiente: ");

                   // }else{

                   //     tablero[fila][colum] = 1;
                   //     tablero[fila+1][colum] = 1;
                   //     dibujartablero();
                   //     System.out.println("Siguiente: ");

                    //}

                    //casillas++;

                //} else {

                //    System.out.println("Este Casillero ya se Encuentra Marcado, seleccione otro");

                //}

            //}

        }


}
