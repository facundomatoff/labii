package Collections;

import java.util.LinkedList;

/**
 * Created by umantram on 18/11/16.
 */
public class Main {

    public static void main(String[] args) {

        LinkedList <Mamifero> mamife = new LinkedList<>();
        mamife.add(new Mamifero("aaaa", 1.0));
        mamife.add(new Mamifero("ssss", 2.0));
        mamife.add(new Mamifero("dddd", 3.0));
        mamife.add(new Mamifero("ffff", 4.0));
        mamife.add(new Mamifero("gggg", 5.0));

        for(Mamifero m: mamife){

            System.out.println(m.getNombre() + m.getPeso());
        }


    }

}
