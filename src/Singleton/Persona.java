package Singleton;

/**
 * Created by umantram on 24/11/16.
 */
public class Persona {

    private int dni;
    private static Persona cargardni;

    private Persona(int dni){

        this.dni = dni;
        System.out.println("creado");
    }

    public static Persona cargandoSingleton(int dni){

        if (cargardni == null){

            cargardni = new Persona(dni);

        }else {

            System.out.println("ya existe");
        }

        return cargardni;

    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
