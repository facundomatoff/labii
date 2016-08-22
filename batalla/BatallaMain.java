package batalla;

import batalla.clases.Block;
import batalla.clases.Estaticas;
import batalla.clases.Nave;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Usuario1 on 19/08/2016.
 *
 * se deben crear 3 (tres) naves por cada usuario
 * el campo de batalla tiene N filas y N columnas
 * cada fila se identifica con números de 1 al  N
 * cada columna se identifica con letras mayúsculas o minúsculas
 *
 * cada nave se forma por dos celdas adyacentes o Block , en Horizontal o Vertical - en diagonal NO
 * cada celda (Block) se identifica por (letra, número)
 *
 *
 * Está previsto el ingreso erroneo del  del Primer Block solo si se encuentra fuera de la grilla,
 * por lo que volverá a pedir los datos. Para el segundo Block,  si se ingresa en diagonal
 * respecto del primero, o un block que no sea adyacente , o fuera de la grilla vuelve a pedir
 *los datos del mismo.
 *
 * Ejemplo de ingreso y salida de los datos.
 *
 * Ingrese dimensión de Grilla: 7
 *
    Ingrese datos de la Nave 1
        Primer Block
             Ingrese la columna: g
             Ingrese la fila: 1
        Segundo Block
             Ingrese la columna: g
             Ingrese la fila: 2

    Ingrese datos de la Nave 2
        Primer Block
             Ingrese la columna: b
             Ingrese la fila: 3
        Segundo Block
             Ingrese la columna: b
             Ingrese la fila: 4

     Ingrese datos de la Nave 3
        Primer Block
             Ingrese la columna: a
             Ingrese la fila: 7
        Segundo Block
             Ingrese la columna: b
             Ingrese la fila: 7


   Nave N. 1 :((g 1) (g 2))
   Nave N. 2 : ((b 3) (b 4))
   Nave N. 3 :((a 7) (b 7))

 *
 */
public class BatallaMain {

    public static void main(String[]args){

       Scanner sc=new Scanner(System.in);

        String a = null;
        int b=0;
        String c=null;
        int d=0;
        int y=0;
        int control=0;
        Nave[] naves = new Nave[3];


       System.out.print("Ingrese dimensión de Grilla: ");
       int dim=sc.nextInt();
        Block block1 = null;
        Block block2=null;

        while (y <3 ) {                                         //  Inicia la carga de datos de las naves
            System.out.println("Ingrese datos de la Nave " + (y + 1));

            if (control==0) {
                System.out.println("\tPrimer Block"); // Ingreso coordenadas del primer Block de la nave.
                System.out.print("\t\tIngrese la columna: ");
                a = sc.next();
                System.out.print("\t\tIngrese la fila: ");
                b = sc.nextInt();

                boolean t = Estaticas.armaBlockUno(dim, a, b);

                if (t) {

                    block1 = new Block(a.toUpperCase(), b);
                }

                else {
                    System.out.println("\n         ATENCION!!  Ingresó datos fuera del rango.");
                    control = 0;
                    continue;
                }
            }

            System.out.println("\tSegundo Block"); // Ingreso coordenadas del segundo Block de la nave.
            System.out.print("\t\tIngrese la columna: ");
            c = sc.next();
            System.out.print("\t\tIngrese la fila: ");
            d = sc.nextInt();

                boolean t = Estaticas.armaBlockDos(dim, c, d, a, b);

                if (t) {

                    block2 = new Block(c.toUpperCase(), d);
                } else {
                    System.out.println("\n         ATENCION!!  Ingresó datos fuera del rango.");
                    control = 1;
                    continue;
                }

            Nave nave=new Nave(block1,block2,1,1);      //   Carga los dos Blocks a las naves
            naves[y]=nave;
            y++;
            control=0;
        }
        System.out.println("\n");

        int i=0;
        for (Nave e:naves ) {
            i++;
            System.out.println(" Nave N. "+i+" :"+e);
        }

        /*
        ===============================================================
        ==================  COMIENZA EL COMBATE  ============================
        ===============================================================
         */

        System.out.println("\n-- NAVES EN POSICIÓN Y LISTAS PARA ENTRAR EN COMBATE --");

        int p=0;
        String Col=null;                            // columna del disparo
        int Fil=0;                                      // fila del disparo
        int[] NFC=new int[3];                   // arreglo que almacena las naves fuera de combate

        while (p==0){
            System.out.print("Ingresar posición del disparo (' E 5 '): ");

            while(true){                        // hago una validación del número de fila
                try{
                    System.out.print(" > ");
                    Col=sc.next();
                    Fil=sc.nextInt();
                    break;
                } catch(InputMismatchException ex){
                    System.err.println("Debe ingresar una letra y un número!");
                }

            }

             if (Col.equalsIgnoreCase("0") || Fil==0){       // corto el juego con una bandera

                p=1;

                int r=0;

                for (Nave e:naves ) {                               // muestro el estado en que quedaron las naves
                    r++;
                    if(e.getD1()==0 && e.getD2()==0){
                        System.out.println(" Nave N. " + r + " :" + e +" Nave Destruida");
                    }
                    if((e.getD1()==0 && e.getD2()==1)||(e.getD1()==1 && e.getD2()==0)){
                        System.out.println(" Nave N. " + r + " :" + e +" Nave Averiada");
                    }
                    if(e.getD1()==1 && e.getD2()==1){
                        System.out.println(" Nave N. " + r + " :" + e +" Nave aún en combate");
                    }
                }

                break;
            }

            boolean t = Estaticas.armaBlockUno(dim, Col, Fil);      // validacion del disparo dentro de la grilla

            if (t) {

                 Block otro = new Block(Col.toUpperCase(),Fil);     // comienza a comparar la ubicación del disparo
                                                                                         // con los block 1 de la nave
                Block nav= new Block();

                for (int j = 0; j <3 ; j++) {

                    nav=naves[j].getDim1();

                    if (otro.equals(nav)) {

                        if (naves[j].getD1() == 1) {

                            System.out.println("Nave " + (j + 1) + " averiada !!");

                            naves[j].setD1(0);

                        }else{

                            System.out.println("Este disparo ya se ha hecho");
                        }
                    }

                    nav=naves[j].getDim2();     // comienza a comparar la ubicación del disparo
                                                             // con los block 2 de la nave
                    if (otro.equals(nav)){

                        if (naves[j].getD2() == 1) {

                            System.out.println("Nave "+(j+1)+" averiada !!");

                            naves[j].setD2(0);

                        }else{

                            System.out.println("Este disparo ya se ha hecho");
                        }

                    }

                    if ((naves[j].getD1()==0) && (naves[j].getD2()==0)){  // verifica si la nave está destruida

                        int tt=0;

                        if (NFC[j]==0){                         //  Si el contenido de la celda es cero significa que la nave aún no estaba fuera de combate

                            System.out.println("Nave "+(j+1)+" Nave Fuera de Combate !!");  //  entonces avisa que ha quedado destruida

                            NFC[j]=j+1;                         // y almacena un valor != 0 en la celda

                            for (int k = 0; k < 3; k++) {   // analiza la cantidad de naves destruidas

                                if(NFC[k]!=0){                  // si el valor es = cero la nave aun está averiada o entera; sino scuenta un valor más en tt

                                    tt++;
                                }
                            }

                            if (tt==3){

                                System.out.print("El juego ha finalizado - Tres Naves fuera de combate.");

                                p=1;

                                break;
                            }
                        }

                    }

                }
            }

            else {

                System.out.println("\n       Ha disparado fuera de la grilla de batalla.");

            }

        }

    }

}
