package fp.daw.prog.zoo.rexistro;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Clase do modelo de datos, que representa un listado de rexistros e que so é usado nas transformacións
 * JAXB para poder mapear un XML co mesmo formato e exportar a instancia a un XML.
 */
@XmlRootElement(name="rexistros")
@XmlAccessorType(XmlAccessType.FIELD)
public class RexistrosListado {
	
	@XmlElement(name = "rexistro")
	private List<Rexistro> rexistros;
	
    /**
	 * Construtor por defecto
	 */
	public RexistrosListado() {		
	}
	
	/**
	 * Obtén o listado de rexistros
	 *
	 * @return o listado de rexistros
	 */
	public List<Rexistro> getRexistros() {
		if (rexistros == null)
			rexistros = new ArrayList<Rexistro>();
		return rexistros;
	}

	/**
	 * Configura o listado de rexistros
	 * 
	 * @param rexistros o listado de rexistros a configurar
	 */
	public void setRexistros(List<Rexistro> rexistros) {
		this.rexistros = rexistros;
	}

    
}
