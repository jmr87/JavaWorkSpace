package server;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHilo {
	
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
			
		ServerSocket servidor = null;
		
		
		
		
		try {
			
			servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO);
			servidor.bind(direccion);
			
			System.out.println("Servidor creado por el puerto: " + PUERTO);
			System.out.println("Servidor creado por la IP Local: " + direccion.getAddress());
			
			while (true) {
				Socket enchufeAlCliente = servidor.accept();
				System.out.println("Comunicación entrante");
				new HiloEscuchador(enchufeAlCliente);
			}
			
		} catch (IOException e) {
			System.err.println("main -> " + e.getMessage());
		}finally {
			
			if(servidor!= null){
				
				try {
				
					
					servidor.close();
				
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		}
				
	}
   }	
}
