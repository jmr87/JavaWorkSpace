package empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import correos.Emails;

//Cómo su nombre indica, esta clase va a ser la encargada de generar los atributos de la clase Emails.

public class GeneradorEmails {

	
	public Emails generarEmail() {
		
		Emails emails =new Emails();
		emails.setId(generarId());
		emails.setDestinatario(generarDestinatario());
		emails.setRemitente(generarRemitente());
		emails.setAsunto(generarAsunto());
		emails.setCuerpo(generarCuerpo());
		
		
		return emails;
		
	}

//	Método por el cual generamos el Id del Email.
	
	public int generarId(){
		
		int num = ThreadLocalRandom.current().nextInt(1,30);
		return num;
		
	}

//	Método por el cual generamos el destinatario del Email.
	
	public String generarDestinatario() {
		
		List<String>listaDestinatarios = new ArrayList<String>();
		listaDestinatarios.add("Juan@gmail.com");
		listaDestinatarios.add("Pepe@gmail.com");
		listaDestinatarios.add("Maria@gmail.com");
		listaDestinatarios.add("Laura@gmail.com");
		listaDestinatarios.add("Jaime@gmail.com");
		listaDestinatarios.add("Sergio@gmail.com");
		listaDestinatarios.add("Marta@gmail.com");
		listaDestinatarios.add("Pikachu@gmail.com");
		listaDestinatarios.add("Esteban@gmail.com");
		listaDestinatarios.add("Dani@gmail.com");
		
		int num = ThreadLocalRandom.current().nextInt(0,10);
		
		return listaDestinatarios.get(num);
		
	}

//	Método por el cual generamos el remitente del Email.	
	
	public String generarRemitente() {
		
		List<String>listaRemitentes = new ArrayList<String>();
		listaRemitentes.add("Dirección");
		listaRemitentes.add("Administración");
		listaRemitentes.add("Contabilidad");
		
		int num = ThreadLocalRandom.current().nextInt(0,3);
		
		return listaRemitentes.get(num);	
		
	}

//	Método por el cual generamos el asunto del Email.	
	
	public String generarAsunto() {
		
		List<String>listaAsuntos = new ArrayList<String>();
		listaAsuntos.add("Dias libres");
		listaAsuntos.add("Adelanto nómina");
		listaAsuntos.add("Reunión");
		listaAsuntos.add("Faltas");
		
		int num = ThreadLocalRandom.current().nextInt(0,3);
		
		return listaAsuntos.get(num);
	}

//	Método por el cual generamos el cuerpo del Email.	
	
	public String generarCuerpo() {
		
		List<String>listaCuerpos = new ArrayList<String>();
		listaCuerpos.add("aaaaaaaa");
		listaCuerpos.add("bbbbbbbb");
		listaCuerpos.add("cccccccc");
		listaCuerpos.add("dddddddd");
		
		int num = ThreadLocalRandom.current().nextInt(0,4);
		
		return listaCuerpos.get(num);
	}

}
