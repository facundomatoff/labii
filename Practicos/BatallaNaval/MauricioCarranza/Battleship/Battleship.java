/**
 * Created by Contrarian on 08/09/2016.
 */
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int cantidad,i,j,y,b,ganador=0,z=0,error=0;
        char x,a;

        System.out.println("Ingrese la cantidad de naves:");
        cantidad=(sc.nextInt());

        //Inicializo el tablero y las naves
        int[][] tablero = new int['J'][10];
        Ship[] Shipyard = new Ship[cantidad];

        for (i=0;i<cantidad;i++){
            Shipyard[i]=new Ship();
        }

        //Tablero de la A a la J y del 1 al 10. Se deben introducir las coordenadas con un espacio, y la letra en mayuscula
        System.out.println("Tablero de tamaño 10x10. Formato de ingreso: 'A 1')");

        System.out.println("Ingrese sus naves");
        for(i=0;i<(cantidad);i++){
            do {
                do {
                    System.out.println("Ingrese la primera coordenada de la nave numero " + (i + 1));
                    x = sc.next().charAt(0);
                    y = sc.nextInt();
                    if ((x<'A') || (x>'J') || (y < 1) || (y > 10)) {
                        System.out.println("Coordenadas fuera de rango, intente de nuevo");
                        error = 1;
                    } else error = 0;
                    for (j=0;j<cantidad;j++) {
                        if (((Shipyard[j].getCorX() == x) && (Shipyard[j].getCorY() == y)) || ((Shipyard[j].getCorA() == x) && (Shipyard[j].getCorB() == y))) {
                            System.out.println("ERROR: Espacio ocupado, intente de nuevo");
                            error = 1;
                        }
                    }
                } while (error == 1);
                do {
                    System.out.println("Ingrese la segunda coordenada de la nave numero " + (i + 1));
                    a = sc.next().charAt(0);
                    b = sc.nextInt();
                    if ((a<'A') || (a>'J') || (b < 1) || (b > 10)) {
                        System.out.println("ERROR: Coordenadas fuera de rango, intente de nuevo");
                        error = 1;
                    } else error = 0;
                } while (error == 1);
                for (j=0;j<cantidad;j++) {
                    if (((Shipyard[j].getCorX() == a) && (Shipyard[j].getCorY() == b)) || ((Shipyard[j].getCorA() == a) && (Shipyard[j].getCorB() == b))) {
                        System.out.println("ERROR: Espacio ocupado, intente de nuevo");
                        error = 1;
                    }
                }
                if (((((x == a + 1) || (x == a - 1)) && (y == b)) || (((y == b + 1) || (y == b - 1)) && (x == a)))&&error==0) {
                    //Si no hay errores, se graban las coordenadas de la nave
                    Shipyard[i].setCorA(a);
                    Shipyard[i].setCorB(b);
                    Shipyard[i].setCorX(x);
                    Shipyard[i].setCorY(y);
                    error = 0;
                } else if (error==0) {
                    error = 1;
                    System.out.println("ERROR: Nave separada, intente de nuevo");
                }

            }while(error==1);
        }

        while(ganador==0){
            do {
                do {
                    System.out.println("Ingrese coordenadas a atacar:");
                    x = sc.next().charAt(0);
                    y = sc.nextInt();
                    if ((x<'A') || (x>'J') || (y < 1) || (y > 10)) {
                        System.out.println("ERROR: Coordenadas fuera de rango, intente de nuevo");
                        error = 1;
                    } else error = 0;
                }while(error==1);
                if (tablero[x-1][y-1]==0){
                    tablero[x-1][y-1]=1;
                    error=0;
                } else if(tablero[x-1][y-1]==1) {
                    System.out.println("ERROR: Ya ha disparado al agua en esa celda, intente de nuevo");
                    error=1;
                }else{
                    System.out.println("ERROR: Ya ha disparado a la nave en esa celda, intente de nuevo");
                    error=1;
                }
            }while(error==1);
            for(i=0;i<cantidad;i++){
                if (((Shipyard[i].getCorX()==x)&&(Shipyard[i].getCorY()==y))||((Shipyard[i].getCorA()==x)&&(Shipyard[i].getCorB()==y))){
                    Shipyard[i].hundir();
                    z=1;
                    tablero[x-1][y-1]=2;
                }
            }
            if (z==1)System.out.println("Disparo acertado");
                else System.out.println("Disparo fallido");
            z=0;

            //Si no quedan naves sin hundir, el juego termina
            ganador=1;
            for(i=0;i<cantidad;i++){
                if ((!(Shipyard[i].getEstado().equals("Hundido")))){
                    ganador = 0;
                }
            }

            if(ganador!=1) {
                System.out.println("Desea continuar jugando? Y/N");
                do {
                    if (sc.next().charAt(0) == 'N') {
                        error = 0;
                        ganador = -1;
                    } else if (sc.next().charAt(0) == 'Y') {
                        error = 0;
                    } else {
                        error = 1;
                        System.out.println("ERROR: Caracter incorrecto, intente de nuevo");
                    }
                } while (error == 1);
            }
        }
        if (ganador==1) {
            System.out.println("VICTORY");
        } else System.out.println("GAME OVER");
    }
}
