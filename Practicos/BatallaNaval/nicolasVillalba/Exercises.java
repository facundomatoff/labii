package org.utn.progr2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nicolas Villalba on 8/30/16.
 * Juego de Batalla Naval
 */
public class BattleShip {

    /**
     * Game id
     */
    public final int gameId = this.hashCode();
    /**
     * Para formar el tablero
     */
    private static char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    private static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    /**
     * Lleva la cuenta de los Ship's creados a nivel global
     */
    private static int shipCounter = 0;
    private static int downCounter = 0;
    private static int touchCounter = 0;

    /**
     * Todas las posibles posiciones que forman el
     * tablero
     */
    private String[] board = new String[100];
    /**
     * Para crear los string apartir arreglos de chars
     */
    private StringBuilder st = new StringBuilder();
    /**
     * Posiciones simples que controlar en arreglo
     */
    private String[] positions;
    /**
     * Objetos que controlar en el juego
     */
    private Ship[] ships;

//-------------------------------------------------------------------------------------
    public static void main(String ... arg){
        boolean p = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de embarcaciones: ");
        int np = sc.nextInt();
        BattleShip game2 = new BattleShip(np);
        System.out.println(game2.gameId);
        while (np != 0){
            game2.show();
            System.out.print("Ingresa una posicion: ");
            String guess = sc.next();
            if(game2.touch(guess)){
                System.out.println("Toque");
                System.out.println(Arrays.toString(game2.getPositions()));
            }else{
                System.out.println("Fallido");
            }
            np--;
        }

        String[] pos = game2.getPositions();
        presentationBoard(game2.allpos(), pos);

        System.out.println("Naves derrivadas" + game2.getDownShips());
        System.out.println("Naves alcanzadas" + game2.getTouchedShips());


    }
//-------------------------------------------------------------------------------------
    /**
     * Contructor de la clase que representa el juego
     * @param pos
     */
    public BattleShip(int pos){
        populate();
        setPositionsR(pos);
        this.positions = new String[0];
    }

    /**
     * Genera numeros aletorios del 0 a max
     * @param max
     * @return
     */
    public static int getRandom(int max){
        return (int) (Math.random() * max);
    }

    public String[] getPositions(){
        return this.positions;
    }

    /**
     *
     * @return
     */
    public int getDownShips(){
        return this.downCounter;
    }

    /**
     *
     * @return
     */
    public int getTouchedShips(){
        return this.touchCounter;
    }

    /**
     * Calcula todas la combinaciones que se pueden tener entre
     * las letras presentes la matriz letters y los numeros
     * en la matriz numbers en total 100 ocurencias
     */
    private void populate(){
        int c = this.board.length - 1;
        for (int i = 0; i < this.letters.length; i++) {
            for (int j = 0; j < this.numbers.length; j++){
                st.append(this.letters[i]);
                st.append(this.numbers[j]);
                this.board[c] = st.toString();
                st.setLength(0);
                c--;
            }
        }
    }

//    /**
//     * Genera posiciones aleatorias individuales y las
//     * guarda en positions
//     * @param p
//     */
//    private void setPositions(int p){
//        this.positions = new String[p];
//        for (int n = 0; n < p; n++){
//            this.positions[n] = this.board[getRandom(90)];
//        }
//    }

    /**
     * Genera objetos posiciones mediante el objeto
     * Ship que representan a las embarcaciones que
     * estan en el tablero
     * @param p
     */
    private void setPositionsR(int p){
        this.ships = new Ship[p];
        for (int n = 0; n < p; n++){
            int e = getRandom(90);
            this.ships[n] = new Ship(this.board[e]);
        }
    }

    public String[] allpos(){
        String sp =
                Arrays.stream(ships)
                        .map(Ship::toString)
                        .reduce("", (x,y)-> x + "," + y)
                ;
        sp = sp.substring(1, sp.length());
        return sp.split(",");
    }

    /**
     * Para debuguear: muestra el contenido del arrelgo
     * de Ship's
     */
    public void show(){

        System.out.println(Arrays.toString(ships) + " Cantidad Naves: " + shipCounter);
    }

//    /**
//     * Se verifica sí existe una posición dada
//     * @param g
//     * @return
//     */
//    public boolean guess(String g){
//        if(Arrays.binarySearch(this.positions, g) < 0) return false;
//        return true;
//    }

    private static String[] addPos(String[] org, String added) {
        String[] result = Arrays.copyOf(org, org.length +1);
        result[org.length] = added;
        return result;
    }

    /**
     * Se fija si hay una posición dada en alguno de
     * los objetos Ship, de ser así marca que la posicion
     * se encontro marcando el miembro con null
     * @param c
     * @return
     */
    public boolean touch(String c){
        Pattern p = Pattern.compile("^[a-j][0-9]$|^[a-j]10$");
        Matcher m = p.matcher(c);
        boolean b = m.matches();
        if(!b){
            System.out.print("¡ingreso erroneo! pero cuenta como ");
            return false;
        }

        Iterator<Ship> it = Arrays.asList(ships).iterator();
        while (it.hasNext()){
            Ship t = it.next();
            if(t.getA().compareToIgnoreCase(c) == 0){
                t.mark();
                this.positions = addPos(this.positions, c);
                return true;
            }
            if(t.getB().compareToIgnoreCase(c) == 0){
                t.mark();
                this.positions = addPos(this.positions, c);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que maneja la presentacion en pantalla del juego, muestra una grilla
     * donde marca las posiciones de la embarcaciones y los toques a las naves
     * @param pos
     * @param marks
     */
    public static void presentationBoard(String[] pos, String[] marks){

        List<String> lp = new LinkedList<>(Arrays.asList(pos));
        List<String> lm = new LinkedList<>(Arrays.asList(marks));

        String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
        String[] sa = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};

        char ch;

        for(int k = 0;k < a.length -1; k++){
//---------------------------------------------------------------------------------
            for(int i = 0;i < a.length -1; i++){
                ch = '\u256D';
                if(lp.contains(a[k] + sa[i])) ch = '\u250f';
                System.out.print(ch);
                int o = (sa[i].compareTo("10")==0)? 3 :2;
                for(int j =0; j < o; j++){
                    ch = '\u2504';
                    if(lp.contains(a[k] + sa[i])) ch = '\u2505';
                    System.out.print(ch);
                }
                if(i != a.length -1){
                    if(a[i].charAt(0) != a[i + 1].charAt(0)){
                        ch = '\u256E';
                        if(lp.contains(a[k] + sa[i])) ch = '\u2513';
                        System.out.print(ch);
                    }
                }
            }
            System.out.println("");
//---------------------------------CARACTERES--------------------------------------

            System.out.print('\u2506');
            for (int i = 0; i < sa.length; i++) {
                if(i == 0){
                    System.out.print(a[k] + sa[i]);
                }else{
                    if(lm.contains(a[k] + sa[i])){
                        System.out.print('\u25B6' + a[k] + sa[i]);
                    }else{
                        System.out.print('\u2506' + a[k] + sa[i]);
                    }

                }
                if(k != a.length - 1){
                    if(a[k].charAt(0) != a[k + 1].charAt(0)){
                        if(lm.contains(a[k] + sa[i])){
                            System.out.print('\u25C0');
                        }else{
                            System.out.print('\u2506');
                        }
                    }
                }
                if(i == 9)System.out.println("");
            }
            for(int w = 0;w < a.length -1; w++){
                ch =  '\u2570';
                if(lp.contains(a[k] + sa[w])) ch = '\u2517';
                System.out.print(ch);
                int  o = (sa[w].compareTo("10")==0)? 3 :2;
                for(int j =0; j < o; j++){
                    ch =  '\u2504';
                    if(lp.contains(a[k] + sa[w])) ch = '\u2505';
                    System.out.print(ch);
                }
                if(w != a.length -2){
                    ch =  '\u256F';
                    if(lp.contains(a[k] + sa[w])) ch = '\u251B';
                    if(a[w].charAt(0) != a[w + 1].charAt(0)){
                        System.out.print(ch);
                    }
                }
            }
            //-------
            System.out.print('\u256F');
            System.out.println("");
        }
    }

//---------------------------Ship Object-------------------------------------
    /**
     * Clase interna para representar las embarcaciones
     * de dos tipos buque(dos casilleros) y bote(un solo
     * casillero)
     */
    private class Ship{
        private int shipId;
        private String a;
        private String b;
        private int helth = 2;
        private boolean down = false;

        public Ship(String a){
            this.a = a;
            setB();
            shipId = shipCounter++;
        }

        private void setB(){
            if(getRandom(1000) % 2 == 0){
                int k = Character.getNumericValue(this.a.charAt(1));
                if(k == 10 || k >= 5) k = k - 1;
                if(k < 5 || k ==1) k = k + 1;
                st.append(this.a.charAt(0));
                st.append(k);
                this.b = st.toString();
                st.setLength(0);
            }else {
                int k = Arrays.binarySearch(letters, this.a.charAt(0));
                if(k == 10 || k >= 5) k = k - 1;
                if(k < 5 || k ==1) k = k + 1;
                st.append(letters[k]);
                st.append(this.a.charAt(1));
                this.b = st.toString();
                st.setLength(0);
            }
        }

        public void mark(){
            if(helth != 0){
                helth --;
            }else {
                this.down = true;
                downCounter++;
            }
        }
        public String getA(){

            return this.a;
        }

        public String getB(){

            return this.b;
        }

        public int getId(){

            return this.shipId;
        }

        public String[] pos(){
            String[] r = {getA(), getB()};
            return  r;
        }

        public String toString(){
            //return getA() + "-" + getB() + "/id:" + getId();
            return getA() + "," + getB();

        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BattleShip that = (BattleShip) o;

        if (gameId != that.gameId) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(board, that.board)) return false;
        if (st != null ? !st.equals(that.st) : that.st != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(positions, that.positions)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(ships, that.ships);

    }

    @Override
    public int hashCode() {
        int result = getRandom(44);
        result = 31 * result + Arrays.hashCode(board);
        result = 31 * result + (st != null ? st.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(positions);
        result = 31 * result + Arrays.hashCode(ships);
        return result;
    }
}