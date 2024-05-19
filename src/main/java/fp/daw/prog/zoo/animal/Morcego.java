package fp.daw.prog.zoo.animal;

import java.util.Date;

import fp.daw.prog.zoo.animal.medio.Terrestre;

/**
 * Clase que representa un morcego
 */
public class Morcego extends Animal implements Terrestre {
	
	/**
	 * Construtor da clase Morcego.
	 * 
	 * {@inheritDoc}
	 */
    public Morcego(String codigo, String nome, Date dataNacemento) {
        super(codigo, nome, dataNacemento);
    }
	
	/**
	 * Método para que o morcego emita un son.
	 */
	@Override
	public void emitirSon() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' emite un ruxido.");
	}

	/**
	 * Método que realiza a alimentación dun morcego.
	 */
	@Override
	public void alimentar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' aliméntase con carne de diferentes tipos de presas, polo xeral herbívoros.");
	}
	
	/**
	 * Método que executa o descanso dun morcego.
	 */
	public void descansar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' dorme ao sol.");
	}

	/**
	 * Método que rexistra o movemento do morcego.
	 */
	@Override
	public void mover() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' move as súas patas con forza.");		
	}
}