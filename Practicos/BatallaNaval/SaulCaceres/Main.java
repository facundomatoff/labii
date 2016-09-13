package saul;
import java.util.*;
public class Main {
	
	


	

		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tam=0, cantBar=0,fila=0,columna=0,fila2=0,columna2=0,barDest=0,contAta=0,coor=-1;
		String coordenada1, coordenada2,barcoAtac="";
		boolean salida = false;
		
		
		

		System.out.println("              BIENVENIDA A LA BATALLA NAVAL");
		System.out.println("");
		System.out.println("Para salir del juego escriba EXIT en la paticion de coordenadas");
		System.out.println("");
		
		
		//Ingresar tamaño del Tablero y verificacion
		do{
		System.out.println("Ingrese tamaño del Tablero NO debe ser mayor a 10");
		tam=sc.nextInt();
		if(tam >10 || tam < 1){
			System.out.println("ERROR: vuelva a introducir");
		}
		System.out.println("");
		}while(tam>10 || tam < 1);
		
		
		//Creacion del Tablero
		tam= tam+1;
		String [][] matriz = new String[tam][tam];
		
		//Cargar Tablero con valores predeterminaods
		Operaciones.valoresPrede(matriz,tam);
		
		
		//Mostrar Tablero
		Operaciones.mostrar(matriz);
		System.out.println("");
		
		//Ingresar Cantidad de Barcos
		
		System.out.println("Ingrese la cantidad de barcos");
		cantBar=sc.nextInt();
		Naves[] barcos= new Naves[cantBar];
		
			
		
		System.out.println("");
		
		
		
	    //Ubicacion de los Barcos en el Tablero
		System.out.println("         COORDENADAS DE LOS BARCOS");
		System.out.println("");
		System.out.println("Ingrese valores: 1er valor entre (a-j) 2do valor entre (1-10)");
		System.out.println("Las coordenadas deben ser continuas EJ: a1-a2, a1-b1");
		System.out.println("");
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		for(int i=0; i<barcos.length;i++){
			boolean confirm=false;
			
		do{	
			
		System.out.println("Ingrese 1ra coordenada para el barco Nº:"+(i+1));
		coordenada1 = sc.next();
		
		
		//Verificacion de Lugar en el Tablero
			if(false == Operaciones.lugarLibre(coordenada1, barcos)){
				System.out.println("ERROR: Lugar ocupado");
				continue;
			}
			
		
		columna = (Operaciones.obtenerColumna(coordenada1));
		
		
		//Verificacion de Columna
		if(columna == -1){
			System.out.println("ERROR: columna incorrecta");
			continue;
		}
		
		
		fila = (Operaciones.obtenerFila(coordenada1));
		
		
		//Verificacion de Fila
			if(fila <= -1){
				System.out.println("ERROR: fila incorrecta");
				continue;
			}
			
		
		
		////////////////////////////////////////////////////////////////////////////
		
		
		System.out.println("Ingrese 2da coordenada para el barco Nº:"+(i+1));
		coordenada2 = sc.next();
		
		//Verificacion de Lugar en el Tablero
				if(false == Operaciones.lugarLibre(coordenada2, barcos)){
					System.out.println("ERROR: Lugar ocupado");
					continue;
				}
				
		
		columna2 = (Operaciones.obtenerColumna(coordenada2));
		
		//Verificacion de Columna
			if(columna2 == -1){
				System.out.println("ERROR: columna incorrecta");
				continue;
			}
			
		fila2 = (Operaciones.obtenerFila(coordenada2));
		
		//Verificacion de Fila
				if(fila2 <= -1){
					System.out.println("ERROR: fila incorrecta");
					continue;
				}
				
		
		//Verificacion si es Continua
		if(false == Operaciones.continuas(fila, columna, fila2, columna2)){
			System.out.println("ERROR: coordenadas NO continuas");
			continue;
		}		
				
		
		//Verificacion de rango
			if(false == Operaciones.rango(fila2, columna2, tam)){
					System.out.println("ERROR: fuera de rango");
					continue;
		    }
			
		matriz[fila][columna]=" 1";	
		matriz[fila2][columna2]=" 1";
		confirm = true;
		barcos[i] = new Naves (coordenada1,coordenada2," %100");
		
	    
		}while(confirm == false);
		
		}
		
		
		
		System.out.println("");
		Operaciones.mostrar2(barcos);
		System.out.println("");
		Operaciones.mostrar(matriz);
		System.out.println("");
		
		
	//////////////////////////////////////////////////////////////////////////////////////////	
		//ATAQUES
		do{
		System.out.println("Ingresar coordenadas de ataques");
		coordenada1 = sc.next();
		
		
		if(coordenada1.equalsIgnoreCase("exit")){
			salida = true;
			break;
		}
		contAta++;
		
		
		barcoAtac=Operaciones.ataque(coordenada1,barcos);
		
		if( barcoAtac == "destruido"){
			System.out.println("BARCO DESTRUIDO");
			cantBar--;
			barDest++;
				
			    coor =Operaciones.borrarMatriz(barcos);
			    
				fila=(Operaciones.obtenerFila(barcos[coor].getCoordenada1()));
				columna=(Operaciones.obtenerColumna(barcos[coor].getCoordenada1()));
				fila2=(Operaciones.obtenerFila(barcos[coor].getCoordenada2()));
				columna2=(Operaciones.obtenerColumna(barcos[coor].getCoordenada2()));
				
				
				matriz[fila][columna]=" 0";	
				matriz[fila2][columna2]=" 0";
				System.out.println("");
				Operaciones.mostrar2(barcos);
				Operaciones.mostrar(matriz);
				System.out.println("");
			
			
			
		}else{
			if(barcoAtac == "acertado"){
								
			System.out.println("ATAQUE ACERTADO PERO NO DESTRUIDO");
		}else{
			if(barcoAtac == null){
			System.out.println("ATAQUE FALLIDO");
		}
		}
		}
		
		
		}while(cantBar != 0);
		
	///////////////////////////////////////////////////////////////////////////////////////////
		
		if(salida == true){
			System.out.println("");
			System.out.println("");
			System.out.println("      EL JUEGO HA TERMINADO");
			System.out.println("      (ABANDONO DEL JUGADOR)");
			System.out.println("");
			System.out.println("Barcos Destruido: "+ barDest);
			System.out.println("Barcos con Vida: "+cantBar);
			System.out.println("Ataques realizados: "+contAta);
		
		}else{
			System.out.println("");
			System.out.println("");
			System.out.println("       GAME OVER");
			System.out.println("   (DESTRUCCION TOTAL)");
			System.out.println("");
			System.out.println("Barcos Destruido: "+ barDest);
			System.out.println("Barcos con Vida: "+cantBar);
			System.out.println("Ataques realizados: "+contAta);
		}

	}
	}


