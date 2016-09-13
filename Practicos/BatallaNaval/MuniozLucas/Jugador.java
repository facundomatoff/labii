import java.util.Scanner;
public class Jugador {
	
	private int nroJugador;
	
	private int cantidadBarcos;
	
	private Barco[] barcos;
	
	Scanner sc=new Scanner(System.in);
	
	
	public Jugador(int cantidadBarcos, int nroJugador){
		
		this.cantidadBarcos=cantidadBarcos;
		
		this.nroJugador=nroJugador;
		
		barcos=new Barco[cantidadBarcos];
	}
	
	
	
	
	public String toString(){
		return "jugador nro"+nroJugador;
	}
	
	
	
	
	
	public void ubicarBarco(Tablero tab){
		
		int j=0;
		
		while(j<cantidadBarcos){
			
			System.out.println(toString()+": ingrese las coordenadas "
					+ "donde colocar el barco nro. "+(j+1));
			
			String ent=sc.next().toLowerCase();
			
			int columna=ent.charAt(0)-96;
			
			int fila=Integer.parseInt(ent.substring(1, ent.length()));
			
			if(!tab.posicionOcupada(columna, fila)){
				if(!tab.posicionOcupada(columna+1, fila)){
					
					barcos[j]=new Barco(columna, fila, columna+1, fila);
					tab.setPuntos(barcos[j]);
					j++;
					
				}else if(!tab.posicionOcupada(columna-1, fila)){

					barcos[j]=new Barco(columna, fila, columna-1, fila);
					tab.setPuntos(barcos[j]);
					j++;
					
				}else if(!tab.posicionOcupada(columna, fila+1)){

					barcos[j]=new Barco(columna, fila, columna, fila+1);
					tab.setPuntos(barcos[j]);
					j++;
					
				}else if(!tab.posicionOcupada(columna, fila-1)){

					barcos[j]=new Barco(columna, fila, columna, fila-1);
					tab.setPuntos(barcos[j]);
					j++;
					
				}else System.out.println("error: no hay espacio para colocar"
						+ "el barco");
			}else System.out.println("error: posicion invalida");
			tab.imprimir();
		}
		
	}
	
	
	
	
	
	
	public int[] ingresaCoordenadas(){
		
		int[] arreglo=new int[2];
		
		
		System.out.println(toString()+": ingrese las coordenadas "
				+ "donde atacar. ");
		
		String ent=sc.next().toLowerCase();
		
		arreglo[1]=ent.charAt(0)-96;
		
		arreglo[0]=Integer.parseInt(ent.substring(1, ent.length()));
		
		return arreglo;
	}
	
	
	
	
	
	
	public boolean ataquExitoso(Tablero tab, Jugador oponente ,int[] coordenadas){
		
		if(tab.posicionOcupada(coordenadas[1], coordenadas[0])){
			for(Barco bar:oponente.getBarcos()){
				if((bar.getColumnaUno()==coordenadas[1] && bar.getFilaUno()==coordenadas[0])
					|| (bar.getColumnaDos()==coordenadas[1] && bar.getFilaDos()==coordenadas[0])){
					tab.setPuntosX(bar);
					return true;
				}
			}
		}
		return false;
		
	}
	
	
	
	public void setCantidadBarcos(int cantidadBarcos){
		this.cantidadBarcos=cantidadBarcos;
	}
	
	public int getCantidadBarcos(){
		return cantidadBarcos;
	}
	
	public Barco[] getBarcos(){
		return barcos;
	}
}
