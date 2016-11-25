package pract30;

/**
 * Created by umantram on 25/08/16.
 */
public class ej9 {

    public static void main(String[] args){

        int suma = 0;

        for (int i = 0; i < 100; i++) {

            if(i%2!=0){

                suma +=i;
            }
        }

        System.out.println("Suma: " + suma);

    }

}
