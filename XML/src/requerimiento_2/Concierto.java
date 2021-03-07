package requerimiento_2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//Esta clase tendrá la fecha y hora del concierto y una lista de participantes

@XmlRootElement(name = "Concierto")
public class Concierto {

    private String fecha;

    private String hora;

    private List<Participantes> participantes;

    public Concierto() {
        participantes = new ArrayList<Participantes>();
    }

    public Concierto(String fecha, String hora) {
        super();
        this.fecha = fecha;
        this.hora = hora;
    }

    @XmlElement(name = "fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @XmlElement(name = "hora")
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @XmlElement(name = "participantes")
    public List<Participantes> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participantes> participantes) {
        this.participantes = participantes;
    }
	
	

}
