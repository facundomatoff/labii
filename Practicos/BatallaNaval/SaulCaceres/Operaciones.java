package saul;

public class Operaciones {

	public static void mostrar(String[][] matriz) {
		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[f].length; c++) {
				System.out.print(matriz[f][c] + " ");
			}
			System.out.println();
		}
	}

	public static int obtenerColumna(String datos) {
		char dato = datos.charAt(0);
		int num = -1;

		switch (dato) {

		case 'a':
			num = 1;
			break;
		case 'b':
			num = 2;
			break;
		case 'c':
			num = 3;
			break;
		case 'd':
			num = 4;
			break;
		case 'e':
			num = 5;
			break;
		case 'f':
			num = 6;
			break;
		case 'g':
			num = 7;
			break;
		case 'h':
			num = 8;
			break;
		case 'i':
			num = 9;
			break;
		case 'j':
			num = 10;
			break;

		}
		return num;

	}

	public static int obtenerFila(String datos) {
		int cant = 0, num10;
		char num1 = 0, num2 = 0;

		cant = datos.length();

		if (cant > 3) {
			return -1;
		}

		if (cant == 3) {
			num1 = datos.charAt(1);
			num2 = datos.charAt(2);

			if (num1 == '1' && num2 == '0') {
				return 10;
			} else {
				return -1;
			}
		}

		if (cant < 3) {
			num10 = Integer.parseInt("" + datos.charAt(1));

			if (num10 > 0 && num10 <= 9) {
				return num10;
			} else {
				return -1;
			}

		}
		return -1;

	}

	public static boolean rango(int fila, int columna, int tamaño) {
		columna = columna + 1;
		fila = fila + 1;
		boolean bool = true;

		if (fila > tamaño || columna > tamaño) {
			bool = false;
		}
		return bool;
	}

	public static void mostrar2(Naves[] barcos) {
		for (int i = 0; i < barcos.length; i++) {
			System.out.println("Coordenadas del Barco Nº" + (i + 1) + ":  " + barcos[i].getCoordenada1() + "  "	+ barcos[i].getCoordenada2()+"  "+barcos[i].getEstado());

		}
	}

	public static boolean continuas(int fila, int columna, int fila2, int columna2) {
		boolean bool = false;

		if (fila == fila2) {
			if (columna2 == (columna - 1) || columna2 == (columna + 1)) {
				bool = true;
			} else {
				return bool;
			}
		}
		if (columna == columna2) {
			if (fila == (fila2 - 1) || fila == (fila2 + 1)) {
				bool = true;
			} else {
				return bool;
			}

		}
		return bool;

	}

	public static boolean lugarLibre(String coor, Naves[] barcos) {

		for (int i = 0; i < barcos.length; i++) {
			if (barcos[i] == null) {
				return true;
			}
			if (barcos[i].getCoordenada1().equalsIgnoreCase(coor)
					|| barcos[i].getCoordenada2().equalsIgnoreCase(coor)) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public static String ataque(String coordenada, Naves[] barcos){
				
		for(int i=0; i<barcos.length; i++){
			if(barcos[i].getCoordenada1().equalsIgnoreCase(coordenada)){
				if(barcos[i].getEstado().equalsIgnoreCase("%50")){
					barcos[i].setEstado("destruido");
					return "destruido";
				}else{
					barcos[i].setEstado("%50");
					return "acertado";
				}
				}else{
	               if(barcos[i].getCoordenada2().equalsIgnoreCase(coordenada)){
	            	   if(barcos[i].getEstado().equalsIgnoreCase("%50")){
	   					barcos[i].setEstado("destruido");
	   					return "destruido";
	   				}else{
	   					barcos[i].setEstado("%50");
	   					return "acertado";
	   				}
	            	
			}
		 }
			
		}
		return null;
	}	
	
	
	
	public static int borrarMatriz (Naves[] barcos){
		for(int i=0; i<barcos.length; i++){	
			if(barcos[i].getEstado().equalsIgnoreCase("destruido")){
				return i;
			}
		}
		return -1;
	}

	public static void valoresPrede(String[][] matriz, int tam) {
		String cadena = "ABCDEFGHIJ";
		matriz[0][0] = "/ ";

		for (int i = 1; i < tam; i++) {
			matriz[0][i] = String.valueOf(" " + cadena.charAt(i - 1));
		}

		for (int i = 1; i < tam; i++) {
			matriz[i][0] = String.valueOf(i + "|");
		}

		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[f].length; c++) {
				if (matriz[f][c] == null) {
					matriz[f][c] = " 0";
				}
			}

		}
	}

}
