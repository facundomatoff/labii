package com.obregonAlan.batallaNaval;

import java.util.Scanner;

/**
 * Created by Alan on 27/08/2016.
 */
public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        char[][] matriz = new char[10][10];

        for (int i = 0; i < 10; i++){
            for (int f = 0; f < 10; f++){
                matriz[i][f] = '~';
            }
        }

        int cont = 0;
        while (cont != 3){
            int i = (int) (Math.random()*9);
            int f = (int) (Math.random()*9);

            if(matriz[i][f] == '~'){
                matriz[i][f] = 'O';

                boolean rta = true;
                do {
                    int a = (int) (Math.random()*(1-4)+4);
                    switch (a){
                        case 1: { //Arriba
                            if((i != 0) && (matriz[i - 1][f] == '~')){
                                matriz[i - 1][f] = 'O';
                                rta = false;
                            }
                        }
                        break;
                        case 2: { //Abajo
                            if ((i != 9)  && (matriz[i + 1][f] == '~')){
                                matriz[i + 1][f] = 'O';
                                rta = false;
                            }
                        }
                        break;
                        case 3: { //Derecha
                            if ((f != 9)  && (matriz[i][f + 1] == '~')){
                                matriz[i][f + 1] = 'O';
                                rta = false;
                            }
                        }
                        break;
                        case 4: { //Izquierda
                            if ((f != 0)  && (matriz[i][f - 1] == '~')){
                                matriz[i][f - 1] = 'O';
                                rta = false;
                            }
                        }
                        break;
                    }
                } while (rta);
                cont++;
            }
        }
        System.out.println("     Tablero Inicial");
        System.out.println("   A B C D E F G H I J");
        for (int i = 0; i < 10; i++){
            System.out.print((i + 1) + ". ");
            for (int f = 0; f < 10; f++){
                System.out.print(matriz[i][f] + " ");
            }
            System.out.println("");
        }

        System.out.println("\n");
        boolean rta = true;
        do {
            /**
             * Ingreso de coordenadas
             */
            System.out.println("Ingrese coordenadas para atacar");
            System.out.print("Ingrese una letra de la A a la J en Mayusculas: "); char letra = sc.next().charAt(0);
            System.out.print("Ingrese un numero del 1 al 10: "); int num = sc.nextInt();

            if ((letra >= 65) && (letra <= 74)){
                int let = 0;
                switch (letra){
                    case 'A': let = 1; break;
                    case 'B': let = 2; break;
                    case 'C': let = 3; break;
                    case 'D': let = 4; break;
                    case 'E': let = 5; break;
                    case 'F': let = 6; break;
                    case 'G': let = 7; break;
                    case 'H': let = 8; break;
                    case 'I': let = 9; break;
                    case 'J': let = 10; break;
                }

                if ((num >= 1) && (num <= 10)){
                    let = let - 1;
                    num = num - 1;

                    if (matriz[num][let] == 'O'){
                        matriz[num][let] = 'X';
                    }
                } else {
                    System.out.println("El numero ingresado no esta entre el 1 y el 10");
                }
            } else {
                System.out.println("La letra ingresada no esta entre la A y la J o no esta en mayusculas");
            }

            /**
             * Imprimir tablero actual
             */
            System.out.println("1: Imprimir tablero");
            System.out.println("-1: Salir del juego");
            int preg = sc.nextInt();

            if (preg == 1){
                System.out.println("   A B C D E F G H I J");
                for (int i = 0; i < 10; i++){
                    System.out.print((i + 1) + ". ");
                    for (int f = 0; f < 10; f++){
                        System.out.print(matriz[i][f] + " ");
                    }
                    System.out.println("");
                }
            } else if (preg == -1){
                rta = false;
            } else {
                System.out.println("Tenes que ingresar 1 o -1");
                System.out.println("Por vivo segui jugando");
            }

            /**
             * Comprobar cantidad de barcos
             */
            int cont2 = 0;
            for (int i = 0; i < 10; i++){
                for (int f = 0; f < 10; f++){
                    if (matriz[i][f] == 'X'){
                        cont2++;
                    }
                }
            }

            if (cont2 == 6){
                System.out.println("Juego finalizado");
                rta = false;
            }
        }while (rta);
    }
}
