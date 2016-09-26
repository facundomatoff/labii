package main.java.com.frre.tsp.interfaces.ejemploClase;

import java.util.Arrays;

/**
 * Clase para probar el controlador de acceso a datos.
 */
public class Main {

    public static void main(String[] args) {

        //agregarClientes();
        agregarProductos();

    }

    static void agregarClientes() {

        ControlladorAccesoDatos ctlAD = new ControlladorAccesoDatos();

        Cliente cliente1 = new Cliente();
        cliente1.nombre = "Juan";
        cliente1.apellido = "Perez";

        Cliente cliente2 = new Cliente();
        cliente2.nombre = "Steve";
        cliente2.apellido = "Jobs";

        ctlAD.agregar(cliente1);
        ctlAD.agregar(cliente2);

        System.out.println(Arrays.toString(ctlAD.leer()));

    }

    static void agregarProductos() {

        ControlladorAccesoDatos ctlAD = new ControlladorAccesoDatos();

        IContable[] contables = new IContable[100];

        Producto p1 = new Producto("coca-cola", 50);
        Producto p2 = new Producto("sprite", 55);
        Producto p3 = new Producto("fanta", 30);

        contables[0] = p1;
        contables[1] = p2;
        contables[2] = p3;

        System.out.println(Arrays.toString(ctlAD.leerMenoresA(contables, 40)));
    }
}
