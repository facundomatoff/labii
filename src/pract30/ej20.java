package pract30;

/**
 * Created by umantram on 25/08/16.
 * 20. Imprimir y contar los números que son múltiplos de 2 o 3 que hay del 1 al 100.
 */
public class ej20 {

    public static void main(String[] args){

        int cont = 0;

        for (int i = 0; i <= 100; i++) {

            if(i%2==0 || i%3==0 ){

                System.out.println(i);
                cont++;
            }
        }

        System.out.println("cant de Mul 2 y 3: " + cont);

    }
}
