import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		
		System.out.println("indique el tamaño del tablero");
		
		int tamanioTab=sc.nextInt();
		
		
		System.out.println("indique la cantidad de barcos");
		
		int cantidadBarcos=sc.nextInt();
		
		
		
		/*creo los tablero*/
		
		Tablero tableroJrd1=new Tablero(tamanioTab);
		Tablero tableroJrd2=new Tablero(tamanioTab);
		
		
		
		
		/*inicio los jugadores*/
		
		Jugador jdr1= new Jugador(cantidadBarcos, 1);
		Jugador jdr2= new Jugador(cantidadBarcos, 2);
		
		
		
		
		/*los jugadores ordenan los barcos en sus tableros*/
		
		jdr1.ubicarBarco(tableroJrd1);
		jdr2.ubicarBarco(tableroJrd2);
		
		
		
		
		/*comienza el juegooo =D*/
		
		while(jdr1.getCantidadBarcos()>0 && jdr2.getCantidadBarcos()>0){
			int[] coordenadas=jdr1.ingresaCoordenadas();
			
			while(!tableroJrd2.posicionValida(coordenadas[1], coordenadas[0])){
				System.out.println("error: posicion invalida");
				coordenadas=jdr1.ingresaCoordenadas();
			}
			
			if(jdr1.ataquExitoso(tableroJrd2, jdr2, coordenadas)){
				System.out.println("blanco!");
				jdr2.setCantidadBarcos(jdr2.getCantidadBarcos()-1);
			}else System.out.println("fallo!");
			
			tableroJrd2.imprimir();
			
			if(jdr2.getCantidadBarcos()==0) continue;
			
			coordenadas=jdr2.ingresaCoordenadas();
			
			while(!tableroJrd1.posicionValida(coordenadas[1], coordenadas[0])){
				System.out.println("error: posicion invalida");
				coordenadas=jdr2.ingresaCoordenadas();
			}
			
			if(jdr2.ataquExitoso(tableroJrd1, jdr1, coordenadas)){
				System.out.println("blanco!");
				jdr1.setCantidadBarcos(jdr1.getCantidadBarcos()-1);
			}else System.out.println("fallo!");
			
			tableroJrd1.imprimir();
		}
		
		
		if(jdr2.getCantidadBarcos()==0){
			System.out.println("jugador nro.1 ha ganado!");
		}else System.out.println("jugador nro.2 ha ganado!");
		
		
		sc.close();
	}
}
