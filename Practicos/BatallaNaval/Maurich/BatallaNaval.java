/**
 * BatallaNaval
 * version 1
 */


import java.util.Scanner;

/**
 * @author Maurich
 *
 */
public class BatallaNaval {

	static Scanner sc=new Scanner(System.in);
	static int contador=0;
	
	static int conta=0;//mantiene una cuenta de las veces que se ingreso a la lista dos
	static String[] tableroContrincante;
	static String[] listaBarcosPropios;
	static boolean var;
	static int contadorAciertosOponente = 0;
	static int contadorAciertosPropio = 0;
	

	public static void main(String[] args) {
		boolean resp;
		
		//Inicio
		tituloInicio();
		int tt=establecerTamanioTablero();
		int cb=establecerCantidadBarcos();
		
		String listaBarcosPropios[]=new String[cb]; 
		String tableroContrincante[]=new String[(tt*tt)];
		listaBarcosPropios=cargadorBarcos(cb,tt);
		
		int condition=0;
		do {
			
			condition=menu();
	
				if(condition==1){
					
					boolean valido;
					do{
					titulo2();
					String nm=sc.next();
					valido=validarEntrada2(nm);
						
					if(valido){
					
						boolean v=verificarRepetido(buscarRepetido(tableroContrincante, nm));
						
						respuesta3(!v);
						if(!v){
						resp=pregunta();
						
						
						tableroContrincante=cargarBarcoPs(tableroContrincante, nm);
						contadorAciertosPropio=contadorAciertosPropios(resp,contadorAciertosPropio);
			
						}
						valido=!v;
						}
					}while(!valido);
					
				}else
					if(condition==2){
						var=eliminarBarcaoDeLista(pedirCordenadaAUndir(), listaBarcosPropios);
						 respuesta1(var);
						 contadorAciertosOponente = contadorAciertosCantrincante(var, contadorAciertosOponente);
					}else
						if(condition==3){
							estadoDelJuego(contadorAciertosPropio, contadorAciertosOponente, cb);
						}else
							if(condition==4){
								condition = 6;
							}else{
								System.out.println("opcion 	NO VALIDA 	");
							}
			
		} while (condition != 6 && !(contadorAciertosOponente==cb || contadorAciertosPropio==cb));
		System.out.println();
		System.out.println("    ***  JUEGO TERMINADO  ***");
		System.out.println();
		estadoDelJuego(contadorAciertosPropio, contadorAciertosOponente, cb);

	}
	

	public static int establecerTamanioTablero(){
		System.out.print("Ingrese tamaño del tablero(MAXIMO 10): ");
		int n=sc.nextInt();
		return n;
	}
	public static int establecerCantidadBarcos(){
		System.out.print("Ingrese cantidad de barcos: ");
		int n=sc.nextInt();
		return n;
	}
	
	public static void cargarBarco(int n){
		System.out.print("Ingrese las cordenadas barco ("+(n+1)+"): ");
	}
	
	public static String[] cargadorBarcos(int n, int tamanioTablero){
		String arg[]=new String[n];
		String cadena;
		boolean valido=false;
		int contador=n;
		int contador2=0;
	
				
		while(contador>0){
					cargarBarco(contador2);
					
					do{
					cadena=sc.next();
					valido=validarEntrada(cadena);
					
					if(valido){
						valido=verificoCordenadaEnElTablero(cadena, tamanioTablero);
					
						if(valido){
							arg[contador2]=cadena;
							contador--;
							contador2++;
						}
					}respuesta3(valido);
					}while(!valido);
				
				}return arg;
	}
	
	public static int contadorAciertosCantrincante(boolean b, int n){
		
		if(b){
			n=n+1;
		}
		return n;
	}

	public static int contadorAciertosPropios(boolean a, int n){
		
		if(a){
			n=n+1;
		}
		return n;
	}
	
	public static String pedirCordenadaAUndir(){
		String s;
		boolean var=false;
		do{
		System.out.println("Ingrese coordenadas para verificar acierto " );
		s=sc.next();
		var=validarEntrada2(s);
		respuesta3(var);
		}while(!var);
		return s;
	}
	
	public static int buscaBarcoP(String s, String[] arg){
		boolean value=false;
		int cont=0;
		int n=0;
		int n2=-1;
		
		while(!value && cont<arg.length){
			n=arg[cont].indexOf(s);
			
			if(n!=-1){
				value=true;
			}
			
			cont++;
		}
		if(value){
			return (cont-1);
		}
		else{
			return n2;
		}
		
	}
	
	
	public static boolean eliminarBarcaoDeLista(String s, String[] arg){
		boolean op=false;
		int pos=(buscaBarcoP(s, arg));
		
		if(pos!=-1){
			arg[pos]="----";
			op=true;
			
		}
		return op;
	}
	
	public static void respuesta1(boolean v){
		if(v){
			System.out.println("El oponente a acertado :( ");
		}
		else{
			System.out.println("El oponente a fallado...:) ");
		}
	}
	public static void respuesta2(boolean var2) {
		if(var2){
			System.out.println("Usted a acertado :( ");
		}
		else{
			System.out.println("Usted a fallado...:) ");
		}
	}
	public static void respuesta3(boolean v){
		if(v){
			System.out.println("cordenada correcta");
		}
		else{
			System.out.println("cordenada icorrecta");
		}
	}
	public static boolean pregunta(){
		boolean bool=false;
		System.out.print("Usted a acertado con su cordenada S/N: ");
		String resp=sc.next();
		if(resp.equalsIgnoreCase("S")){
			bool=true;
		}
		return bool;
	}
	public static void titulo2(){
		System.out.print("Ingrese su cordenada:  ");
	}
	
	
	public static String[] cargarBarcoPs(String[] tableroContrincante, String nm) {
		
				tableroContrincante[conta]=nm;
				conta++;
		return tableroContrincante;
	}

	

	public static int buscarRepetido(String[] s, String c){
		int n=-1;
		System.out.println("c="+c);
		for(int i=0;i<s.length;i++){
			String st=String.valueOf(s[i]);
			
			if(st.equalsIgnoreCase(c)){
			
				n=i;
			}
		}
		
		return n;
	}
	public static boolean verificarRepetido(int n){
		boolean variable=false;
		if(n!=-1){
			variable=true;
		}
		
		return variable;
	}
	public static void estadoDelJuego(int aciertosPropios, int aciertosContrarios, int cantidadBarcos){

		int total=cantidadBarcos-aciertosContrarios;
			System.out.println("Estado del juego");
			System.out.println("Cantidad de aciertos oponente: "+aciertosContrarios);
			System.out.println("Cantidad de aciertos propios: "+aciertosPropios);
			System.out.println("Cantidad de barcos propios que quedan sin undir: "+total);

		
	}
	
	public static void tituloInicio(){
		System.out.println("******** Inicio del Juego.... **********");
		System.out.println();
	}
	
	public static int menu(){
		System.out.println();
		System.out.println("     ELIJA UNA OPCION DEL MENU    ");
		System.out.println();
		System.out.println(" 1_ JUGAR SU TURNO ");
		System.out.println(" 2_ JUGAR TURNO OPONENTE");
		System.out.println(" 3_ ESTADO DEL JUEGO. ");
		System.out.println(" 4_ SALIR ");
		 int n=sc.nextInt();
		return n;
	}
	
	public static boolean verificadorCordenadadContigua(int a, int b, int c, int d, int tamanioArreglo ){
		boolean var=false;
		
		
		if(a==1 && b==1){//VERIFIVO ESQUINA SUPERIOR IZQUIERDA
			
			if((c==(a+1) && d==b) || (d==(b+1) && c==a)){					
					var=true;
			}
		}else
			if(a==1 && b==tamanioArreglo){//VERIFICO ESQUINA INFERIOR IZQUIERDA
				if((c==a+1 && d==b) || (d==b-1 && c==a)){
					var=true;
				}
			}else
				if(a==tamanioArreglo && b==1){//VERIFICO ESQUINA SUPERIOR DERECHA
					if((c==a-1 && d==b) || (d==b+1 && c==a)){
						var=true;
					}
				}
			else
				if((a>1 && a<tamanioArreglo) && (b>1 && b<tamanioArreglo)){//VERIFICO COORDENADAS DEL CENTRO
					if((c==a+1 && d==b) || (c==a-1 && d==b) || (d==b-1 && c==a) || (d==b+1 && c==a)){
						var=true;
					}
				}else
					if(a==tamanioArreglo && b==tamanioArreglo){//VERIFICO ESQUINA INFERIOR DERECHA
						if((c==a-1 && d==b) || (d==b-1 && c==a)){
							var=true;
						}
				}else
					if((a>1 && a<tamanioArreglo) && b==tamanioArreglo){//VERIFICO CENTRO INFERIOR
						if((c==a+1 && d==b) || (c==a-1 && d==b) || (d==b-1 && c==a)){
							var=true;
						}
					}else
						if(a==1 && (b>1 && b<tamanioArreglo)){//VERIFICO CENTRO IZQUIERDO
							if((d==b+1 && c==a) || (d==b-1 && c==a) || (c==a+a && d==b)){
								var=true;
							}
						}else
							if(b==1 && (a>1 && a<tamanioArreglo)){//VRIFICO CENTRO SUPERIOR
								if((c==a+1 && d==b) || (c==a-1 && d==b) || (d==b+1 && c==a)){
									var=true;
								}
							}else
								if(a==tamanioArreglo && (b>1 && b<tamanioArreglo)){//VERIFICO CENTRO DERECHO
									if((d==b+1 && c==a) || (d==b-1 && c==a) || (c==a-1 && d==b)){
										var=true;
									}
								}
		return var;
	}
	public static boolean validarEntrada(String entrada){//Sin Espacios
		return ((entrada.matches("[A-Ja-j]+([1-9][0])+[A-Ja-j]+([1-9][0])")) || 
				(entrada.matches("[A-Ja-j]+[1-9]+[A-Ja-j]+[1-9]")) || 
				(entrada.matches("[A-Ja-j]+([1-9][0])+[A-Ja-j]+[1-9]")) ||
				(entrada.matches("[A-Ja-j]+[1-9]+[A-Ja-j]+([1-9][0])")));
	}
	public static boolean validarEntrada2(String entrada){//Sin Espacios
		return ((entrada.matches("[A-Ja-j]+([1-9][0])")) || 
				(entrada.matches("[A-Ja-j]+[1-9]")));
	}
	
	public static boolean verificoCordenadaEnElTablero(String cadena,int tamanioTablero){
		boolean v2=false;
		
			char a1=cadena.charAt(0);
			
			char b1=cadena.charAt(1);
			
			char c1=cadena.charAt(2);
			
			char d1=cadena.charAt(3);
			
			//PROCESO LOS CHAR
			int a=(Character.digit(a1, 32)-9);
			int b=(Character.digit(b1, 16));
			int c=(Character.digit(c1, 32)-9);
			int d=(Character.digit(d1, 16));
					
			
			v2=verificadorCordenadadContigua(a, b, c, d, tamanioTablero);
		return v2;
	}
}
	
