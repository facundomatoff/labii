package main.java.com.frre.tsp.interfaces.herenciaMultiple;

/**
 * Clase PersonaAccion
 */
public class PersonaAccion extends Heroe
        implements IPoderCorrer,
                    IPoderNadar,
                    IPoderVolar {

    @Override
    public String correr() {
        return "Puede correr";
    }

    @Override
    public String nadar() {
        return "Puede nadar";
    }
}
