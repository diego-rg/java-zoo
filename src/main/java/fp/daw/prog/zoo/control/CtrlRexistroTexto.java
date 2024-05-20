package fp.daw.prog.zoo.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fp.daw.prog.zoo.Util;
import fp.daw.prog.zoo.Util.TipoFicheiro;
import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.TipoAccion;

/**
 * Clase que se encarga de implementar XestionRexistros para que lea/garde os datos dun ficheiro TXT
 */
public class CtrlRexistroTexto extends CtrlRexistro {

	/**
	 * {@inheritDoc}
	 */
	public CtrlRexistroTexto(String rutaFicheiro, String nomeFicheiro) throws Exception {
		super(rutaFicheiro, nomeFicheiro, TipoFicheiro.TXT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void gardarRexistros(List<Rexistro> rexistros) {
		try {
			// Se rexistros é nulo, entón non facemos nada
			if (rexistros == null)
				return;
			// Consultamos os rexistros do ficheiro para poder gardalas todas
			List<Rexistro> rexistrosTotais = consultarRexistros();
			rexistrosTotais.addAll(rexistros);

			// Abre o ficheiro para escritura usando FileWriter no modo de engadir ao final respectando o seu contido
			FileWriter fileWriter = new FileWriter(ficheiro, true);

			// Envolve FileWriter nun BufferedWriter para unha escritura máis eficiente
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Percorremos os rexistros e ímolos gardando no ficheiro
			for (Rexistro rexistro : rexistros) {
				// Escribir o contido no ficheiro

				// Se NON usa animal = 3 datos
				if (rexistro.getCodigoAnimal() == null) {
					String line = Util.converterData(rexistro.getData()) + SPLIT_CHAR + rexistro.getNomeEmpregado()
							+ SPLIT_CHAR + rexistro.getAccion();
					bufferedWriter.write(line);
					bufferedWriter.newLine(); // Engade un salto de liña
				} else {

					// Se usa animal = 5 datos
					String line = Util.converterData(rexistro.getData()) + SPLIT_CHAR + rexistro.getNomeEmpregado()
							+ SPLIT_CHAR + rexistro.getCodigoAnimal() + SPLIT_CHAR + rexistro.getTipoAnimal()
							+ SPLIT_CHAR + rexistro.getAccion();
					bufferedWriter.write(line);
					bufferedWriter.newLine(); // Engade un salto de liña
				}
			}
			System.out.println("Rexistros gardados con éxito.");

			// Pecha o BufferedWriter e o FileWriter
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Erro ao gardar os rexistros no ficheiro: " + e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void gardarRexistro(Rexistro rexistro) {
		gardarRexistros(Arrays.asList(rexistro));
	}

	/**
	 * Crea un rexistro a partir dun numero variable de datos lidos do documento de texto
	 * 
	 * @param String partesLinha cada un dos datos obtidos de cada liña lida
	 * @return Rexistro rexistro lido do TXT
	 */
	public Rexistro obterRexistro(String[] partesLinha) {
		// Asignamos cada valor ao atributo correspondente dependendo do numero de datos

		// 3 datos = accion sin animal: date, nome empregado, accion
		if (partesLinha.length == 3)
			try {
				return new Rexistro(Util.obterData(partesLinha[0]), partesLinha[0],
						TipoAccion.getAccion(partesLinha[2]));
			} catch (Exception e) {
				System.err.println("Erro ao convertir as datos de texto a data: " + e.getMessage());
			}

		// 5 datos: accion con animal: data, nomeEmpregado, codigoAnimal, tipoAnimal, accion
		if (partesLinha.length == 5)
			try {
				return new Rexistro(Util.obterData(partesLinha[0]), partesLinha[1], partesLinha[2], partesLinha[3],
						TipoAccion.getAccion(partesLinha[4]));
			} catch (Exception e) {
				System.err.println("Erro ao convertir as datos de texto a data: " + e.getMessage());
			}

		// Se non coincide con ningun constructor
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Rexistro> consultarRexistros() {
		List<Rexistro> rexistros = new ArrayList<>();
		try (BufferedReader lector = new BufferedReader(new FileReader(ficheiro))) {
			String liña;
			while ((liña = lector.readLine()) != null) {
				// Cada liña ten campos separados por "," e obtémolos separados nun array co método "split"
				String[] partesLinha = liña.split(SPLIT_CHAR);

				// Creamos un novo rexistro por cada liña de datos de TXT
				Rexistro rexistro = obterRexistro(partesLinha);

				// Engadimos o rexistro
				rexistros.add(rexistro);
			}
			System.out.println("Rexistros cargados con éxito.");
		} catch (IOException e) {
			System.err.println("Erro ao ler os rexistros do ficheiro: " + e.getMessage());
		}
		return rexistros;
	}

}
