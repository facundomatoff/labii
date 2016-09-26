package main.java.com.frre.tsp.interfaces.ejemploClase;

/**
 * Clase ControladorDeAccesoDatos que permite agregar, borrar y leer objetos.
 */
public class ControlladorAccesoDatos {

    private Entidad[] entidades = new Entidad[100];
    private int count = 0;

    public void agregar(Entidad entidad) {

        int indiceAInsertar = -1;

        // Realiza una búsqueda secuencial buscando una posicion
        // libre (null) para insertar un valor
        for (int i = 0; i < 100; i++) {
            if (entidades[i] == null) {
                indiceAInsertar = i;
                return; // cuando encuentra el índice, sale del for.
            }
        }

        // Despuess de hacer la búsqueda no encontró una posicion libre,
        // entonces no puede insertar el objecto y sale de metodo con "return".
        if (indiceAInsertar == -1) {
            return;
        }

        // Inserta el objecto en la posicion libre
        this.entidades[indiceAInsertar] = entidad;
    }

    public void borrar(int id) {
        for (int i = 0; i < 100; i++) {
            if (entidades[i].ID == id)
                entidades[i] = null;
        }
    }

    public Entidad[] leer() {
        return this.entidades;
    }

    public Entidad encontrar(String nombre) {
        for (int i = 0; i < 100; i++) {
            if (entidades[i].toString().equals(nombre))
                return entidades[i];
        }
        return null;
    }

    public Entidad encontrar(int id) {
        for (int i = 0; i < 100; i++) {
            if (entidades[i].ID == id) {
                return entidades[i];
            }
        }
        return null;
    }

    public IContable[] leerMenoresA(IContable[] contables, double precio) {
        IContable[] tempTemporales = new IContable[100];
        int indice = 0;

        // Utiliza un for-each para obtener un objeto que implemente IContable
        // del arreglo de IContable[] que se pasa como argumento del metodo.
        for(IContable item : contables) {

            // Se asegura de que el item no sea null
            if (item != null) {

                // Compara el valor de los precios
                if (item.getPrecio() < precio) {
                    tempTemporales[indice] = item;
                    indice++;
                }
            }
        }

        // Retorna la lista temporal de IContable que no superan el precio.
        return tempTemporales;
    }
}
