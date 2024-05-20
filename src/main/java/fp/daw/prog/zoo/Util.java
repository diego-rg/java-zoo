package fp.daw.prog.zoo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fp.daw.prog.zoo.animal.Animal;
import fp.daw.prog.zoo.animal.Elefante;
import fp.daw.prog.zoo.animal.Morcego;
import fp.daw.prog.zoo.animal.Tigre;
import fp.daw.prog.zoo.persoa.Auxiliar;
import fp.daw.prog.zoo.persoa.Empregado;
import fp.daw.prog.zoo.persoa.Garda;
import fp.daw.prog.zoo.persoa.Veterinario;

public class Util {

	public static final String PATRON_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	public static final String PATRON_DATA = "dd/MM/yyyy";
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 * Enumerado que representa o tipo de ficheiros que manexa o sistema
	 */
	public static enum TipoFicheiro {
		XML(1, ".xml"), TXT(2, ".txt");

		private int id;
		private String formato;

		private TipoFicheiro(int id, String formato) {
			this.id = id;
			this.formato = formato;
		}

		/**
		 * Obtén o valor de formato
		 *
		 * @return o valor de formato
		 */
		public String getFormato() {
			return formato;
		}

		/**
		 * Obtén o valor do id
		 *
		 * @return o valor do id
		 */
		public int getId() {
			return id;
		}

		/**
		 * Método que a partires da opción seleccionada de tipo enteiro devolve o TipoFicheiro.
		 * 
		 * @param opcion opción seleccionada polo usuario.
		 * @return O tipo de ficheiro correspondente entre as opcións existentes.
		 */
		public static TipoFicheiro getTipo(int opcion) {
			for (TipoFicheiro tipo : TipoFicheiro.values()) {
				if (tipo.getId() == opcion)
					return tipo;
			}
			return null;
		}
	}

	/**
	 * Solicita ao usuario que insira o tipo de arquivo por consola
	 * 
	 * @param descricion Descricion da acción que realizamos referida ao dato lido
	 * @return Dato inserido pola consola
	 */
	public static int solicitarExtension() {
		Integer numero;
		do {
			try {
				System.out.println("Indica o tipo de arquivo a usar para gardar os datos:");
				System.out.println("1 para XML");
				System.out.println("2 para TXT");
				numero = scanner.nextInt();
				if (numero != 1 && numero != 2) {
					throw new Exception("Erro! Tipo de arquivo non válido!");
				}
				break; // Se chega até aquí é porque se inseriu un valor válido e polo tanto saímos do bucle
			} catch (Exception e) {
				System.out.println("[ERRO] O dato inserido non é un enteiro, por favor ténteo de novo.");
			} finally {
				scanner.nextLine(); // Limpamos o buffer para que non colla o salto de liña
			}
		} while (true);
		return numero;
	}

	/**
	 * Subclase estática de Util que se utiliza para xerar datos de proba
	 */
	public static class DatosProba {

		/**
		 * Método que xera unha serie de empregados de proba para traballar na aplicación
		 * 
		 * @return Lista de empregados
		 * @throws ParseException
		 */
		public static List<Empregado> crearEmpregados() throws ParseException {
			List<Empregado> empregados = new ArrayList<>();
			empregados
					.add(new Veterinario("333671702H", "Carla", "Carrión Souto", Util.obterData("17/01/2007"), 35000d));
			empregados.add(new Veterinario("345678902G", "Sira", "López Sieira", Util.obterData("17/01/2001"), 29000d));
			empregados.add(new Auxiliar("555973002L", "Xiana", "Castosa Moure", Util.obterData("17/01/2003"), 32548d));
			empregados.add(new Garda("333693912J", "Antón", "Veiga Souto", Util.obterData("26/07/2003"), 18000d));
			empregados.add(new Garda("543678922L", "Xoel", "Castro Marzán", Util.obterData("26/07/1989"), 20000d));
			return empregados;
		}

		/**
		 * Método que xera unha serie de animais de proba para traballar na aplicación
		 * 
		 * @return Lista de animais
		 * @throws ParseException
		 */
		public static List<Animal> crearAnimais() throws ParseException {
			List<Animal> animais = new ArrayList<>();
			animais.add(new Morcego("MO0089", "Draculín", Util.obterData("04/10/2022")));
			animais.add(new Elefante("EL0011", "Trompa", Util.obterData("23/11/2019")));
			animais.add(new Tigre("TI0021", "Simba", Util.obterData("08/04/2008")));
			return animais;
		}
	}

	/**
	 * Método estático que converte a cadea unha data
	 * 
	 * @param data   data que queremos converter a cadea
	 * @param patron patrón que aplicamos para converter a cadea a String
	 * @return data convertida a cadea
	 */
	public static String converterData(Date data, String patron) {
		// Creamos un formato para as datas co patrón establecido en Empregado
		DateFormat df = new SimpleDateFormat(patron);
		// Convertemos a data a String
		return df.format(data);
	}

	/**
	 * Método estático que converte a cadea unha data
	 * 
	 * @param data data que queremos converter a cadea
	 * @return data convertida a cadea
	 */
	public static String converterData(Date data) {
		return converterData(data, PATRON_DATA);
	}

	/**
	 * Método estático que converte unha cadea a un tipo Date
	 * 
	 * @param data data en formato texto que queremos converter a Date
	 * @return a data como un tipo Date
	 * @throws ParseException
	 */
	public static Date obterData(String data) throws ParseException {
		SimpleDateFormat formatData = new SimpleDateFormat(PATRON_DATA);
		return formatData.parse(data);
	}

	/**
	 * Solicita ao usuario que insira un dato por consola, isto é, unha palabra que devolvemos. Se inserimos máis dunha
	 * palabra (separadas por espazos), devolverá so a primeira delas.
	 * 
	 * @param descricion Descricion da acción que realizamos referida ao dato lido
	 * @return Dato inserido pola consola
	 */
	public static String solicitarDatoPorConsola(String descricion) {
		System.out.print(descricion);
		String dato = scanner.next(); // Como é un dato non permitimos unha liña completa, so unha palabra
		return dato;
	}

	/**
	 * Solicita ao usuario que insira unha liña de texto por consola (permite varias palabras separadas por espazos).
	 * 
	 * @param descricion Descricion da acción que realizamos referida ao dato lido
	 * @return Dato inserido pola consola
	 */
	public static String solicitarTextoPorConsola(String descricion) {
		System.out.print(descricion);
		return scanner.nextLine(); // Como é un dato non permitimos unha liña completa, so unha palabra
	}

	/**
	 * Solicita ao usuario que insira un número enteiro por consola. Se insire un valor non enteiro, entón solicita que
	 * volva a inserir outr valor, e repite a acción até que se realiza correctamente.
	 * 
	 * @param descricion Descricion da acción que realizamos referida ao dato lido
	 * @return Valor enteiro inserido pola consola
	 */
	public static Integer solicitarNumeroPorConsola(String descricion) {
		Integer numero;
		do {
			try {
				System.out.print(descricion);
				numero = scanner.nextInt();
				break; // Se chega até aquí é porque se inseriu un valor válido e polo tanto saímos do bucle
			} catch (Exception e) {
				System.out.println("[ERRO] O dato inserido non é un enteiro, por favor ténteo de novo.");
			} finally {
				scanner.nextLine(); // Limpamos o buffer para que non colla o salto de liña
			}
		} while (true);
		return numero;
	}

	/**
	 * Permite seleccionar un valor numérico no rango indicado
	 * 
	 * @param min valor mínimo permitido
	 * @param max valor máximo permitido
	 * @return O número da opción seleccionada
	 */
	public static int seleccionarOpcion(int min, int max) {
		int opcion = -1;
		while (true) {
			try {
				opcion = Util.scanner.nextInt();
				// Se a opción seleccionada é correcta, entón saímos e retornamos ese valor
				if ((opcion >= 0) && (opcion <= max))
					break;
				System.out.println("\n [ERRO] A opción ten que estar no rango [" + min + "," + max + "].");
				System.out.print("  > Volve intentalo: ");
			} catch (Exception e) {
				// No caso de inserir un valor incorrecto, temos que limpar o buffer para que non colla o
				// salto de liña
				Util.scanner.nextLine();
				System.out.print("[ERRO] Opción incorrecta, volve intentalo: ");
			}
		}
		// Limpamos o buffer para que non colla o salto de liña
		Util.scanner.nextLine();
		return opcion;
	}

	/**
	 * Método que mostra a lista de tarefas por consola, e para iso fai uso de xenéricos, deste xeito podemos usalo con
	 * calquera tipo de rexistro.
	 * 
	 * @param <T>        Calquera tipo de dato.
	 * @param descricion Texto que indica os datos que se van visualizar
	 * @param datos      Colección dos datos que queremos mostrar por consola
	 */
	public static <T> void mostrarDatosPorConsola(String descricion, Collection<T> datos) {
		if (datos == null)
			return;
		System.out.println(descricion);
		for (T rexistro : datos) {
			System.out.println(" . " + rexistro);
		}
	}

	/**
	 * Método que solicita que un usuario prema a tecla Intro para continuar. Mentres non se fai, a execución mantense
	 * en espera
	 */
	public static void premaIntroParaContinuar() {
		System.out.print("\n Prema Intro para continuar... \n");
		scanner.nextLine();
	}
}
