package com.frreutn;

import java.util.ArrayList;

/**
 * Created by rmlrd on 6/9/2016.
 */
public class Jugador {
    String nombre;
    Tablero tablero;

    public Jugador(String nombre) {
        this.nombre = nombre;
        tablero = new Tablero();
    }

    public void mostrarTablero(){
        tablero.mostrarTablero();
    }

    public void cargarBarco(String y, String x){
        tablero.cargarBarco(y, x);
    }

    public void mostrarFlota(){
        System.out.println(tablero.toString());
    }

    public void disparoEnemigo(String tiro){
        tablero.ataqueEnemigo(tiro);
    }

    @Override
    public String toString() {
        return "Jugador1{" +
                "nombre='" + nombre + '\'' +
                '}';
    }




}
