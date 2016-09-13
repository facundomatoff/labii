package batallaNaval;

import java.util.Scanner;

import static batallaNaval.metodos.Metodos.*;


/**
 * Created by Alan on 03/09/2016.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        println("BATALLA NAVAL");
        print("Ingrese el tamaño del tablero que desea generar (MAX: 10): ");
        int a = scanner.nextInt();
        while (a > 10) {
            print("El numero supera el tamaño maximo. Por favor ingreselo nuevamente: ");
            a = scanner.nextInt();
        }

        //Creamos el tablero de juego
        char[][] tablero = new char[a][a];
        crearTablero(tablero, a);
        imprimirTablero(tablero, a);
        println("");

        //Cargamos la cantidad de barcos deseados
        int cantMAX = ((a * a) / 2);
        print("Ingrese la cantidad de barcos que desea cargar (MAX: " + cantMAX + "): ");
        int cantBarcos = scanner.nextInt();
        while (cantBarcos > cantMAX) {
            print("El numero supera el tamaño maximo. Por favor ingreselo nuevamente: ");
            cantBarcos = scanner.nextInt();
        }

        //Hora de cargar los barcos
        String coor1 = "";
        String coor2 = "";
        int letA, numA, letB, numB;
        int cont = 1;
        while (cont <= cantBarcos) {
            print("Ingrese las coordenadas para añadir al barco " + cont + ": ");
            coor1 = scanner.next();
            coor2 = scanner.next();
            letA = posicionLetra(coor1) - 1;
            numA = posicionNum(coor1) - 1;
            letB = posicionLetra(coor2) - 1;
            numB = posicionNum(coor2) - 1;

            if ((letA >= 0) && (letA < a)){
                if ((numA >= 0) && (numA < a)){
                    if ((letB >= 0) && (letB < a)){
                        if ((numB >= 0) && (numB < a)){
                            if (sonContiguos(a, letA, numA, letB, numB)){
                                if ((tablero[numA][letA] == '~') && (tablero[numB][letB] == '~')){
                                    tablero[numA][letA] = 'O';
                                    tablero[numB][letB] = 'O';
                                    cont++;
                                }
                            } else {
                                println("Las coordenadas no son contiguas. Por favor ingrese dos coordenadas que sean contiguas");
                            }
                        } else {
                            println("La numero de la coordenada " + coor2 + " no puede ser cargada. Por favor ingrese las coordenadas nuevamente");
                        }
                    } else {
                        println("La letra de la coordenada " + coor2 + " no puede ser cargada. Por favor ingrese las coordenadas nuevamente");
                    }
                } else {
                    println("La numero de la coordenada " + coor1 + " no puede ser cargada. Por favor ingrese las coordenadas nuevamente");
                }
            } else {
                println("La letra de la coordenada " + coor1 + " no puede ser cargada. Por favor ingrese las coordenadas nuevamente");
            }
        }

        println("");
        //Imprimir tablero inicial
        println("Tablero Inicial:");
        imprimirTablero(tablero, a);

        int rta = 0;
        while (quedanBarcos(tablero, a)){
            //Atacar
            print("Ingrese las coordenadas para atacar: "); coor1 = scanner.next();
            letA = posicionLetra(coor1) - 1;
            numA = posicionNum(coor1) - 1;

            if (tablero[numA][letA] == 'O'){
                tablero[numA][letA] = 'X';
            }

            println("1: Imprimir tablero actual\n2: Continuar\n3: Salir");
            print("Que desea hacer?: "); rta = scanner.nextInt();
            if (rta == 1){
                imprimirTablero(tablero, a);
            } else if (rta == 3){
                crearTablero(tablero, a);
            }
        }

        println("Juego finalizado");
    }
}