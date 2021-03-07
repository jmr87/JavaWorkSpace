package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Clientes {

	// IP y Puerto al que conectaremos.

	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {

		System.out.println("       BIENVENIDO A LA BLIBLIOTECA");
		System.out.println("-------------------------------------------");

		Socket clientes = null;
		DataInputStream entrada = null;
		DataOutputStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		Scanner sc = new Scanner(System.in);

		try {

			clientes = new Socket();
			clientes.connect(direccionServidor);
			System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO + "\n");

			entrada = new DataInputStream(clientes.getInputStream()); // entrada de datos del servidor (from)
			salida = new DataOutputStream(clientes.getOutputStream()); // salida de datos al servidor(to)

			System.out.println("Por favor elija una opción \n");
			System.out.println("1. Consultar libro por ISBN");
			System.out.println("2. Consultar libro por título");
			System.out.println("3. Consultar libro por autor");
			System.out.println("4. Añadir libro.");
			System.out.println("5. Salir de la aplicación");

			String num = "";
			while (!num.equals("5")) {
				
				while(!num.equalsIgnoreCase("fin")){
					num = sc.nextLine();
					salida.writeUTF(num);

					String respuesta = entrada.readUTF();
					System.out.println(respuesta);
				}

				
			}

		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {

		} finally {

			try {
				if (salida != null && entrada != null) {

					salida.close();
					entrada.close();
					clientes.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sc.close();
		System.out.println("Se acabo la comunicación");
	}
}