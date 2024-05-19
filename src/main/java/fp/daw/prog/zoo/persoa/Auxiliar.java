package fp.daw.prog.zoo.persoa;

import java.util.Date;

import fp.daw.prog.zoo.animal.Animal;
import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.TipoAccion.AccionAuxiliar;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Clase que representa un veterinario no zoo.
 */
@XmlType
public class Auxiliar extends Coidador {
	
	
	/**
	 * Construtor da clase Veterinario.
	 * 
	 * @param nome    O nome do veterinario.
	 * @param salario O salario do veterinario.
	 */
	public Auxiliar(String di, String nome, String apelidos, Date dataNacemento, Double salario) {
		super(di, nome, apelidos, dataNacemento, salario);
	}

	/**
	 * Método para que un coidador realice unha tarefa sobre un animal e engadilo ao rexistro. Volvemos a
	 * declaralo e non se sobrescribe. De feito na clase pai, realizarTarefa é protected, isto permite que
	 * teñamos acceso desde a clase pai, pero que non poidamos invocalo desde unha instancia directamente,
	 * como se fose private.
	 * 
	 * Volvemos a declarar un método co mesmo nome, pero diferente sinatura, xa que o restrinximos para que so
	 * permita recibir accións de tipo AccionAuxiliar.
	 * 
	 * @param  animal Animal sobre o que se fai a acción de coidado.
	 * @param  accion Acción a realizar sobre o animal.
	 * @return        O rexistro engadido.
	 */
	public Rexistro realizarTarefa(Animal animal, AccionAuxiliar accion) {
		return super.realizarTarefa(animal, accion);
	}
}