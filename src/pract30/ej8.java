package pract30;

/**
 * Created by umantram on 25/08/16.
 */
public class ej8 {

    public static void main(String[] args){

        int cont = 0;

        for (int i = 0; i <= 100; i++) {

            if(i%3==0){

                System.out.println(i);
                cont++;
            }
        }

        System.out.println("cant de Mul 3: " + cont);

    }

}
