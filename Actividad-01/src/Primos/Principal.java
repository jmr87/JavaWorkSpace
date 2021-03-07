package Primos;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
//Iniciamos la funci�n Scanner		
		Scanner lector = new Scanner(System.in);
		
//Damos la bienvenida al programa y preguntamos si queremos guardar la informaci�n en un fichero externo.
		
		System.out.println("En este programa podremos saber si un n�mero es primo o no.");
		System.out.println("�Desea guardar los resultados obtenidos en un fichero por cada hilo?");

		String generarFichero = lector.nextLine();

		if (generarFichero.equalsIgnoreCase("si")) {
			System.out.println("Muy bien, el resultado se guardar� en un fichero externo");

		} else {
			System.out.println("Los resultados obtenidos no se guardar�n en un fichero.");
		}

		System.out.println("Por favor ingrese 4 n�meros.");

//Ingresamos los 4 n�meros que nos pide el programa	
		
		int n1 = lector.nextInt();
		int n2 = lector.nextInt();
		int n3 = lector.nextInt();
		int n4 = lector.nextInt();

//Declaramos cada hilo, que ser�n 4, uno por cada n�mero	
		
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

//Ejecutamos los 4 hilos, los cuales nos dir�n si los n�meros ingresados son primos o no.	
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		lector.close();

	}

}
