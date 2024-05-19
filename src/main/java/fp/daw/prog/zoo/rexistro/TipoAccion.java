package fp.daw.prog.zoo.rexistro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que representa as accións que poden rexistrarse, e atópanse categorizadas
 */
public class TipoAccion {

	/**
	 * Define unha acción xenérica do rexistro. Usámola para que os tipos enumerados dos diferentes rexistros
	 * poidan ser agrupados polo tipo que representa esta Interface, da que herdan todos eses tipos.
	 * 
	 */
	public interface Accion {
		/**
		 * Obtén o nome da acción asignada
		 * 
		 * @return nome descriptivo da acción a realizar
		 */
		public String getNome();
	}

	/**
	 * Tipo de enumerado que contén todos os tipos de rexistros necesarios para o control presencial dos
	 * empregados
	 */
	public enum AccionControlAcceso implements Accion {
		ENTRADA("O usuario entra nas instalación"),
		SAIDA("O usuario sae das instalacións");

		private String nome;

		/**
		 * Construtor do enumerado. Faise privado porque os valores están acotados e delimitados, polo que non
		 * se permite xerar máis.
		 * 
		 * @param nome descripción da acción a realizar
		 */
		private AccionControlAcceso(String nome) {
			this.nome = nome;
		}

		/**
		 * Obtén o nome da acción asignada
		 * 
		 * @return nome descriptivo da acción a realizar
		 */
		public String getNome() {
			return nome;
		}
	}

	/**
	 * Tipo de enumerado que contén todos os tipos de rexistros necesarios para as accións dos coidadores
	 */
	public enum AccionAuxiliar implements Accion {
		DAR_COMIDA("Dar de comer"),
		DAR_AUGA("Dar auga"),
		LIMPAR("Limpar habitáculo"),
		RECONTO("Reconto de animais");

		private String nome;

		/**
		 * Construtor do enumerado. Faise privado porque os valores están acotados e delimitados, polo que non se permite xerar máis.
		 * 
		 * @param nome descripción da acción a realizar
		 */
		private AccionAuxiliar(String nome) {
			this.nome = nome;
		}

		/**
		 * Obtén o nome da acción asignada
		 * 
		 * @return nome descriptivo da acción a realizar
		 */
		public String getNome() {
			return nome;
		}
	}

	/**
	 * Define as posibles accións do coidador
	 */
	public enum AccionVeterinario implements Accion {
		VACINA("Pon unha vacina ao animal"),
		REVISION("Realiza unha revisión do aniaml"),
		CONTROL_MEDIDAS("Fai un control de medidas e de peso do animal"),
		URXENCIA("Fai unha intervención de urxencia do animal");

		private String nome;

		/**
		 * Construtor do enumerado. Faise privado porque os valores están acotados e delimitados, polo que non
		 * se permite xerar máis.
		 * 
		 * @param nome descripción da acción a realizar
		 */
		private AccionVeterinario(String nome) {
			this.nome = nome;
		}

		/**
		 * Obtén o nome da acción asignada
		 * 
		 * @return nome descriptivo da acción a realizar
		 */
		public String getNome() {
			return nome;
		}
	}
	
	/**
	 * Tipo de enumerado que contén todos os tipos de rexistros necesarios para as accións dos coidadores
	 */
	public enum AccionGarda implements Accion {
		REVISAR_ALARMAS("Revisar as alarmas dos habitáculos de animais perigosos."),
		CONTROL_PERIMETRO("Realizar un control do perímetro do zoo."),
		CONTROL_VISITAS("Facer un control das visitas de público ao Zoo."),
		AVISO_POLICIA("Dar aviso á policía ao detectar que se comete algún tipo de actividade delictiva.");

		private String nome;

		/**
		 * Construtor do enumerado. Faise privado porque os valores están acotados e delimitados, polo que non se permite xerar máis.
		 * 
		 * @param nome descripción da acción a realizar
		 */
		private AccionGarda(String nome) {
			this.nome = nome;
		}

		/**
		 * Obtén o nome da acción asignada
		 * 
		 * @return nome descriptivo da acción a realizar
		 */
		public String getNome() {
			return nome;
		}
	}

	/**
	 * Buscamos unha acción (tipo enumerado Accion) pola súa clave
	 * 
	 * @param  clave Clave que identifica a opción do enumerado pasado por parámetro
	 * @return       O tipo de acción atopada, ou null en caso contrario
	 */
	public static Accion getAccion(String clave) {
		try {
			// Creamos unha lista na que engadimos todas as accións permitidas para os diferentes tipos de
			// usuario
			List<Accion> accions = new ArrayList<Accion>();
			accions.addAll(Arrays.asList(AccionAuxiliar.values()));
			accions.addAll(Arrays.asList(AccionVeterinario.values()));
			accions.addAll(Arrays.asList(AccionGarda.values()));
			// Buscamos polo nome do enumerado, se coincide algunha coa que se pasa por parámetro
			for (Accion accion : accions) {
				if (accion.toString().equals(clave))
					return accion; // No caso de atopala devolvemos a acción
			}
		}
		catch (Exception e) {
			System.out.println("Non hai ningún tipo de acción dada de alta coa clave indicada");
		}
		return null; // Se non atopa a acción, devolvemos null
	}

}
