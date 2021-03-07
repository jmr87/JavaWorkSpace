package beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu1 {

	/*
	 * Primero inicializamos las variables del scanner, la lista de coches y los
	 * ficheros que utilizaremos para guardar los datos.
	 */

	private static Scanner sc;
	private static List<Coche1> listaCoches = new ArrayList<Coche1>();

	public static final String nombreFichero = "coches.dat";
	public static final String nombreFichero1 = "coches.txt";

	public static void main(String[] args) {

		/*
		 * Despues comprobamos si el fichero coches.dat existe, de ser así, se mostrarán
		 * por pantalla los datos del fichero y automaticamente se guardarán en la lista
		 * de coches para poder trabajar en el menú.
		 */

		sc = new Scanner(System.in);

		File file = new File(nombreFichero);
		int opc;

		if (file.exists()) {
			System.out.println("Se ha comprobado que existe un fichero con el nombre coches.dat \n"
					+ "------------------------------------------------------- \n"
					+ "A continuación se mostrará en pantalla su contenido y se procederá al volcado de datos en un ArrayList vacia \n");
			try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
				List<Coche1> listaCoche = (List<Coche1>) ois.readObject();

				for (Coche1 c : listaCoche) {
					System.out.println(c + "\n");
					listaCoches.add(c);
				}
				System.out.println("Objetos Coche del fichero coches.dat introducidos en el ArrayList \n");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		/*
		 * 
		 * Hacemos un switch con el menu donde ponemos los métodos que realizará según
		 * la opción de desee el usuario.
		 */

		do {
			menuPr();

			switch (opc = Integer.parseInt(sc.nextLine())) {
			case 1:
				añadirCoche();

				break;
			case 2:
				borrarCoche();
				break;
			case 3:
				consultarCoche();
				break;
			case 4:
				listarCoches();
				break;
			case 5:
				exportarTxt();
				break;
			case 6:
				terminar();
				break;

			default:
				System.out.println("Por favor marque una opción de la lista \n");
				break;
			}

		} while (opc != 6);

	}

	private static void menuPr() {

		System.out.println("    CONCESIONARIO JAMARO \n" + "-------------------------- \n"
				+ "Por favor elija una opcion \n \n" + "1. Añadir nuevo coche \n" + "2. Borrar coche por id \n"
				+ "3. Consultar coche por id \n" + "4. Listar coches \n" + "5. Exportar coches a archivo de texto \n"
				+ "6. Terminar programa \n");

	}

	/*
	 * 
	 * Método por el cual añadimos nuevos coches a la lista. Preguntará al usuario
	 * por los campos a rellenar excepto el id que es autoincremental.
	 * 
	 */
	public static void añadirCoche() {

		int nuevoId = 0;
		String nuevaMatricula = "";
		String nuevaMarca = "";
		String nuevoModelo = "";
		String nuevoColor = "";

		for (Coche1 c : listaCoches) {
			nuevoId = c.getId();
			if (nuevoId == c.getId()) {

			}
			nuevoId++;
		}

		System.out.println("Por favor escriba una matricula");
		nuevaMatricula = sc.nextLine();

		System.out.println("Por favor escriba una marca de coche");
		nuevaMarca = sc.nextLine();

		System.out.println("Por favor escriba un módelo de coche");
		nuevoModelo = sc.nextLine();

		System.out.println("Por favor escriba un color para el coche");
		nuevoColor = sc.nextLine();

		Coche1 coche = new Coche1(nuevoId, nuevaMatricula, nuevaMarca, nuevoModelo, nuevoColor);

		listaCoches.add(coche);

		System.out.println("Coche añadido correctamente \n");

	}

	// Método por el cual borramos coches según el id que nos de el usuario.

	public static void borrarCoche() {

		int id;

		System.out.println("Por favor indica un id de coche para borrarlo de la lista");
		id = Integer.parseInt(sc.nextLine());
		try {
			for (Coche1 coche : listaCoches) {
				if (id == (coche.getId())) {
					listaCoches.remove(coche);
					System.out.println("El coche con id: " + id + " ha sido borrado\n");
				}
			}
		} catch (Exception e) {
			System.out.println("No se ha podido borrar el coche.");
		}

	}

	// Método para consultar un coche

	public static void consultarCoche() {
		int id;
		System.out.println("Por favor indica un id para consultar coche");
		id = Integer.parseInt(sc.nextLine());
		
		System.out.println("--------------------------------------------------------------------\n");

		for (Coche1 coche : listaCoches) {

			if (id == (coche.getId())) {

				System.out.println("Estos son los coches con id " + id + ":\n");
				System.out.println(
						coche + "\n" + "--------------------------------------------------------------------\n");
			
			}
			
		}
		
	}

	// Método para listar todos los coches de la lista.
	public static void listarCoches() {

		if (listaCoches.isEmpty()) {
			System.out.println("Todavia no tienes coches añadidos a la lista \n");
		} else {
			System.out.println("Estos son todos los coches que has añadido en la lista: \n"
					+ "-----------------------------------------------------------------");

			for (Coche1 coche : listaCoches) {
				System.out.println(coche + "\n" + "-----------------------------------------------------------------");
			}
		}
	}

	// Método para crear y exportar lso datos de los coches a un fichero de texto.
	public static void exportarTxt() {

		try (FileOutputStream fos1 = new FileOutputStream(nombreFichero1);
				ObjectOutputStream oos1 = new ObjectOutputStream(fos1);) {
			for (Coche1 c : listaCoches) {
				oos1.writeObject(c.toString());
			}
			System.out.println("Objetos guardados en el fichero coches.txt \n");
		} catch (IOException e) {
			System.out.println("Ocurrio un error al guardar los objetos en el fichero");
			e.printStackTrace();
		}
		menuPr();

	}

	// Con este método terminamos el programa y automáticamente se guardaran
	// los datos de lso coches en el fichero coches.dat.

	public static void terminar() {

		try (FileOutputStream fos = new FileOutputStream(nombreFichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(listaCoches);
			System.out.println("Objetos guardados en el fichero coches.dat \n");
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Hasta pronto, gracias por establecer conexión");

		sc.close();
	}

}
