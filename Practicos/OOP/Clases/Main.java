package main.java.com.frre.tsp.oop;

/**
 * Test oop methods.
 */
public class Main {

    public static void main(String[] args) {

        crearObjectos();
        //crearObjectosSuper();
        //crearObjectosAbstract();
        //castingObjectos();
        //enums();
        //interfaces();
    }

    private static void crearObjectos() {

        // Error: No se puede instanciar una clase abstracta.
        //Animal a1 = new Animal();

        // Se crean instancias de cada clase
        Mamifero m1 = new Mamifero();
        Perro p1 = new Perro();
        Gato g1 = new Gato();

        m1.caminar();
        m1.comer();

        p1.caminar();
        p1.comer();
        p1.ladrar();

        g1.caminar();
        g1.comer();
        g1.maullar();
    }

    private static void crearObjectosSuper() {
        // Se crean instancia de su clase padre.
        Mamifero p2 = new Perro();
        Mamifero g2 = new Gato();

        p2.caminar();
        p2.comer();
        p2.desplazarse();

        g2.caminar();
        g2.comer();
    }

    private static void crearObjectosAbstract() {

        // Se crean instanciia de su clase padre.
        Animal m3 = new Mamifero();
        Animal p3 = new Perro();
        Animal g3 = new Gato();

        m3.caminar();
        p3.caminar();
        g3.caminar();
    }

    private static void castingObjectos() {

        // Casting
        Perro p4 = new Perro();
        Mamifero m4 = p4;

        System.out.println(p4.getClass());
        System.out.println(m4.getClass());

        // Casting error:
        Mamifero m5 = new Gato();
        Perro p5 = (Perro)m5;
        Perro p6 = (Perro) m4;

        System.out.println(m5.getClass());
        System.out.println(p6.getClass());
    }

    private static void enums() {

        // Obtener el valor ordinal
        System.out.println(Dias.DOMINGO.ordinal());

        // Obtener una lista de los valores
        Dias[] dias =Dias.values();

        for(int i = 0; i < dias.length;i++) {
            System.out.println(dias[i]);
        }

        // Usando custom enum constructor
        Impuestos imp =  Impuestos.IMPUESTO21;
    }

    private static void interfaces() {

        System.out.println(Months.APRIL);

    }
}









