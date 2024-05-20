package fp.daw.prog.zoo.rexistro;

import java.util.Date;

import fp.daw.prog.zoo.Util;
import fp.daw.prog.zoo.rexistro.TipoAccion.Accion;
import fp.daw.prog.zoo.rexistro.adaptador.AdaptadorAccion;
import fp.daw.prog.zoo.rexistro.adaptador.AdaptadorDate;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Clase que representa os rexistros de accións realizados polos diferentes empregados
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Rexistro {
	/**
	 * Data e hora na que se rexistra a operación
	 */
	@XmlElement
	@XmlJavaTypeAdapter(AdaptadorDate.class)
	protected Date data;

	/**
	 * Nome do empregado que realiza o rexistro dunha acción
	 */
	@XmlElement
	protected String nomeEmpregado;

	/**
	 * Código do animal sobre o que se realiza unha acción
	 */
	@XmlElement
	protected String codigoAnimal;

	/**
	 * Tipo de animal sobre o que se fai a acción
	 */
	@XmlElement
	protected String tipoAnimal;

	/**
	 * Acción que realiza o empregado
	 */
	@XmlElement
	@XmlJavaTypeAdapter(AdaptadorAccion.class)
	protected Accion accion;

	/**
	 * Construtor por defecto
	 */
	public Rexistro() {
		super();
	}

	/**
	 * Construtor da clase Rexistro Crea unha acción xenérica do empregado sobre un animal nunha data dada
	 * 
	 * @param data          Data de nacemento do animal.
	 * @param nomeEmpregado Nome do empregado que rexistra a acción.
	 * @param codigoAnimal  Código do animal realiza a acción.
	 * @param tipoAnimal    Tipo de animal segundo a clase pola que se representa.
	 * @param accion        Tipo de accion rexistrada.
	 */
	public Rexistro(Date data, String nomeEmpregado, String codigoAnimal, String tipoAnimal, Accion accion) {
		this.data = data;
		this.nomeEmpregado = nomeEmpregado;
		this.codigoAnimal = codigoAnimal;
		this.accion = accion;
		this.tipoAnimal = tipoAnimal;
	}

	/**
	 * Construtor da clase Rexistro Crea unha acción xenérica do empregado sobre un animal e usando a data actual como a
	 * de rexistro desta acción
	 * 
	 * @param nomeEmpregado Nome do empregado que rexistra a acción.
	 * @param codigoAnimal  Código do animal realiza a acción.
	 * @param tipoAnimal    Tipo de animal segundo a clase pola que se representa.
	 * @param accion        Tipo de accion rexistrada.
	 */
	public Rexistro(String nomeEmpregado, String codigoAnimal, String tipoAnimal, Accion accion) {
		this(new Date(), nomeEmpregado, codigoAnimal, tipoAnimal, accion);
	}

	/**
	 * Construtor da clase Rexistro Crea unha acción xenérica do empregado non relacionada con animais
	 * 
	 * @param data          Data de nacemento do animal.
	 * @param nomeEmpregado Nome do empregado que rexistra a acción.
	 * @param accion        Tipo de accion rexistrada.
	 */
	public Rexistro(Date data, String nomeEmpregado, Accion accion) {
		this(data, nomeEmpregado, null, null, accion);
	}

	/**
	 * Construtor da clase Rexistro Crea unha acción xenérica do empregado non relacionada con animais e usando como
	 * data por defecto a actual
	 * 
	 * @param nomeEmpregado Nome do empregado que rexistra a acción.
	 * @param accion        Tipo de accion rexistrada.
	 */
	public Rexistro(String nomeEmpregado, Accion accion) {
		this(new Date(), nomeEmpregado, null, null, accion);
	}

	/**
	 * Obtén a data do rexistro
	 * 
	 * @return data do rexistro.
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Obtén a acción do rexistro
	 * 
	 * @return acción do rexistro
	 */
	public Accion getAccion() {
		return accion;
	}

	/**
	 * Obtén o valor de nomeEmpregado
	 *
	 * @return o valor de nomeEmpregado
	 */
	public String getNomeEmpregado() {
		return nomeEmpregado;
	}

	/**
	 * Obtén o valor de codigoAnimal
	 *
	 * @return o valor de codigoAnimal
	 */
	public String getCodigoAnimal() {
		return codigoAnimal;
	}

	/**
	 * Obtén en formato texto os datos que representan un rexistro.
	 * 
	 * @return acción en formato String.
	 */
	@Override
	public String toString() {
		String resultado = "Rexistro [" + Util.converterData(data) + "]:";
		resultado += "\n    > O empregado '" + nomeEmpregado + "'";
		resultado += "\n    > Realiza a acción: " + accion.getNome();
		if (codigoAnimal != null)
			resultado += "\n    > Sobre o  animal co codigo: '" + codigoAnimal + "'";
		return resultado;
	}

	/**
	 * @return the tipoAnimal
	 */
	public String getTipoAnimal() {
		return tipoAnimal;
	}

}
