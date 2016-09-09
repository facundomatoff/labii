import java.util.stream.*;

public class Practice {

	public static void main(String[] args) {
		excercise11(200);
	}
	
	/**
	 * Hacer un programa que imprima los números del 0 al 100
	 */
	public static void excercise1() {
		IntStream
			.rangeClosed(0, 100)
			.forEach(System.out::println);
	}
	
	/**
	 * Hacer un programa que imprima los números del 100 al 0 en orden decreciente
	 */
	public static void excercise2() {
		IntStream
			.range(-100, 1)
			.map(i -> Math.abs(i))
			.forEach(System.out::println);
//		Stream<Integer> l = IntStream.rangeClosed(0, 100).boxed();
//		List<Integer> list = l.collect(Collectors.toList());
//		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	/**
	 * Hacer un programa que imprima las sumas de los 100 primeros números enteros
	 */
	private static void excercise3() {
		System.out.println(IntStream.rangeClosed(0, 100).sum());
	}
	
	/**
	 * Hacer un programa que imprima los números pares entre el 0 al 100
	 */
	public static void excercise4() {
		IntStream
			.rangeClosed(0, 100)
			.filter(i -> i % 2 == 0 )
			.forEach(System.out::println);
		
	}
	
	/**
	 *  Hacer un programa que imprima los números impares hasta el 100 
	 *  y que imprima cuantos impares hay
	 */
	public static void excercise5() {
		IntStream
			.rangeClosed(0, 100)
			.filter(i -> i % 2 != 0)
			.forEach(System.out::println);
		
		System.out.println("Contidad de impares: " + IntStream.range(0, 100).filter(i -> i % 2 != 0).count());
	}
	
	/**
	 * Hacer un programa que imprima los números impares desde el 100
	 * hasta la unidad y que calcule su suma
	 */
	public static void excercise6() {
		IntStream
			.rangeClosed(-100, -1)
			.map(x -> Math.abs(x))
			.filter(i -> i % 2 != 0)
			.forEach(System.out::println);
		
		System.out.println(
				"Suma de impares: " +
				IntStream
					.rangeClosed(-100, -1)
					.map(x -> Math.abs(x))
					.filter(i -> i % 2 != 0)
					.sum()
				
				);
	}
	
	/**
	 *  Hacer un programa que imprima todos los números naturales 
	 *  que hay desde la unidad hasta un número introducido por teclado
	 */
	public static void excercise7(int n) {
		IntStream
			.rangeClosed(1, n)
			.forEach(System.out::println);
	}
	
	/**
	 * Hacer un  programa que imprima y cuente los múltiplos de 3 que
	 * hay entre 1 y 100
	 */
	public static void excercise8() {
		IntStream
			.range(1, 100)
			.filter(x -> x % 3 ==0)
			.forEach(System.out::println);
	}

	/**
	 * Hacer un programa que calcule la suma de los números impares 
	 * comprendidos entre el 0 y 100
	 */
	public static void excercise9() {
		System.out.println(
				IntStream
					.rangeClosed(0, 100)
					.filter(x -> x % 2 != 0)
					.sum()
		);
	}

	/**
	 * Hacer un algoritmo que imprima y cuente los múltiplos de 5
	 * que hay entre 1 y 500
	 */
	public static void excercise10(){
		IntStream
			.rangeClosed(1, 500)
			.filter(x -> x % 5 == 0)
			.forEach(System.out::println);
		
		System.out.println(
				"Suma de multiplos de 5: " +
				IntStream
					.rangeClosed(1, 500)
					.filter(x -> x % 5 == 0)
					.sum()
		);
	}
	
	/**
	 *  Imprimir, contar y sumar los múltiplos de 2 hasta un número 
	 *  que introducimos por teclado
	 */
	public static void excercise11(int n){
		IntStream.rangeClosed(0, n).filter(x -> x % 2 == 0).forEach(System.out::println);
		String m = Stream
				.of(
					(int)IntStream.rangeClosed(0, n).filter(x -> x % 2 == 0).count(),
					(int)IntStream.rangeClosed(0, n).filter(x -> x % 2 == 0).sum()
				)
				.map(c -> c + "")
//				.collect(
//						StringBuilder::new,
//				        StringBuilder::appendCodePoint, StringBuilder::append
//				)
				.reduce("", (x,y) -> x + "--:" + y);
		System.out.println(m);
		System.out.println("Cuantos multiplos: " + IntStream.rangeClosed(0, n).filter(x -> x % 2 == 0).count());
		System.out.println("Suma de multiplos: " + IntStream.rangeClosed(0, n).filter(x -> x % 2 == 0).sum());
	}
}

