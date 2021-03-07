package Primos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Creamos la clase NumerosPrimos que implementa Runnable para poder trabajar con hilos.

public class NumerosPrimos implements Runnable {

//Atributos de la clase.
	private int numero;
	private String generarDocumento;

//Creamos contructor vacio
	public NumerosPrimos() {
		super();
	}

//Creamos contructor con dos parametros, el número y el String generarDocumento.
	public NumerosPrimos(int numero, String generarDocumento) {
		super();
		this.numero = numero;
		this.generarDocumento = generarDocumento;

	}

	public String getGenerarDocumento() {
		return generarDocumento;
	}

	public void setGenerarDocumento(String generarDocumento) {
		this.generarDocumento = generarDocumento;
	}

//Arrancamos el método run() que funciona cómo un main donde ira el programa que deberá realizar cada hilo.

	@Override
	public void run() {
//Variable de tiempo
		double inicio = System.currentTimeMillis();

//Iniciamos un bucle if para guardar o no el resultado en un documento
		if (getGenerarDocumento().equalsIgnoreCase("si")) {

			try {
//Se generará un documento por cada hilo, que se guardará dentro de la carpeta del proyecyo, sin sobreescribir la información anterior.
				FileWriter fl = new FileWriter(Thread.currentThread().getName() + ".txt", true);
				BufferedWriter bf = new BufferedWriter(fl);

				if (esPrimo(numero)) {
					double fin = System.currentTimeMillis();

					bf.write("El " + Thread.currentThread().getName() + " ha procesado el número " + numero
							+ ": es primo" + "->Tiempo: " + (fin - inicio) / 1000 + " seg \n"
							+ "<-------------------------------------------------------------------> \n");

				} else {
					double fin = System.currentTimeMillis();
					bf.write("El " + Thread.currentThread().getName() + " ha procesado el número " + numero
							+ ": no es primo" + "->Tiempo: " + (fin - inicio) / 1000 + " seg \n"
							+ "<----------------------------------------------------------------> \n");

				}
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
//El bucle es igual al anterior pero esta vez para sacar la información de cada hilo por consola.		
		if (esPrimo(numero)) {
			double fin = System.currentTimeMillis();
			System.out.println("El " + Thread.currentThread().getName() + " ha procesado el número " + numero
					+ ": es primo" + "->Tiempo: " + (fin - inicio) / 1000 + " seg");

		} else {
			double fin = System.currentTimeMillis();
			System.out.println("El " + Thread.currentThread().getName() + " ha procesado el número " + numero
					+ ": no es primo" + "->Tiempo: " + (fin - inicio) / 1000 + " seg");

		}

	}

//Método por el cual podemos saber si un número es primo o no.
	public static boolean esPrimo(int numero) {

		if (numero <= 1) {
			return false;
		}

		int contador = 0;

		// bucle que cuenta los numeros divisibles
		for (int i = (int) Math.sqrt(numero); i > 1; i--) {

			try {
				Thread.sleep(300);// simulacon de tarea que tarda 300 milisegungdos
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (numero % i == 0) {
				contador++;
			}
		}

		return contador < 1;
	}

}
