package main.java.com.frre.tsp.interfaces.herenciaMultiple;

/**
 * Clase Aventura
 */
public class Aventura {

    public static String tieneQueVolar(IPoderVolar personaje) {
        return personaje.volar();
    }

    public static String tieneQueCorrer(IPoderCorrer personaje) {
        return personaje.correr();
    }

    public static String tieneQueNadar(IPoderNadar personaje) {
        return personaje.nadar();
    }

    public static String tieneQueSerHeroe (Heroe personaje) {
        return personaje.fuerza();
    }

}
