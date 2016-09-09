package org.utn.progr2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    private List<Ship> list;
    /**
     * Lleva la cuenta de los Ship's creados a nivel global
     */
    private static int shipCounter = 0;
    private int downCounter = 0;
    private int touchCounter = 0;

    /**
     * Todas las posibles posiciones que forman el
     * tablero
     */
    private String[] board = new String[100];
    private List<String> lb = new LinkedList<String>();
    private List<String> used = new LinkedList<String>();
    /**
     * Para crear los string apartir arreglos de chars
     */
    private StringBuilder st = new StringBuilder();
    /**
     * Posiciones acertadas
     */
    private String[] positions;
    /**
     * Objetos que controlar en el juego
     */
    private String[] shots;

//-------------------------------------------------------------------------------------
    public static void main(String ... arg){
        boolean finish = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Con cuantas embarcaciones quiere jugar: ");
        int np = sc.nextInt();
        int np2 = np;
        BattleShip[] players = new BattleShip[2];
        players[0] = new BattleShip(np);
        players[1] = new BattleShip(np);
        int p = 0;
        while (p < 2){
            String ply = (p == 0)? "1" : "2";
            //se muestra el tablero para elegir
            presentationBoard();
            while (np > 0){
                //indentificador de juego
                //System.out.println("<--ID de juego-->: " + game.gameId + "--->" + np);
                System.out.println("Ingresa una posiciones Jugador: " + ply + ", como por ejemplo a1-a2 o b2-c2");
                String[] c = sc.next().split("-");
                System.out.println(Arrays.toString(c));
                if(players[p].isValidShip(c)){
                    if(players[p].addShip(c)){
                        np--;
                    }else {
                        System.out.println("Jugador: " + ply + "La posicion existe ingrese otra");
                    }
                    //presentationBoard(players[p].getPositions());
                }else {
                    System.out.println("Jugador: " + ply + "Ingreso herroneo!");
                }
            }
            p++;
            np = np2;
        }

        for (int g = 0; g < 75; g++) {
            System.out.print('\u2589');
        }
        System.out.println("");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!----------!!!!--!!!!!!!!!!!!-----!!!!!!!!------!!!!!!!------!!!!");
        System.out.println("!!!!!!!!!!!--!!!!!!--!!!!--!!!!!!!!!!!------!!!!!!!!!-----!!!!!!!-----!!!!!");
        System.out.println("!!!!!!!!!!!--!!!!!!--!!!!--!!!!!!!!!!!--!!!--!!!!!!!!!-----!!!!!-----!!!!!!");
        System.out.println("!!!!!!!!!!!--!!!!!!--!!!!--!!!!!!!!!!--!!!!!--!!!!!!!!!-----!!!-----!!!!!!!");
        System.out.println("!!!!!!!!!!!----------!!!!--!!!!!!!!!!--!!!!!!--!!!!!!!!!!---------!!!!!!!!!");
        System.out.println("!!!!!!!!!!!--!!!!!!!!!!!!--!!!!!!!!!-------------!!!!!!!!!!-----!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!--!!!!!!!!!!!!-------!!!--!!!!!!!!!!!--!!!!!!!!!-----!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!--!!!!!!!!!!!!-------!!!--!!!!!!!!!!!--!!!!!!!!!-----!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        for (int g = 0; g < 75; g++) {
            System.out.print('\u2589');
        }
        System.out.println("");

        int ships = BattleShip.getShipCounter();
            System.out.println("-----------------" + ships);
            while (ships > 0){
                String ply = (ships % 2 == 0)? "1" : "2";
                //game.show();
                System.out.print("Ingresa una posicion Jugador:" + ply + " ");
                String guess = sc.next();
                if(BattleShip.isValidPosition(guess)){
                    int pick = ply.compareTo("1") == 0 ? 1 : 0;
                    if(players[pick].isRepeated(guess)){
                        System.out.println("REPETIDO /（*_*）\\＞");
                    }else {
                        if(players[pick].touch(guess)){
                            System.out.println("Toque \\( ö )/");
                            //System.out.println(Arrays.toString(players[pick].getPositions()));

                        }else{
                            System.out.println("Fallido ＜（－︿－）＞");
                        }
                    }
                    ships--;
                }else {
                    System.out.println("Posicion inválida Jugador: " + ply + " " + guess);
                }
            }

        System.out.println("Jugador 1:");
        presentationBoard(players[0].getPositions(), players[0].getShots());
        System.out.println("Naves derrivadas: " + players[0].getDownShips());
        System.out.println("Naves alcanzadas: " + players[0].getTouchedShips());

        System.out.println("Jugador 2:");
        presentationBoard(players[1].getPositions(), players[1].getShots());
        System.out.println("Naves derrivadas: " + players[1].getDownShips());
        System.out.println("Naves alcanzadas: " + players[1].getTouchedShips());


        if(players[0].getDownShips() < players[1].getDownShips()){
            System.out.println("Ganador 1");
        }
        if(players[0].getDownShips() > players[1].getDownShips()){
            System.out.println("Ganador 2");
        }
        if(players[0].getDownShips() == players[1].getDownShips()){
            if (players[0].getDownShips() == players[1].getDownShips()){
                if(players[0].getTouchedShips() < players[1].getTouchedShips()) {
                    System.out.println("Ganador 1");
                }
                if(players[0].getTouchedShips() > players[1].getTouchedShips()) {
                    System.out.println("Ganador 2");
                }
                if(players[0].getTouchedShips() == players[1].getTouchedShips()) {
                    System.out.println("EMPATADOS");
                }
            }
        }
    }
//-------------------------------------------------------------------------------------
    /**
     * Contructor de la clase que representa el juego
     * @param pos
     */
    public BattleShip(int pos){
        this.list = new LinkedList<>();
        //this.used = new LinkedList<>();
        this.positions = new String[0];
        this.shots = new String[0];
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

    public String[] getShots(){
        return this.shots;
    }

    public static int getShipCounter(){
        return shipCounter;
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


    public boolean addShip(String[] c){
        List lb = Arrays.asList(this.positions);
        if(lb.contains(c[0]) && lb.contains(c[1])) return false;
        this.positions = addString(this.positions, c[0]);
        this.positions = addString(this.positions, c[1]);
        list.add(new Ship(c[0], c[1]));
        this.shipCounter++;
        return true;
    }

    /**
     * Para debuguear: muestra el contenido del arrelgo
     * de Ship's
     */
    public void show(){

        System.out.println(list.toString() + "<--Cantidad Naves:--> " + shipCounter);
    }

    /**
     * función accesoria que añade posiciones a un arreglo de cadenas
     * @param org
     * @param added
     * @return
     */
    private static String[] addString(String[] org, String added) {
        String[] result = Arrays.copyOf(org, org.length + 1);
        result[org.length] = added;
        return result;
    }

    /**
     * Método que verifia si una posición ingresada es válida
     * @param pos
     * @return
     */
    public static boolean isValidPosition(String pos){
        Pattern p = Pattern.compile("^[a-j][0-9]$");
        Matcher m = p.matcher(pos);
        boolean b = m.matches();
        if(!b){
            return false;
        }
        return true;
    }


    /**
     * Se fija si hay una posición dada en alguno de
     * los objetos Ship, de ser así marca que la posicion
     * se encontro marcando el miembro con null
     * @param c
     * @return
     */
    public boolean touch(String c){
        this.shots = addString(shots, c);
        Iterator<Ship>it = list.iterator();
        while (it.hasNext()){
            Ship t = it.next();
            if(t.getA().compareToIgnoreCase(c) == 0 || t.getB().compareToIgnoreCase(c) == 0){
                t.mark();
                return true;
            }
        }
        return false;
    }

    public boolean isRepeated(String c){
        List dc = Arrays.asList(this.shots);
        return dc.contains(c);
    }


    //posiciones validas y no ocupadas
    public boolean isValidShip(String[] c){
        if(c.length != 2) return false;
        if(c[0].length() == 3 || c[1].length() == 3) return false;
        //nuemro del cero al nueve
        int numberA = Character.getNumericValue(c[0].charAt(1));
        if(numberA > 9) return false;
        //posiciones del cero al nueve
        int letterA = Arrays.binarySearch(letters, c[0].charAt(0));
        if(letterA < 0) return false;
        int numberB = Character.getNumericValue(c[1].charAt(1));
        if(numberB > 9) return false;
        //posiciones del cero al nueve
        int letterB = Arrays.binarySearch(letters, c[1].charAt(0));
        if(letterA < 0) return false;
        //System.out.println(numberA - numberB);
        //System.out.println(letterA - letterB);
        if(!(Math.abs(numberA - numberB) <= 1 && Math.abs(letterA - letterB) <= 1)) return false;
        //si son iguales la letras posicion vertical, si lo son los numeros horizontal
        //de lo contrario es una posición diagonal tampoco nunca puede ser iguales
        return (!(numberA == numberB) || !(letterA == letterB))
                && !(numberA != numberB && letterA != letterB);
    }

    /**
     * Metodo que maneja la presentacion en pantalla del juego, muestra una grilla
     * donde marca las posiciones de la embarcaciones y los toques a las naves
     * con distintos versiones segun se quiera mostrar distintos resultados
     * o solo el tablero
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
//-------------------------------------CARACTERES--------------------------------------

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



//-------------------------------------------------------------------------------------

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

    public static void presentationBoard(String[] pos){

        List<String> lp = new LinkedList<>(Arrays.asList(pos));
        List<String> lm = new LinkedList<>();

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
//-------------------------------------CARACTERES--------------------------------------

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



//-------------------------------------------------------------------------------------

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

    public static void presentationBoard(){

        List<String> lp = new LinkedList<>();
        List<String> lm = new LinkedList<>();

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
//-------------------------------------CARACTERES--------------------------------------

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



//-------------------------------------------------------------------------------------

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

        public Ship(String a, String b){
            this.a = a;
            this.b = b;
            shipId = shipCounter++;
        }

        /**
         * Metodo accesorio para evitar repetir
         * código
         */
        private void create(){
            this.b = st.toString();
            lb.remove(this.b);
            st.setLength(0);
        }

        public void mark(){
            if(helth != 1){
                helth--;
                touchCounter++;
            }else {
                this.down = true;
                downCounter++;
                touchCounter --;
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


/////////////////////////////////////////AUTOGENERADO POR LA IDE////////////////////////////////////////////////////
    @Override
    public int hashCode() {
        int result = getRandom(44);
        result = 31 * result + Arrays.hashCode(board);
        result = 31 * result + (st != null ? st.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(positions);
        return result;
    }
}
