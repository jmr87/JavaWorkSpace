package beans;

import java.io.Serializable;

public class Coche implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 484846456456465L;
	private String id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	
	
	public Coche(String id, String matricula, String marca, String modelo, String color) {
		super();
		this.id=id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}


	public Coche() {
		super();
	}


	public String getId() {
		return id;
	}


	public String getMatricula() {
		return matricula;
	}


	public String getMarca() {
		return marca;
	}


	public String getModelo() {
		return modelo;
	}


	public String getColor() {
		return color;
	}
	
	


	public void setId(String id) {
		this.id = id;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + "]";
	}
	
	
	
	
		
	
	
	

}
