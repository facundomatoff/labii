package main.java.com.frre.tsp.oop;

/**
 * Enumeracion en la que se sobre-carga el constructor por defecto por otro tipado
 * el cual permite obtener los valores de la enumeracion por índice.
 */
public enum Impuestos {
    IMPUESTO21(21),
    IMPUESTO25(25),
    IMPUESTO35(35);

    private int value;

    private Impuestos(int value) {
        this.value  = value;
    }

    public int getValue() {
        return this.value;
    }
}
