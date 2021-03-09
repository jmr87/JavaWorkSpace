package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HiloEscuchador implements Runnable {

	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeCliente;
//
	public HiloEscuchador(Socket cliente) {

		numCliente++;
		hilo = new Thread(this, "Cliente_" + numCliente);
		this.enchufeCliente = cliente;
		hilo.start();
	}

	private String menu() {

		return "Por favor elija una opcion \n \n" + "1. Consultar libro por ISBN \n"
				+ "2. Consultar libro por titulo \n" + "3. Consultar libro por autor \n" + "4. Añadir libro \n"
				+ "5. Salir de la aplicacion \n";
	}

	@Override
	public void run() {

		ArrayList<Libros> listaLibros = new ArrayList<Libros>();
		listaLibros.add(new Libros("1", "La mentira", "Fede", "10.50"));
		listaLibros.add(new Libros("2", "La Verdad", "Juan", "15.40"));
		listaLibros.add(new Libros("3", "El amor", "Jose", "Pepe", "19.99"));
		listaLibros.add(new Libros("4", "El odio", "Adolfo", "20.50"));
		listaLibros.add(new Libros("5", "La confianza", "Julia", "10.80"));

		System.out.println("Estableciendo comunicación con " + hilo.getName());
		DataOutputStream salida = null;
		DataInputStream entrada = null;

		try {

			salida = new DataOutputStream(enchufeCliente.getOutputStream());
			entrada = new DataInputStream(enchufeCliente.getInputStream());

			boolean continuar = true;

			while (continuar) {

				String opcion = "";
				String isbn = "";
				String titulo = "";
				String autor = "";
				String dosAutores = "";
				String nuevoIsbn = "";
				String nuevoTitulo = "";
				String nuevoAutor = "";
				String nuevoAutor2 = "";
				String nuevoPrecio = "";

				opcion = entrada.readUTF();
				if (opcion.equalsIgnoreCase("5")) {

					salida.writeUTF("Hasta pronto, gracias por establecer conexión");
					System.out.println(hilo.getName() + " ha cerrado la comunicación");

					continuar = false;

				} else if (opcion.trim().equalsIgnoreCase("1")) {
					salida.writeUTF("Por favor selecciona un ISBN del 1 al 5: (Escriba 'Volver' para ir al menu) \n");
					System.out.println("El cliente quiere consultar libro por ISBN ");
					do {
						isbn = entrada.readUTF();
						boolean sinLibro = true;
						for (Libros libro : listaLibros) {
							if (isbn.equalsIgnoreCase(libro.getIsbn())) {
								salida.writeUTF(libro.toString());
								sinLibro = false;
							}
						}
						if ((sinLibro) && (!isbn.equalsIgnoreCase("volver"))) {
							salida.writeUTF("Libro no encontrado");
						}

					} while (!isbn.equalsIgnoreCase("volver"));

					salida.writeUTF(menu());

				} else if (opcion.trim().equalsIgnoreCase("2")) {
					salida.writeUTF("Por favor escriba el nombre del titulo: (Escriba 'Volver' para ir al menu) \n");
					System.out.println("El cliente quiere consultar libro por titulo ");

					do {

						titulo = entrada.readUTF();
						boolean sinLibro = true;

						for (Libros libro : listaLibros) {

							if (titulo.trim().equalsIgnoreCase(libro.getTitulo().trim())) {
								salida.writeUTF(libro.toString());
								sinLibro = false;
							}
						}
						if ((sinLibro) && (!titulo.trim().equalsIgnoreCase("volver"))) {
							salida.writeUTF("Libro no encontrado");
						}

					} while (!titulo.equalsIgnoreCase("volver"));

					salida.writeUTF(menu());

				} else if (opcion.trim().equalsIgnoreCase("3")) {
					salida.writeUTF("Por favor escriba el nombre del autor: (Escriba 'Volver' para ir al menu) \n");
					System.out.println("El cliente quiere consultar libro por autor ");

					do {

						autor = entrada.readUTF();
						boolean sinLibro = true;

						for (Libros libro : listaLibros) {
							if (autor.trim().equalsIgnoreCase(libro.getAutor())
									|| autor.trim().equalsIgnoreCase(libro.getAutor2())) {
								salida.writeUTF(libro.toString());
								sinLibro = false;
							}
						}
						if ((sinLibro) && (!autor.trim().equalsIgnoreCase("volver"))) {
							salida.writeUTF("Libro no encontrado");
						}

					} while (!autor.equalsIgnoreCase("volver"));

					salida.writeUTF(menu());

				} else if (opcion.trim().equalsIgnoreCase("4")) {

					salida.writeUTF("¿Desea añadir un libro de dos autores? (Escriba 'Volver' para ir al menu)");
					dosAutores = entrada.readUTF();
					if (dosAutores.equalsIgnoreCase("si") && !dosAutores.equalsIgnoreCase("volver")) {
						System.out.println("El cliente quiere añadir un libro con dos autores.");

						salida.writeUTF("Escriba un numero ISBN: ");
						nuevoIsbn = entrada.readUTF();

						salida.writeUTF("Escriba el titulo del libro: ");
						nuevoTitulo = entrada.readUTF();

						salida.writeUTF("Escriba el nombre del primer autor: ");
						nuevoAutor = entrada.readUTF();

						salida.writeUTF("Escriba el nombre del segundo autor: ");
						nuevoAutor2 = entrada.readUTF();

						salida.writeUTF("Escriba el precio del libro: ");
						nuevoPrecio = entrada.readUTF();

						listaLibros.add(new Libros(nuevoIsbn, nuevoTitulo, nuevoAutor, nuevoAutor2, nuevoPrecio));

						salida.writeUTF("Nuevo libro de dos autores añadido a la biblioteca.(Escriba 'Volver' para ir al menu).");
						System.out.println("El cliente ha añadido un nuevo libro con dos autores.");

						salida.writeUTF(menu());

					} else if (dosAutores.equalsIgnoreCase("no") && !dosAutores.equalsIgnoreCase("volver")) {

						System.out.println("El cliente quiere añadir un libro.");

						salida.writeUTF("Escriba un numero ISBN: ");
						nuevoIsbn = entrada.readUTF();

						salida.writeUTF("Escriba el titulo del libro: ");
						nuevoTitulo = entrada.readUTF();

						salida.writeUTF("Escriba el nombre del primer autor: ");
						nuevoAutor = entrada.readUTF();

						salida.writeUTF("Escriba el precio del libro: ");
						nuevoPrecio = entrada.readUTF();

						listaLibros.add(new Libros(nuevoIsbn, nuevoTitulo, nuevoAutor, nuevoPrecio));

						salida.writeUTF("Nuevo libro añadido a la biblioteca.(Escriba 'Volver' para ir al menu).");
						System.out.println("El cliente ha añadido un nuevo libro.");

						salida.writeUTF(menu());
					}
				}
			}
		} catch (IOException e) {
			System.err.println("run -> " + e.getMessage());
		} finally {

			try {
				if (salida != null && entrada != null) {
					salida.close();
					entrada.close();
					enchufeCliente.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}