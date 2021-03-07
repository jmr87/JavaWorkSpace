package prueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;



public class Prueba {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
			
		EntityManager em = null;
		
		//Instanciamos los autores
		
		Autor a1 = new Autor(null,"Jose","perez",new Date());
		Autor a2 = new Autor(null,"Enrique","Delgado Espinosa",new Date());
		Autor a3 = new Autor(null,"Maria","Gutierrez Cano",new Date());
		Autor a4 = new Autor(null,"Jhon","Adams",new Date());
		Autor a5 = new Autor(null,"Laura","Martinez Tello",new Date());
		
		//Instanciamos las editoriales
		
		Editorial e = new Editorial(null,"SAS");
		Editorial e1 = new Editorial(null,"Paginas");
		Editorial e2 = new Editorial(null,"Santillana");
		
		//Añadimos la dirección a las editoriales
		
		Direccion d = new Direccion();
		d.setTipoVia("Av");
		d.setNombreVia("España");
		d.setCiudad("Madrid");
		
		e.setDireccion(d);
		
		Direccion d1 = new Direccion();
		d1.setTipoVia("Calle");
		d1.setNombreVia("Francia");
		d1.setCiudad("Madrid");
		
		e1.setDireccion(d1);
		
		Direccion d2 = new Direccion();
		d2.setTipoVia("Calle");
		d2.setNombreVia("Pantone");
		d2.setCiudad("Barcelona");
		
		e2.setDireccion(d2);
		
		//Instanciamos los libros
		
		Libro l1 =new Libro(null,"Soles",45,a1,e);
		Libro l2 =new Libro(null,"Rocio del alba",58,a2,e2);
		Libro l3 =new Libro(null,"Los crimenes de Tom",16,a3,e1);
		Libro l4 =new Libro(null,"Una noche deseada",25,a4,e);
		Libro l5 =new Libro(null,"Sin ti nada",32,a5,e2);
		Libro l6 =new Libro(null,"Todo vale",41,a1,e1);	
		Libro l7 =new Libro(null,"Luz de tus ojos",48,a2,e);
		Libro l8 =new Libro(null,"Detras de tu mirada",29,a3,e2);
		Libro l9 =new Libro(null,"Bipolar",19,a4,e1);
		Libro l10 =new Libro(null,"Los caños",40,a5,e2);
		Libro l11=new Libro(null,"El astronauta y la flor",31,a1,e);
		Libro l12 =new Libro(null,"Camino a tu ser",23,a2,e1);
		
		//Asignamos a cada autor sus libros
		
		List<Libro>librosJose = new ArrayList<Libro>();
		librosJose.add(l1);
		librosJose.add(l6);
		librosJose.add(l11);
		
		a1.setLibros(librosJose);
		
		List<Libro>librosEnrique = new ArrayList<Libro>();
		librosEnrique.add(l2);
		librosEnrique.add(l7);
		librosEnrique.add(l12);
		a2.setLibros(librosEnrique);
		
		List<Libro>librosMaria = new ArrayList<Libro>();
		librosMaria.add(l3);
		librosMaria.add(l8);
		a3.setLibros(librosMaria);
		
		List<Libro>librosJhon = new ArrayList<Libro>();
		librosJhon.add(l4);
		librosJhon.add(l9);
		a4.setLibros(librosJhon);
				
		List<Libro>librosLaura = new ArrayList<Libro>();
		librosLaura.add(l5);
		librosLaura.add(l10);
		a5.setLibros(librosLaura);
		
		//Asignamos a cada editorial sus libros
		
		List<Libro> ediSAS =new ArrayList<Libro>();
		ediSAS.add(l1);
		ediSAS.add(l4);
		ediSAS.add(l7);
		ediSAS.add(l12);
		e.setLibros(ediSAS);
		
		List<Libro> ediPaginas =new ArrayList<Libro>();
		ediPaginas.add(l3);
		ediPaginas.add(l6);
		ediPaginas.add(l9);
		ediPaginas.add(l11);
		e1.setLibros(ediPaginas);
		
		List<Libro> ediSantillana =new ArrayList<Libro>();
		ediSantillana.add(l2);
		ediSantillana.add(l5);
		ediSantillana.add(l8);
		ediSantillana.add(l10);
		e2.setLibros(ediSantillana);
		
		//Instanciamos las librerias y le damos una dirección
		
		Libreria li1 = new Libreria(null,"Ahora que leo","Juan",null);				
		Libreria li2 = new Libreria(null,"Lecturas","Pedro",null);
		
		Direccion d3 = new Direccion();
		d3.setTipoVia("Calle");
		d3.setNombreVia("Libertad");
		d3.setCiudad("Barcelona");
		
		li2.setDireccion(d3);
		
		Direccion d4 = new Direccion();
		d4.setTipoVia("Calle");
		d4.setNombreVia("Garcilaso");
		d4.setCiudad("Madrid");
		
		li1.setDireccion(d4);
		
		//Asignamos a cada libreria los libros que tiene
		
		List<Libreria> libreriasl1 = new ArrayList<Libreria>();
		libreriasl1.add(li1);
		l1.setLibrerias(libreriasl1);
		l2.setLibrerias(libreriasl1);
		l3.setLibrerias(libreriasl1);
		l4.setLibrerias(libreriasl1);
		l5.setLibrerias(libreriasl1);
		l6.setLibrerias(libreriasl1);
		
		List<Libreria> libreriasl2 = new ArrayList<Libreria>();
		libreriasl1.add(li2);
		l7.setLibrerias(libreriasl2);
		l8.setLibrerias(libreriasl2);
		l9.setLibrerias(libreriasl2);
		l10.setLibrerias(libreriasl2);
		l11.setLibrerias(libreriasl2);
		l12.setLibrerias(libreriasl2);
		
		List<Libro>librosLibreria1 = new ArrayList<Libro>();
		librosLibreria1.add(l1);
		librosLibreria1.add(l2);
		librosLibreria1.add(l3);
		librosLibreria1.add(l4);
		librosLibreria1.add(l5);
		librosLibreria1.add(l6);
		
		li1.setLibros(librosLibreria1);
		
		List<Libro>librosLibreria2 = new ArrayList<Libro>();
		librosLibreria2.add(l7);
		librosLibreria2.add(l8);
		librosLibreria2.add(l9);
		librosLibreria2.add(l10);
		librosLibreria2.add(l11);
		librosLibreria2.add(l12);
		
		li2.setLibros(librosLibreria2);
				
		//Una vez que tenemos todo el módelo de bases de datos, persistimos toda la información
		
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(a1); 
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.persist(a5);
		
		System.out.println(" ----- Dando de alta los autores con sus libros ----- ");
		
		em.persist(e);
		em.persist(e1);
		em.persist(e2);
		
		System.out.println("-------Dando de alta las editoriales con sus libros------");
		
		em.persist(li1);
		em.persist(li2);
		
		System.out.println("------Dando de alta las librerias con sus libros----------");
		
		em.getTransaction().commit(); 
		
		//Primera consulta para listar todos los libros con sus autores y editoriales.
		
		Query query = em.createQuery("Select l from Libro l");
		List<Libro> list = query.getResultList();
		System.out.println("==== listado de libros ====");
		listarLibros(list);
		
		//Segunda consulta para listar los autores con sus libros
		
		Query query1 = em.createQuery("Select  l.autor, l.titulo from Libro l order by l.autor");
		List<Object[]> listaAutores = query1.getResultList();
		System.out.println("==== listado de Autores con sus libros ====");
		for(Object[] lib :listaAutores) {
			System.out.println(lib[0]+ " - " + lib[1]);
		}
		
		//Consulta para listar las librerias con susu libros
		
		Query query2 = em.createQuery("Select l.nombre, li.titulo from Libreria l join l.libros li group by li.titulo");
        List<Object[]> listaLibrerias = query2.getResultList();
        System.out.println("==== listado de librerias con sus libros ====");
        for(Object[] libro :listaLibrerias) {
            System.out.println("Libreria: "+ libro[0]+", libro:" + libro[1] );
        }
        
        //Consulta para listar los libros y las librerias que lo tienen

        Query query3 = em.createQuery("Select l.titulo, li.nombre from Libro l  join l.librerias li ");
        List<Object[]> listaLibros = query3.getResultList();
        System.out.println("==== listado de Libros con sus librerias ====");
        for(Object[] libro :listaLibros) {
            System.out.println("Libro: "+ libro[0]+", libreria:" + libro[1] );
        }

		em.close();	
		
		emf.close();
	
	}
	public static void listarLibros(List<Libro>listaLibros) {
		for(Libro l : listaLibros) {
			System.out.println("Nombre del libro: " + l.getTitulo());
			System.out.println("Autor del libro: " + l.getAutor().getNombre());
			System.out.println("Editorial del libro: " + l.getEditorial().getNombre());
			System.out.println("--------------------");
		}
	}
	
		
}
