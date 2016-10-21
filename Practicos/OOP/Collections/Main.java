package main.java.com.frre.tsp.colecciones;

import main.java.com.frre.tsp.interfaces.herenciaMultiple.Heroe;
import main.java.com.frre.tsp.oop.Mamifero;
import main.java.com.frre.tsp.oop.Perro;

import java.util.*;

/**
 * Test JAVA collections
 */
public class Main {

    public static void main(String[] args) {

        ejemploList();
        //ejemploStack();
        //ejemploSet();
        //ejemploMap();
        //pruebaColeccionesSimples();
    }

    static void ejemploList() {

        // ArrayList
        ArrayList l1 = new ArrayList();

        l1.add(1);
        l1.add(2);
        l1.add("perro");
        l1.add(new Mamifero("perro"));
        l1.add(new Perro());
        l1.add(new Heroe());

        System.out.println(l1.toString());

        // ArrayList
        ArrayList l2 = new ArrayList();

        l2.add(1);
        l2.add(2);
        l2.add(3);

        // ejemplo generic.
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(1);
        l3.add(2);
        l3.add(3);

        System.out.println(l3.toString());

        // LinkedList
        List ll1 = new LinkedList();

        l1.add(1);
        l1.add(2);
        l1.add("perro");

        LinkedList ll2 = new LinkedList();
        ll2.addLast("mundo");
        ll2.addFirst("hola");

        System.out.println(ll2.toString());
    }

    static void ejemploStack() {
        Stack s1 = new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        System.out.println(s1.toString());

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }

    static void ejemploSet() {
        Set s1 = new HashSet();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(1);

        System.out.println(s1.toString());

        // Usando clase
        Set s2 = new HashSet();
        s2.add(new Mamifero("perro"));
        s2.add(new Mamifero("gato"));
        s2.add(new Mamifero("raton"));
        s2.add(new Mamifero("perro"));

        System.out.println(s2.toString());

        // Usando instancias de clase
        Set s3 = new HashSet();

        Mamifero m1 = new Mamifero("perro");
        Mamifero m2 = new Mamifero("gato");
        Mamifero m3 = new Mamifero("raton");

        s3.add(m1);
        s3.add(m2);
        s3.add(m3);
        s3.add(m1);

        System.out.println(s3.toString());
    }

    static void ejemploMap() {

        Map m1 = new HashMap();

        m1.put(1, "hola");
        m1.put(2, "mundo");
        m1.put("a", 1);

        // ejemplo generic
        Map<Integer,Integer> m2 = new HashMap<Integer,Integer>();

        for(int i = 0; i < 20; i++) {
            m2.put(i, i + 100);
        }
    }

    static void pruebaColeccionesSimples() {

        //// List
        print(fill(new ArrayList<String>()));
        print(fill(new LinkedList<String>()));

        //// Set
        print(fill(new HashSet<String>()));
        print(fill(new TreeSet<String>()));
        print(fill(new LinkedHashSet<String>()));

        //// Map
        print(fill(new HashMap<String,String>()));
        print(fill(new TreeMap<String,String>()));
        print(fill(new LinkedHashMap<String,String>()));
    }

    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String,String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    static void print(Object obj) {
        System.out.println(obj);
    }

}


