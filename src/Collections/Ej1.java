package Collections;

import java.util.ArrayList;

/**
 * Created by umantram on 18/11/16.
 */
public class Ej1 {

    public static void main(String[] args) {

        ArrayList <String> lista =  new ArrayList<>();

        lista.add("mama");
        lista.add("papa");
        lista.add("hermana");

        System.out.println(lista);

        lista.remove("papa");

        System.out.println(lista);

    }
}
