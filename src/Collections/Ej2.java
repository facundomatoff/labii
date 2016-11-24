package Collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by umantram on 18/11/16.
 */
public class Ej2 {

    public static void main(String[] args) {

        String[] lista = {"mama", "papa", "aa", "ss"};

        ArrayList lista2 = new ArrayList();

        lista2.add(lista[0]);
        lista2.add(lista[1]);
        lista2.add(lista[2]);
        lista2.add(lista[3]);

        System.out.println(lista2);

        List sublista = lista2.subList(1,3);

        System.out.println(sublista);

        sublista.clear();

        System.out.println(sublista);
        System.out.println(lista2);

    }
}
