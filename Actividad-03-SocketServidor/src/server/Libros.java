package server;

public class Libros {

	private String isbn;
	private String titulo;
	private String autor;
	private String autor2;
	private String precio;
	
	
	public Libros(String isbn, String titulo, String autor, String precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;		
		this.precio = precio;
		
		
	}
	public Libros(String isbn, String titulo, String autor, String autor2, String precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.autor2 = autor2;
		this.precio = precio;
		
		
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAutor2() {
		return autor2;
	}
	public void setAutor2(String autor2) {
		this.autor2 = autor2;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Libros [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", autor2=" + autor2 + ", precio="
				+ precio + "]";
	}

	

	

	
	

	
	
	
	
	
	

	
	
	



	
	
	
	
}
