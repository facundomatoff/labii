package BatallaNaval;


import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner scn=new Scanner(System.in);

        System.out.println("Cuantos barcos tiene su juego ?");
        int cant;
        while (true) {
            try {
                cant = scn.nextInt();
                if (cant>=1){
                    break;
                }else{
                    System.out.println("Al menos debe colocar un barco o más");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Error ingrese un numero correcto");
                scn.nextLine();
            }
        }
        scn.nextLine();
        Tablero jugador1 = new Tablero(cant);
        System.out.println("-------------------------- Posicione sus barcos ------------------------------");
        jugador1.mostrarPosiciones();
        while (cant>0) {
            System.out.println("Barco: " + cant);
            jugador1.colcarBarco();
            jugador1.mostrarPosiciones();
            cant--;
        }
        System.out.println("-------------------------- El Juego A Comenzado ------------------------------");
        jugador1.dibujarTableroJuego();
        while (!(jugador1.comprobarTablero())){
            System.out.println(jugador1.status());
            System.out.println("Ingrese las coordenadas para lanzar la bomba Formato: Letra(columna) espacio Numero(fila)");
            jugador1.lanzarMisil();

        }





    }

}

class Tablero {
    private int x;
    private int y;
    private int misiles;
    private int acertados;

    private Agua[][] posiciones;



    public Tablero(int barcos)
    {
        misiles=0;
        acertados=0;
        this.x=10;
        this.y=10;
        this.posiciones = new Agua[10][10];
        for (int x = 0; x < 10; x++) {

            for (int y = 0; y < 10; y++) {
                posiciones[x][y] = new Agua();

            }

        }
    }


    public void mostrarPosiciones(){
        System.out.println("    A B C D E F G H I J");
        for (int x=0;x<10;x++){
            if (x==9){
                System.out.print((x+1)+" ");
            } else {
                System.out.print((x+1)+"  ");
            }

            for (int y=0;y<10;y++){

                System.out.print(" "+ posiciones[y][x].getSimbolo(y,x));
            }
            System.out.println();
        }
    }

    public void dibujarTableroJuego(){
        System.out.println("    A B C D E F G H I J");
        for (int x=0;x<10;x++){
            if (x==9){
                System.out.print((x+1)+" ");
            } else {
                System.out.print((x+1)+"  ");
            }
            for (int y=0;y<10;y++){

                System.out.print(" "+ posiciones[y][x].getSimboloJuego(y,x));
            }
            System.out.println();
        }
    }

    public void colcarBarco(){
        Scanner sc = new Scanner(System.in);
        int xp=0,yp=0,xt=0,yt=0;
        boolean[] popa = new boolean[4];
        for (int i=0;i<4;i++){
            popa[i]=false;
        }
        int mov=0,opcion;
        while (mov==0) {
            String bandera;
            System.out.println("Ingrese La cordenada de la proa, Formato: Letra(Columna)  Espacio  Numero(Fila): ");
            bandera=sc.next();
            if (bandera.length()==1){
                xt = convertirLetra(bandera.charAt(0));
                if (xt==10){
                    System.out.println("Error ingreso una coordenada incorrecta");
                    sc.nextLine();
                    continue;
                }
            } else {
                System.out.println("Error ingreso una coordenada incorrecta");
                sc.nextLine();
                continue;
            }
            try {
                yt = (sc.nextInt()-1);
                if (!(yt>=0 && yt<10)) {
                    System.out.println("Error ingreso una coordenada incorrecta");
                    sc.nextLine();
                    continue;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error ingreso una coordenada incorrecta");
                sc.nextLine();
                continue;
            }


            System.out.println("Popa Seleccione coordenada:");
            if ((posiciones[xt][yt].getEstado(xt,yt).equals("Barco"))){
                System.out.println("Ya hay un barco en ese lugar");
                continue;
            }
            if (xt + 1 != 10 && !(posiciones[xt + 1][yt].getEstado(xt + 1, yt).equals("Barco"))) {
                System.out.println("1: Derecha");
                popa[0]=true;
                mov++;
            }
            if (xt - 1 != -1 && !(posiciones[xt - 1][yt].getEstado(xt - 1, yt).equals("Barco"))) {
                System.out.println("2: izquierda");
                popa[1]=true;
                mov++;
            }
            if (yt + 1 != 10 && !(posiciones[xt][yt + 1].getEstado(xt,yt + 1).equals("Barco"))) {
                System.out.println("3: abajo");
                popa[2]=true;
                mov++;
            }
            if (yt - 1 != -1 && !(posiciones[xt][yt - 1].getEstado(xt, yt - 1).equals("Barco"))) {
                System.out.println("4: arriba");
                popa[3]=true;
                mov++;
            }
            if (mov==0){
                System.out.println("No Tiene espacio para poner un barco en ese lugar");
            }
        }
        while (true){
            try {
                opcion=sc.nextInt();
                if (opcion>0 && opcion <5) {
                    if (popa[opcion - 1]) {
                        break;
                    }
                }
                System.out.println("Error, Ingrese un número dentro del rango de valores.");
            } catch (java.util.InputMismatchException e){
                System.out.println("Error, ingrese un numero");
                sc.nextLine();
            }
        }
        switch (opcion) {
            case 1:
                xp = xt + 1;
                yp = yt;
                break;
            case 2:
                xp = xt - 1;
                yp = yt;
                break;
            case 3:
                xp = xt;
                yp = yt + 1;
                break;
            case 4:
                xp = xt;
                yp = yt - 1;
                break;
        }

        Barco bc = new Barco(yt,xt,yp,xp);
        this.posiciones[xt][yt] = (Agua)bc;
        this.posiciones[xp][yp] = (Agua)bc;


    }

    public void lanzarMisil(){
        Scanner sc = new Scanner(System.in);
        int x,y;
        String bandera;
        while (true) {
            bandera = sc.next();
            if (bandera.length()==1){
                x=convertirLetra(bandera.charAt(0));
                if (x==10){
                    sc.nextLine();
                    System.out.println("Error, ingreso una coordenada incorrecta");
                    continue;
                }
            } else {
                sc.nextLine();
                System.out.println("Error, ingreso una coordenada incorrecta");
                continue;
            }
            try {
                y=sc.nextInt();
                if (!(y>0 && y<11)){
                    sc.nextLine();
                    System.out.println("Error, ingreso una coordenada incorrecta");
                    continue;
                }
            }
            catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Error, ingreso una coordenada incorrecta");
                continue;
            }

            if (posiciones[x][y-1].getSimboloJuego(x, y-1) != '~'){
                System.out.println("Ya Bombardeo ese lugar");
                continue;
            }

            posiciones[x][y-1].recibirAtaque(x, y-1);
            this.dibujarTableroJuego();
            this.misiles++;
            if (posiciones[x][y-1].getSimboloJuego(x, y-1) == '@'){
                System.out.println("Falló, le dio al agua");

            }
            if (posiciones[x][y-1].getSimboloJuego(x, y-1) == 'X'){
                System.out.println("Acertó, le dio a un barco");
                this.acertados++;

            }
            break;
        }
    }

    public String status(){
        return ("Misiles lanzados: " + misiles  + " | Acertados: " + acertados + " | Cantidad de barcos restantes: " + Barco.cant);
    }



    private int convertirLetra(char letra){
        switch (Character.toLowerCase(letra)){
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            case 'i': return 8;
            case 'j': return 9;
            default: return 10;

        }
    }


    public boolean comprobarTablero(){
        int sum=0;
        for(int x=0;x<this.x;x++){
            for (int y=0;y<this.y;y++){
                if (this.posiciones[y][x].getEstado(x,y).equals("Barco")){
                    sum++;
                }
            }
        }

        if (sum == 0){
            System.out.println("DESTRUYÓ TODOS LOS BARCOS!!!");
            System.out.println(this.status());
            return true;

        } else{
            return false;
        }

    }


}

class Agua {
    private int[] cor = {0,0};
    private String estado="Agua";
    private char simbolo = ' ';
    private char simboloJuego = ' ';

    public Agua(){
        this.simbolo = '~';
        this.simboloJuego = '~';
        this.estado="Agua";
    }

    public String getEstado(int x, int y){
        return this.estado;
    }

    public int recibirAtaque(int x,int y){
        this.estado = "Agua Fusilada";
        this.simboloJuego = '@';
        return 0;
    }

    public char getSimbolo(int x,int y){
        return simbolo;
    }

    public char getSimboloJuego(int x,int y){
        return simboloJuego;
    }



}


class Barco extends Agua {

    private int trompa[] = {0,0};
    private int popa[] = {0,0};
    static int cant;
    private int estado[] = {1,1};
    private char simbolo = '۩';
    private char[] simboloJuego = {'~','~'} ;

    public Barco(int xt,int yt,int xp, int yp){
        this.simbolo = '۩';
        this.simboloJuego[0] = '~';
        this.simboloJuego[1] = '~';
        Barco.cant++;
        this.trompa[0]=xt;
        this.trompa[1]=yt;
        this.popa[0]=xp;
        this.popa[1]=yp;

    }


    @Override
    public String getEstado(int x, int y){
        if (estado[0]==0 && estado[1]==0) return "Barco Hundido";
        if (trompa[0]==y && trompa[1]==x) {
            if (this.estado[0] == 1) {
                return "Barco";
            } else {
                return "Barco Destruido";
            }
        } else {
            if (this.estado[1] == 1) {
                return "Barco";
            } else {
                return "Barco Destruido";
            }
        }

    }

    @Override
    public int recibirAtaque(int y,int x){

        if (x==this.trompa[0] && y==this.trompa[1]){
            if (this.estado[0]==1){
                this.estado[0]=0;
                this.simboloJuego[0]='X';
                if (this.estado[1]==0){
                    Barco.cant--;
                }
                return 1;
            } else {
                return -1;
            }

        } else
        if (this.estado[1]==1){
            this.estado[1]=0;
            this.simboloJuego[1]='X';
            if (this.estado[0]==0){
                Barco.cant--;
            }
            return 1;
        } else {
            return -1;
        }



    }
    @Override
    public char getSimboloJuego(int x, int y){
        if (this.trompa[0]==y && this.trompa[1]==x){
            if (this.estado[0]==1){
                return '~';
            } else{
                return 'X';
            }

        } else{
            if (this.estado[1]==1){
                return '~';
            }
            else{
                return 'X';
            }
        }
    }

    @Override
    public char getSimbolo(int x,int y){
        return this.simbolo;
    }



}
