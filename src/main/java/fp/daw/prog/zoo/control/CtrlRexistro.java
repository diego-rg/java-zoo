package fp.daw.prog.zoo.control;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fp.daw.prog.zoo.Util.TipoFicheiro;
import fp.daw.prog.zoo.persoa.Auxiliar;
import fp.daw.prog.zoo.persoa.Empregado;
import fp.daw.prog.zoo.persoa.Garda;
import fp.daw.prog.zoo.persoa.Veterinario;
import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.TipoAccion;
import fp.daw.prog.zoo.rexistro.TipoAccion.Accion;

public abstract class CtrlRexistro {

	protected static final String SPLIT_CHAR = ";";
	protected TipoFicheiro tipoFicheiro;
	protected File ficheiro = null;

	/**
	 * Listado que garda todos os rexistros de accións realizado polo empregado.
	 */
	protected List<Rexistro> rexistros = new ArrayList<Rexistro>();

	/**
	 * Construtor da clase CtrlRexistro.
	 * 
	 * @param rutaFicheiro Ruta ao ficheiro
	 * @param nomeFicheiro O nome do ficheiro.
	 * @param tipoFicheiro O tipo de ficheiro onde gardamos os datos do rexistro de accións
	 * @throws Exception
	 */
	public CtrlRexistro(String rutaFicheiro, String nomeFicheiro, TipoFicheiro tipoFicheiro) throws Exception {
		if (rutaFicheiro == null || nomeFicheiro == null)
			throw new Exception("Debe indicar unha rota válida e un nome de ficheiro para gardar os rexistros");

		this.tipoFicheiro = tipoFicheiro;
		nomeFicheiro = nomeFicheiro.endsWith(tipoFicheiro.getFormato()) ? nomeFicheiro
				: nomeFicheiro + tipoFicheiro.getFormato();
		ficheiro = new File(rutaFicheiro + nomeFicheiro);
	}

	/**
	 * Engade os rexistros ao final do sistema de ficheiros utilizado. No caso de non existir o ficheiro crearao
	 * 
	 * @param rexistros Os rexistros a engadir
	 */
	public abstract void gardarRexistros(List<Rexistro> rexistros);

	/**
	 * Engade o rexistro ao final do sistema de ficheiros utilizado * No caso de non existir o ficheiro crearao
	 * 
	 * @param rexistros A rexistros engadir
	 */
	public abstract void gardarRexistro(Rexistro rexistro);

	/**
	 * Permite consultar o listado de rexistros desde o ficheiro
	 * 
	 * @return Listado de rexistros desde o ficheiro
	 */
	public abstract List<Rexistro> consultarRexistros();

	/**
	 * Elimina o ficheiro de rexistros
	 */
	public void borrarFicheiro() {
		if (ficheiro == null) {
			System.out.println("Debe indicar un ficheiro (o valor indicao é nulo).");
		} else if (!ficheiro.exists()) {
			System.out.println("O ficheiro indicado non existe.");
		} else if (ficheiro.delete()) {
			System.out.println("O ficheiro foi borrado con éxito.");
		} else {
			System.out.println("Non se puido borrar o ficheiro.");
		}
	}

	/**
	 * Renomea o ficheiro onde se gardan os rexistros
	 *
	 * @param novoNome Nome que se asignará ao ficheiro de datos
	 */
	public Boolean renomearFicheiro(String novoNome) {
		// Para que sexa compatible con todos os sistemas operativos, usamos a propiedade File.separator
		// que nos devolve a barra separadora compatible co sistema no que executamos a app
		String rutaNovoFicheiro = ficheiro.getParent() + File.separator + novoNome + tipoFicheiro.getFormato();
		File novoFicheiro = new File(rutaNovoFicheiro);
		Boolean resultado = ficheiro.renameTo(novoFicheiro);
		ficheiro = novoFicheiro;
		return resultado;
	}

	/**
	 * Obtén o ficheiro no que se gardan os rexistros
	 *
	 * @return O ficheiro no que se gardan os rexistros
	 */
	public File getFicheiro() {
		return ficheiro;
	}

	/**
	 * Busca as accións permitidas para o tipo de empregado indicado e devolve so as que se permiten a cada tipo de
	 * empregado
	 * 
	 * @param empregado Empregado para o que se buscan as accións permitidas en función do seu rol
	 * @return Listado de accións permitidas ao usuario indicado
	 */
	public static List<Accion> buscarAccions(Empregado empregado) {
		List<Accion> accions = new ArrayList<Accion>();
		if (empregado == null)
			return accions;
		if (empregado instanceof Garda) {
			accions.addAll(Arrays.asList(TipoAccion.AccionGarda.values()));
		} else if (empregado instanceof Auxiliar) {
			accions.addAll(Arrays.asList(TipoAccion.AccionAuxiliar.values()));
		} else if (empregado instanceof Veterinario) {
			accions.addAll(Arrays.asList(TipoAccion.AccionVeterinario.values()));
		}
		return accions;
	}

	/**
	 * Obtén o valor de tipoFicheiro
	 *
	 * @return o valor de tipoFicheiro
	 */
	public TipoFicheiro getTipoFicheiro() {
		return tipoFicheiro;
	}

	/**
	 * Obtén o valor de rexistros
	 *
	 * @return o valor de rexistros
	 */
	public List<Rexistro> getRexistros() {
		return rexistros;
	}

}
