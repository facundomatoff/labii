package main.java.com.frre.tsp.interfaces.ejemploClase;

/**
 * Clase Factura, hereda de Entidad e implementa IContable
 */
public class Factura extends Entidad implements IContable {

    public Producto[] productos;

    /*
    * Retorna el total de precios de todos los productos
    */
    @Override
    public double getPrecio() {

        double total = 0.0;

        for (int i = 0; i < productos.length; i++) {
            total += productos[i].getPrecio();
        }

        return total;
    }
}
