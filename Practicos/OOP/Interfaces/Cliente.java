package main.java.com.frre.tsp.interfaces.ejemploClase;

/**
 * Clase Cliente.
 */
public class Cliente extends Entidad {

    public String nombre;
    public String apellido;

    @Override
    public String toString() {
        return apellido  + " - " + nombre;
    }

}
