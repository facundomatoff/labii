package ClaseAnonima;

import java.util.*;

/**
 * Created by umantram on 23/11/16.
 */
public class Main {

    public static void main(String[] args) {

        Persona a = new Persona(20);
        Persona b = new Persona(12);

        Comparator <Persona> OrdenPorDNI = new Comparator<Persona>() {
            @Override
            public int compare(Persona persona, Persona t1) {
                return persona.getDni() - t1.getDni();
            }
        };

        TreeSet<Persona> tree = new TreeSet<>(OrdenPorDNI);

        tree.add(a);
        tree.add(b);
        System.out.println(tree);

        Map mapa = new TreeMap();

        mapa.put("perro","perro");

        System.out.println(mapa);
    }

}
