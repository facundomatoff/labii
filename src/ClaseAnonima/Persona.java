package ClaseAnonima;

/**
 * Created by umantram on 23/11/16.
 */
public class Persona {

    int dni;

    public Persona(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni=" + dni +
                '}';
    }
}
