package naval;

//Creado por Favio Veron

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		int cantNaves;
		int[] tiro= new int[2];
		int[] posicion= new int[4];
		int filasTablero=0;
		int columnasTablero=0;
		
		
		Scanner sc = new Scanner(System.in);
		
		//Determino el tamaño del tablero
		System.out.println("Ingresa la cantidad de filas del tablero: ");
		filasTablero=verificarTamañoTablero();
		
		
		System.out.println("Ingresa la cantidad de columnas del tablero: ");
		columnasTablero=verificarTamañoTablero();
		
		
		
		//Creo los barcos
		System.out.println("Ingresa la cantidad de naves: ");
		cantNaves=verificarCantNaves(); //Realiza el ingreso de cantidad de naves hasta que dicha cantidad sea valida.
		
		Nave[] naves = new Nave[cantNaves];
		
		System.out.println("A continuacion ingresa coordenadas una a una. Los barcos no pueden ocupar celdas en diagonal ni celdas superpuestas, tampoco pueden ocupar celdas negativas.");
		for (int i=0;i<cantNaves;i++){	
			System.out.println("Ingresa coordenadas del barco: "+(i+1));
			//Establezco coordenadas
			for (int k=0;k<4;k++){
				posicion[k]=sc.nextInt();
			}
			
			posicion=verificarPosicionBarco(posicion,i);
	
			//Creo una nave
			naves[i]=new Nave(posicion);
			
		}
		
		Tablero t=new Tablero(filasTablero,columnasTablero,cantNaves);
		t.imprimirTablero();
		
		//Ataco a los barcos
		int destruidos=0;
		int aciertos=0;
		int terminar=1;
		
		while(destruidos!=cantNaves && terminar == 1){
			System.out.println(".\n\nIntroduce un punto para atacar... Si deseas terminar el juego, ingresa un numero negativo. ");
			aciertos=0;
			//Establezco coordenada x de ataque
			System.out.println("Introduce coordenada x: ");
			tiro[0]=sc.nextInt();
			

			//Establezco coordenada y de ataque
			System.out.println("Introduce coordenada y: ");
			tiro[1]=sc.nextInt();
			
			//Verifico que las coordenadas de ataque esten dentro del rango del tablero.
			while (tiro[0]>filasTablero || tiro[1]>columnasTablero){
				System.out.println("\n\nCoordenadas no validas\n\nIntroduce de nuevo un punto para atacar: . Si deseas terminar el juego, ingresa un numero negativo. ");
				//Establezco coordenada x de ataque
				System.out.println("Introduce coordenada x: ");
				tiro[0]=sc.nextInt();
				

				//Establezco coordenada y de ataque
				System.out.println("Introduce coordenada y: ");
				tiro[1]=sc.nextInt();
			}
			
			
			if (tiro[0]<=0 || tiro[1]<=0){
				System.out.println("Has finalizado el juego.");
				terminar=0;
			}	else{
				//Verifico que alguna nave haya sido alcanzada por el tiro
				for(int k=0;k<cantNaves;k++){
					if(naves[k].recibirAtaque(tiro[0],tiro[1])){
						aciertos += 1;
						//Verifico que alguna nave haya sido destruida
						if (naves[k].destruirNave()) {
							destruidos +=1 ;
						}break;
					} 
				}
				if (aciertos==0){
					System.out.println("\nFALLASTE\n");
					t.ocuparCeldasFail(tiro[0],tiro[1]);
				} else {
				t.ocuparCeldasWin(tiro[0],tiro[1]);
				}
				
				t.imprimirTablero();
				
				if (destruidos==cantNaves){
					System.out.println("\nFin del juego. Ganaste!");
					terminar=0;
				}
			}		
		}
		
		
		
		
	}
	
	//Con este metodo ingreso el tamaño tanto de filas como de columnas del tablero.
	public static int verificarTamañoTablero(){
		Scanner sc = new Scanner(System.in);
		
		int longitud=sc.nextInt();
		while (longitud <= 2){
			System.out.println("\nNumero no valido. Por favor ingrese una dimension superior a 2. ");
			longitud=sc.nextInt();
		}
		return longitud;
		
	}
	
	//Con este metodo ingreso la cantidad de naves
		public static int verificarCantNaves(){
			Scanner sc = new Scanner(System.in);
			
			int longitud=sc.nextInt();
			while (longitud < 1){
				System.out.println("\nNumero no valido. Por favor ingrese una cantidad igual o superior a 1. ");
				longitud=sc.nextInt();
			}
			return longitud;
			
		}
	
	
	
	//Con este metodo logro que el usuario ingrese coordenadas validas para los barcos.
	public static int[] verificarPosicionBarco(int[] posicion,int i){
		Scanner sc = new Scanner(System.in);
		
		boolean  iguales = posicion[0]==posicion[2] && posicion[1]==posicion[3];
	 	boolean negativos = posicion[0]<=0 ||posicion[1] <=0 || posicion[2]<=0 || posicion[3]<=0;
	 	boolean diagonal1=(posicion[2]==posicion[0]+1) && (posicion[3] == posicion[1]+1);
	 	boolean diagonal2=(posicion[2]==posicion[0]-1) && (posicion[3] == posicion[1]-1);
	 	boolean diagonal3=(posicion[2]==posicion[0]-1) && (posicion[3] == posicion[1]+1);
	 	boolean diagonal4=(posicion[2]==posicion[0]+1) && (posicion[3] == posicion[1]-1);
	 	boolean distanciaX=Math.abs(posicion[2]-posicion[0])>1;
	 	boolean distanciaY=Math.abs(posicion[3]-posicion[1])>1;
			
		while(iguales || negativos || diagonal1 || diagonal2 || diagonal3 || diagonal4 || distanciaX || distanciaY){
			System.out.println("\nCoordenadas incorrectas.\nIngresa coordenadas del barco: "+(i+1));
			//Establezco coordenadas
			for (int h=0;h<4;h++){
				posicion[h]=sc.nextInt();
			}
			iguales = posicion[0]==posicion[2] && posicion[1]==posicion[3];
		 	negativos = posicion[0]<=0 ||posicion[1] <=0 || posicion[2]<=0 || posicion[3]<=0;
 			diagonal1=(posicion[2]==posicion[0]+1) && (posicion[3] == posicion[1]+1);
 			diagonal2=(posicion[2]==posicion[0]-1) && (posicion[3] == posicion[1]-1);
 			diagonal3=(posicion[2]==posicion[0]-1) && (posicion[3] == posicion[1]+1);
 			diagonal4=(posicion[2]==posicion[0]+1) && (posicion[3] == posicion[1]-1);
 			distanciaX=Math.abs(posicion[2]-posicion[0])>1;
 		 	distanciaY=Math.abs(posicion[3]-posicion[1])>1;
		}
		
		return posicion;
	}
}
