package Collections;

/**
 * Created by umantram on 18/11/16.
 */
public class Mamifero {

    String nombre;
    Double peso;

    public Mamifero(String nombre, Double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
