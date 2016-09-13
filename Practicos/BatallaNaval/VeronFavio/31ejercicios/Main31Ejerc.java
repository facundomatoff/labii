package 31ejercicios;

import java.util.Scanner;

/*CREADO POR FAVIO VERON.*/

public class Main31Ejerc {


    public static void main (String[] args) {
        int opcion=100;
        Scanner sc = new Scanner (System.in);


        System.out.println("Opciones de ejercicios: ");
            for (int i = 1;i<=31;i++){
                System.out.println("Opcion "+i+": Ejercicio "+i);
            }
        while (opcion!=0){
            System.out.println("\n\nElija que ejercicio desea ver. O presione 0(cero) para finalizar. ");
            /*for (int i = 1;i<=31;i++){
                System.out.println("Opcion "+i+": Ejercicio "+i);
            }*/ //Es demasiado engorroso que imprima siempre las 31 opciones en pantalla.

            while(true){
                try {
                    opcion = sc.nextInt();
                    break;
                }catch(java.util.InputMismatchException e) {
                    System.out.println("Ingrese un numero.");
                    sc.nextLine();
                }
            }

            switch (opcion){
                case 0: System.out.println("Finalizar");break;
                case 1: ejercicio1();break;
                case 2: ejercicio2();break;
                case 3: ejercicio3();break;
                case 4: ejercicio4();break;
                case 5: ejercicio5();break;
                case 6: ejercicio6();break;
                case 7: ejercicio7();break;
                case 8: ejercicio8();break;
                case 9: ejercicio9();break;
                case 10: ejercicio10();break;
                case 11: ejercicio11();break;
                case 12: ejercicio12();break;
                case 13: ejercicio13();break;
                case 14: ejercicio14();break;
                case 15: ejercicio15();break;
                case 16: ejercicio16();break;
                case 17: ejercicio17();break;
                case 18: ejercicio18();break;
                case 19: ejercicio19();break;
                case 20: ejercicio20();break;
                case 21: ejercicio21();break;
                case 22: ejercicio22();break;
                case 23: ejercicio23();break;
                case 24: ejercicio24();break;
                case 25: ejercicio25();break;
                case 26: ejercicio26();break;
                case 27: ejercicio27();break;
                case 28: ejercicio28();break;
                case 29: ejercicio29();break;
                case 30: ejercicio30();break;
                case 31: ejercicio31();break;
                default: System.out.println("\nOpcion incorrecta. ");break;
            }
        }
        System.out.print("\n\nEl programa ha finalizado");

        }


    static void ejercicio1(){
        System.out.println("Numeros del 1 al 100: ");
        for(int i=0;i<=100;i++){
            System.out.print(i+" ");
        }
    }


    static void ejercicio2(){
        System.out.println("Numeros del 100 al 1: ");
        for(int i=100;i>=0;i--){
            System.out.print(i+" ");
        }
    }


    static void ejercicio3(){
        int suma=0;
        for(int i=1;i<101;i++){
            suma+= i;
        }
        System.out.println("La suma de los numeros del 1 al 100 es: "+suma);
    }

    static void ejercicio4(){
        System.out.println("Los numeros pares existentes entre 1 y 100: ");
        for(int i=0;i<=100;i++){
            if (i%2==0){
                System.out.print(i+" ");
            }
        }
    }

    static void ejercicio5(){
        System.out.println("Los numeros impares existentes entre 1 y 100 son: ");
        int cantImpares=0;
        for(int i=0;i<=100;i++){
            if (i%2!=0){
                System.out.print(i+" ");
                cantImpares+=1;
            }
        }
        System.out.println("\nEntre 1 y 100 hay : " +  cantImpares+" numeros impares");
    }


    static void ejercicio6(){
        int sumaImpares=0;
        System.out.println("Los numeros impares existentes entre 100 y 1 son: ");
        for(int i=100;i>0;i--){
            if (i%2!=0){
                System.out.print(i+" ");
                sumaImpares+=i;
            }
        }
        System.out.println("\nLa sumatoria de los numeros impares existentes entre 1 y 100 es : " +sumaImpares);
    }


    static void ejercicio7(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero mayor que cero: ");
        int num = sc.nextInt();
        while(num <= 0){
            System.out.print("Numero no valido. Introduce un numero mayor que cero: ");
            num = sc.nextInt();
        }

        System.out.print("\nNumeros naturales desde el cero hasta el numero introducido: ");
        for(int i=0;i<=num;i++){
            System.out.print(i+" ");
        }
    }


    static void ejercicio8(){
        int cant=0;
        System.out.print("Multiplos de 3 existentes entre 1 y 100: \n");
        for(int i=1;i<=100;i++){
            if (i%3==0){
                System.out.print(i+" ");
                cant= cant+1;
            }
        }
        System.out.println("\nCantidad de multiplos de 3: " +  cant);
    }


    static void ejercicio9(){
        int sumaImpares=0;
        for(int i=0;i<100;i++){
            if (i%2!=0){
                sumaImpares+= i;
            }
        }
        System.out.print("La suma de los numeros impares contenidos entre 0 y 100 es: "+sumaImpares);
    }

    static void ejercicio10(){
        int cant=0;

        System.out.print("Multiplos de 5 contenidos entre 1 y 500: ");
        for(int i=1;i<=500;i++){
            if (i%5==0){
                System.out.print(i+" ");
                cant+=1;
            }
        }
        System.out.println("\nEl total de multiplos de 5 es : " +  cant);
    }


    static void ejercicio11(){
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        num = sc.nextInt();

        int suma=0,cant=0;
        System.out.println("Multiplos de 2 existentes entre 0 y el numero introducido: ");
        for(int i=0;i<=num;i++){
            if (i%2==0){
                System.out.print(i+" ");
                cant+=1;
                suma+=i;
            }

        }
        System.out.println("\nEl total de multiplos de 2: "+ cant);
        System.out.println("Suma total de los multiplos de 10: "+suma);
    }


    static void ejercicio12(){
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        num = sc.nextInt();

        int suma=0,cant=0;
        System.out.println("Multiplos de 3 existentes entre 0 y 100 ");
        for(int i=0;i<=num;i++){
            if (i%10==0){
                System.out.print(i+" ");
                cant+=1;
                suma+=i;
            }

        }
        System.out.println("El total de multiplos de 10: "+ cant);
        System.out.println("Suma total de los multiplos de 10: "+suma);
    }

    static void ejercicio13(){
        int num,suma=0,cant=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero menor que 500: ");
        num = sc.nextInt();
        while (num >= 500){
            System.out.println("Numero no valido. ntroduce un numero menor que 500: ");
            num = sc.nextInt();
        }

        System.out.print("Numeros separados entre si 8 posiciones: ");
        for(int i=num;i<=500;i=i+8){
            System.out.print(i+" ");
            cant=cant+1;
            suma=suma+i;
        }

        System.out.println("\nCantidad total: "+ cant);
        System.out.println("Suma total de numeros: "+suma);
    }


    static void ejercicio14(){
        int suma=0;
        for(int i=0;i<=100;i++){
            if (i%2==0){
                suma+=(i*i);
            }
        }
        System.out.print("La suma de los cuadrados de los numeros pares comprendidos entre 0 y 100 es: "+suma);
    }


    static void ejercicio15(){
        int num,sumatoria=0;
        Scanner sc = new Scanner (System.in);

        System.out.println("Ingrese un numero positivo y menor que 100");
        num = sc.nextInt();
        while(num >= 100 || num <= 0){
            System.out.println("El numero ingresado no es valido. Por favor ingrese nuevamente: ");
            num = sc.nextInt();
        }
        for (int i=1;i<=num;i+=4){
            sumatoria+=Math.pow(i, 2);
        }
        System.out.println("La sumatoria de los cuadrados comprendidos entre 0 y el numero ingresado es: "+Math.pow(num, 2));
    }


    static void ejercicio16(){
        int num;
        Scanner sc = new Scanner (System.in);

        System.out.println("Ingrese un numero distinto de cero: ");
        num = sc.nextInt();
        while(num == 0){
            System.out.println("El numero ingresado no es valido. Por favor ingrese nuevamente: ");
            num = sc.nextInt();
        }
        if (num > 0){
            System.out.println("Ha ingresado un numero positivo: ");
        } else{
            System.out.println("Ha ingresado un numero negativo");
        }

    }

    static void ejercicio17(){
        int num;
        Scanner sc = new Scanner (System.in);

        System.out.println("Ingrese un numero distinto de cero: ");
        num = sc.nextInt();
        while(num == 0){
            System.out.println("El numero ingresado no es valido. Por favor ingrese nuevamente: ");
            num = sc.nextInt();
        }
        if (num %2 == 0){
            System.out.println("El numero ingresado es par: ");
        } else {
            System.out.println("El numero ingresado es impar");
        }

    }

    static void ejercicio18(){
        int num,cantidadMultiplos=0;
        Scanner sc = new Scanner (System.in);

        System.out.println("Ingrese un numero positivo");
        num = sc.nextInt();
        while(num <= 0){
            System.out.println("El numero ingresado no es valido. Por favor ingrese nuevamente: ");
            num = sc.nextInt();
        }
        System.out.println("\nLos numeros multiplos de 3 son: ");
        for (int i=1;i<=num;i++){
            if (i % 3==0){
                System.out.print(i+" ");
                cantidadMultiplos += 1;
            }

        }
        System.out.println("\nEn total hay "+cantidadMultiplos+" de multiplos de 3");

    }

    static void ejercicio19(){
        int sumatoriaPares=0,sumatoriaImpares=0;

        for (int i=1;i<=100;i++){
            if (i%2==0){
                sumatoriaPares += i;
            }else {
                sumatoriaImpares+=i;
            }
        }
        System.out.println("La sumatoria de los pares es:  "+sumatoriaPares);
        System.out.println("La sumatoria de los impares es:  "+sumatoriaImpares);
    }

    static void ejercicio20(){
        int cantMultiplos=0;
        int sumatoriaMultiplos=0;


        for (int i=1;i<=100;i++){
            if (i%2==0 || i%3==0 ){
                sumatoriaMultiplos+=i;
                cantMultiplos+= 1;
            }
        }
        System.out.println("Entre 1 y 100 hay en total "+cantMultiplos+" multiplos de 2 o 3 , y su sumatoria es :"+sumatoriaMultiplos);

    }

    static void ejercicio21(){
        int cantMultiplos=0;
        int sumatoriaMultiplos=0;

        for (int i=1;i<=100;i++){
            if (i%2==0 && i%3==0 ){
                sumatoriaMultiplos=i;
                cantMultiplos= 1;
            }
        }
        System.out.println("Entre 1 y 100 hay en total "+cantMultiplos+" multiplos de 2 y 3 , y su sumatoria es :"+sumatoriaMultiplos);
    }

    static void ejercicio22(){
        int num,max,min;
        Scanner sc = new Scanner (System.in);

        System.out.println("Introduzca numero: ");
        num = max = min = sc.nextInt();

        for (int i=0;i < 4;i++){
            System.out.println("Introduzca siguiente numero: ");
            num = sc.nextInt();
            if (num > max){
                max = num;
            }else if (num < min){
                min=num;
            }
        }

        System.out.println("El maximo de los numeros ingresados es: "+max+" y el minimo es: "+min);

    }

    static void ejercicio23(){
        int num1,num2,max,min,cantTotal=0,cantPares=0,sumatoriaImpares=0;
        Scanner sc = new Scanner (System.in);

        System.out.println("Introduzca primer numero: ");
        num1 = sc.nextInt();
        System.out.println("Introduzca segundo numero, distinto al primer numero: ");
        num2 = sc.nextInt();
        while (num1==num2){
            System.out.println("Error. El numero debe ser distinto del primero. Introduzcalo nuevamente");
            num2 = sc.nextInt();

        }

        if (num1>num2){
            max=num1;
            min=num2;
        }else {
            max=num2;
            min=num1;
        }

        System.out.println("Los numeros narturales comprendidos entre dichos numeros son");
        for (int i=min+1;i < max;i++) {
            System.out.println(i+" ");
            cantTotal+=1;
            if (i%2!=0){
                sumatoriaImpares+=i;
            }
        }

        System.out.println("Entre los numeros ingresados hay en total: "+cantTotal+" numeros");
        System.out.println("La sumatoria de los numeros impares es: "+sumatoriaImpares);

    }

    static void ejercicio24(){
        int cantidad,num;
        Scanner sc = new Scanner (System.in);

        System.out.println("Introduzca la cantidad de numeros a ingresar: ");
        cantidad = sc.nextInt();
        for (int i=0;i < cantidad;i++) {
            System.out.println("Introduzca un numero: ");
            num = sc.nextInt();
            if (num < 10){
                System.out.println("Es menor que 10");
            } else if (num > 10){
                System.out.println("Es mayor que 10");
            }

        }
    }

    static void ejercicio25(){
        System.out.println("Numeros entre 1y100 que no son multiplos de 2:");
        for (int i=0;i<=100;i++){
            if (i%2!=0){
                System.out.print(i+" ");
            }
        }
    }

    static void ejercicio26(){
        int num,suma=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un numero mayor que cero: ");
        num = sc.nextInt();
        while(num <=0){
            System.out.println("Numero no valido. Introduzca un numero mayor que cero: ");
            num = sc.nextInt();
        }

        System.out.println("Numeros entre 1 y "+num+" que no son multiplos de 5:");
        for (int i=0;i<=num;i++){
            if (i%5==0){
                suma+=i;
            } else {
                System.out.print(i+" ");
            }
        }
        System.out.println("\nLa sumatoria de los multiplos de 5 es: "+suma);

    }

    static void ejercicio27(){
        int num,suma=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un numero mayor que cero: ");
        num = sc.nextInt();
        while(num <=0){
            System.out.println("Numero no valido. Introduzca un numero mayor que cero: ");
            num = sc.nextInt();
        }

        System.out.println("Numeros entre 1 y "+num+" que son multiplos de 2 y de 3 a la vez:");
        for (int i=1;i<=num;i++){
            if (i%2==0 && i%3==0){
                System.out.print(i+" ");
                suma+=i;
            } else {
            }
        }
        System.out.println("\nLa suma de los numeros que son multiplos de 2 y de 3 a la vez es: "+suma);

    }

    static void ejercicio28(){
        int num=0,total=0,suma=0,max;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una serie de numeros. Si desea terminar ingrese una -999");

        num = sc.nextInt();
        max=num;
        if (num!=-999){
            total+=1;
        }


        while(num!=-999){
            num = sc.nextInt();
            if (num!=-999){
                total+=1;
                if (num%5==0){
                    suma+=num;
                }
                if (num > max){
                    max = num;
                }
            }
        }

        System.out.print(" En total se han introducido "+total+" numeros. La suma de los multiplos de 5 es: "+suma);

    }

    static void ejercicio29(){
        int num,max,min,total=0,cantPares=0,sumaImpares=0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero: ");
        num=sc.nextInt();
        min=num;

        System.out.print("Ingrese un mayor que el primero: ");
        num=sc.nextInt();
        while(num<=min){
            System.out.print("Numero no valido. Debe ser mayor que el primero. Ingreselo de nuevo por favor: ");
            num=sc.nextInt();
        }
        max=num;

        for (int i=min;i<=max;i+=7){
            System.out.print(i+" ");
            total+=1;
            if (i%2==0){
                cantPares+=1;
            }else {
                sumaImpares+=i;
            }
        }
        System.out.println("\nTotal de numeros separados 7 unidades: "+total);
        System.out.println("\nCantidad de numeros pares: "+cantPares);
        System.out.println("\nSuma total de los numeros impares "+sumaImpares);

    }

    static void ejercicio30(){
        float num;
        Scanner sc=new Scanner(System.in);

        System.out.print("Ingrese un numero mayor que cero: ");
        num=sc.nextFloat();
        while(num <= 0){
            System.out.print("Numero no valido. Ingrese un numero mayor que cero: ");
            num=sc.nextFloat();
        }

        if (num < 500){
            num+=num*0.5;
            System.out.print("Se ha sumado el %50 al numero ingresado\n");

        } else if (num >= 500 && num < 1000){
            num+=num*0.07;
            System.out.print("Se ha sumado el %7 al numero ingresado\n");


        } else if (num >=1000 && num < 5000){
            num-=num*0.05;
            System.out.print("Se ha restado el %5 al numero ingresado\n");


        } else {
            System.out.print("No se han realizado operaciones sobre el numero ingresado.\n");
        }

        System.out.print("\nResultado: "+num+"\n\n");



    }

    static void ejercicio31(){
        int num=-2,num1=1,num2=1,repeticiones=100;
        int terminado=0;
        Scanner sc = new Scanner(System.in);


        while(num < 0){
            System.out.print("Introduce numero mayor o igual que 0: ");
            num = sc.nextInt();

        }
        System.out.println("Los 100 términos de Fibonacci siguiente al numero ingresado son:");

        if (num == 0 ) {
        	System.out.print(1+" ");
        	repeticiones-=1;
        	num1=0;
        	num2=1;
        } else if (num == 1){
        	System.out.print(2+" ");
        	repeticiones-=1;
        }
        
        while(terminado !=1){
            
        	num2 += num1;
            num1 = num2 - num1;
            if (num2>=num ){
                if(num1>num){
                    System.out.print(num1+" ");
                    repeticiones-=1;
                }
                for(int j=0;j<repeticiones;j++){
                    num2 += num1;
                    num1 = num2 - num1;
                System.out.print(num2 +" ");
                }
                terminado =1;
            }
        }
        System.out.println();
    }
}