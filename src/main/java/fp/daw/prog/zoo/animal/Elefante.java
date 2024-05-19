package fp.daw.prog.zoo.animal;

import java.util.Date;

import fp.daw.prog.zoo.animal.medio.Terrestre;

/**
 * Clase que representa un elefante.
 */
public class Elefante extends Animal implements Terrestre {
		
	/**
	 * Construtor da clase Elefante.
	 * 
	 * {@inheritDoc}
	 */
    public Elefante(String codigo, String nome, Date dataNacemento) {
        super(codigo, nome, dataNacemento);
    }
	
	/**
	 * Método para que o elefante emita un son.
	 */
	@Override
	public void emitirSon() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' emite un son coa trompa.");
	}

	/**
	 * Método que realiza a alimentación dun elefante.
	 */
	@Override
	public void alimentar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' aliméntase con herba e vexetais.");
	}
	
	/**
	 * Método que executa o descanso dun elefante.
	 */
	public void descansar() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' descansa á sombra ou nos ríos.");
	}

	/**
	 * Método que rexistra o movemento do elefante.
	 */
	@Override
	public void mover() {
		System.out.println(" . O " + this.getClass().getSimpleName() + " '" + getNome() + "' é un mamífero que se despraza pola sabana.");		
	}
}