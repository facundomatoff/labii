package pracProgII.Batalla;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BatallaMain {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String a = null;
        int b=0;
        String c=null;
        int d=0;
        int y=0;
        int control=0;
        System.out.print("Ingrese la cantidad de naves: ");
        int cn=sc.nextInt();
        Nave[] naves = new Nave[cn];

        System.out.print("Ingrese dimensión de Grilla: ");
        int dim=sc.nextInt();
        Block block1 = null;
        Block block2=null;

        while (y <cn ) {                                         //  Inicia la carga de datos de las naves
            System.out.println("Ingrese datos de la Nave " + (y + 1));
            if (control==0) {
                System.out.println("\tPrimer Block"); // Ingreso coordenadas del primer Block de la nave.
                System.out.print("\t\tIngrese la columna: ");
                a = sc.next(); a=a.toUpperCase();
                System.out.print("\t\tIngrese la fila: ");
                b = sc.nextInt();
                    /*
                            Verifico que el block ingresado no sea el mismo de otra nave
                     */
                if (y>0){
                    boolean verigual = false;
                    verigual = Estaticas.controlaIngresoRepetido(y,a,b,naves);
                    if (verigual){
                        System.out.println("Este Block ya está asignado en una nave ");
                        control = 0;
                        continue;
                    }
                }
                    /*
                            Fin de la verificación
                     */
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
            c = sc.next();c=c.toUpperCase();
            System.out.print("\t\tIngrese la fila: ");
            d = sc.nextInt();
             /*
                        Verifico que el block ingresado no sea el mismo de otra nave
             */
            if (y>0){
                boolean verigual=false;
                verigual = Estaticas.controlaIngresoRepetido(y,c,d,naves);
                if (verigual){
                    System.out.println("Este Block ya está asignado en una nave ");
                    control = 1;
                    continue;
                }
            }
                    /*
                                Fin de la verificación
                    */
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
        int[] NFC=new int[cn];                   // arreglo que almacena las naves fuera de combate

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
                for (int j = 0; j <cn ; j++) {
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
                            for (int k = 0; k < cn; k++) {   // analiza la cantidad de naves destruidas
                                if(NFC[k]!=0){                  // si el valor es = cero la nave aun está averiada o entera; sino scuenta un valor más en tt
                                    tt++;
                                }
                            }
                            if (tt==cn){
                                System.out.print("El juego ha finalizado - Todas las naves fuera de combate.");
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
//============================================   BLOKES   ================================================================
class Block {
    private String dimB1;
    private int dimB2;

    public Block(String dimB1, int dimB2) {
        this.dimB1 = dimB1;
        this.dimB2 = dimB2;
    }

    public Block() {
    }

    public String getDimB1() {
        return dimB1;
    }

    public int getDimB2() {
        return dimB2;
    }

    @Override
    public String toString() {
        return "("
                + dimB1 + " "
                + dimB2 +
                ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Block) {
            Block otro = (Block) obj;
            if (this.getDimB1().equals(otro.getDimB1()) && this.getDimB2() == otro.getDimB2()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
//==========================================   NAVES   =================================================================
    class Nave {
private Block dim1;
private Block dim2;
private int d1;
private int d2;

public Nave(Block dim1, Block dim2, int d1, int d2){
        this.dim1=dim1;
        this.dim2=dim2;
        this.d1=d1;
        this.d2=d2;
        }
public Block getDim1() {
        return dim1;
        }
public Block getDim2() {
        return dim2;
        }
public int getD1() {
        return d1;
        }
public int getD2() {
        return d2;
        }
public void setD1(int d1) {
        this.d1 = d1;
        }
public void setD2(int d2) {
        this.d2 = d2;
        }

@Override
public String toString() {
        return "("
        + dim1 + ' '
        +dim2 +
        ") - "+ d1+ " - "+ d2;
        }
        }
//================   ESTATICAS   ===================================================================================
class Estaticas {
    public static String[] armacabecera(int n) {
        String[] abcdario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] cabecera = new String[n];
        for (int i = 0; i < n; i++) {
            cabecera[i] = abcdario[i];
        }
        return cabecera;
    }
    public static boolean controlaIngresoRepetido(int n, String d1, int d2, Nave[] nn){
        for (int i = (n-1); i >=0 ; i--) {
            Block bnew = new Block(d1,d2);
            Block b1=new Block();Block b2=new Block();
            b1=nn[i].getDim1(); b2=nn[i].getDim2();
            if (bnew.equals(b1)||bnew.equals(b2)){
                System.out.println(n + " "+ b1 + " "+b2);
                return true;
            }
        }
        return false;
    }


    public static boolean controlaIngRepetidos(Block n, Block b1, Block b2){
        if (n.equals(b1)||n.equals(b2)){
            System.out.println(n + " "+ b1 + " "+b2);
            return true;
        }
        return false;
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