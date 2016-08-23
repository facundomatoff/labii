package batalla.clases;

/**
 * Created by Usuario1 on 19/08/2016.
 */

/*

Estas clases estáticas controlan el ingreso de los datos de cada bloque
para poder asignarlas a las naves que van a formar eventualmente.

Se puede armar una grilla hasta 26 x 26. Con la idea de ampliar duplicando las letras

 */
public class Estaticas {
    public static String[] armacabecera(int n) {

        String[] abcdario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] cabecera = new String[n];
        for (int i = 0; i < n; i++) {

            cabecera[i] = abcdario[i];
        }
        return cabecera;
    }


    public static boolean armaBlockUno(int n, String aa, int bb) {

        String[] cols = new String[n];
        int[] filas = new int[n];

        cols = armacabecera(n);
        for (int i = 0; i < n; i++) {
            filas[i] = i + 1;
        }

        for (int j = 0; j < n; j++) {

            if (aa.equalsIgnoreCase(cols[j])) {    // verifico que esté en el arreglo de cabecera

                if (bb >= 1 && bb <= n) {                  // Verifico que esté dentro del arreglo de filas

                    return true;   // si se cumple, retorno verdadero

                }
            }

        }

        return false;
    }


    public static boolean armaBlockDos(int n, String cc, int dd, String aa, int bb) {

        String[] cols = new String[n];
        int[] filas = new int[n];

        cols = armacabecera(n);
        for (int i = 0; i < n; i++) {
            filas[i] = i + 1;
        }

        for (int j = 0; j < n; j++) {

            if (cc.equalsIgnoreCase(cols[j])) {    // verifico que esté en el arreglo de cabecera

                if ((j > 0) && (aa.equalsIgnoreCase(cols[j-1]) && (j<(n-1)))) {
                    if (bb == dd) {
                        return true;
                    }
                }


                if (cc.equalsIgnoreCase(aa)){
                    if (bb == dd) {
                        return false;
                    }

                    if (bb == 1 && dd == bb + 1) {

                        return true;
                    }

                    if (dd == 1 && bb == dd + 1) {
                        return true;
                    }
                    if (bb == n && dd == bb - 1) {
                        return true;
                    }

                    if (dd == n && bb == dd - 1) {
                        return true;
                    }

                    if (bb < n && bb > 1 && (dd == bb - 1 || dd == bb + 1)) {
                        return true;
                    }

                    if (dd < n && dd > 1 && (bb == dd - 1 || bb == dd + 1)) {
                        return true;
                    }

                }

                if ((j<(n-1) && (j>0))){

                    if (((aa.equalsIgnoreCase(cols[j-1])) || (aa.equalsIgnoreCase(cols[j+1]))) && (dd==bb)){
                        return true;
                    }

                }

                 if ((j==(n-1) && (aa.equalsIgnoreCase(cols[j-1]))) && (dd==bb)){
                        return true;
                 }

                 if ((j==0 && (aa.equalsIgnoreCase(cols[j+1]))) && (dd==bb)){
                        return true;
                 }

            }

        }

        return false;
    }
}
