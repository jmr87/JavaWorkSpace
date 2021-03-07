package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String titulo;
	private double precio;
	
	//Muchos libros para un autor
	//Siempre la FK en una relacion ManyToOne irá en la tabla de muchos.
	
	@ManyToOne
	@JoinColumn(name = "fk_id_autor", referencedColumnName = "id")
	private Autor autor;
	
	//Muchos libros para una editorial
	
	@ManyToOne	
	@JoinColumn(name = "fk_id_editorial", referencedColumnName = "id")
	private Editorial editorial;
	
	//Muchos libros para muchas librerias
	
	@ManyToMany(mappedBy = "libros", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Libreria> librerias;
	
	
	
	public Libro() {
		super();
	}
	
	public Libro(Integer id, String titulo, double precio, Autor autor, Editorial editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;		
		this.autor = autor;
		this.editorial = editorial;
		
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public List<Libreria> getLibrerias() {
		return librerias;
	}

	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}

	
	
	
	
	
	
	

}
