package com.frreutn;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //variable Scanner para ingreso de datos requeridos
        Scanner ent = new Scanner(System.in);
        String primerJugador;
        String segundoJugador;
        String continuar;

        //ingreso el nombre del jugador 1
        System.out.println("Ingrese el nombre del jugador");
        primerJugador = ent.next();


        //declaro la clase Jugador
        Jugador jugador1 = new Jugador(primerJugador);

        //muestro el nombre del jugador
        System.out.println(jugador1.toString());

        //Muestro el tablero
        jugador1.mostrarTablero();

        //cargo los barcos

        for (int i=0;i<=2;i++){
            String fila1, columna1;
            String fila2, columna2;
            String posicion1, posicion2;
            String num1, num2;
            System.out.println("Ingrese fila y columna");
            fila1 = ent.next();
            num1 = convertir(fila1);
            columna1 = ent.next();
            posicion1 = num1 + ","+columna1;

            System.out.println("Ingrese fila y columna");
            fila2 = ent.next();
            num2 = convertir(fila2);
            columna2 = ent.next();
            posicion2 = num2 + "," +columna2;
            jugador1.cargarBarco(posicion1, posicion2);
        }

        jugador1.mostrarFlota();

        //segundo jugador

        System.out.println("Ingrese nombre del segundo  jugador");
        segundoJugador=ent.next();
        Jugador jugador2 = new Jugador(segundoJugador);

        for (int i=0;i<=2;i++){
            String fila1, columna1;
            String fila2, columna2;
            String posicion1, posicion2;
            String num1, num2;

            System.out.println("Ingrese fila y columna");
            fila1=ent.next();
            num1 = convertir(fila1);
            columna1 = ent.next();
            posicion1 = num1 + "," + columna1;

            System.out.println("Ingrese fila y columna");
            fila2 = ent.next();
            num2 = convertir(fila2);
            columna2 = ent.next();
            posicion2 = num2 + "," + columna2;

            jugador2.cargarBarco(posicion1, posicion2);
        }

        do {
            System.out.println("Juega Jugador 1");
            //variables para las coordenadas de ataque
            String a, b, c, d;
            System.out.println("Ingrese coordenadas de tiro");
            a = ent.next();
            b = convertir(a);
            c = ent.next();
            d = b+","+c;
            jugador2.disparoEnemigo(d);
            System.out.println("Juega Jugador 2");
            jugador2.mostrarTablero();

            //variables para las coordenadas de ataque
            String a2, b2, c2, d2;
            System.out.println("Ingrese coordenadas de tiro");
            a2 = ent.next();
            b2 = convertir(a2);
            c2 = ent.next();
            d2 = b2+","+c2;
            jugador1.disparoEnemigo(d2);

            System.out.println("¿Desea continuar? (S|N)");
            continuar = ent.next();

        }while (continuar.equalsIgnoreCase("s"));


    }//fin de main

    //metodo para convertir una letra en numero
    public static String convertir(String num){
        String convertir[] = {"a", "b", "c", "d","e", "f", "g", "h", "i", "j"};
        String valor;
        for (int i=0;i<=convertir.length;i++){
            if (convertir[i].equalsIgnoreCase(num)){
                valor = String.valueOf(i);
                return valor;
            }
        }
        return "";
    }//fin de metodo



}//fin de clase
