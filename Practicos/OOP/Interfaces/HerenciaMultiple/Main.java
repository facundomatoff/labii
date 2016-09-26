package main.java.com.frre.tsp.interfaces.herenciaMultiple;

/**
 * Created by facundo.matoff on 16/09/2016.
 */
public class Main {

    public static void main(String[] args) {

        ejecutarAventura();
        //intercambiarUpCasting();
    }

    static void ejecutarAventura() {

        PersonaAccion pa = new PersonaAccion();

        System.out.println(Aventura.tieneQueVolar(pa));
        System.out.println(Aventura.tieneQueCorrer(pa));
        System.out.println(Aventura.tieneQueNadar(pa));
        System.out.println(Aventura.tieneQueSerHeroe(pa));
    }

    static void intercambiarUpCasting() {

        // Crea una instancia de la clase Personaje de Accion y hace el Upcasting a los tipos.
        // Se visualizan los metodos que va a poseer el objecto al hacer el upcasting.
        PersonaAccion pa = new PersonaAccion();
        pa.fuerza();
        pa.nadar();
        pa.correr();
        pa.volar();

        Heroe he = new PersonaAccion();
        he.fuerza();
        he.fuerza();

        IPoderVolar pv = new PersonaAccion();
        pv.volar();

        IPoderCorrer pc = new PersonaAccion();
        pc.correr();

        IPoderNadar pn = new PersonaAccion();
        pn.nadar();

        // Puede asignarse UpCasting.
        he = pa;

        pv = pa;

        pc = pa;

        pn = pa;
    }

}
