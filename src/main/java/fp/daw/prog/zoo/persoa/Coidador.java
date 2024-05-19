package fp.daw.prog.zoo.persoa;

import java.util.Date;

import fp.daw.prog.zoo.animal.Animal;
import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.TipoAccion.Accion;

/**
 * Clase que representa a un tipo de empregado xenérico e que especializarán os tipos de empregados encargados
 * de dar algún tipo de coidado aos animais.
 */
public class Coidador extends Empregado {

	/**
	 * Construtor por defecto
	 */
	public Coidador() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public Coidador(String di, String nome, String apelidos, Date dataNacemento, Double salario) {
		super(di, nome, apelidos, dataNacemento, salario);
	}

	/**
	 * Método para que un coidador realice unha tarefa sobre un animal e engadilo ao rexistro.
	 * 
	 * @param  animal Animal sobre o que se fai a acción de coidado.
	 * @param  accion Acción a realizar sobre o animal.
	 * @return        O rexistro engadido.
	 */
	protected <T extends Accion> Rexistro realizarTarefa(Animal animal, T accion) {
		if (animal == null)
			return null;
		return new Rexistro(new Date(), this.getNome(), animal.getCodigo(), animal.getClass().getSimpleName(), accion);
	}
}
