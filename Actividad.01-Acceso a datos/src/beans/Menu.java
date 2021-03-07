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

public class Menu {

	public static final String nombreFichero = "coches.dat";
	public static final String nombreFichero1 = "coches.txt";

	private static String menuIni() {

		return "    CONCESIONARIO JAMARO \n" + "-------------------------- \n" + "Por favor elija una opcion \n \n"
				+ "1. Añadir nuevo coche \n" + "2. Borrar coche por id \n" + "3. Consultar coche por id \n"
				+ "4. Listar coches \n" + "5. Exportar coches a archivo de texto \n" + "6. Terminar programa \n";
	}

	public static void main(String[] args) {
		List<Coche> listaCoches = new ArrayList<Coche>();
		File file = new File(nombreFichero);

		if (file.exists()) {
			System.out.println("Se ha comprobado que existe un fichero con el nombre coches.dat \n"
					+ "------------------------------------------------------- \n"
					+ "A continuación se mostrará en pantalla su contenido y se procederá al volcado de datos en un ArrayList vacia \n");
			try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
				List<Coche> listaCoche = (List<Coche>) ois.readObject();

				for (Coche c : listaCoche) {
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

		System.out.println(menuIni());

		String nuevoId = "";
		String nuevaMatricula = "";
		String nuevaMarca = "";
		String nuevoModelo = "";
		String nuevoColor = "";
		String ide = "";

		Scanner sc = new Scanner(System.in);

		String opcion = sc.nextLine();

		do {

			if (opcion.equalsIgnoreCase("1")) {

				System.out.println("Por favor escriba un id para el coche");
				nuevoId = sc.nextLine();

				System.out.println("Por favor escriba una matricula");
				nuevaMatricula = sc.nextLine();

				System.out.println("Por favor escriba una marca de coche");
				nuevaMarca = sc.nextLine();

				System.out.println("Por favor escriba un módelo de coche");
				nuevoModelo = sc.nextLine();

				System.out.println("Por favor escriba un color para el coche");
				nuevoColor = sc.nextLine();

				Coche coche = new Coche(nuevoId, nuevaMatricula, nuevaMarca, nuevoModelo, nuevoColor);

				listaCoches.add(coche);

				System.out.println("Coche añadido correctamente \n");

				System.out.println(menuIni());

				opcion = sc.nextLine();

			} else if (opcion.equalsIgnoreCase("2")) {

				System.out.println("Por favor indica un id de coche para borrarlo de la lista");
				ide = sc.nextLine();
				try {
					for (Coche coche : listaCoches) {
						if (ide.equalsIgnoreCase(coche.getId())) {
							listaCoches.remove(coche);
							System.out.println("El coche con id: " + ide + " ha sido borrado\n");
						}

					}

				} catch (Exception e) {
					
				}

				System.out.println(menuIni());
				opcion = sc.nextLine();

			} else if (opcion.equalsIgnoreCase("3")) {
				System.out.println("Por favor indica un id para consultar coche");
				ide = sc.nextLine();
				System.out.println("--------------------------------------------------------------------\n");
				
				for (Coche coche : listaCoches) {
					
					if (ide.equalsIgnoreCase(coche.getId())) {
						
						System.out.println("Estos son los coches con id " + ide + ":\n");
						System.out.println(coche + "\n"
								+ "--------------------------------------------------------------------\n");	
						
					}
				}
				System.out.println(menuIni());
				opcion = sc.nextLine();

			} else if (opcion.equalsIgnoreCase("4")) {
				if (listaCoches.isEmpty()) {
					System.out.println("Todavia no tienes coches añadidos a la lista \n");
				} else {
					System.out.println("Estos son todos los coches que has añadido en la lista: \n"
							+ "-----------------------------------------------------------------");

					for (Coche coche : listaCoches) {
						System.out.println(
								coche + "\n" + "-----------------------------------------------------------------");
					}
				}

				System.out.println(menuIni());
				opcion = sc.nextLine();
			} else if (opcion.equalsIgnoreCase("5")) {

				try (FileOutputStream fos1 = new FileOutputStream(nombreFichero1);
						ObjectOutputStream oos1 = new ObjectOutputStream(fos1);) {
					for (Coche c : listaCoches) {
						oos1.writeObject(c.toString());
					}
					System.out.println("Objetos guardados en el fichero coches.txt \n");
				} catch (IOException e) {
					System.out.println("Ocurrio un error al guardar los objetos en el fichero");
					e.printStackTrace();
				}
				System.out.println(menuIni());
				opcion = sc.nextLine();
			} else {
				System.out.println("Por favor escriba una opcion correcta.");
				System.out.println(menuIni());
				opcion = sc.nextLine();
			}

		} while (!opcion.equalsIgnoreCase("6"));

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
