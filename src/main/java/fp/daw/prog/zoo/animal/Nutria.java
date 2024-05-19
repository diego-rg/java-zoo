package fp.daw.prog.zoo.animal;

import java.util.Date;

import fp.daw.prog.zoo.animal.medio.Acuatico;
import fp.daw.prog.zoo.animal.medio.Terrestre;

/**
 * Clase que representa unha Nutria
 */
public class Nutria extends Animal implements Acuatico, Terrestre {
	
	/**
	 * Construtor da clase Nutria.
	 * 
	 * {@inheritDoc}
	 */
	public Nutria(String codigo, String nome, Date dataNacemento) {
		super(codigo, nome, dataNacemento);
	}	
	
	/**
	 * Método para que a nutria emita un son.
	 */
	@Override
	public void emitirSon() {
		System.out.println(" . A " + this.getClass().getSimpleName() + " '" + getNome() + "' emite un gruñido ou silbido cando son molestadas.");
	}

	/**
	 * Método que realiza a alimentación dunha nutria.
	 */
	@Override
	public void alimentar() {
		System.out.println(" . A " + this.getClass().getSimpleName() + " '" + getNome() + "' come xuncos, ramas, raíces e tubeŕculos.");
	}
	
	/**
	 * Método que executa o descanso dunha nutria.
	 */
	public void descansar() {
		System.out.println(" . A " + this.getClass().getSimpleName() + " '" + getNome() + "' está descansando na auga.");
	}

	/**
	 * Método que rexistra o nado dunha nutria.
	 */
	@Override
	public void nadar() {
		System.out.println(" . A " + this.getClass().getSimpleName() + " '" + getNome() + "' é un animal que se despraza polo río.");		
	}

	/**
	 * Método que rexistra o movemento da nutria en terra.
	 */
	@Override
	public void mover() {
		System.out.println(" . A " + this.getClass().getSimpleName() + " '" + getNome() + "' tamén se desplaza pola terra.");		
	}

}
