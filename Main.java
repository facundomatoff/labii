import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Con cuantos barcos desean jugar (50 como maximo)?");

		int cantBarcos = sc.nextInt();

		// Controlo que la cantidad de barcos sea correcto.
		boolean cantBarcosIncorrecta = true;
		if (cantBarcos > 50 || cantBarcos < 1) {
			System.out.println("Error: cantidad de barcos no aceptada");
			while (cantBarcosIncorrecta) {
				System.out.println("¿Con cuantos barcos desean jugar (50 como maximo)?");
				cantBarcos = sc.nextInt();
				if (cantBarcos > 50 || cantBarcos < 1) {
					System.out.println("Error: cantidad de barcos no aceptada");
				} else if (cantBarcos > 51 || cantBarcos > 0) {
					cantBarcosIncorrecta = false;
				}
			}
		}

		boolean[][] tableroJ1 = new boolean[10][10];
		boolean[][] tableroJ2 = new boolean[10][10];

		// Pongo en false los arrays.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tableroJ1[i][j] = false;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tableroJ2[i][j] = false;
			}
		}

		// carga de matriz del jugador 1.
		for (int i = 0; i < cantBarcos; i++) {
			boolean coordenadasIncorrectasJ1 = true;
			while (coordenadasIncorrectasJ1) {
				System.out.println("ingrese las cordenadas del barco " + (i + 1) + " del jugador 1 (Ej: a 1 a 2): ");

				char letra1 = sc.next().toLowerCase().charAt(0);
				int num1 = sc.nextInt();
				char letra2 = sc.next().toLowerCase().charAt(0);
				int num2 = sc.nextInt();

				// Controlo que los numeros sean validos.
				boolean numero1IncorrectoJ1 = true;
				if (num1 < 1 || num1 > 10) {
					System.out.println("Error: numero 1 invalido.");
					while (numero1IncorrectoJ1) {
						System.out.println("Introduzca el primer numero de nuevo:");
						num1 = sc.nextInt();
						if (num1 > 0 && num1 < 11) {
							numero1IncorrectoJ1 = false;
						} else {
							System.out.println("Error: numero 1 invalido.");
						}
					}
				}

				boolean numero2IncorrectoJ1 = true;
				if (num2 < 1 || num2 > 10) {
					System.out.println("Error: numero 2 invalido.");
					while (numero2IncorrectoJ1) {
						System.out.println("Introduzca el segundo numero de nuevo:");
						num2 = sc.nextInt();
						if (num2 > 0 && num2 < 11) {
							numero2IncorrectoJ1 = false;
						} else {
							System.out.println("Error: numero 2 invalido.");
						}
					}
				}

				// Controlo que las letras sean validas.
				boolean letra1IncorrectaJ1 = true;
				if (letra1 != 'a' && letra1 != 'b' && letra1 != 'c' && letra1 != 'd' && letra1 != 'e' && letra1 != 'f'
						&& letra1 != 'g' && letra1 != 'h' && letra1 != 'i' && letra1 != 'j') {
					System.out.println("Error: letra 1 invalida.");
					while (letra1IncorrectaJ1) {
						System.out.println("Introduzca la primera letra de nuevo:");
						letra1 = sc.next().toLowerCase().charAt(0);
						if (letra1 == 'a' || letra1 == 'b' || letra1 == 'c' || letra1 == 'd' || letra1 == 'e'
								|| letra1 == 'f' || letra1 == 'g' || letra1 == 'h' || letra1 == 'i' || letra1 == 'j') {
							letra1IncorrectaJ1 = false;
						} else {
							System.out.println("Error: letra 1 invalida.");
						}
					}
				}

				boolean letra2IncorrectaJ1 = true;
				if (letra2 != 'a' && letra2 != 'b' && letra2 != 'c' && letra2 != 'd' && letra2 != 'e' && letra2 != 'f'
						&& letra2 != 'g' && letra2 != 'h' && letra2 != 'i' && letra2 != 'j') {
					System.out.println("Error: letra 2 invalida.");
					while (letra2IncorrectaJ1) {
						System.out.println("Introduzca la segunda letra de nuevo:");
						letra2 = sc.next().toLowerCase().charAt(0);
						if (letra1 == 'a' || letra1 == 'b' || letra1 == 'c' || letra1 == 'd' || letra1 == 'e'
								|| letra1 == 'f' || letra1 == 'g' || letra1 == 'h' || letra1 == 'i' || letra1 == 'j') {
							letra2IncorrectaJ1 = false;
						} else {
							System.out.println("Error: letra 2 invalida.");
						}
					}
				}

				// Obtengo un numero a partir de la letra para poder manejar las
				// posiciones de la matriz.
				int numLetra1 = 0;
				switch (letra1) {
				case 'a':
					numLetra1 = 0;
					break;
				case 'b':
					numLetra1 = 1;
					break;
				case 'c':
					numLetra1 = 2;
					break;
				case 'd':
					numLetra1 = 3;
					break;
				case 'e':
					numLetra1 = 4;
					break;
				case 'f':
					numLetra1 = 5;
					break;
				case 'g':
					numLetra1 = 6;
					break;
				case 'h':
					numLetra1 = 7;
					break;
				case 'i':
					numLetra1 = 8;
					break;
				case 'j':
					numLetra1 = 9;
					break;
				}

				int numLetra2 = 0;
				switch (letra2) {
				case 'a':
					numLetra2 = 0;
					break;
				case 'b':
					numLetra2 = 1;
					break;
				case 'c':
					numLetra2 = 2;
					break;
				case 'd':
					numLetra2 = 3;
					break;
				case 'e':
					numLetra2 = 4;
					break;
				case 'f':
					numLetra2 = 5;
					break;
				case 'g':
					numLetra2 = 6;
					break;
				case 'h':
					numLetra2 = 7;
					break;
				case 'i':
					numLetra2 = 8;
					break;
				case 'j':
					numLetra2 = 9;
					break;
				}

				// Le resto 1 a los numeros por que la matriz empieza desde 0.
				num1 = num1 - 1;
				num2 = num2 - 1;

				// Controlar que las dos posiciones sean contiguas (o
				// correctas).
				if ((num1 == num2) && ((numLetra2 == numLetra1 + 1) || (numLetra2 == numLetra1 - 1))) {// Si
																										// los
																										// numeros
																										// son
																										// igual,
																										// las
																										// letras
																										// tienen
																										// que
																										// ser
																										// distintas
																										// y
																										// contiguas.
					if (!tableroJ1[numLetra1][num1] && !tableroJ1[numLetra2][num2]) {
						tableroJ1[numLetra1][num1] = true;
						tableroJ1[numLetra2][num2] = true;
						coordenadasIncorrectasJ1 = false;
					} else {
						System.out.println("Error: coordenadas ya utilizadas.");
					}

				} else if ((numLetra1 == numLetra2) && ((num2 == num1 + 1) || (num2 == num1 - 1))) {// Si
																									// las
																									// letras
																									// son
																									// iguales,
																									// los
																									// numeros
																									// tienen
																									// que
																									// ser
																									// distinotos
																									// y
																									// contiguos.
					if (!tableroJ1[numLetra1][num1] && !tableroJ1[numLetra2][num2]) {
						tableroJ1[numLetra1][num1] = true;
						tableroJ1[numLetra2][num2] = true;
						coordenadasIncorrectasJ1 = false;
					} else {
						System.out.println("Error: coordenadas ya utilizadas.");
					}

				} else {
					System.out.println("Error: coordenadas invalidas.");
				}
			}

		}

		// carga de matriz del jugador 2 y controla las mismas cosas.
		for (int i = 0; i < cantBarcos; i++) {
			boolean coordenadasIncorrectasJ2 = true;
			while (coordenadasIncorrectasJ2) {

				System.out.println("ingrese las cordenadas del barco " + (i + 1) + " del jugador 2 (Ej: a 1 a 2): ");

				char letra1 = sc.next().toLowerCase().charAt(0);
				int num1 = sc.nextInt();
				char letra2 = sc.next().toLowerCase().charAt(0);
				int num2 = sc.nextInt();

				boolean numero1IncorrectoJ2 = true;
				if (num1 < 1 || num1 > 10) {
					System.out.println("Error: numero 1 invalido.");
					while (numero1IncorrectoJ2) {
						System.out.println("Introduzca el primer numero de nuevo:");
						num1 = sc.nextInt();
						if (num1 > 0 && num1 < 11) {
							numero1IncorrectoJ2 = false;
						} else {
							System.out.println("Error: numero 1 invalido.");
						}
					}
				}
				boolean numero2IncorrectoJ2 = true;
				if (num2 < 1 || num2 > 10) {
					System.out.println("Error: numero 2 invalido.");
					while (numero2IncorrectoJ2) {
						System.out.println("Introduzca el segundo numero de nuevo:");
						num2 = sc.nextInt();
						if (num2 > 0 && num2 < 11) {
							numero2IncorrectoJ2 = false;
						} else {
							System.out.println("Error: numero 2 invalido.");
						}
					}
				}

				boolean letra1IncorrectaJ2 = true;
				if (letra1 != 'a' && letra1 != 'b' && letra1 != 'c' && letra1 != 'd' && letra1 != 'e' && letra1 != 'f'
						&& letra1 != 'g' && letra1 != 'h' && letra1 != 'i' && letra1 != 'j') {
					System.out.println("Error: letra 1 invalida.");
					while (letra1IncorrectaJ2) {
						System.out.println("Introduzca la primera letra de nuevo:");
						letra1 = sc.next().toLowerCase().charAt(0);
						if (letra1 == 'a' || letra1 == 'b' || letra1 == 'c' || letra1 == 'd' || letra1 == 'e'
								|| letra1 == 'f' || letra1 == 'g' || letra1 == 'h' || letra1 == 'i' || letra1 == 'j') {
							letra1IncorrectaJ2 = false;
						} else {
							System.out.println("Error: letra 1 invalida.");
						}
					}
				}

				boolean letra2IncorrectaJ2 = true;
				if (letra2 != 'a' && letra2 != 'b' && letra2 != 'c' && letra2 != 'd' && letra2 != 'e' && letra2 != 'f'
						&& letra2 != 'g' && letra2 != 'h' && letra2 != 'i' && letra2 != 'j') {
					System.out.println("Error: letra 2 invalida.");
					while (letra2IncorrectaJ2) {
						System.out.println("Introduzca la segunda letra de nuevo:");
						letra2 = sc.next().toLowerCase().charAt(0);
						if (letra1 == 'a' || letra1 == 'b' || letra1 == 'c' || letra1 == 'd' || letra1 == 'e'
								|| letra1 == 'f' || letra1 == 'g' || letra1 == 'h' || letra1 == 'i' || letra1 == 'j') {
							letra2IncorrectaJ2 = false;
						} else {
							System.out.println("Error: letra 2 invalida.");
						}
					}
				}

				int numLetra1 = 0;

				switch (letra1) {
				case 'a':
					numLetra1 = 0;
					break;
				case 'b':
					numLetra1 = 1;
					break;
				case 'c':
					numLetra1 = 2;
					break;
				case 'd':
					numLetra1 = 3;
					break;
				case 'e':
					numLetra1 = 4;
					break;
				case 'f':
					numLetra1 = 5;
					break;
				case 'g':
					numLetra1 = 6;
					break;
				case 'h':
					numLetra1 = 7;
					break;
				case 'i':
					numLetra1 = 8;
					break;
				case 'j':
					numLetra1 = 9;
					break;
				}

				int numLetra2 = 0;

				switch (letra2) {
				case 'a':
					numLetra2 = 0;
					break;
				case 'b':
					numLetra2 = 1;
					break;
				case 'c':
					numLetra2 = 2;
					break;
				case 'd':
					numLetra2 = 3;
					break;
				case 'e':
					numLetra2 = 4;
					break;
				case 'f':
					numLetra2 = 5;
					break;
				case 'g':
					numLetra2 = 6;
					break;
				case 'h':
					numLetra2 = 7;
					break;
				case 'i':
					numLetra2 = 8;
					break;
				case 'j':
					numLetra2 = 9;
					break;
				}

				num1 = num1 - 1;
				num2 = num2 - 1;

				if ((num1 == num2) && ((numLetra2 == numLetra1 + 1) || (numLetra2 == numLetra1 - 1))) {
					if (!tableroJ2[numLetra1][num1] && !tableroJ2[numLetra2][num2]) {
						tableroJ2[numLetra1][num1] = true;
						tableroJ2[numLetra2][num2] = true;
						coordenadasIncorrectasJ2 = false;

					} else {
						System.out.println("Error: coordenadas ya utilizadas.");
					}

				} else if ((numLetra1 == numLetra2) && ((num2 == num1 + 1) || (num2 == num1 - 1))) {
					if (!tableroJ2[numLetra1][num1] && !tableroJ2[numLetra2][num2]) {
						tableroJ2[numLetra1][num1] = true;
						tableroJ2[numLetra2][num2] = true;
						coordenadasIncorrectasJ2 = false;
					} else {
						System.out.println("Error: coordenadas ya utilizadas.");
					}

				} else {
					System.out.println("Error: coordenadas invalidas.");
				}
			}

		}

		// Uso dos variables booleanas para controlar cuando terimina el juego.
		boolean jugador1Perdio = false;
		boolean jugador2Perdio = false;
		boolean nadieGano = true;

		while (nadieGano) { // Si ninguno gano.
			System.out.println("jugador 1 ¡Dispara!: ");
			int letra = sc.next().toLowerCase().charAt(0);
			int numLetra = 0;

			boolean letraDisparoIncorrectaJ1 = true;
			if (letra != 'a' && letra != 'b' && letra != 'c' && letra != 'd' && letra != 'e' && letra != 'f'
					&& letra != 'g' && letra != 'h' && letra != 'i' && letra != 'j') {
				System.out.println("Error : letra invalida.");
				while (letraDisparoIncorrectaJ1) {
					System.out.println("Introduzca la letra y el numero de nuevo: ");
					sc.nextLine();
					letra = sc.next().toLowerCase().charAt(0);
					if (letra == 'a' || letra == 'b' || letra == 'c' || letra == 'd' || letra == 'e' || letra == 'f'
							|| letra == 'g' || letra == 'h' || letra == 'i' || letra == 'j') {
						letraDisparoIncorrectaJ1 = false;
					} else {
						System.out.println("Error : letra invalida.");
					}
				}
			}

			switch (letra) {
			case 'a':
				numLetra = 0;
				break;
			case 'b':
				numLetra = 1;
				break;
			case 'c':
				numLetra = 2;
				break;
			case 'd':
				numLetra = 3;
				break;
			case 'e':
				numLetra = 4;
				break;
			case 'f':
				numLetra = 5;
				break;
			case 'g':
				numLetra = 6;
				break;
			case 'h':
				numLetra = 7;
				break;
			case 'i':
				numLetra = 8;
				break;
			case 'j':
				numLetra = 9;
				break;
			}

			int num = (sc.nextInt()) - 1;

			boolean numDisparoIncorrectoJ1 = true;
			if (num < 0 || num > 9) {
				System.out.println("Error: numero invalido.");
				while (numDisparoIncorrectoJ1) {
					System.out.println("Introduzca el numero de nuevo: ");
					num = (sc.nextInt()) - 1;
					if (num > -1 && num < 10) {
						numDisparoIncorrectoJ1 = false;
					} else {
						System.out.println("Error: numero invalido.");
					}
				}
			}

			if (tableroJ2[numLetra][num] == true) {// Si le pega pongo en false
													// ese punto.
				System.out.println("¡Barco averiado!");
				tableroJ2[numLetra][num] = false;
			} else {
				System.out.println("¡Agua!");
			}

			// Controlo si perdio contando la cantidad de false.
			int contFalse = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (tableroJ2[i][j] == false) {
						contFalse++;
					}
				}
			}

			if (contFalse == 100) {
				jugador1Perdio = true;
			}

			// Lo mismo con el jugador 2.
			System.out.println("jugador 2 ¡Dispara!: ");
			int letra2 = sc.next().toLowerCase().charAt(0);
			int numLetra2 = 0;

			boolean letraDisparoIncorrectaJ2 = true;
			if (letra2 != 'a' && letra2 != 'b' && letra2 != 'c' && letra2 != 'd' && letra2 != 'e' && letra2 != 'f'
					&& letra2 != 'g' && letra2 != 'h' && letra2 != 'i' && letra2 != 'j') {
				System.out.println("Error : letra invalida.");
				while (letraDisparoIncorrectaJ2) {
					System.out.println("Introduzca la letra y el numero de nuevo: ");
					sc.nextLine();
					letra2 = sc.next().toLowerCase().charAt(0);
					if (letra2 == 'a' || letra2 == 'b' || letra2 == 'c' || letra2 == 'd' || letra2 == 'e'
							|| letra2 == 'f' || letra2 == 'g' || letra2 == 'h' || letra2 == 'i' || letra2 == 'j') {
						letraDisparoIncorrectaJ2 = false;
					} else {
						System.out.println("Error : letra invalida.");
					}
				}
			}

			switch (letra2) {
			case 'a':
				numLetra2 = 0;
				break;
			case 'b':
				numLetra2 = 1;
				break;
			case 'c':
				numLetra2 = 2;
				break;
			case 'd':
				numLetra2 = 3;
				break;
			case 'e':
				numLetra2 = 4;
				break;
			case 'f':
				numLetra2 = 5;
				break;
			case 'g':
				numLetra2 = 6;
				break;
			case 'h':
				numLetra2 = 7;
				break;
			case 'i':
				numLetra2 = 8;
				break;
			case 'j':
				numLetra2 = 9;
				break;
			}

			int num2 = (sc.nextInt()) - 1;

			boolean numDisparoIncorrectoJ2 = true;
			if (num2 < 0 || num2 > 9) {
				System.out.println("Error: numero invalido.");
				while (numDisparoIncorrectoJ2) {
					System.out.println("Introduzca el numero de nuevo: ");
					num2 = (sc.nextInt()) - 1;
					if (num2 > -1 && num2 < 10) {
						numDisparoIncorrectoJ2 = false;
					} else {
						System.out.println("Error: numero invalido.");
					}
				}
			}

			if (tableroJ1[numLetra2][num2] == true) {
				System.out.println("¡Barco averiado!");
				tableroJ1[numLetra2][num2] = false;
			} else {
				System.out.println("¡Agua!");
			}

			int contFalse2 = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (tableroJ1[i][j] == false) {
						contFalse2++;
					}
				}
			}

			if (contFalse2 == 100) {
				jugador2Perdio = true;
			}

			if (jugador1Perdio || jugador2Perdio) {
				nadieGano = false;
			}

		}
		if (jugador1Perdio == true && jugador2Perdio == false) {
			System.out.println("¡Gano el jugador 1!");
		} else if (jugador1Perdio == false && jugador2Perdio == true) {

			System.out.println("¡Gano el jugador 2!");
		} else {
			System.out.println("¡Hubo empate!");
		}

	}
}
