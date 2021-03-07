package modelo.entidad;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editoriales")
public class Editorial {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	//Dirección embebida
		
	@Embedded
	private Direccion direccion;
	
	//Una editorial tiene muchos libros
	
	@OneToMany(mappedBy="editorial", cascade=CascadeType.ALL)
	private List<Libro> libros;
	
	
	public Editorial(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;		
		
	}


	public Editorial() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public List<Libro> getLibros() {
		return libros;
	}


	public void setLibros(List<Libro> libros2) {
		this.libros = libros2;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	
}
