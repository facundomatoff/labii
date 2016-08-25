import java.util.Arrays;

public class Tablero{
	private char[][] matriz;
	
	
	
	
	
	public Tablero(int tamaño){
		matriz=new char[tamaño][tamaño];
		
		for(int i=0; i<tamaño; i++){
			Arrays.fill(matriz[i], '-');
		}
	}
	
	
	
	

	public boolean posicionValida(int columna, int fila){
		if(fila-1>=0 && fila-1<matriz.length-1){
			if(columna-1>=0 && columna-1<matriz[0].length-1){
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean posicionOcupada(int columna, int fila){
		if(posicionValida(columna, fila)){
			if(matriz[fila-1][columna-1]=='-'){
				return false;
			}
		}
		return true;
	}
	
	
	
	
	public void imprimir(){
		for(int i=0; i<matriz.length; i++){
			for(int j=0; j<matriz[0].length; j++){
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void setPuntos(Barco bar){
		matriz[bar.getFilaUno()-1][bar.getColumnaUno()-1]='o';
		matriz[bar.getFilaDos()-1][bar.getColumnaDos()-1]='o';
	}
	
	public void setPuntosX(Barco bar){
		matriz[bar.getFilaUno()-1][bar.getColumnaUno()-1]='x';
		matriz[bar.getFilaDos()-1][bar.getColumnaDos()-1]='x';
	}
	
}
