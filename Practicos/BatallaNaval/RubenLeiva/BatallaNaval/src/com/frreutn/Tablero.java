package com.frreutn;

import java.util.ArrayList;

/**
 * Created by rmlrd on 6/9/2016.
 */
public class Tablero {
    //atributos del tablero
    private String tablero[][] = new String[10][10];
    private Barco barco;
    private ArrayList<Barco>flota = new ArrayList<Barco>();
    private int tocados = 0;

    //cargo la matriz por constructor


    public Tablero() {
        cargarMatriz();
    }



    //mostrar tablero
    public void mostrarTablero(){
        for (int i=0;i<10;i++){
            for(int j=0;j<10;j++){
              System.out.print("  "+tablero[i][j]);
            }
            System.out.println();
        }
    }

    //cargo en un arrayList la posición de los barcos de la flota
    //falta controlar que la posición del barco sea continua
    public void cargarBarco(String y, String x){
        if (!(flota.size()>=3)) {
            barco = new Barco();
            barco.setPosicion(y,x);
            flota.add(barco);
        }else{
            System.out.println("Flota completa");
        }
    }

    //cargo la matriz
    public void cargarMatriz(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                tablero[i][j]="*";
            }
        }
    }

    //posicion del ataque enemigo
    public void ataqueEnemigo(String tiro){
        String uno = tiro.substring(0);
        String num = convertir(uno);
        int i = Integer.parseInt(num);
        String dos = tiro.substring(2);
        int j = Integer.parseInt(dos);

        for (Barco naves : flota) {
            if (naves.getPosicion().equals(tiro)) {
                tablero[i][j] = "T";
                tocados++;
            }else {
                tablero[i][j] = "A";
            }
        }

        if(tocados==6){
            System.out.println("Ha ganado el juego");
        }
        mostrarTablero();
    }

    @Override
    public String toString() {
        return "Tablero{" +
                "flota=" + flota +
                '}';
    }
//    public Barco recorrerBarcos(){
//        for (Barco grupo: flota) {
//            if (grupo.getPosicion().equals())
//                return grupo.getPosicion();
//        }
//
//    }

    //metodo para convertir una letra en numero
    public String convertir(String num){
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




}
