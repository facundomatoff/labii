package batalla;

import batalla.clases.Block;
import batalla.clases.Estaticas;
import batalla.clases.Nave;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by Usuario1 on 19/08/2016.
 */
public class BatallaMain {

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String a = null;
        int b = 0;
        String c = null;
        int d = 0;
        int y = 0;
        int control = 0;
        int NJ = 0;
        int cn;
        int dim;
        while(true){
            System.out.print("Ingrese la cantidad de naves que tendrá cada jugador: ");
            cn = sc.nextInt();
            System.out.print("Ingrese dimensión de Grilla: ");
            dim = sc.nextInt();
            if ((float)(cn*2)/(float)(dim*dim)<= 0.40){
                break;
            }else{
                System.err.println("Hay hacinamiento de naves. Reduzca la cantidad o agrande la grilla");
            }
        }
        Nave[] naves = new Nave[cn];
        Nave[] navesUno = new Nave[cn];
        Nave[] navesDos = new Nave[cn];
        Block block1 = null;
        Block block2 = null;

        while (NJ < 2) {
            System.out.println("Navegante : " + (NJ + 1));
            while (y < cn) {                                         //  Inicia la carga de datos de las naves
                System.out.println("Ingrese datos de la Nave " + (y + 1));
                if (control == 0) {
                    System.out.println("\tPrimer Block"); // Ingreso coordenadas del primer Block de la nave.
                    System.out.print("\t\tIngrese la columna: ");
                    a = sc.next();
                    a = a.toUpperCase();
                    System.out.print("\t\tIngrese la fila: ");
                    b = sc.nextInt();
                    /*
                            Verifico que el block ingresado no sea el mismo de otra nave
                     */
                    if (y > 0) {
                        boolean verigual = false;
                        if (NJ == 0) {
                            naves = navesUno;
                        } else {
                            naves = navesDos;
                        }
                        verigual = Estaticas.controlaIngresoRepetido(1, y, a, b, naves);
                        if (verigual) {
                            System.out.println("Este Block ya está asignado en una nave ");
                            control = 0;
                            continue;
                        }
                    }
                    System.out.println(y + " " + NJ);
                    /*
                            Fin de la verificación
                     */
                    boolean t = Estaticas.armaBlockUno(dim, a, b);
                    if (t) {
                        block1 = new Block(a.toUpperCase(), b);
                    } else {
                        System.out.println("\n         ATENCION!!  Ingresó datos fuera del rango.");
                        control = 0;
                        continue;
                    }
                }
                System.out.println("\tSegundo Block"); // Ingreso coordenadas del segundo Block de la nave.
                System.out.print("\t\tIngrese la columna: ");
                c = sc.next();
                c = c.toUpperCase();
                System.out.print("\t\tIngrese la fila: ");
                d = sc.nextInt();
             /*
                        Verifico que el block ingresado no sea el mismo de otra nave
             */
                if (y > 0) {
                    boolean verigual = false;
                    if (NJ == 0) {
                        naves = navesUno;
                    } else {
                        naves = navesDos;
                    }
                    verigual = Estaticas.controlaIngresoRepetido(2, y, c, d, naves);
                    if (verigual) {
                        System.out.println("Este Block ya está asignado en una nave ");
                        control = 1;
                        continue;
                    }

                    /*
                                Fin de la verificación
                    */
                }
                boolean t = Estaticas.armaBlockDos(dim, c, d, a, b);
                if (t) {
                    block2 = new Block(c.toUpperCase(), d);
                } else {
                    System.out.println("\n         ATENCION!!  Ingresó datos fuera del rango.");
                    control = 1;
                    continue;
                }
                Nave nave = new Nave(block1, block2, 1, 1);      //   Carga los dos Blocks a las naves
                if (NJ == 0) {
                    navesUno[y] = nave;
                    y++;
                    control = 0;
                } else {
                    navesDos[y] = nave;
                    y++;
                    control = 0;
                }
            }

            y = 0;
            NJ++;
        }

        System.out.println("\n");
        int i = 0;
        for (Nave e : navesUno) {
            i++;
            System.out.println(" Nave N. " + i + " :" + e);
        }


        System.out.println("\n");
        int f = 0;
        for (Nave e : navesDos) {
            f++;
            System.out.println(" Nave N. " + f + " :" + e);
        }

        /*
        ===============================================================
        ==================  COMIENZA EL COMBATE  ============================
        ===============================================================
         */
        System.out.println("\n-- NAVES EN POSICIÓN Y LISTAS PARA ENTRAR EN COMBATE --");

        int p = 0;
        int jug=0;
        String Col = null;                            // columna del disparo
        int Fil = 0;                                      // fila del disparo
        int[] NFCJ1 = new int[cn];                   // arregloS que almacenaN las naves fuera de combate
        int[] NFCJ2 = new int[cn];                      // de cada jugador
        int disparo=1;

        while (p == 0) {
                System.out.print("JUGADOR "+Estaticas.ContrDisparo(disparo)+" - Ingresa posición del disparo (' E 5 '): ");
                while (true) {                        // hago una validación del número de fila
                    try {
                        System.out.print(" > ");
                        Col = sc.next();
                        Fil = sc.nextInt();
                        break;
                    } catch (InputMismatchException ex) {
                        System.err.println("Debe ingresar una letra y un número!");
                    }

                }
                if (Col.equalsIgnoreCase("0") || Fil == 0) {       // corto el juego con una bandera
                    p = 1;
                    int r = 0;
                    int estnav=1;
                    while(estnav<3){
                        if (estnav%2==0){
                            naves=navesDos;
                        }
                        else{
                            naves=navesUno;
                        }
                        System.out.println("\n\t Datos del JUGADOR "+estnav+":");
                        for (Nave e : naves) {                               // muestro el estado en que quedaron las naves
                            r++;
                            if (e.getD1() == 0 && e.getD2() == 0) {
                                System.out.println(" Nave N. " + r + " :" + e + " Nave Destruida");
                            }
                            if ((e.getD1() == 0 && e.getD2() == 1) || (e.getD1() == 1 && e.getD2() == 0)) {
                                System.out.println(" Nave N. " + r + " :" + e + " Nave Averiada");
                            }
                            if (e.getD1() == 1 && e.getD2() == 1) {
                                System.out.println(" Nave N. " + r + " :" + e + " Nave aún en combate");
                            }
                        }
                        r=0;
                        estnav++;
                    }

                    break;
                }
                boolean t = Estaticas.armaBlockUno(dim, Col, Fil);      // validacion del disparo dentro de la grilla
                if (t) {                                                // verifica quien hizo el disparo
                    if (disparo%2==0){                           //el disparo lo hizo el jugador 2
                        naves=navesUno;
                        jug=1;
                    }else{                                      //el disparo lo hizo el jugador 1
                        naves=navesDos;
                        jug=2;
                    }
                    Block otro = new Block(Col.toUpperCase(), Fil);     // comienza a comparar la ubicación del disparo
                                                                        // con los block 1 de la nave
                    Block nav = new Block();
                    for (int j = 0; j < cn; j++) {
                        nav = naves[j].getDim1();
                        if (otro.equals(nav)) {
                            if (naves[j].getD1() == 1) {
                                System.err.println("\tATENCION! Nave " + (j + 1) + " - Jugador "+jug+": averiada !!");
                                naves[j].setD1(0);
                            } else {
                                System.out.println("\tEste disparo ya se ha hecho - Pierde el turno\n");
                            }
                        }
                        nav = naves[j].getDim2();     // comienza a comparar la ubicación del disparo
                                                      // con los block 2 de la nave
                        if (otro.equals(nav)) {
                            if (naves[j].getD2() == 1) {
                                System.err.println("\tATENCION! Nave " + (j + 1) + " - Jugador "+jug+": averiada !!");
                                naves[j].setD2(0);
                            } else {
                                System.out.println("\tEste disparo ya se ha hecho. Pierde el turno\n");
                            }
                        }
                        if ((naves[j].getD1() == 0) && (naves[j].getD2() == 0)) {  // verifica si la nave está destruida
                            if (disparo%2==0){
                                int tt = 0;
                                if (NFCJ1[j] == 0) {                               //  Si el contenido de la celda es cero significa que la nave aún no estaba fuera de combate
                                    System.out.println("Nave " + (j + 1) + " Nave Fuera de Combate !!");  //  entonces avisa que ha quedado destruida
                                    NFCJ1[j] = j + 1;                              // y almacena un valor != 0 en la celda
                                    for (int k = 0; k < cn; k++) {                 // analiza la cantidad de naves destruidas
                                        if (NFCJ1[k] != 0) {                       // si el valor es = cero la nave aun está averiada o entera; sino se cuenta un valor más en tt
                                            tt++;
                                        }
                                    }
                                    if (tt == cn) {
                                        System.out.println("\n\t\t=======  VENCEDOR:  JUGADOR  2  =======");
                                        System.out.println("El juego ha finalizado - Todas las naves del jugador 1 fuera de combate.");
                                        p = 1;
                                        break;
                                    }
                                }
                            }else{
                                int tt = 0;
                                if (NFCJ2[j] == 0) {                                 //  Si el contenido de la celda es cero significa que la nave aún no estaba fuera de combate
                                    System.out.println("Nave " + (j + 1) + " Nave Fuera de Combate !!");  //  entonces avisa que ha quedado destruida
                                    NFCJ2[j] = j + 1;                                // y almacena un valor != 0 en la celda
                                    for (int k = 0; k < cn; k++) {                   // analiza la cantidad de naves destruidas
                                        if (NFCJ2[k] != 0) {                         // si el valor es = cero la nave aun está averiada o entera; sino se cuenta un valor más en tt
                                            tt++;
                                        }
                                    }
                                    if (tt == cn) {
                                        System.out.println("\n\t\t=======  VENCEDOR:  JUGADOR  1  =======");
                                        System.out.println("El juego ha finalizado - Todas las naves del jugador 2 fuera de combate.");
                                        p = 1;
                                        break;
                                    }
                                }
                            }




                        }
                    }
                } else {
                    System.out.println("\n       Ha disparado fuera de la grilla de batalla.");
                }
            disparo++;
        }

        String[] cabecera = new String[dim];
        cabecera = Estaticas.armacabecera(dim);
        for (int j = 0; j < dim; j++) {
            System.out.print("\t" + cabecera[j]);
        }

        for (int j = 0; j < dim; j++) {
            for (int k = 0; k < dim; k++) {

            }

        }


    }
}
