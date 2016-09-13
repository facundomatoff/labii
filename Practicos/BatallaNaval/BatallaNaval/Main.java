import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 * Created by romina brutti on 20/08/16.
 */

public class Main {

    private static int n;
    private static int m=10;
    private static int tablero[][];
    private static String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String linea = System.getProperty("line.separator");

    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);

        int controlBarcos[];
        int contBarcos;
        int cont = 0;
        int contInverso;
        int posI1=0,posI2=0,posJ1=0,posJ2=0;
        int termina=1;
        boolean error=true;


        do{

            System.out.println("Ingrese cantidad de barcos. (Entre 3 y 10)");
            n = sc.nextInt();

        }while(n<3 || n>10);

        tablero = new int[m][m];             //asigna tamaño del tablero de acuerdo a la cantidad de barcos elegida
        controlBarcos = new int[n+1];        //arreglo q lleva el control de barcos encontrados
        contBarcos = 1;                     //cuenta el nro de cada barco
        contInverso = n;                       //cuenta el numero de barcos restantes

        imprimirTablero();

        System.out.println("INICIA LA CARGA DE NAVES."+linea);

        for (int i = 0; i < n; i++) {

            System.out.println("Nave N° "+(i+1));

            do {
                do {
                    if (posI1 >= m || posJ1 >= m || posI1 < 0) System.out.println("No existe coordenada.");
                    System.out.println("Ingrese 1° coordenada del barco (Letra Nro): ");
                    posJ1 = abc.indexOf(toUpperCase(sc.next()));
                    posI1 = sc.nextInt() - 1;

                } while (posI1 >= m || posJ1 >= m || posI1 < 0);

                if(tablero[posI1][posJ1]!=0) System.out.println("Coordenada ocupada!!");           //unicamente se puede asigar si es = 0 (agua)

            }while(tablero[posI1][posJ1]!=0);

            tablero[posI1][posJ1] = contBarcos;                     //cada barco se representa en el tablero de acuerdo
                                                                    //a un numero
            do {
                do {

                    if (posI2 >= m || posJ2 >= m || posI2 < 0) System.out.println("No existe coordenada.");
                    System.out.println("Ingrese 2° coordenada del barco (Nro Letra): ");
                    posJ2 = abc.indexOf(toUpperCase(sc.next()));
                    posI2 = sc.nextInt() - 1;

                } while (posI2 >= m || posJ2 >= m || posI2 < 0);

                if(tablero[posI2][posJ2]!=0) System.out.println("Coordenada ocupada!!");
                else {

                    if (posI1 != posI2 && posJ1 != posJ2) {
                        System.out.println("La 2° coordenada no puede estar tan alejada de la 1°.");
                        error = true;
                    } else error = false;
                    if (posI1 == posI2) {
                        if (Math.abs(posJ1 - posJ2) != 1) {
                            System.out.println("La 2° coordenada no puede estar tan alejada de la 1°.");
                            error = true;
                        } else error = false;
                    } else if (posJ1 == posJ2) {
                        if (Math.abs(posI1 - posI2) != 1) {
                            System.out.println("La 2° coordenada no puede estar tan alejada de la 1°.");
                            error = true;
                        } else error = false;
                    }
                }

            }while(tablero[posI2][posJ2]!=0||error);

            tablero[posI2][posJ2] = contBarcos;

            controlBarcos[contBarcos]=1;
            contBarcos++;

            imprimirTablero();

        }


        System.out.println("INICIA EL JUEGO!"+linea);

        do {

            do{

                if (posI1 >= m || posJ1 >= m || posI1 < 0) System.out.println("No existe coordenada.");
                System.out.println("Ingrese coordenada a hundir: (Letra Nro)");
                posJ1 = abc.indexOf(toUpperCase(sc.next()));
                posI1 = sc.nextInt() - 1;

            }while (posI1 >= m || posJ1 >= m || posI1 < 0);

            if(tablero[posI1][posJ1]==0) {
                System.out.println("AGUA!!");
                tablero[posI1][posJ1]=-2;
            }else
                if(tablero[posI1][posJ1]==-1 || tablero[posI1][posJ1]==-2) System.out.println("Coordenada anteriormente seleccionada.");
            else {
                    int n = tablero[posI1][posJ1];
                    if(controlBarcos[n]==0){
                        contInverso--;
                        System.out.println("Nave N°"+n+": HUNDIDA!!!");
                        if(contInverso==1){
                            System.out.println("Queda: "+contInverso+" nave.");
                        }else if(contInverso!=0){
                            System.out.println("Quedan: "+contInverso+" naves.");
                        }
                        cont++;

                    }else{
                        System.out.println("Nave N°"+n+": Encontrada!");
                        controlBarcos[n]--;
                    }
                    tablero[posI1][posJ1]=-1;
                }

            imprimirTablero();


            do {

                if (termina != 1 && termina!=-1) System.out.println("Valor inválido.");
                if(cont<n) {
                    System.out.println("Seguir 1 / Parar -1");
                    termina=sc.nextInt();
                }

            }while(termina!=1 && termina!=-1);

        }while(termina==1 && cont<n);


        if (cont == n) System.out.println("FIN DEL JUEGO.");
        if (termina == -1) System.out.println("Juego Cancelado.");

    }

    public static void imprimirTablero(){
        System.out.print(linea+"   |");
        for (int i = 0; i < m; i++) {
            System.out.print(" "+abc.charAt(i)+" |");
        }

        System.out.println(" ");

        for (int i = 0; i < m ; i++) {

            if(i<9) System.out.print(" "+(i+1)+" |");
            else System.out.print((i+1)+" |");

            for (int j = 0; j < m; j++) {
                if(tablero[i][j]>0) System.out.print(" O |");
                else if(tablero[i][j]==0) System.out.print(" ~ |");
                else if(tablero[i][j]==-1) System.out.print(" X |");
                else if(tablero[i][j]==-2) System.out.print(" ° |");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
