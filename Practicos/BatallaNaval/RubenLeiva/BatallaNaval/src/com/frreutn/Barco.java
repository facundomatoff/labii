package com.frreutn;

import java.util.Arrays;

/**
 * Created by rmlrd on 6/9/2016.
 */
public class Barco {
    private String posicion[] = new String[2];

    public void setPosicion(String pos1, String pos2){
        this.posicion[0] = pos1;
        this.posicion[1] = pos2;
    }

    public String[] getPosicion() {
        return posicion;
    }

    public void setPosicion(String[] posicion) {
        this.posicion = posicion;
    }
    @Override
    public String toString() {
        return "posicion=" + Arrays.toString(posicion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Barco barco = (Barco) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(posicion, barco.posicion);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(posicion);
    }
}
