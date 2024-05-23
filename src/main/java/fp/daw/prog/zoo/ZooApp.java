package fp.daw.prog.zoo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fp.daw.prog.zoo.Util.TipoFicheiro;
import fp.daw.prog.zoo.animal.Animal;
import fp.daw.prog.zoo.animal.medio.Acuatico;
import fp.daw.prog.zoo.animal.medio.Aereo;
import fp.daw.prog.zoo.animal.medio.Terrestre;
import fp.daw.prog.zoo.control.CtrlRexistro;
import fp.daw.prog.zoo.control.CtrlRexistroTexto;
import fp.daw.prog.zoo.control.CtrlRexistroXML;
import fp.daw.prog.zoo.persoa.Auxiliar;
import fp.daw.prog.zoo.persoa.Coidador;
import fp.daw.prog.zoo.persoa.Empregado;
import fp.daw.prog.zoo.persoa.Garda;
import fp.daw.prog.zoo.persoa.Veterinario;
import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.TipoAccion;
import fp.daw.prog.zoo.rexistro.TipoAccion.Accion;
import fp.daw.prog.zoo.rexistro.TipoAccion.AccionAuxiliar;
import fp.daw.prog.zoo.rexistro.TipoAccion.AccionVeterinario;

/**
 * Clase principal que representa o programa principal.
 */
public class ZooApp {
	/**
	 * Valor por defecto da rota onde se gardan os ficheiros así como do nome do ficheiro
	 */
	protected static final String RUTA_POR_DEFECTO = "./src/main/resources/";
	protected static final String NOME_FICHEIRO_POR_DEFECTO = "rexistros";
	/**
	 * Listado de empregados da aplicación.
	 */
	protected List<Empregado> empregados = new ArrayList<Empregado>();

	/**
	 * Listado de animais da aplicación.
	 */
	protected List<Animal> animais = new ArrayList<Animal>();

	/**
	 * Controlador de rexistros que realiza as operacións de entrada salida ao ficheiro de datos.
	 */
	protected CtrlRexistro ctrlRexistro = null;

	/**
	 * Construtor por defecto.
	 * 
	 */
	public ZooApp() {
		super();
	}

	/**
	 * Construtor ao que se lle pasa por parámetro os animais e empregados do sistema.
	 * 
	 * @param animais    Animais da aplicación.
	 * @param empregados Empregados da aplicación
	 */
	public ZooApp(List<Animal> animais, List<Empregado> empregados) {
		this.animais = animais;
		this.empregados = empregados;
	}

	/**
	 * Método principal que realiza a execución da aplicación, polo que mostra o menú e permite seleccionar por consola
	 * ao usuario a opción que desexa executar. Isto repítese indefinidamente até que se preme a opción de saír.
	 * 
	 * @throws Exception
	 */
	public void executar() throws Exception {
		int opcion = 0;

		// Solicitamos o nome do ficheiro
		String nomeFicheiroDatos = solicitarNomeFicheiroPorConsola();
		// Solicitamos a extension
		Integer idTipoFicheiro = Util.solicitarExtension();
		// Solicitamos o directorio pai onde se gardará
		String directorio = Util.solicitarDatoPorConsola(
				"Indica a subcarpeta en 'resources' onde o queres gardar ou introduce '/' para gardala directamente nese directorio");
		// Ruta final indicada tendo eu conta o inputo do usuario
		String rutaFinal = directorio.equals("/") ? RUTA_POR_DEFECTO : RUTA_POR_DEFECTO + directorio + File.separator;
		// Creamos a carpeta se non existe
		Util.comprobarDirectorio(rutaFinal);

		ctrlRexistro = inicializarControladorRexistrosPorConsola(TipoFicheiro.getTipo(idTipoFicheiro), rutaFinal,
				nomeFicheiroDatos);
		do {
			mostrarMenuPrincipalPorConsola();
			opcion = Util.seleccionarOpcion(0, 7);
			switch (opcion) {
			case 1:
				// Mostrar os empregados
				Util.mostrarDatosPorConsola("\n## Listado de empregados ##", empregados);
				// Mostrar os animais
				Util.mostrarDatosPorConsola("\n## Listado de animais ##", animais);
				break;
			case 2:
				// Crear unha tarefa de xeito manual
				Rexistro rexistro = crearRexistroPorConsola();
				ctrlRexistro.gardarRexistro(rexistro);

				Util.premaIntroParaContinuar();
				break;
			case 3:
				// Consultar os rexistros no ficheiro
				List<Rexistro> rexistros = ctrlRexistro.consultarRexistros();
				Util.mostrarDatosPorConsola("\n## Listado de rexistros ##\n", rexistros);
				break;
			case 4:
				// Consultar os rexistros no ficheiro
				Animal animal = solicitarAnimalPorConsola();
				mostrarInformacionCompletaPorConsola(animal);
				break;
			case 5:
				// Configuramos outro ficheiro para gardar o rexistro de accións
				nomeFicheiroDatos = solicitarNomeFicheiroPorConsola();
				Integer novaIdTipoFicheiro = Util.solicitarExtension();
				// Solicitamos o directorio pai onde se gardará
				directorio = Util.solicitarDatoPorConsola(
						"Indica a subcarpeta en 'resources' onde o queres gardar ou introduce '/' para gardala directamente nese directorio");
				// Ruta final indicada tendo eu conta o inputo do usuario
				rutaFinal = directorio.equals("/") ? RUTA_POR_DEFECTO : RUTA_POR_DEFECTO + directorio + File.separator;
				// Creamos a carpeta se non existe
				Util.comprobarDirectorio(rutaFinal);
				ctrlRexistro = inicializarControladorRexistrosPorConsola(TipoFicheiro.getTipo(novaIdTipoFicheiro),
						rutaFinal, nomeFicheiroDatos);
				break;
			case 6:
				// Se dá un erro porque inserimos un valor non numérico, entón limpamos o buffer
				String novoNome = Util.solicitarDatoPorConsola(
						"Escolle un novo nome para o ficheiro '" + ctrlRexistro.getFicheiro().getName() + "': ");
				// Renomear o ficheiro e o seu contido
				ctrlRexistro.renomearFicheiro(novoNome);
				break;
			case 7:
				// Eliminar o ficheiro e o seu contido
				ctrlRexistro.borrarFicheiro();
				break;
			case 0:
				// Se escollemos esta opción, entón non fai nada e sae
				break;
			default:
				System.out.println("Opción non válida. Por favor, introduce un número válido.");
				break;
			}
		} while (opcion != 0);

		System.out.println("## Fin da execución do programa.");
		Util.scanner.close();
	}

	/**
	 * Método que inicializa o controlador de rexistros, pasando como parámetro o tipo de ficheiro co que imos a
	 * traballar para facer iso solicita ao usuario por consola o nome do ficheiro que se usará como medio físico para
	 * gardar os datos.
	 * 
	 * @param tipoFicheiro Tipo de ficheiro que se usará para gardar a información.
	 * @throws Exception Erro en caso de que non se seleccione unha opción válida ou exista un erro ao tentar
	 *                   inicializar o ficheiro de datos
	 */
	public String solicitarNomeFicheiroPorConsola() throws Exception {
		// Valor do nome do ficheiro que conterá os datos
		String nomeFicheiro = NOME_FICHEIRO_POR_DEFECTO;

		System.out.println("\n## Configurar ficheiro de datos ##");
		System.out.print("  > Selecciona o nome do ficheiro: ");
		String nomeSeleccionado = Util.scanner.next();
		nomeFicheiro = (nomeSeleccionado != null && nomeSeleccionado.length() > 0) ? nomeSeleccionado : nomeFicheiro;
		return nomeFicheiro;
	}

	/**
	 * Método que inicializa o controlador de rexistros, pasando como parámetro o tipo de ficheiro co que imos a
	 * traballar para facer iso solicita ao usuario por consola o nome do ficheiro que se usará como medio físico para
	 * gardar os datos.
	 * 
	 * @param tipoFicheiro Tipo de ficheiro que se usará para gardar a información.
	 * @param rutaFicheiro Ruta do ficheiro
	 * @param nomeFicheiro Nome do ficheiro
	 * @return Controlador de rexistros inicializado
	 * @throws Exception Erro en caso de que non se seleccione unha opción válida ou exista un erro ao tentar
	 *                   inicializar o ficheiro de datos
	 */
	public CtrlRexistro inicializarControladorRexistrosPorConsola(TipoFicheiro tipoFicheiro, String rutaFicheiro,
			String nomeFicheiro) throws Exception {
		CtrlRexistro ctrlRexistro = null;

		if (tipoFicheiro == null) {
			System.out.print("\n  [ERRO] O tipo de ficheiro non pode ser nulo.");
			return null;
		}
		if (tipoFicheiro.equals(TipoFicheiro.XML)) {
			ctrlRexistro = new CtrlRexistroXML(rutaFicheiro, nomeFicheiro);
		}
		// Se tiveramos implementado outro control de rexistro con acceso a outro tipo de ficheiro ou medio
		// físico
		else if (tipoFicheiro.equals(TipoFicheiro.TXT)) {
			ctrlRexistro = new CtrlRexistroTexto(rutaFicheiro, nomeFicheiro);
		} else {
			System.out.print("\n  [ERRO] Opción inválida, o tipo de ficheiro indicado non existe");
		}
		return ctrlRexistro;
	}

	/**
	 * Mostra o menú coas opcións da aplicación por consola
	 */
	public void mostrarMenuPrincipalPorConsola() {
		System.out.println("\n## Menú Principal ##");
		System.out.println("   1. Mostrar empregados e animais");
		System.out.println("   2. Engadir unha acción ao rexistro");
		System.out.println("   3. Mostrar os rexistros das accións");
		System.out.println("   4. Probar accións de animal");
		System.out.println("   5. Modificar o ficheiro de rexistros seleccionado");
		System.out.println("   6. Renomear o ficheiro de rexistros");
		System.out.println("   7. Borrar o ficheiro de rexistros");
		System.out.println("   0. Saír");

		System.out.print("\n  > Escolle unha opción: ");
	}

	/**
	 * Solicita por consola un empregado a través do seu documento de identidade e devolve o empregado atopado
	 * 
	 * @return O empregado atopado
	 */
	public Empregado solicitarEmpregadoPorConsola() {
		Empregado empregado = null;
		// Amosar os empregados
		Util.mostrarDatosPorConsola("\n## Listado de empregados ##", empregados);
		do {
			try {
				// Seleccionamos o empregado para o que queremos crear o rexistro
				String diEmpregado = Util.solicitarDatoPorConsola("\n   > Documento de identidade (di) do empregado: ");
				empregado = Empregado.buscarEmpregado(empregados, diEmpregado);
				if (empregado == null)
					throw new Exception("     Non existe un empregado co documento de identidade indicado.");
				System.out.println("     O empregado seleccionado é o " + empregado.getClass().getSimpleName() + " '"
						+ empregado.getNome() + "' co DI '" + empregado.getDi() + "'");
				break; // Se atopa o empregado, entón sae do bucle
			} catch (Exception e) {
				System.out.println("[ERRO] Datos incorrectos: " + e.getMessage());
				String opcion = Util
						.solicitarDatoPorConsola("     Prema 's' ou 'S' para saír ou calquera outra para continuar.");
				// Se preme a opción de saír, entón sae do bucle
				if ((opcion != null) && (opcion.equalsIgnoreCase("s")))
					break;
			}
		} while (true);
		return empregado;
	}

	/**
	 * Solicita por consola unha opción de todas as posibles para o tipo de empregado que se pase por parámetro
	 * 
	 * @param empregado Empregado para o cal fitlraremos so as opcións que se permite ao rol que desempeñe
	 * @return A acción atopada
	 */
	public Accion solicitarAccionPorConsola(Empregado empregado) {
		Accion accion = null;
		do {
			try {
				List<Accion> accionsPermitidas = CtrlRexistro.buscarAccions(empregado);
				Util.mostrarDatosPorConsola("\n## Accións permitidas ao " + empregado.getClass().getSimpleName() + " '"
						+ empregado.getNome() + "' co DI '" + empregado.getDi() + "': ", accionsPermitidas);
				String accionSeleccionada = Util.solicitarDatoPorConsola("\n  > Acción seleccionada: ");
				accion = TipoAccion.getAccion(accionSeleccionada);
				if (accion == null)
					throw new Exception(
							"Non indicou unha acción válida para o empregado '" + empregado.getNome() + "'.");
				break; // Se atopa a acción, entón sae do bucle
			} catch (Exception e) {
				System.out.println("[ERRO] Datos incorrectos: " + e.getMessage());
				String opcion = Util
						.solicitarDatoPorConsola("    Prema 's' ou 'S' para saír ou calquera outra para continuar:");
				// Se preme a opción de saír, entón sae do bucle
				if ((opcion != null) && (opcion.equalsIgnoreCase("s")))
					break;
			}
		} while (true);
		return accion;
	}

	/**
	 * Solicita por consola un animal a través do seu nome e devolve o animal atopado
	 * 
	 * @return O animal atopado
	 */
	public Animal solicitarAnimalPorConsola() {
		Animal animal = null;
		// Amosar os animais
		Util.mostrarDatosPorConsola("\n## Listado de animais ##", animais);
		do {
			try {
				// Seleccionamos o animal para o que queremos crear o rexistro
				String codigoAnimal = Util.solicitarDatoPorConsola("\n  > Código do aninal: ");
				animal = Animal.buscarAnimal(animais, codigoAnimal);
				if (animal == null)
					throw new Exception("Non existe un animal co nome indicado.");
				break; // Se atopa o animal, entón sae do bucle
			} catch (Exception e) {
				System.out.println("[ERRO] Datos incorrectos: " + e.getMessage());
				String opcion = Util
						.solicitarDatoPorConsola(" Prema 's' ou 'S' para saír ou calquera outra para continuar.");
				// Se preme a opción de saír, entón sae do bucle
				if ((opcion != null) && (opcion.equalsIgnoreCase("s")))
					break;
			}
		} while (true);
		return animal;
	}

	/**
	 * Crea unha tarefa a partires dos datos introducidos polo usuario por consola
	 * 
	 * @return O rexistro creado polo usuario
	 */
	public Rexistro crearRexistroPorConsola() {
		System.out.println("\n## 1. Engadir rexistro:\n");
		Rexistro rexistro = null;

		try {
			Empregado empregado = solicitarEmpregadoPorConsola();
			Accion accion = solicitarAccionPorConsola(empregado);

			// Se o empregado é un coidador, entón solicitamos o animal ao que fai a acción de coidado
			if (empregado instanceof Coidador) {
				Animal animal = solicitarAnimalPorConsola();
				// Facemos unha conversión explícita a cada tipo para utilizar a función de cada rol
				if (empregado instanceof Veterinario) {
					rexistro = ((Veterinario) empregado).realizarTarefa(animal, (AccionVeterinario) accion);
				} else if (empregado instanceof Auxiliar) {
					rexistro = ((Auxiliar) empregado).realizarTarefa(animal, (AccionAuxiliar) accion);
					ctrlRexistro.getRexistros().add(rexistro);
					System.out.println(rexistro);
				}
			} else if (empregado instanceof Garda) {
				rexistro = ((Garda) empregado).realizarTarefa(accion);
			}
		} catch (Exception e) {
			// Se dá un erro porque inserimos un valor non numérico, entón limpamos o buffer
			Util.scanner.nextLine();
			System.out.println("[ERRO] Datos incorrectos: " + e.getMessage());
		}
		return rexistro;
	}

	/**
	 * Mostra información detallada do animal por consola e executa as súas accións permitidas en función do tipo de
	 * animal e das súas características.
	 */
	public void mostrarInformacionCompletaPorConsola(Animal animal) {
		System.out.println("\n## Información detallada do empregado ##\n");
		System.out.println("O animal seleecionado é un '" + animal.getClass().getSimpleName() + "'");
		System.out.println("\nEn función das súas características vai executar unha serie de accións:");
		if (animal instanceof Acuatico)
			((Acuatico) animal).nadar();
		if (animal instanceof Aereo)
			((Aereo) animal).voar();
		if (animal instanceof Terrestre)
			((Terrestre) animal).mover();
	}

	/**
	 * Método principal que executa a aplicación
	 * 
	 * @param args argumentos pasados por consola (non se utilizan nesta app)
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Inicializamos a aplicación cargando uns animais e empregados de proba, que están xerados na clase
		// Util a través dos métodos indicados.
		ZooApp zoo = new ZooApp(Util.DatosProba.crearAnimais(), Util.DatosProba.crearEmpregados());
		zoo.executar();
	}

}