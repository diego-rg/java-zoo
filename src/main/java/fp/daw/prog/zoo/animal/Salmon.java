package fp.daw.prog.zoo.animal;

import java.util.Date;

import fp.daw.prog.zoo.animal.medio.Acuatico;

/**
 * Clase que representa un Salmón
 */
public class Salmon extends Animal implements Acuatico {
	
	/**
	 * Construtor da clase Salmon.
	 * 
	 * {@inheritDoc}
	 */
	public Salmon(String codigo, String nome, Date dataNacemento) {
		super(codigo, nome, dataNacemento);
	}	
	
	/**
	 * Método para que o salmón emita un son.
	 */
	@Override
	public void emitirSon() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' emite sons imperceptibles debaixo da auga.");
	}

	/**
	 * Método que realiza a alimentación dun salmón.
	 */
	@Override
	public void alimentar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' come pequenos peixes.");
	}
	
	/**
	 * Método que executa o descanso dun salmón.
	 */
	public void descansar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' está descansando debaixo da auga.");
	}


	/**
	 * Método que rexistra o voo do salmón.
	 */
	@Override
	public void nadar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' é un peixe que se despraza polo mar.");		
	}
	

}
