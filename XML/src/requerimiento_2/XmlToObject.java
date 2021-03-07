package requerimiento_2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

//En esta clase convertimos el fichero XML a un objeto y lo mostramos por pantalla;

public class XmlToObject {

	public static void main(String[] args) {

		try {
			JAXBContext contexto = JAXBContext.newInstance(Concierto.class);

			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("Concierto.xml");

			// Preguntamos si el fichero existe, y de ser así simplemente hacemos el
			// unmarshal y accedemos a los datos que queremos mediante el método get y el
			// indice.

			if (fichero.exists()) {
				Concierto c = (Concierto) u.unmarshal(fichero);
				System.out.println("Fecha y hora del concierto : " + c.getFecha() + " " + c.getHora());
				System.out.println("Participan los siguientes grupos:");
				System.out.print(" " + c.getParticipantes().get(0).getParticipante().get(0));
				System.out.print(" " + c.getParticipantes().get(0).getParticipante().get(1));
				System.out.print(" " + c.getParticipantes().get(0).getParticipante().get(2));

			} else {
				System.out.println("Fichero XML Concierto.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
