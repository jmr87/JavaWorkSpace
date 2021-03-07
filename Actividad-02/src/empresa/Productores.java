package empresa;

import correos.Emails;

//Clase Productores que extiende de Thread por lo que será un hilo.

public class Productores extends Thread {
	
	public Buffer buffer;
	public String nombre;
	public int id;
	
	
		
	public Productores() {
		super();
	}

//Contructor de la clase Productores.
	
	public Productores(String nombre,Buffer buffer) {
		
		this.buffer=buffer;
		this.nombre=nombre;
		
		
	}

//Método run(), donde especificaremos cual será la función de la clase.
	
	public void run() {

/*
 * Cómo van a ser 3 Productores, hacemos un bucle for de 10 repeticiones para que en total
 * generen 30 Emails. Instanciamos el Generador de Emails y cada vez que produzcamos un Email
 * lo meteremos en el buffer, siempre se sea posible. Además cada vez que introduzcamos un Email
 * en el buffer, pondremos por consola que productor a generado el Email y el Id de dicho Email.
 * 
*/		
		GeneradorEmails ge = new GeneradorEmails();
		for(int i = 1;i <= 10;i++){
			try {
				Thread.sleep(500);
				
								
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			Emails emails = ge.generarEmail();
			buffer.addMensaje(emails);
			System.out.println( nombre + " ha producido el email " + emails.getId());
			
		}
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
