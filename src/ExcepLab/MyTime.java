package ExcepLab;

/**
 * Created by umantram on 24/11/16.
 */
public class MyTime extends  RuntimeException{

    int hora;
    int minuto;

    public MyTime(int hora, int minuto) {


        this.hora = hora;
        this.minuto = minuto;


    }



    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
