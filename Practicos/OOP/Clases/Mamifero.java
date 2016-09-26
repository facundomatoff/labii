package main.java.com.frre.tsp.oop;

/**
 * Clase Manifero que hereda de Animal
 */
public class Mamifero extends Animal {

    private String nombre;

    public Mamifero() {
    }

    public Mamifero(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    // metodo comer
    void comer() {
    }

    void desplazarse() {}

    /*
    * Sobre-escribe el metodo equals para demostrar como se utiliza este metodo en la comparacion
    * de instancias de una misma clase.
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Mamifero m = (Mamifero)obj;

        return this.nombre.equals(m.nombre);
    }

    /*
    * Ejemplos de como al sobre-escribir el metodo hashCode podemos retornar el mismo
    * valor para varias instancias de la clase Manifero y al utilizar el metodo Equals
    * entre distintas instancia de la clase este nos retornarrá "false", demostrando que
    * la comparacion entre objectos no esta relacionada con el metodo HashCode, pero si
    * con el metodo Equals().
    */
    /*
    @Override
    public int hashCode() {
        return 99;
        //return this.nombre.hashCode();
    }
    */
}
