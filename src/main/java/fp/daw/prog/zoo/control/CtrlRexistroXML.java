package fp.daw.prog.zoo.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fp.daw.prog.zoo.Util.TipoFicheiro;
import fp.daw.prog.zoo.rexistro.Rexistro;
import fp.daw.prog.zoo.rexistro.RexistrosListado;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * Clase que se encarga de implementar XestionRexistros para que lea/garde os datos dun ficheiro XML
 */
public class CtrlRexistroXML extends CtrlRexistro {
	
	/**
	 * {@inheritDoc}
	 */
	public CtrlRexistroXML(String rutaFicheiro, String nomeFicheiro) throws Exception {
		super(rutaFicheiro, nomeFicheiro, TipoFicheiro.XML);
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
			
			// Crear un contexto JAXB coa clase RexistrosListado anotada
			JAXBContext context = JAXBContext.newInstance(RexistrosListado.class);
			
			// Crear un Unmarshaller para serializar obxectos Java nun XML
			Marshaller marshaller = context.createMarshaller();
			
			// Configuramos a propiedade para obter a saída formateada e correctamente sangrada
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Engadimos os rexistros consultadas ao listado JAXB que gardaremos nun ficheiro
			RexistrosListado rexistrosListado = new RexistrosListado();
			rexistrosListado.setRexistros(rexistrosTotais);
			
			// Xeramos o noso documento XML a partires da instancia de RexistrosListado
			marshaller.marshal(rexistrosListado, ficheiro);
			
		}
		catch (JAXBException e) {
			e.printStackTrace();
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
	 * {@inheritDoc}
	 */
	@Override
	public List<Rexistro> consultarRexistros() {
		try {
			// Se o ficheiro non existe, entón devolvemos unha lista baleira
			if (!ficheiro.exists())
				return new ArrayList<Rexistro>();
			
			// Crear un contexto JAXB coa clase RexistrosListado anotada
			JAXBContext context = JAXBContext.newInstance(RexistrosListado.class);

			// Crear un Unmarshaller para deserializar XMLs en obxectos Java
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// Deserializar un XML nun obxecto RexistrosListado facendo unha conversión explícita
			RexistrosListado listadoRexistros = (RexistrosListado) unmarshaller.unmarshal(ficheiro);
			return (listadoRexistros.getRexistros() != null) ? listadoRexistros.getRexistros() : new ArrayList<Rexistro>();
		}
		catch (JAXBException e) {
			e.printStackTrace();
			return new ArrayList<Rexistro>();
		}
	}


}
