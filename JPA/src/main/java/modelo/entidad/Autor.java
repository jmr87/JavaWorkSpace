package modelo.entidad;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "autores")
public class Autor {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellidos;
	
	
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	//Relación OneToMany porque un autor puede escribir muchos libros.
	
	@OneToMany(mappedBy="autor", cascade=CascadeType.ALL)
	private List<Libro> libros;
	
	public Autor() {
		super();
	}

	public Autor(Integer id, String nombre, String apellidos, Date fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [ nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	
	
}	