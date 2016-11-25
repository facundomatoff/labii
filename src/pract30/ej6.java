package pract30;

/**
 * Created by umantram on 25/08/16.
 */
public class ej6 {

    public static void main(String[] args ){

        int suma = 0;

        for (int i = 100; i >= 0; i--) {

            if(i%2!=0){

                System.out.println(i);
                suma +=i;
            }
        }

        System.out.println("Suma: " + suma);

    }
}
