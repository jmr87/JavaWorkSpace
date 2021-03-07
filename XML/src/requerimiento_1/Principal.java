package requerimiento_1;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Principal {

	public static void main(String[] args) {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;

		try {
			analizador = fabrica.newDocumentBuilder();
			
			doc = analizador.newDocument();
			
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			
			agregarParticipantes(concierto, doc);
			
			guardar(doc);

			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void agregarParticipantes(Element concierto, Document doc) {

		// Agregamos la fecha y la hora:

		Element fecha = doc.createElement("fecha");
		Text textoFecha = doc.createTextNode("20-oct-2018");
		fecha.appendChild(textoFecha);
		concierto.appendChild(fecha);
		Element hora = doc.createElement("hora");
		Text textoHora = doc.createTextNode("21:30");
		hora.appendChild(textoHora);
		concierto.appendChild(hora);

		// Agregamos participantes:

		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);

		// Agregamos 1er participante:

		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);
		Element entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("21:30"));
		participante.appendChild(entrada);
		Element grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		participante.appendChild(grupo);

		// Aggregamos al segundo participante:

		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("22:15"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(grupo);

		// Agregamos al tercer participante:

		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("23:00"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Coldplay"));
		participante.appendChild(grupo);

	}

	private static void guardar(Document doc) throws TransformerException {
		
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
	
		Transformer conversor = fabricaConversor.newTransformer();
		
		DOMSource fuente = new DOMSource(doc);
		
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		
		conversor.transform(fuente, resultado);
	}

}
