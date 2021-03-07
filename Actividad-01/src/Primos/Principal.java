package Primos;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
//Iniciamos la función Scanner		
		Scanner lector = new Scanner(System.in);
		
//Damos la bienvenida al programa y preguntamos si queremos guardar la información en un fichero externo.
		
		System.out.println("En este programa podremos saber si un número es primo o no.");
		System.out.println("¿Desea guardar los resultados obtenidos en un fichero por cada hilo?");

		String generarFichero = lector.nextLine();

		if (generarFichero.equalsIgnoreCase("si")) {
			System.out.println("Muy bien, el resultado se guardará en un fichero externo");

		} else {
			System.out.println("Los resultados obtenidos no se guardarán en un fichero.");
		}

		System.out.println("Por favor ingrese 4 números.");

//Ingresamos los 4 números que nos pide el programa	
		
		int n1 = lector.nextInt();
		int n2 = lector.nextInt();
		int n3 = lector.nextInt();
		int n4 = lector.nextInt();

//Declaramos cada hilo, que serán 4, uno por cada número	
		
		NumerosPrimos np1 = new NumerosPrimos(n1, generarFichero);
		Thread t1 = new Thread(np1);
		t1.setName("hilo1");

		NumerosPrimos np2 = new NumerosPrimos(n2, generarFichero);
		Thread t2 = new Thread(np2);
		t2.setName("hilo2");

		NumerosPrimos np3 = new NumerosPrimos(n3, generarFichero);
		Thread t3 = new Thread(np3);
		t3.setName("hilo3");

		NumerosPrimos np4 = new NumerosPrimos(n4, generarFichero);
		Thread t4 = new Thread(np4);
		t4.setName("hilo4");

//Ejecutamos los 4 hilos, los cuales nos dirán si los números ingresados son primos o no.	
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		lector.close();

	}

}
