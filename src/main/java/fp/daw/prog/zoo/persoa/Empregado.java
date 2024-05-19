package fp.daw.prog.zoo.persoa;

import java.util.Date;
import java.util.List;

import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.TipoAccion.AccionControlAcceso;

/**
 * Clase abstracta que representa un empregado do zoo.
 */
public abstract class Empregado {

	protected String di;
	protected String nome;
	protected String apelidos;
	protected Date dataNacemento;
	protected Double salario;

	/**
	 * Construtor por defecto
	 */
	public Empregado() {
		super();
	}

	/**
	 * Construtor da clase Empregado
	 * 
	 * @param di            Número do documento de identidade.
	 * @param nome          Nome do usuario
	 * @param apelidos      Apelidos do usuario
	 * @param dataNacemento Data de nacemento do usuario
	 * @param salario       Salario do empregado
	 */
	public Empregado(String di, String nome, String apelidos, Date dataNacemento, Double salario) {
		this.di = di;
		this.nome = nome;
		this.apelidos = apelidos;
		this.dataNacemento = dataNacemento;
		this.salario = salario;
	}

	/**
	 * Rexistra unha acción de control de acceso (Entrada ou Saída)
	 * 
	 * @param  accion    Tipo de acción de control de acceso a realizar (Entrada/Saída)
	 * @throws Exception
	 */
	public Rexistro rexistrarAcceso(AccionControlAcceso accion) throws Exception {
		if (accion == null)
			throw new Exception("[Erro] É preciso indicar un tipo de rexsitro de acceso.");

		Rexistro rexistro = new Rexistro(new Date(), this.getNome(), accion);
		return rexistro;
	}

	/**
	 * Método para obter o salario do empregado.
	 * 
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * Configura o salario dos empregados
	 * 
	 * @param salario Salario a configurar.
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	/**
	 * Método para obter o nome do empregado.
	 * 
	 * @return O nome do empregado.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para obter os apelidos do empregado.
	 * 
	 * @return Apelidos do empregado.
	 */
	public String getApelidos() {
		return apelidos;
	}

	/**
	 * Configura os apelidos do empregado
	 * 
	 * @param apelidos Apelidos do empregado.
	 */
	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}

	/**
	 * Obter a data de nacemento
	 * 
	 * @return A data de nacemento
	 */
	public Date getDataNacemento() {
		return dataNacemento;
	}

	/**
	 * Configura a data de nacemento do empregado
	 * 
	 * @param dataNacemento Data de nacemento do empregado.
	 */
	public void setDataNacemento(Date dataNacemento) {
		this.dataNacemento = dataNacemento;
	}

	/**
	 * Método para obter o documento de identidade do empregado.
	 * 
	 * @return Documento de identidade do empregado.
	 */
	public String getDi() {
		return di;
	}

	/**
	 * Configura o nome do empregado.
	 * 
	 * @param nome Nome do empregado.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Busca un empregado entre o listado de empregados da aplicación
	 * 
	 * @param  empregados listado de empregados sobre o que buscar
	 * @param  di         documento de identidade que queremos buscar
	 * @return            o empregado buscado se existe, e senón null
	 */
	public static Empregado buscarEmpregado(List<Empregado> empregados, String di) {
		if (empregados == null)
			return null;
		for (Empregado empregado : empregados) {
			if (empregado.getDi().equals(di))
				return empregado;
		}
		return null;
	}	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Empregado [di: '" + di + "'] => tipo: '" + this.getClass().getSimpleName() + "', nome: '" + nome + "', apelidos: '" + apelidos + "', dataNacemento: '" + dataNacemento + "', salario: '" + salario + "'";
	}	
}