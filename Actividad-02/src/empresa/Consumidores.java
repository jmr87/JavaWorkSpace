package empresa;

import correos.Emails;

//Clase Consumidores que extiende de Thread por lo que es un hilo.

public class Consumidores extends Thread {
	
	public String nombre;
	public Buffer buffer;
	
		
	public Consumidores() {
		super();
	}

//Constructor de la clase Consumidores. 
	
	public Consumidores(String nombre,Buffer buffer) {
		
		this.nombre=nombre;
		this.buffer=buffer;
		
		
	}
	
/*
 * Método de la clase Consumidores. Al tener dos consumidores(2hilos)vamos a hacer un bucle for
 * para que cada consumidor envie 15 Emails diferentes. Cada vez que mande un Email pondremos
 * el nombre del consumidor y los datos del Email enviado.
*/
	public void run() {
		for(int i = 1;i <= 15;i++){
			
			Emails emails = buffer.getMensaje();
			System.out.println(nombre + " ha enviado el email " + emails);
		}
		
	}

}
