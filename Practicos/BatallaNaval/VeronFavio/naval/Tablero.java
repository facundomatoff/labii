package naval;

//Creado por Favio Veron

public class Tablero {
	
	private int filas=0;
	private int columnas=0;
	private String[][] grilla;
	private String cabecera = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int cantBarcos=0;
	
	//Constructor
	public Tablero(int filas,int columnas,int cantBarcos){
		this.cantBarcos=cantBarcos;
		this.filas=filas;
		this.columnas=columnas;
		grilla=new String[filas][columnas];
		for (int i=0;i<grilla.length;i++){
			for(int j = 0; j <grilla[i].length;j++){
				grilla[i][j]="#";
			}
		}
	}
	
	//Imprimo el tablero
	public void imprimirTablero(){
		imprimirCabecera();
		for (int i=0;i<grilla.length;i++){
			System.out.print(i+1+"  ");
			for(int j = 0; j <grilla[i].length;j++){
				System.out.print(grilla[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	public void imprimirCabecera(){
		System.out.print("   ");
		for (int i=0;i<filas;i++){
			System.out.print(cabecera.charAt(i)+" ");
		}
		System.out.println("");
	}
	
	
	//Cambio la representacion de las celdas que reciben un ataque
	public void ocuparCeldasFail(int xfila,int ycolumna){
		grilla[xfila-1][ycolumna-1]="X";
	}
	
	public void ocuparCeldasWin(int xfila,int ycolumna){
		grilla[xfila-1][ycolumna-1]="O";
	}
	
	
	

}
