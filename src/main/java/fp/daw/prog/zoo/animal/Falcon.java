package fp.daw.prog.zoo.animal;

import java.util.Date;

import fp.daw.prog.zoo.animal.medio.Aereo;

/**
 * Clase que representa un falcón
 */
public class Falcon extends Animal implements Aereo {
	
	/**
	 * Construtor da clase Falcon.
	 * 
	 * {@inheritDoc}
	 */
	public Falcon(String codigo, String nome, Date dataNacemento) {
		super(codigo, nome, dataNacemento);
	}	
	
	/**
	 * Método para que o falcón emita un son.
	 */
	@Override
	public void emitirSon() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' emite un son característico.");
	}

	/**
	 * Método que realiza a alimentación dun falcón.
	 */
	@Override
	public void alimentar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' come réptiles e outras aves.");
	}
	
	/**
	 * Método que executa o descanso dun falcón.
	 */
	public void descansar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' está descansando na sombra.");
	}


	/**
	 * Método que rexistra o voo do falcón.
	 */
	@Override
	public void voar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' é unha ave que se despraza polo ar.");		
	}
	

}
