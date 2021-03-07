package empresa;

import java.util.LinkedList;
import java.util.Queue;

import correos.Emails;

//La clase buffer nos va a permitir establecer un orden de entrada y salida de los Emails.

public class Buffer {

//Primero le decimos que el m�ximo de elementos que admita sean 5.
	
		final int MAX_ELEMENTOS = 5;
		
		private Queue<Emails> buffer = new LinkedList<>();

//Ahora vamos a contruir un m�todo para que entren los mensajes en el buffer.		
		
		public synchronized void addMensaje(Emails emails) {
			
//Al tener el buffer un n�mero m�ximo de elementos debemos decirle que deje entrar los Emails mientras el buffer no este lleno. A excepci�n de los emails dirigidos a pikachu.
			
			if(buffer.size() < MAX_ELEMENTOS){
				
				if(emails.getDestinatario().equals("Pikachu@gmail.com")) {
					System.out.println("El email con destinatario pikachu@gmailcom no ha entrado en el buffer ");
				}else {
					buffer.offer(emails);
					notify();
					
				}
				
			}
//Ponemos una condici�n; si el buffer esta lleno no deje pasar ma�s emails y espere a que haya un espacio libre. 
			
			while(buffer.size()==MAX_ELEMENTOS) {
				try {
					wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
					
				}
			}
			
				
			
			
		}
//M�todo por el cual el consumidor va cogiendo los emails del buffer para enviarlos.
		
		public synchronized Emails getMensaje() {
			
			Emails s=null;
			while(buffer.size()==0) {
				try {
				wait();
				}catch(InterruptedException e) {
				e.printStackTrace();
				}
			}
			s= buffer.poll();
			
			notify();
			return s;
			
		}
				
	
}
		
		
