package main.java.com.frre.tsp.interfaces.ejemploClase;

/**
 * Clase Producto, solo implementa IContable.
 */
public class Producto implements IContable {

    public String descripcion;

    private double precio;

    public Producto(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
