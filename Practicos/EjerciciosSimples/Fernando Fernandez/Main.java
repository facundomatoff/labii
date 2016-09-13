package Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by fer on 17/08/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0;
        while (true) {
            System.out.println("Ingrese el numero de ejercicio que desea ejecutar, para ver los problemas ejecute el 32: ");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("números del 0 al 100");
                    ejercicio1();
                    break;
                case 2:
                    System.out.println("números del 100 al 0 en orden decreciente");
                    ejercicio2();
                    break;
                case 3:
                    System.out.println("sumas de los 100 primeros números enteros");
                    ejercicio3();
                    break;
                case 4:
                    System.out.println("los números pares entre el 0 al 100");
                    ejercicio4();
                    break;
                case 5:
                    System.out.println("los números impares hasta el 100 y que imprima cuantos impares hay");
                    ejercicio5();
                    break;
                case 6:
                    System.out.println("los números impares desde el 100 hasta la unidad y que calcule su suma");
                    ejercicio6();
                    break;
                case 7:
                    System.out.println("números naturales, ingrese tope:");
                    ejercicio7(sc.nextInt());
                    break;
                case 8:
                    System.out.println("múltiplos de 3 que hay entre 1 y 100");
                    ejercicio8();
                    break;
                case 9:
                    System.out.println("suma de números impares comprendidos entre el 0 y 100");
                    System.out.println(ejercicio9());
                    break;
                case 10:
                    System.out.println("los múltiplos de 5 que hay entre 1 y 500");
                    ejercicio10();
                    break;
                case 11:
                    System.out.println("Cantidad y suma múltiplos de 2, ingrese hasta que número: ");
                    ejercicio11(sc.nextInt());
                    break;
                case 12:
                    System.out.println("Cantidad y suma múltiplos de 10, ingrese hasta que número: ");
                    ejercicio12(sc.nextInt());
                    break;
                case 13:
                    System.out.println("Introducir un número por teclado menor que 500:");
                    ejercicio13(sc.nextInt());
                    break;
                case 14:
                    System.out.println("suma de los cuadrados de los números pares entre el 0 y el 100");
                    System.out.println(ejercicio14());
                    break;
                case 15:
                    System.out.println("Introducir un número por teclado menor que 100:");
                    System.out.println(ejercicio15(sc.nextInt()));
                    break;
                case 16:
                    System.out.println("Introducir un número positivo o negativo:");
                    ejercicio16(sc.nextInt());
                    break;
                case 17:
                    System.out.println("Introducir un número par o impar");
                    ejercicio17(sc.nextInt());
                    break;
                case 18:
                    System.out.println("Multiplos de 3, ingrese un numero hasta:");
                    ejercicio18(sc.nextInt());
                    break;
                case 19:
                    System.out.println("números del 1 al 100,pares e impares:");
                    ejercicio19();
                    break;
                case 20:
                    System.out.println("múltiplos de 2 o 3 que hay del 1 al 100.");
                    ejercicio20();
                    break;
                case 21:
                    System.out.println("múltiplos de 2 y 3 que hay del 1 al 100.");
                    ejercicio21();
                    break;
                case 22:
                    System.out.println("Introduci 5 números:");
                    ejercicio22(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case 23:
                    System.out.println("Introduci 2 números diferentes:");
                    ejercicio23(sc.nextInt(), sc.nextInt());
                    break;
                case 24:
                    System.out.println("Introduci una serie de números y para finalizar ingresa una letra:");
                    a = 0;
                    int men = 0, may = 0, bol = 0;
                    while (a != 1) {


                        try {
                            switch (ejercicio24(sc.nextInt())) {
                                case 0:
                                    men++;
                                    break;
                                case 1:
                                    may++;
                                    break;
                                case -1:
                                    bol = 1;
                                    break;

                            }
                        } catch (InputMismatchException e) {
                            a = 1;
                            sc.nextLine();
                            if (bol != 1) {
                                if (men > 0 && may == 0) {
                                    System.out.println("Los numeros son menores a 10");
                                } else if (men == 0 && may > 0) {
                                    System.out.println("Los numeros son mayores a 10");
                                } else {
                                    System.out.println("Ingreso numeros mayores y menores a 10");
                                }
                            } else {
                                System.out.println("Secuencia ingresada es incorrecta");
                            }
                        }

                    }

                    break;
                case 25:
                    System.out.println("Introducir numeros entre 1 y 100 multiplos 2:");
                    ejercicio25();
                    break;
                case 26:
                    System.out.println("Ingrese un número mayor a 0:");
                    ejercicio26(sc.nextInt());
                    break;
                case 27:
                    System.out.println("Ingrese un número mayor a 1:");
                    ejercicio27(sc.nextInt());
                    break;
                case 28:
                    System.out.println("Introducir una serie de numeros");
                    ejercicio28();
                    break;
                case 29:
                    System.out.println("Introducir dos números, el primero debe ser menor que el segundo:");
                    ejercicio29(sc.nextInt(), sc.nextInt());
                    break;
                case 30:
                    System.out.println("Introducir una cantidad:");
                    System.out.println( ejercicio30(sc.nextInt()));
                    break;
                case 31:
                    System.out.println("Ingrese un numero para calcular los 100 siguientes de fibonnaci:");
                    int num = sc.nextInt();
                    for (int i = num; i < num + 100; i++) {
                        System.out.println(ejercicio31(i));
                    }
                    break;
                case 32:
                    ejercicio32();
                    break;


            }

            System.out.println("Desea ejecutar otro ejercicio? s-Si n-terminar: ");
            if (sc.next().charAt(0) == 'n') {
                break;
            }
        }


    }


    /*1. Hacer un programa que imprima los nÃºmeros del 0 al 100*/
    static void ejercicio1() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + ", ");
        }
    }
/*2. Hacer un programa que imprima los nÃºmeros del 100 al 0 en orden decreciente*/


    static void ejercicio2() {
        for (int i = 100; i >= 0; i--) {
            System.out.println(i + ", ");
        }
    }

/*3. Hacer un programa que imprima las sumas de los 100 primeros nÃºmeros enteros*/

    static void ejercicio3() {
        int suma = 0;
        for (int i = 0; i <= 100; i++) {
            suma +=i;
        }
        System.out.println(suma);
    }
/*4. Hacer un programa que imprima los nÃºmeros pares entre el 0 al 100*/

    static void ejercicio4() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + ", ");
            }

        }
    }

/*5. Hacer un programa que imprima los nÃºmeros impares hasta el 100 y que imprima cuantos impares hay*/

    static void ejercicio5() {
        int cant = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i + ", ");
                cant +=1;
            }

        }
        System.out.println("Cantidad: " + cant);
    }
/*6. Hacer un programa que imprima los nÃºmeros impares desde el 100 hasta la unidad y que calcule su suma*/

    static void ejercicio6() {
        int sum = 0;
        for (int i = 100; i > 0; i--) {
            if (i % 2 != 0) {
                System.out.println(i + ", ");
                sum = sum + i;
            }

        }
        System.out.println("suma: " + sum);
    }

/*7. Hacer un programa que imprima todos los nÃºmeros naturales que hay desde la unidad hasta un nÃºmero introducido por teclado*/

    static void ejercicio7(int num) {
        for (int i = 0; i <= num; i++) {
            System.out.println(i + ", ");
        }
    }

/*8. Hacer un  programa que imprima y cuente los mÃºltiplos de 3 que hay entre 1 y 100*/

    static void ejercicio8() {
        int cant = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i + ", ");
                cant = cant + 1;
            }

        }
        System.out.println("Cantidad: " + cant);
    }

/*9. Hacer un programa que calcule la suma de los nÃºmeros impares comprendidos entre el 0 y 100*/

    static int ejercicio9() {
        int sum = 0;
        for (int i = 100; i > 0; i--) {
            if (i % 2 != 0) {
                sum = sum + i;
            }

        }
        return sum;
    }
/*10. Hacer un algoritmo que imprima y cuente los mÃºltiplos de 5 que hay entre 1 y 500*/

    static void ejercicio10() {
        int cant = 0;
        for (int i = 1; i <= 500; i++) {
            if (i % 5 == 0) {
                System.out.println(i + ", ");
                cant = cant + 1;
            }

        }
        System.out.println("Cantidad: " + cant);
    }
/*11. Imprimir, contar y sumar los mÃºltiplos de 2 hasta un nÃºmero que introducimos por teclado*/

    static void ejercicio11(int num) {
        int sum = 0, cant = 0;
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 0) {
                System.out.println(i + ", ");
                cant = cant + 1;
                sum = sum + i;
            }

        }
        System.out.println("cantidad: " + cant);
        System.out.println("sumatoria: " + sum);
    }
/*12. Imprimir, contar y sumar los mÃºltiplos de 10 hasta un nÃºmero que introducimos por teclado*/

    static void ejercicio12(int num) {
        int sum = 0, cant = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 10 == 0) {
                System.out.println(i + ", ");
                cant = cant + 1;
                sum = sum + i;
            }

        }
        System.out.println("cantidad: " + cant);
        System.out.println("sumatoria: " + sum);
    }

    /* 13. Introducir un nÃºmero por teclado menor que 500. Imprimir, sumar y contar los nÃºmeros que estÃ¡n separadas entre si 8 posiciones, desde ese nÃºmero al 500 */
    static void ejercicio13(int num) {
        int sum = 0, cant = 0;
        if (num <= 500) {
            for (int i = num; i <= 500; i = i + 8) {

                System.out.println(i + ", ");
                cant = cant + 1;
                sum = sum + i;


            }
        }
        System.out.println("cantidad: " + cant);
        System.out.println("sumatoria: " + sum);
    }

/*14. Calcular la suma de los cuadrados de los nÃºmeros pares entre el 0 y el 100.*/

    static int ejercicio14() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum = sum + (i * i);
            }
        }
        return sum;
    }
/*15. Introducir un nÃºmero por teclado menor que 100.imprimir la suma de los cuadrados de los nÃºmeros que estÃ¡n separados entre sÃ­ 4 posiciones.*/

    static int ejercicio15(int num) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 4 == 0) {
                sum = sum + (i * i);
            }
        }
        return sum;
    }
/* 16. Introducir un nÃºmero por teclado que nos diga si es positivo o negativo . */

    static void ejercicio16(int num) {
        if (num >= 0) {
            System.out.println("El numero es positivo");
        } else {
            System.out.println("El numero es negativo");
        }
    }
/* 17. Introducir un nÃºmero por teclado. Que nos diga si es par o impar. */

    static void ejercicio17(int num) {
        if (num % 2 == 0) {
            System.out.println("El numero es par");
        } else {
            System.out.println("El numero es impar");
        }
    }
/*18. Imprimir y contar los mÃºltiplos de 3 desde la unidad hasta un nÃºmero que introducimos por teclado*/

    static void ejercicio18(int num) {
        int cant = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0) {
                System.out.println(i + ", ");
                cant = cant + 1;
            }

        }
        System.out.println("cantidad: " + cant);
    }
/* 19. Hacer un programa que imprima los nÃºmeros del 1 al 100 .que calcule la suma de todos los nÃºmeros pares por un lado y otro la de todos los impares. */

    static void ejercicio19() {
        int sump = 0, sumi = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + ", ");
            if (i % 2 == 0) {
                sump = sump + i;
            } else {
                sumi = sumi + i;
            }
        }
        System.out.println();
        System.out.println("Suma de impares: " + sumi);
        System.out.println("Suma de pares: " + sump);
    }

/*20. Imprimir y contar los nÃºmeros que son mÃºltiplos de 2 o 3 que hay del 1 al 100.*/

    static void ejercicio20() {
        int cant2 = 0, cant3 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i + ", ");
                cant3 = cant3 + 1;
            }
            if (i % 2 == 0) {
                System.out.println(i + ", ");
                cant2 = cant2 + 1;
            }

        }
        System.out.println("cantidad Mult 2: " + cant2);
        System.out.println("cantidad Mult 3: " + cant3);
    }

/*21. Imprimir y contar los nÃºmeros que son mÃºltiplos de 2 y 3 que hay del 1 al 100.*/

    static void ejercicio21() {
        int cant = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i + ", ");
                cant = cant + 1;
            }
            if (i % 2 == 0) {
                System.out.println(i + ", ");
                cant = cant + 1;

            }

        }
        System.out.println("cantidad Mult 2 Y Mult 3: " + cant);
    }

/*22. Hacer un programa que imprima el mayor el menor de una serie de cinco nÃºmeros  que vamos introduciendo por teclado.*/

    static void ejercicio22(int n1, int n2, int n3, int n4, int n5) {
        int max = n1, min = n1;
        if (max < n2) {
            max = n2;
        }
        if (max < n3) {
            max = n3;
        }
        if (max < n4) {
            max = n4;
        }
        if (max < n5) {
            max = n5;
        }
        if (min > n2) {
            min = n2;
        }
        if (min > n3) {
            min = n3;
        }
        if (min > n4) {
            min = n4;
        }
        if (min > n5) {
            min = n5;
        }
        System.out.println("Minimo: " + min);
        System.out.println("MÃ¡ximo: " + max);
    }

/*23. Introducir dos nÃºmeros por teclado. Imprimir los nÃºmeros naturales que hay entre ambos nÃºmeros empezando por el mÃ¡s pequeÃ±o, contar cuantos hay y cuÃ¡ntos de ellos son pares. Calcular la suma de los impares.*/

    static void ejercicio23(int num1, int num2) {
        int cant = 0, cantP = 0, sumI = 0;
        if (num1 > num2) {
            int aux = num2;
            num2 = num1;
            num1 = aux;
        }
        for (int i = num1; num2 >= i; i++) {
            System.out.print(i + ", ");
            cant = cant + 1;
            if (i % 2 == 0) {
                cantP = cantP + 1;
            } else {
                sumI = sumI + i;
            }
        }
        System.out.println();
        System.out.println("Cantidad de numeros: " + cant);
        System.out.println("Cantidad de numeros pares: " + cantP);
        System.out.println("Suma de numeros impares: " + sumI);
    }

/*24. Introducir una serie de nÃºmeros. Decir si esos nÃºmeros son mayores o menores de 10.*/

    static int ejercicio24(int a) {
        if (a > 10) {
            return 1;
        } else if (a < 10) {
            return 0;
        } else {
            return -1;
        }
    }

/*25. Introducir tantos números que hay entre el 1 al 100.excepto los multiplos de 2. */

    static void ejercicio25() {
        Scanner sc = new Scanner(System.in);
        int numero;
        while (true) {
            numero = sc.nextInt();
            if (numero > 0 && numero <= 100 && numero % 2 != 0) {
                System.out.println("Introdujo el número: " + numero);
            } else {
                System.out.println("Introdujo un numero incorrecto");
            }
            System.out.println("Desea terminar? escribe letra t");
            if (Character.toLowerCase(sc.next().charAt(0)) == 't') {
                break;
            }

        }
    }

    /*26 Imprimir y sumar los números desde el cero hasta un número determinado, excepto los múltiplos de 5 imprimir el valor de la suma de los mÃºltiplos de 5.*/
    static void ejercicio26(int numero) {

        int sumatoria = 0;
        for (int i = 0; i <= numero; i++) {
            if (numero % 5 != 0) {
                System.out.println(numero);
            } else {
                sumatoria += numero;
            }

        }
        System.out.println("Suma mult 5: " + sumatoria);
    }

    static void ejercicio27(int numero) {
        int cant = 0;
        for(int i=0;i<numero;i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                System.out.println(i);
                cant++;
            }
        }
        System.out.println("Cantidad de numeros: " + cant);
    }

    static void ejercicio28() {
        int num, op, sum = 0, may = Integer.MIN_VALUE, cont = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        while (true) {
            num = sc.nextInt();
            if (num > may) {
                may = num;
            }

            cont++;
            if (num % 5 == 0) {
                sum += num;

            }
            System.out.println("Desea ingresar otro numero? \n 1 - Si \n 2 - No");
            op = sc.nextInt();
            if (op == 2) {
                break;
            }
        }
        System.out.println("Suma mult5: " + sum);
        System.out.println("Mayor numero ingresado: " + may);
        System.out.println("Cantidad de numeros ingresados: " + cont);
    }

    static void ejercicio29(int num1, int num2) {
        if (num2 > num1) {
            int aux = num1 += 7, cont = 0, parC = 0, impS = 0;
            while (num2 > aux) {
                cont++;
                System.out.println(aux);
                if (aux % 2 == 0) {
                    parC++;
                } else {
                    impS += aux;
                }
                aux += 7;
            }
            System.out.println("");
        } else {
            System.out.println("Debe ingresar el primer numero menor que el segundo");
        }
    }


    static int ejercicio30(int numero) {
        if (numero < 500) {
            return (int) (numero * 1.5);
        } else if (numero < 1000) {
            return (int) (numero * 1.07);
        } else if (numero <= 5000) {
            return (int) (numero * 0.95);
        } else {
            System.out.println("Error el numero tiene que ser menor o igual a 5000");
            return 0;
        }
    }

    static long ejercicio31(int numero) {
        long aux=0,a,b;
        if (numero == 1 || numero == 2) {
            return 1;
        }

        a=0;
        b=1;
        for (int i=0;i<numero;i++) {
            aux=a+b;
            a=b;
            b=aux;
        }
        return aux;
    }

    static void ejercicio32() {
        System.out.println(
                "Ejercicios Simples Java\n" +
                        "1. Hacer un programa que imprima los números del 0 al 100\n" +
                        "2. Hacer un programa que imprima los números del 100 al 0 en orden decreciente\n" +
                        "3. Hacer un programa que imprima las sumas de los 100 primeros números enteros\n" +
                        "4. Hacer un programa que imprima los números pares entre el 0 al 100\n" +
                        "5. Hacer un programa que imprima los números impares hasta el 100 y que imprima cuantos impares hay\n" +
                        "6. Hacer un programa que imprima los números impares desde el 100 hasta la unidad y que calcule su\n" +
                        "suma\n" +
                        "7. Hacer un programa que imprima todos los números naturales que hay desde la unidad hasta un número\n" +
                        "introducido   por teclado\n" +
                        "8. Hacer un  programa que imprima y cuente los múltiplos de 3 que hay entre 1 y 100\n" +
                        "9. Hacer un programa que calcule la suma de los números impares comprendidos entre el 0 y 100\n" +
                        "10. Hacer un algoritmo que imprima y cuente los múltiplos de 5 que hay entre 1 y 500\n" +
                        "11. Imprimir, contar y sumar los múltiplos de 2 hasta un número que introducimos por teclado\n" +
                        "12. Imprimir, contar y sumar los múltiplos de 10 hasta un número que introducimos por teclado\n" +
                        "13. Introducir un número por teclado menor que 500. Imprimir, sumar y contar los números que están\n" +
                        "separadas entre si 8 posiciones, desde ese número al 500\n" +
                        "14. Calcular la suma de los cuadrados de los números pares entre el 0 y el 100.\n" +
                        "15. Introducir un número por teclado menor que 100.imprimir la suma de los cuadrados de los números que\n" +
                        "están separados entre sí 4 posiciones.\n" +
                        "16. Introducir un número por teclado que nos diga si es positivo o negativo .\n" +
                        "17. Introducir un número por teclado. Que nos diga si es par o impar.\n" +
                        "18. Imprimir y contar los múltiplos de 3 desde la unidad hasta un número que introducimos por teclado\n" +
                        "19. Hacer un programa que imprima los números del 1 al 100 .que calcule la suma de todos los números\n" +
                        "pares por un lado y otro la de todos los impares.\n" +
                        "20. Imprimir y contar los números que son múltiplos de 2 o 3 que hay del 1 al 100.\n" +
                        "21. Imprimir y contar los números que son múltiplos de 2 y 3 que hay del 1 al 100.\n" +
                        "22. Hacer un programa que imprima el mayor el menor de una serie de cinco números  que vamos\n" +
                        "introduciendo por teclado.\n" +
                        "23. Introducir dos números por teclado. Imprimir los números naturales que hay entre ambos números\n" +
                        "empezando por el más pequeño, contar cuantos hay y cuántos de ellos son pares. Calcular la suma de los\n" +
                        "impares.\n" +
                        "24. Introducir una serie de números. Decir si esos números son mayores o menores de 10.\n" +
                        "25. Introducir tantos números que hay entre el 1 al 100.excepto los múltiplos de 2.\n" +
                        "26. Imprimir y sumar los números desde el cero hasta un número determinado, excepto los múltiplos de 5\n" +
                        "imprimir el valor de la suma de los múltiplos de 5.\n" +
                        "27. Imprimir y contar los números, que son a la vez múltiplos de 2 y 3, que hay entre la unidad y el\n" +
                        "determinado número.\n" +
                        "28. Introducir una serie de números. Sumar los múltiplos  de 5. Cual es el mayor y cuántos números se han\n" +
                        "introducido.\n" +
                        "29. Introducir dos números por teclado de tal forma que el segundo sea mayor que el primero. A partir del\n" +
                        "primero. Imprimir los números separados. Entre si 7 unidades, contarlos. Cuántos de estos son pares y\n" +
                        "cuanto vale la suma de los impares.\n" +
                        "30. Introducir una cantidad por teclado. Si es menor que 500, sumarle el 50 por ciento; si es mayor o igual a\n" +
                        "500 pero menor que 1000, sumarle el 7 por ciento; si es mayor que 1000 y menor o igual a 5000, restarle el\n" +
                        "5 por ciento\n" +
                        "31. Desarrolle un programa que obtenga un número desde el teclado e imprima por consola los siguientes\n" +
                        "100 números de la serie fibonacci"


        );
    }
}