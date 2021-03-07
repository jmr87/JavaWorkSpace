package requerimiento_2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//A su vez la clase participantes tendrá una lista con todos los participantes

@XmlRootElement(name = "Participantes")
public class Participantes {

    private List<Participante> participante;

    public Participantes() {
        participante = new ArrayList<Participante>();
    }

    @XmlElement(name = "participante")
    public List<Participante> getParticipante() {
        return participante;
    }

    public void setParticipante(List<Participante> participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return participante + "";
    }
}   