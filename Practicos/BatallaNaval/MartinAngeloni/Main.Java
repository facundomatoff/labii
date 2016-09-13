import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		int tamanioMatriz = 10;
		
		Matriz [][]mat = new Matriz[tamanioMatriz][tamanioMatriz];//tablero del jugador 1
		Matriz [][]mat2 = new Matriz[tamanioMatriz][tamanioMatriz];//tablero del jugador 2
		Barco aux[] = new Barco[4];//para controlar que los barcos sean adyacentes
		Barco aux2[] = new Barco[4];
		Barco auxBomba[] = new Barco[6];
	
		
		
		
		//en el siguiente for cargamos los dos tableros con 5
		for (int i=0; i<tamanioMatriz; i++){
			for (int j=0; j<tamanioMatriz; j++){
				mat[i][j]= new Matriz(5);//tablero jugador 1
				mat2[i][j]= new Matriz(5);// tablero jugador 2
			}
		}
		
		System.out.println("Bien, seran 3 barcos introducidos por tablero de cada jugador");
		System.out.println("Recuerda que cada barco consta de dos partes que seran introducidas de manera adyacente sin excepcion");
		
		int contBarcos=0;
		int contCeldas=0;
		int contOtro=0;
		boolean control=true;
		
		while (contBarcos<6){ // serian 3 barcos por tablero
		
			if (contBarcos==0 && contCeldas==0)System.out.println("Jugador 1 comience a introducir sus barcos");
			if (contBarcos==3 && contCeldas==0)System.out.println("Ahora es el turno de rellenar el tablero del jugador 2");
			
			System.out.println("Seleccione una fila y columna");
			int fila = teclado.nextInt();
			String letra = teclado.next();
			int columna=0;
			
			switch (letra){
			case "A": columna=0;break;
			case "B": columna=1;break;
			case "C": columna=2;break;
			case "D": columna=3;break;
			case "E": columna=4;break;
			case "F": columna=5;break;
			case "G": columna=6;break;
			case "H": columna=7;break;
			case "I": columna=8;break;
			case "J": columna=9;break;
			
			}
			
			
				if (contBarcos>=3){
					
					if (mat2[fila][columna].getValor()==5){
						if (contCeldas==1){
							if ((fila == aux2[0].getFila() && columna == aux2[0].getColumna()) 
									|| (fila == aux2[1].getFila() && columna == aux2[1].getColumna())
									|| (fila == aux2[2].getFila() && columna == aux2[2].getColumna()) 
									||(fila == aux2[3].getFila() && columna == aux2[3].getColumna())){
								//en las siguientes lineas asignamos
								if (contOtro<=5){
									auxBomba[contOtro].setFila2(fila);
									auxBomba[contOtro].setColumna2(columna);	
								}
								control=true;
								contOtro++;
							}else {
								System.out.println("No has colocado bien, debes colocar la siguiente parte del barco de manera adyacente");
								control=false;
							}
						}
						if (control==true){
							
							mat2[fila][columna] = new Matriz(1);//colocamos en esta celda el numero del barco
							
							aux2[0] = new Barco(fila-1, columna);
							aux2[1] = new Barco(fila+1, columna);
							aux2[2] = new Barco(fila, columna-1);
							aux2[3] = new Barco(fila, columna+1);
							if (contOtro<=5){
								
								auxBomba[contOtro] = new Barco(fila, columna);
								
							}
							contCeldas++;
						}
					}else System.out.println("Ya has introducido una parte del barco aqui");
				}else{
					if (mat[fila][columna].getValor()==5){
						if (contCeldas==1){//controlamos que coloque la otra parte del barco en una celda adyacente
							if ((fila == aux[0].getFila() && columna == aux[0].getColumna()) || (fila == aux[1].getFila() && columna == aux[1].getColumna())
									|| (fila == aux[2].getFila() && columna == aux[2].getColumna()) 
									||(fila == aux[3].getFila() && columna == aux[3].getColumna())){//para controlar que sea adyacente
								if (contOtro<=5){
									auxBomba[contOtro].setFila2(fila);
									auxBomba[contOtro].setColumna2(columna);
								}
								control=true;
								contOtro++;
							}else {
								System.out.println("No has colocado bien, debes colocar la siguiente parte del barco de manera adyacente");
								control=false;
							}
						}
						if (control == true){
							
							mat[fila][columna] = new Matriz(1);//colocamos en esta celda el numero del barco
							
							//posiciones posibles donde el usuario deberia colocar su siguiente parte del barco, controlando que sea adyacente
							aux[0] = new Barco(fila-1, columna);
							aux[1] = new Barco(fila+1, columna);
							aux[2] = new Barco(fila, columna-1);
							aux[3] = new Barco(fila, columna+1);
							
							if (contOtro<=5){
								auxBomba[contOtro] = new Barco(fila, columna);
							}
							
							contCeldas++;
						}
					}else System.out.println("Ya has introducido una parte del barco aqui");
				}
			
			if (contCeldas==2){//se verifica que este completo un barco
				contBarcos++;
				contCeldas=0;
			}
		}
		
		
		System.out.println("");
		
		
		System.out.println("Tablero del jugador 1");
		System.out.println("");
		for (int i=0; i<tamanioMatriz; i++){
			for (int j=0; j<tamanioMatriz; j++){
				System.out.print(mat[i][j].getValor());
			}
			System.out.println("");
		}
		
		System.out.println("");
		
		System.out.println("Tablero del jugador 2");
		System.out.println("");
		for (int i=0; i<tamanioMatriz; i++){
			for (int j=0; j<tamanioMatriz; j++){
				System.out.print(mat2[i][j].getValor());
			}
			System.out.println("");
		}
		
		System.out.println("");
		
		
		System.out.println("");
		
		System.out.println("Bien, los barcos de ambos jugadores ya estan cargados");
		System.out.println("Comienza a bombardear jugador 1");
		
		int barcoJug1=3;
		int barcoJug2=3;
		boolean boton=true;//para controlar los turnos de cada jugador
		
		
		while (barcoJug1>0 || barcoJug2>0){//para bombardear
			
			if (boton==true) System.out.println("Jugador 1 lanza tus bombas!!");
			else System.out.println("Jugador 2 ahora te toca a ti!");
			
			int filaBomb = teclado.nextInt();
			String colum = teclado.next();
			int coluBomb=0;
			
			switch (colum){
			case "A": coluBomb=0;break;
			case "B": coluBomb=1;break;
			case "C": coluBomb=2;break;
			case "D": coluBomb=3;break;
			case "E": coluBomb=4;break;
			case "F": coluBomb=5;break;
			case "G": coluBomb=6;break;
			case "H": coluBomb=7;break;
			case "I": coluBomb=8;break;
			case "J": coluBomb=9;break;
			}
			
			
			
			if ((filaBomb>=0 && filaBomb<=tamanioMatriz)&&(coluBomb>=0 && coluBomb<=tamanioMatriz)){//controlamos que no se salga del tablero
			
				if (boton==true){
					
					if ((auxBomba[3].getColumna()==coluBomb && auxBomba[3].getFila()==filaBomb) 
							||(auxBomba[3].getColumna2()==coluBomb && auxBomba[3].getFila2()==filaBomb)
							|| (auxBomba[4].getColumna()==coluBomb && auxBomba[4].getFila()==filaBomb)
							|| (auxBomba[4].getColumna2()==coluBomb && auxBomba[4].getFila2()==filaBomb)
							|| (auxBomba[5].getColumna()==coluBomb && auxBomba[5].getFila()==filaBomb)
							|| (auxBomba[5].getColumna2()==coluBomb && auxBomba[5].getFila2()==filaBomb)){//controlamos que la bomba dio en un blanco
						
						System.out.println("Tu bomba dio en un blanco");
					
						//damos valores de 2 a esta arreglo auxiliar para luego controlar que sea un barco quien se haya hundido
						if (auxBomba[3].getColumna()==coluBomb && auxBomba[3].getFila()==filaBomb){
							auxBomba[3].setColumna(2);
							auxBomba[3].setFila(2);
						}
						if (auxBomba[3].getColumna2()==coluBomb && auxBomba[3].getFila2()==filaBomb){
							auxBomba[3].setColumna2(2);
							auxBomba[3].setFila2(2);
						}
						if (auxBomba[4].getColumna()==coluBomb && auxBomba[4].getFila()==filaBomb){
							auxBomba[4].setColumna(2);
							auxBomba[4].setFila(2);
						}
						if (auxBomba[4].getColumna2()==coluBomb && auxBomba[4].getFila2()==filaBomb){
							auxBomba[4].setColumna2(2);
							auxBomba[4].setFila2(2);
						}
						if (auxBomba[5].getColumna()==coluBomb && auxBomba[5].getFila()==filaBomb){
							auxBomba[5].setColumna(2);
							auxBomba[5].setFila(2);
						}
						if (auxBomba[5].getColumna2()==coluBomb && auxBomba[5].getFila2()==filaBomb){
							auxBomba[5].setColumna2(2);
							auxBomba[5].setFila2(2);
						}
						
						
						if ((auxBomba[3].getColumna()==2 && auxBomba[3].getFila()==2) && (auxBomba[3].getColumna2()==2 && auxBomba[3].getFila2()==2)){
							System.out.println("Hundiste un barco");
						}
						if 	((auxBomba[4].getColumna()==2 && auxBomba[4].getFila()==2) && (auxBomba[4].getColumna2()==2 && auxBomba[4].getFila2()==2)){
							System.out.println("Hundiste un barco");
						}
						if 	((auxBomba[5].getColumna()==2 && auxBomba[5].getFila()==2) && (auxBomba[5].getColumna2()==2 && auxBomba[5].getFila2()==2)){
							System.out.println("Hundiste un barco");
						}
						
						if (((auxBomba[3].getColumna()==2 && auxBomba[3].getFila()==2) && (auxBomba[3].getColumna2()==2 && auxBomba[3].getFila2()==2))
						&& ((auxBomba[4].getColumna()==2 && auxBomba[4].getFila()==2) && (auxBomba[4].getColumna2()==2 && auxBomba[4].getFila2()==2))
						&& ((auxBomba[5].getColumna()==2 && auxBomba[5].getFila()==2) && (auxBomba[5].getColumna2()==2 && auxBomba[5].getFila2()==2))){
							barcoJug2=0;
						}
												
							
					}else{
						System.out.println("La bomba ha caido en el agua");
					}
				}else{// este es el else del boton boolean para turno de jugador
					if ((auxBomba[0].getColumna()==coluBomb && auxBomba[0].getFila()==filaBomb) 
							||(auxBomba[0].getColumna2()==coluBomb && auxBomba[0].getFila2()==filaBomb)
							|| (auxBomba[1].getColumna()==coluBomb && auxBomba[1].getFila()==filaBomb)
							|| (auxBomba[1].getColumna2()==coluBomb && auxBomba[1].getFila2()==filaBomb)
							|| (auxBomba[2].getColumna()==coluBomb && auxBomba[2].getFila()==filaBomb)
							|| (auxBomba[2].getColumna2()==coluBomb && auxBomba[2].getFila2()==filaBomb)){
						
						System.out.println("Tu bomba dio en un blanco");
						
						//damos valores de 2 a esta arreglo auxiliar para luego controlar que sea un barco quien se haya hundido
						if (auxBomba[0].getColumna()==coluBomb && auxBomba[0].getFila()==filaBomb){
							auxBomba[0].setColumna(2);
							auxBomba[0].setFila(2);
						}
						if (auxBomba[0].getColumna2()==coluBomb && auxBomba[0].getFila2()==filaBomb){
							auxBomba[0].setColumna2(2);
							auxBomba[0].setFila2(2);
						}
						if (auxBomba[1].getColumna()==coluBomb && auxBomba[1].getFila()==filaBomb){
							auxBomba[1].setColumna(2);
							auxBomba[1].setFila(2);
						}
						if (auxBomba[1].getColumna2()==coluBomb && auxBomba[1].getFila2()==filaBomb){
							auxBomba[1].setColumna2(2);
							auxBomba[1].setFila2(2);
						}
						if (auxBomba[2].getColumna()==coluBomb && auxBomba[2].getFila()==filaBomb){
							auxBomba[2].setColumna(2);
							auxBomba[2].setFila(2);
						}
						if (auxBomba[2].getColumna2()==coluBomb && auxBomba[2].getFila2()==filaBomb){
							auxBomba[2].setColumna2(2);
							auxBomba[2].setFila2(2);
						}
						
						
						if ((auxBomba[0].getColumna()==2 && auxBomba[0].getFila()==2) && (auxBomba[0].getColumna2()==2 && auxBomba[0].getFila2()==2)){
							System.out.println("Hundiste un barco");
						}
						if 	((auxBomba[1].getColumna()==2 && auxBomba[1].getFila()==2) && (auxBomba[1].getColumna2()==2 && auxBomba[1].getFila2()==2)){
							System.out.println("Hundiste un barco");
						}
						if 	((auxBomba[2].getColumna()==2 && auxBomba[2].getFila()==2) && (auxBomba[2].getColumna2()==2 && auxBomba[2].getFila2()==2)){
							System.out.println("Hundiste un barco");
						}
						
						if (((auxBomba[0].getColumna()==2 && auxBomba[0].getFila()==2) && (auxBomba[0].getColumna2()==2 && auxBomba[0].getFila2()==2))
								&& ((auxBomba[1].getColumna()==2 && auxBomba[1].getFila()==2) && (auxBomba[1].getColumna2()==2 && auxBomba[1].getFila2()==2))
								&& ((auxBomba[2].getColumna()==2 && auxBomba[2].getFila()==2) && (auxBomba[2].getColumna2()==2 && auxBomba[2].getFila2()==2))){
									barcoJug1=0;
									
								}
						
						
					}else{// este el el else de la comprobacion de sio dio en algun barco
						System.out.println("La bomba ha caida en el agua");
							
							
					}
					
					}
					
					
					
				}else System.out.println("Has introducido una fila o columna inexistente");
				
				boton=!boton;
				
				if (barcoJug1==0) break;
				
				if (barcoJug2 == 0) break;
			
			}
			
			if (barcoJug1==0) System.out.println("JUGADOR 2 GANA!!!");
				
			if (barcoJug2 == 0) System.out.println("JUGADOR 1 GANA");
		
		



	}

}

class Barco {

	private int fila;
	private int columna;
	private int fila2;
	private int columna2;
	
	public Barco(int fila, int columna){
		this.fila=fila;
		this.columna=columna;
	}
	
	
	
	public Barco(int fila, int columna, int fila2, int columna2){
		this.fila=fila;
		this.columna=columna;
		this.fila2=fila2;
		this.columna2=columna2;
	}

	
	//getters
	public int getFila(){
		return fila;
	}
	public int getColumna(){
		return columna;
	}
	public int getFila2(){
		return fila2;
	}
	public int getColumna2(){
		return columna2;
	}
	//setters
	public void setFila(int fila){
		this.fila=fila;
	}
	public void setColumna(int columna){
		this.columna=columna;
	}
	public void setFila2(int fila2){
		this.fila2=fila2;
	}
	public void setColumna2(int columna2){
		this.columna2=columna2;
	}
	
}


class Matriz {

	private int valor;
	
	//constructor parametrizado
	public Matriz(int valor){
		this.valor=valor;
	}
	
	//getters
	public int getValor(){
		return valor;
	}
	
	
	//setters
	public void setValor(int valor){
		this.valor=valor;
	}
	
}