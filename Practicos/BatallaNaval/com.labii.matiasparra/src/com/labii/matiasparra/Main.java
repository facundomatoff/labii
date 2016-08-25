package com.labii.matiasparra;

import java.util.Scanner;

public class Main {
	public static String[] columnasLetras = { "", "a", "b", "c", "d", "f", "g", "h", "i", "j", "k", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenidos a la batalla naval..");
		System.out.println("ingrese el tamaño del tablero");
		int n = sc.nextInt();
		System.out.println("ingrese la cantidad de barcos");
		int bar = sc.nextInt();
		Barco[] barcos = new Barco[bar + 1];// cantidad de barcos
		String coordenadasRespaldo = "";
		int cantCoord =0;
		for (int i = 0; i < bar; i++) {
			Barco barco = new Barco();
			System.out.println("ingrese las coordeandas del barco nº:" + (i + 1));
			System.out.println("formato de coordenada a1/b1/c1 etc etc");
			// cordenadas q tiene el barco
			Coordenada[] coord = new Coordenada[2];
			// es para controlar si hay o no coordenadas repetidas

			for (int j = 0; j < 2; j++) {
				boolean continuar = false;
				Coordenada cor = new Coordenada();
				while (!continuar) {
					String str = sc.next();
					// compruevo si la coordenada esta ocupada
					if (!coordenadasRespaldo.contains(str)) {
						coordenadasRespaldo = coordenadasRespaldo.concat(str + " ");
						String columna = String.valueOf(str.charAt(0));
						int fila = Integer.parseInt(String.valueOf(str.charAt(1)));
						int col = equivalenteColumna(columna);
						// compruebo q la coordenada este adentro del tablero
						if (col >= 1 && col <= n && fila >= 1 && fila <= n) {
							// si es la primer coordenada se setea sola deveria
							// comprobar si no estan repetidos las coordenadas
							if (j == 0) {
								cor.setColumna(columna);
								cor.setFila(fila);

								continuar = true;
							} else {

								// compruebo en diagonal se comprueba si estan
								// continuos los puntos
								if (coord[0].getColumna().equals(columna) || coord[0].getFila() == fila) {

									boolean bandera = false;

									int colAnt = equivalenteColumna(coord[0].getColumna());
									int filaAnt = coord[0].getFila();
									if ((colAnt + 1 == col || colAnt - 1 == col) && filaAnt == fila) {
										bandera = true;
									}
									if ((filaAnt + 1 == fila || filaAnt - 1 == fila) && colAnt == col) {
										bandera = true;
									}
									if (bandera) {
										cor.setColumna(columna);
										cor.setFila(fila);
										continuar = true;
										System.out.println("barco agregado");
									}
								} else {
									System.out.println("la coordenada ingresada no es consecutiva a la anterior");
								}

							}
							cantCoord+=1;
						}
					} else {
						System.out.println("coordenada ya ocupada");
					}

				}
				cor.setEstado(true);
				coord[j] = cor;
			}
			barco.setPos(coord);
			barcos[i] = barco;
			System.out.println(coordenadasRespaldo);
		}
		mostrar(barcos, n);
		System.out.println("que inicie la batalla ingrese las coordenadas, para terminar ingrese -1");
		String str = sc.next();
		while (!str.equals("-1")) {
			
				if (coordenadasRespaldo.contains(str)) {
					coordenadasRespaldo = reemplazar(coordenadasRespaldo, str, "");
					setearEstadoCoordenada(barcos, str);
					System.out.println("le pegaste capo");
					cantCoord-=1;
				} else {
					System.out.println("LE ERRASTE MI TEGEN");
				}
			if (cantCoord!=0) {	
				System.out.println("sigue la batalla ingrese las coordenadas, para terminar ingrese -1");
				str = sc.next();
			} else {
				System.out.println("ganaste flaco");
				str="-1";
			}
			

		}
		mostrar(barcos, n);
		sc.close();
	}

	private static void setearEstadoCoordenada(Barco[] barcos, String str) {
		int fila = Integer.parseInt(String.valueOf(str.charAt(1)));
		String columna = String.valueOf(str.charAt(0));

		for (int i = 0; i < barcos.length - 1; i++) {
			for (int j = 0; j < 2; j++) {
				if (barcos[i].getPos()[j].getColumna().equals(columna) && barcos[i].getPos()[j].getFila() == fila) {
					barcos[i].getPos()[j].setEstado(false);
				}
			}
		}

	}

	private static void mostrar(Barco[] barcos, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (!estaBarco(i, j, barcos)) {

					System.out.print("|   |");

				}
			}
			System.out.println("");
		}

	}

	private static boolean estaBarco(int i, int j, Barco[] barcos) {
		for (int k = 0; k < barcos.length - 1; k++) {
			Coordenada[] cord = barcos[k].getPos();
			for (int s = 0; s < cord.length; s++) {
				int colAnt = equivalenteColumna(cord[s].getColumna());
				if (colAnt == j && cord[s].fila == i) {
					if (barcos[k].getPos()[s].isEstado()) {
						System.out.print("| O |");
					} else {
						System.out.print("| X |");
					}
					return true;
				}
			}
		}

		return false;
	}

	private static int equivalenteColumna(String columna) {
		for (int i = 0; i < columnasLetras.length; i++) {
			if (columnasLetras[i].equals(columna)) {
				return i;
			}
		}
		return 0;
	}

	public static String reemplazar(String cadena, String busqueda, String reemplazo) {
		return cadena.replaceAll(busqueda, reemplazo);
	}

}
