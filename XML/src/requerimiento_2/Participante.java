package requerimiento_2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Cada participante tendrá una entrada y un grupo

@XmlRootElement(name = "participante")
@XmlType(propOrder = { "entrada", "grupo" })
public class Participante {

    private String entrada;

    private String grupo;

    public Participante() {

    }

    public Participante(String entrada, String grupo) {
        this.entrada = entrada;
        this.grupo = grupo;
    }

    @XmlElement(name = "entrada")
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    @XmlElement(name = "grupo")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return entrada + " " + grupo + "\n";
    }
	
	
}
