package modelo.entidad;


import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity

@Table(name = "librerias")
public class Libreria {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String nombre;
	private String due�o;
	
	//Direcci�n embebida
	
	@Embedded
	private Direccion direccion;
	
	//Muchas librerias para muchos libros, en esta clase creamos la joinTable con las fk de libro y liberia
	
	@ManyToMany
	@JoinTable(name="libreria_libro",
	   joinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id") }, 
	   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id")})
	private List<Libro> libros;
	
	public Libreria() {
		super();
	}
	
	
	public Libreria(Integer id, String nombre, String due�o,List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.due�o = due�o;	
		this.libros = libros;
		
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDue�o() {
		return due�o;
	}
	public void setDue�o(String due�o) {
		this.due�o = due�o;
	}
	
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", due�o=" + due�o + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}
	
	
	
	

}
