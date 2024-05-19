package fp.daw.prog.zoo.animal;

import java.util.Collection;
import java.util.Date;

/**
 * Clase abstracta que representa un animal do zoo.
 */
public abstract class Animal {

	private String codigo;
	private String nome;
	private Date dataNacemento;

	/**
	 * Construtor da clase animal
	 * 
	 * @param codigo        Código do animal.
	 * @param nome          O nome do animal.
	 * @param dataNacemento Data de nacemento do animal.
	 */
	public Animal(String codigo, String nome, Date dataNacemento) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNacemento = dataNacemento;
	}

	/**
	 * Método abstracto para emitir son.
	 */
	public abstract void emitirSon();

	/**
	 * Método abstracto para alimentar ao animal.
	 */
	public abstract void alimentar();

	/**
	 * Método abstracto para descansar un animal.
	 */
	public abstract void descansar();	
	
		
	/**
	 * Obtén o valor de codigo
	 *
	 * @return o valor de codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Configura o valor de codigo
	 * 
	 * @param codigo o valor de codigo a configurar
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método para obter o nome do animal.
	 * 
	 * @return O nome do animal.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para configurar o nome do animal.
	 * 
	 * @param nome nome do animal a configurar
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método para obter a data de nacemento do animal.
	 * 
	 * @return the dataNacemento
	 */
	public Date getDataNacemento() {
		return dataNacemento;
	}

	/**
	 * Método para configurar a data de nacemento do animal.
	 * 
	 * @param dataNacemento the dataNacemento to set
	 */
	public void setDataNacemento(Date dataNacemento) {
		this.dataNacemento = dataNacemento;
	}
	
	/**
	 * Busca un animal entre unha colección de animais
	 * 
	 * @param  animais listado de animais sobre o que buscar
	 * @param  codigo  Codigo do animal que queremos buscar
	 * @return         O animal buscado se existe, e senón null
	 */
	public static Animal buscarAnimal(Collection<Animal> animais, String codigo) {
		if (animais == null)
			return null;
		for (Animal animal : animais) {
			if (animal.getCodigo().equals(codigo))
				return animal;
		}
		return null;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Animal [codigo: '" + codigo + "'] => tipo: '" + this.getClass().getSimpleName() + "', nome: '" + nome + "', dataNacemento: '" + dataNacemento + "'";
	}

}