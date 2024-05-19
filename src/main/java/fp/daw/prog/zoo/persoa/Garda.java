package fp.daw.prog.zoo.persoa;

import java.util.Date;

import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.TipoAccion.Accion;

/**
 * Clase que representa un empregado de tipo garda.
 */
public class Garda extends Empregado {

	/**
	 * Construtor da clase Garda.
	 * 
	 * @param nome    O nome do garda.
	 * @param salario O salario do garda.
	 */
	public Garda(String di, String nome, String apelidos, Date dataNacemento, Double salario) {
		super(di, nome, apelidos, dataNacemento, salario);
	}

	/**
	 * Método para que un garda realice unha tarefa de vixianza e control engadíndoo ao rexistro.
	 * 
	 * @param  accion Acción a realizar sobre o animal.
	 * @return        O rexistro engadido.
	 */
	public Rexistro realizarTarefa(Accion accion) {
		return new Rexistro(new Date(), this.getNome(), accion);
	}
}