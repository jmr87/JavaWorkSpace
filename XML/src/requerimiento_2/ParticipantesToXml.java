package requerimiento_2;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ParticipantesToXml {

	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Concierto.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			return;
		}

		// A continuación agregamos los datos del documento xml. La fecha y hora y los
		// grupos que actuarán.

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Concierto concierto = new Concierto();
			concierto.setFecha("20-oct-2018");
			concierto.setHora("21:30");
			Participantes participantes = new Participantes();
			participantes.getParticipante().add(new Participante("21:30", "Las Ardillas de Dakota"));
			participantes.getParticipante().add(new Participante("22:15", "Fito y Fitipaldis"));
			participantes.getParticipante().add(new Participante("23:00", "Coldplay"));
			concierto.getParticipantes().add(participantes);

			m.marshal(concierto, new File("Concierto.xml"));
			System.out.println("El archivo Concierto.xml ha sido creado con éxito");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
		}

	}

}
