package Collections;

import java.util.LinkedList;

/**
 * Created by umantram on 18/11/16.
 */
public class Ej3 {

    public static void main(String[] args) {

        LinkedList <String> lista = new LinkedList<>();

        lista.add("aaaaa");
        lista.add("sssss");
        lista.add("ddddd");

        System.out.println(lista);

        lista.add("fffff");

        System.out.println(lista);

        System.out.println(lista.element());
        lista.remove(0);

        System.out.println(lista);



    }
}
