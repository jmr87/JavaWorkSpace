package requerimiento_1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		Node raiz;

		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("concierto.xml");
			raiz = doc.getDocumentElement();

			recorrerNodos(raiz);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Para leer el archivo XML tenemos que recorrer los nodos e imprimirlo por
	// consola.

	public static void recorrerNodos(Node raiz) {

		Node fecha = raiz.getChildNodes().item(0);
		Node hora = raiz.getChildNodes().item(1);
		System.out.println("Fecha y hora del concierto: " + fecha.getTextContent() + " " + hora.getTextContent());
		System.out.println("Participan los siguientes grupos:");
		Node participantes = raiz.getChildNodes().item(2);
		recorrerPar(participantes);
	}

	public static void recorrerPar(Node participantes) {

		NodeList nodos = participantes.getChildNodes();

		for (int i = 0; i < nodos.getLength(); i++) {
			Node participante = nodos.item(i);
			if (participante.getNodeType() == Node.ELEMENT_NODE) {

				Node entrada = participante.getChildNodes().item(0);
				Node grupo = participante.getChildNodes().item(1);

				System.out.print("   " + entrada.getTextContent() + "  " + grupo.getTextContent() + "\n");

			}

		}

	}

}
