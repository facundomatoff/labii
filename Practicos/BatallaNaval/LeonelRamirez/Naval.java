
import java.util.Scanner;

public class Naval {

    public static char matriz[][] = new char[8][8];
    public static int contador = 0;
    public static Scanner tec = new Scanner(System.in);

    public static int recorrerTablero() {
        int contador = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] == '1') {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static void ingresarBarcos() {
        int dimensBarcos = 2;
        int ingreso = 0;
        int pos2 = 0;
        int pos1 =0;
        char pos;
        while (dimensBarcos > 0) {
            System.out.println("Ingrese las coordenadas del barco 1");
            pos = tec.next().toUpperCase().charAt(0);
            pos1=cambiarCharPorInt(pos);
            pos2 = tec.nextInt();

            if (encontrado(pos1, pos2) == false) {

                //entra en el caso de que no haya barco en esas posiciones
                matriz[pos1][pos2] = '1';

                dimensBarcos--;
                ingreso++;
            } else {
                System.out.print("Ya existe un barco en esa posicion \n");
            }
            if (ingreso > 0) {
                segPosicionBarco(pos1, pos2);
                ingreso = 0;
            }
        }
    }

    public static boolean encontrado(int pos1, int pos2) {
        if (matriz[pos1][pos2] == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static void mostrarTablero() {
        System.out.println(" --0--1--2--3--4--5--6--7--");
        char a = 'A';
        for (int i = 0; i < 8; i++) {
            if (i != 0) {
                System.out.println("||");
            }
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] == '1') {
                }
                if (j == 0) {
                    System.out.print(a);
                    a++;
                }
                System.out.print("||" + matriz[i][j]);
            }
        }
        System.out.println("||");
    }

    public static int cambiarCharPorInt(char pos1) {
       int posicion=0;
        for(char a= 'A';a<pos1;a++){
            
            
           posicion++;
            
        }
        return posicion;
    }

    public static void atacarJugador2() {
        char pos;
        int pos1;
        int pos2;
        System.out.println("Jugador 2: Ataque a su oponente:");
        pos = tec.next().toUpperCase().charAt(0);
        pos1= cambiarCharPorInt(pos);
        pos2 = tec.nextInt();
        
        if (matriz[pos1][pos2] == '1') {
            System.out.println("haz dado en el blanco");
            matriz[pos1][pos2] = 'x';
        } else if (matriz[pos1][pos2] == 0) {
            System.out.println("Erraste,seguí intentandolo");
            matriz[pos1][pos2] = '-';
        }
        mostrarTablero();
    }

    public static void segPosicionBarco(int pos1, int pos2) {
        int pos4;
        int pos3;
        char pos;
        int conta = 1;

        System.out.println("Ingrese la segunda coordenada de su barco");

        while (conta > 0) {
            pos = tec.next().toUpperCase().charAt(0);
            pos3= cambiarCharPorInt(pos);
            pos4 = tec.nextInt();
            if (encontrado(pos3, pos4) == false) {
                if (pos3 == pos1 - 1 && pos4 == pos2 || pos3 == pos1 + 1 && pos4 == pos2
                        || pos3 == pos1 && pos4 == pos2 - 1 || pos3 == pos1 && pos4 == pos2 + 1) {

                    //entra en el caso de que no haya barco en esas posiciones
                    matriz[pos3][pos4] = '1';

                    conta--;
                }

            } else {
                System.out.print("Ya existe un barco en esa posicion o ingresaste mal wachin :\n");
            }
        }

    }

    public static void main(String[] args) {

        Naval proy = new Naval();
        proy.mostrarTablero();
        proy.ingresarBarcos();
        proy.mostrarTablero();
        contador = proy.recorrerTablero();
        while (contador > 0) {

            proy.atacarJugador2();
            contador = proy.recorrerTablero();

        }
        System.out.println("HAZ PERDIDO");
    }
}
