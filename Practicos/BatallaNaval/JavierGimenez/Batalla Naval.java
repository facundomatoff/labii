import java.util.Scanner;

public class juegoBatalla_2 {
	
	public static void main(String[] args) {
		char partida;
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Desea crear una nueva partida? s/n: ");
		partida = entrada.next().charAt(0);
		
		while (partida == 's') {
			System.out.print ("Ingrese el tamaño del tablero (max 10x10): ");
			int tam = entrada.nextInt();
			int[][] tab1 = crearTablero(tam);
			int[][] tab2 = crearTablero(tam);
			boolean revisar1;
			boolean revisar2;
		
			System.out.print("Ingrese la cantidad de barcos (max. 3): ");
			int barcos= entrada.nextInt();
		
			tab1 = barcosJugador1(barcos, tab1);
			tab2 = barcosJugador2(barcos, tab2);
	    
			System.out.print("Desea ver el tablero del jugador 1? s/n ");
			char ver = entrada.next().charAt(0); 
			if (ver == 's') {
				mostrarTablero(tam, tab1);
			}
	    
			System.out.print("Desea ver el tablero del jugador 2? s/n ");
			ver = entrada.next().charAt(0); 
			if (ver == 's') {
				mostrarTablero(tam, tab2);
			}
	    
			System.out.print("Tableros preparados para jugar. Desea Comenzar? s/n ");
			ver = entrada.next().charAt(0); 
	    
			if (ver == 's') {
				do{
					System.out.println("Lanzamiento JUGADOR 1. Indique obejtivo:");
					tab2 = unDisparo(tab2);
					revisar1 = revisarBarcos(tab2, tam);
	    		
					System.out.println("Lanzamiento JUGADOR 2. Indique obejtivo:");
					tab1 = unDisparo(tab1);
					revisar2 = revisarBarcos(tab1, tam);
	    	
				} while (revisar1 && revisar2);
	    	
				if (!revisar1) {
					System.out.println("Felicitaciones JUGADOR 1 has ganado la partida!");
				}
				if (!revisar2) {
					System.out.println("Felicitaciones JUGADOR 2 has ganado la partida!");
				}
	    	}
			System.out.print("Desea crear una nueva partida? s/n: ");
			partida = entrada.next().charAt(0);
		}
	}
				
	static int[][] crearTablero(int tam) {
		
		int matriz[][];														// tablero jugador 1	
		matriz = new int[tam][tam];
		
		for(int i=0;i<tam;i++){												// reseteo los valores- 
			for(int j=0;j<tam;j++){											// -del tablero con 0.
				matriz[i][j]=0;	
			}
		}		
	return matriz;	
	}
	
	static int mostrarTablero(int tam, int[][] matriz){
		
		String letras[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		
		System.out.println("Nuevo Tablero:");
		System.out.println();
		for (int x=0; x < tam; x++)
			System.out.print("\t" + letras[x] + "\t");
		
		System.out.println();
		for (int i=0; i < tam; i++) {
	        System.out.print(i + " | ");
	        for (int j=0; j < tam; j++) {
	          System.out.print ("\t" + matriz[i][j]);
	          if (j!= tam-1) 
	        	  System.out.print("\t");
	        }
	        System.out.println("\t |");
	    }
	return 0;	
	}
	
	static int[][] barcosJugador1(int barcos, int[][] matriz) {
		
		Scanner enter = new Scanner(System.in);
		boolean rta;		
		System.out.println("Ingrese posicion de los barcos para el JUGADOR 1");
		 
		for (int i=0; i<(barcos); i++) {
		    System.out.println("Ingresar datos para el barco " + (i+1));
		    
		    int fila1;
		    int colum1;
		    do {	
		    	System.out.print("Ingresar numero de fila 1: ");
	    		fila1 = enter.nextInt();
	    		System.out.print("Ingresar numero de columna 1: ");
	    		colum1 = enter.nextInt();
		
	    		rta = validarPos1(fila1, colum1, matriz);
	    		
		    } while (!rta);
		    
		    matriz[fila1][colum1] = 1;
		    
		    int fila2;
		    int colum2;
		    
		    do {	
		    	System.out.print("Ingresar numero de fila 2: ");
	    		fila2 = enter.nextInt();
	    		System.out.print("Ingresar numero de columna 2: ");
	    		colum2 = enter.nextInt();
		
	    		rta = validarPos2(fila2, colum2, matriz, fila1, colum1);
	    		
		    } while (!rta);
		    
		    matriz[fila2][colum2] = 1;
	    }
		
	return matriz;
	}	
	
	static int[][] barcosJugador2(int barcos, int[][] matriz) {
		
		Scanner enter = new Scanner(System.in);
		boolean rta;		
		System.out.println("Ingrese posicion de los barcos para el JUGADOR 2");
		 
		for (int i=0; i<(barcos); i++) {
		    System.out.println("Ingresar datos para el barco " + (i+1));
		    
		    int fila1;
		    int colum1;
		    do {	
		    	System.out.print("Ingresar numero de fila 1: ");
	    		fila1 = enter.nextInt();
	    		System.out.print("Ingresar numero de columna 1: ");
	    		colum1 = enter.nextInt();
		
	    		rta = validarPos1(fila1, colum1, matriz);
	    		
		    } while (!rta);
		    
		    matriz[fila1][colum1] = 1;
		    
		    int fila2;
		    int colum2;
		    
		    do {	
		    	System.out.print("Ingresar numero de fila 2: ");
	    		fila2 = enter.nextInt();
	    		System.out.print("Ingresar numero de columna 2: ");
	    		colum2 = enter.nextInt();
		
	    		rta = validarPos2(fila2, colum2, matriz, fila1, colum1);
	    		
		    } while (!rta);
		    
		    matriz[fila2][colum2] = 1;
	      		
		}
	return matriz;
	}
		
	static boolean validarPos1(int a, int b, int[][] matriz) {
		boolean salida = true;
		Scanner enter = new Scanner(System.in);
		
		if (a>=0 && a<=(matriz[a].length) && b>=0 && b<=(matriz[b].length)){							// valida si esta dentro de la matriz
			if (matriz[a][b]==0) {																	// valida que la posicion este libre
				return salida;
			} else {
				System.out.println("La posicion ya esta ocupada, ingrese de nuevo");
				salida = false;
				}
		} else {
			System.out.println("La posicion ingresada no esta dentro del tablero");
			salida = false;
		}
	return salida;
	}
	
	static boolean validarPos2(int a, int b, int[][] matriz, int x, int y) {

		boolean salida = true;
		Scanner enter = new Scanner(System.in);
		
		if (a>=0 && a<=(matriz[a].length) && b>=0 && b<=(matriz[b].length)){						// valida si esta dentro de la matriz
			if (matriz[a][b]==0) {																	// valida que la posicion este libre
				if (a == x) {																		// FILAS IGUALES PARA AMBAS POSICIONES
					if (b < y) {																	// colum2 < colum1
						if (y - b == 1) {
							matriz[a][b] = 1;
						} else {
							System.out.println("Posicion de la columna 2 erronea");
							salida = false; 
							}
					}
					if (b > y) {																	// colum2 > colum1
						if (b - y == 1) {
							matriz[a][b] = 1;
						} else {
							System.out.println("Posicion de la columna 2 erronea");
							salida = false;
						}
					}
					if (b == y) {																	// error iguales
						System.out.println("Error. Posicion ya ocupada");
						salida = false;
					}
				}
				if (b == y) {																		// COLUMNAS IGUALES PARA AMBAS POSICIONES
					if (a < x) {																	// fila2 < fila1
						if (x - a ==  1) {
							matriz[a][b] = 1;
						} else {
								System.out.println("Posicion de la fila 2 erronea");
								salida = false;
						}
					}
					if (a > x) {																	// fila2 > fila1					
						if (a - x ==  1) {
							matriz[a][b] = 1;
						} else {
							System.out.println("Posicion de la fila 2 erronea");
							salida = false;
						}
					}
					if (a == x) {																	// error iguales
						System.out.println("Error. Posicion ya ocupada");
						salida = false;
					}
				}
				
				if (a!=x && b!=y){																	// error diagonales
					System.out.println("No se puede cargar barcos en diagonales");
					salida = false;
				}
			
			} else {
				System.out.println("La posicion ya esta ocupada, ingrese de nuevo");
				salida = false;
				}
		} else {
			System.out.println("La posicion ingresada no esta dentro del tablero");
			salida = false;
		}
		
	return salida;
	}
	
	static int[][] unDisparo(int[][] matriz){
		Scanner in = new Scanner(System.in);
		boolean disparo = false;
				
		System.out.print("Ingrese posicion de fila: ");
		int fila = in.nextInt();
		System.out.print("Ingrese posicion de columna: ");
		int colum = in.nextInt();
		
		disparo = verificarLanzamiento(fila, colum, matriz);
			
		if (disparo) {
			System.out.println("Muy bien! Disparo acertado en la posicion (" + fila + "," +colum + ")");
			matriz[fila][colum] = 0;
		} else {
			System.out.println("El disparo no dio en ningun blanco. Sigue intentando!");
		}
		
	return matriz;	
	}
	
	static boolean verificarLanzamiento(int a, int b, int[][] matriz){
		boolean acerto = false;
		
		if (matriz[a][b] == 1) {
			acerto = true;
		}
		
	return acerto;	
	}
	
	static boolean revisarBarcos(int[][] matriz, int tam){
		boolean salida = false;
		
		for(int i=0; i<tam; i++) {
			for (int j=0; j<tam; j++){
				if (matriz[i][j]== 1)
					salida = true;
			}
		}
	return salida;	
	}

} 		