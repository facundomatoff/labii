package Singleton;

/**
 * Created by umantram on 24/11/16.
 */
public class Main {

    public static void main(String[] args) {

        Persona andres = Persona.cargandoSingleton(123);
        Persona giu = Persona.cargandoSingleton(456);

        System.out.println(andres.getDni());
        System.out.println(giu.getDni());

    }
}
