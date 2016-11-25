package ExcepLab;

/**
 * Created by umantram on 24/11/16.
 */
public class MyTime {

    int hora;
    int minuto;

    public MyTime(int hora, int minuto) throws AtrapaError {


        if (hora < 0){

            throw new AtrapaError("Ingresar");

        }

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

    public MyTime nextHora(){

        //this.setHora(this.minuto + 1);
        hora = this.hora+1;
        this.setHora(hora);
        return this;
    }

    @Override
    public String toString() {
        return "MyTime{" +
                "hora=" + hora +
                ", minuto=" + minuto +
                '}';
    }
}
