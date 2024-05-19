package fp.daw.prog.zoo.animal;

import java.util.Date;

import fp.daw.prog.zoo.animal.medio.Terrestre;

/**
 * Clase que representa un Tigre.
 */
public class Tigre extends Animal implements Terrestre {
	
	
	/**
	 * Constructor da classe Tigre.
	 * 
	 * {@inheritDoc}
	 */
    public Tigre(String codigo, String nome, Date dataNacemento) {
        super(codigo, nome, dataNacemento);
    }

	/**
	 * Método para que o tigre emita un son.
	 */
	@Override
	public void emitirSon() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' ruge bem alto.");
	}

	/**
	 * Implementação do método para alimentar o tigre.
	 */
	public void alimentar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' está comendo carne.");
	}

	/**
	 * Implementación do método para descansar do tigre.
	 */
	@Override
	public void descansar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' está dormindo na grama.");
	}

	/**
	 * Método que rexistra o movemento do tigre.
	 */
	@Override
	public void mover() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' móvese moi rápido pola sabana.");		
	}
}