import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NavalBattle {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String[][] tablero1 = new String[11][11];
		String[][] tablero2 = new String[11][11];

		armarTablero(tablero1);
		armarTablero(tablero2);
		verTablero(tablero1);
		System.out.println("====|  JUGADOR 1  |====");
		
		cargarCoordenadas(tablero1, tablero2);
		verTablero(tablero1);
		
		System.out.println("====|  JUGADOR 2  |====");
		
		//cargarCoordenadas(tablero2);
		//limpiarPantalla();
		verTablero(tablero2);


	}





















	public static void armarTablero(String[][] Tablero) {
		int n = Tablero.length;

		for(int i=0; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				Tablero[i][j] = "o";
				if(j<1 && (i>0 && i<10)){
					Tablero[i][j] = Integer.toString(i)+"  ";
				}
				if(i>9 && j<1) {
					Tablero[i][j] = Integer.toString(i)+" ";
				}

				if(i == 0) {
					Tablero[i][j] = (char)(j+64)+"";
					//65-74
				}
			}
		}Tablero[0][0] = "   ";
	}


	public static String[][] verTablero(String[][] Tablero) {
		int n = Tablero.length;
		System.out.println("\n");

		for(int i=0; i<n ; i++) {
			System.out.println(" ");
			for(int j=0 ; j<n ; j++) {
				System.out.print(Tablero[i][j]+" ");
			}
		}
		System.out.println("\n\n\n");
		return Tablero;
	}


	public static void cargarCoordenadas(String[][] tablero1, String[][] tablero2) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int barcos = 0;
		System.out.println("");
		//Controlo cantidad de barcos ingresados
		while(barcos < 1 || barcos > 50) {
			System.out.print("Ingrese numero de barcos: ");
			barcos = Integer.parseInt(br.readLine());
		}

		String[] arrayCoordenadas;
		//Ingreso coordenadas
		for(int i=0; i<barcos; i++) {
			System.out.print("");		
			System.out.print("Ingrese coordenadas (Ej:'C 4'): \n");
			boolean noExisteCoordenada = false;			

			for(int j=0; j<2 ; j++) {				
				do{
					String strCoord = br.readLine();
					arrayCoordenadas = strCoord.split(" ");
					char character1 = arrayCoordenadas[0].charAt(0);
					int coordenada1 = (int)character1;
					int coordenada2 = Integer.parseInt(arrayCoordenadas[1]);
					//65 - 74

					//Compruebo limites del tablero
					if(coordenada1 > 64 && coordenada1 < 75 && coordenada2 > 0 && coordenada2 < tablero1.length) {
						cargarBarcos(tablero1, coordenada1, coordenada2);
					}else{
						System.out.println("Coordenada incorrecta!");
						noExisteCoordenada = true;
					}
				}while(noExisteCoordenada);				
			}
			
		}		
	}

	
	public static void cargarBarcos(String[][] tablero, int coordenada1, int coordenada2 ) {
		int b = coordenada1-64;
		tablero[coordenada2][b] = "x";
	}

	public static void limpiarPantalla() {

		for(int i=0; i<15; i++)
		{
			System.out.println();
		}
	}

}
