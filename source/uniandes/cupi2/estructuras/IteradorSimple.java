package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorSimple<T> implements Iterator<T>
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constante para posici—n del iterador por defecto
	 */
	private final static int INICIAL = -1;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Elementos sobre los que se est‡ iterando
	 */
	private T[] elementos;

	/**
	 * Posici—n del pr—ximo elemento a ser visitado
	 */
	private int posActual;

	/**
	 * Nœmero de elementos sobre los que se est‡ iterando.
	 */
	private int numeroDeElementos;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor de un iterador con el tama–o (capacidad) especificado. <br>
	 * <b> post: </b> Se cre— un iterador con la capacidad especificada.<br>
	 * @param tamano El tama–o que va a tener el iterador<br>
	 */
	public IteradorSimple(int tamano)
	{
		elementos = (T[])new Object[tamano];
		numeroDeElementos = 0;
		posActual = INICIAL;
	}

	// -----------------------------------------------------------------
	// MŽtodos: interface Iterador
	// -----------------------------------------------------------------

	/**
	 * Indica si aœn hay elementos sobre los cuales iterar. <br>
	 * <b>post: </b> Se retorn— true si aœn no se han recorrido todos los elementos o false en caso contrario.
	 * @return True si aœn no se han recorrido todos los elementos o false en caso contrario
	 */
	public boolean hasNext() 
	{

		if(elementos.length > 0 && (posActual+1) < numeroDeElementos) 
		{
			return true;
		} 

		else 
		{
			return false;
		}

	}

	/**
	 * Retorna el elemento a ser visitado. <br>
	 * <b>pre: </b> Aœn existe al menos un elemento sobre el cual iterar. <br>
	 * @return El elemento a ser visitado. De no existir un siguiente se retorna null.
	 */
	public T next() throws NoSuchElementException
	{
		if(hasNext())
		{
			return elementos[++posActual];
		}

		else 
		{
			throw new NoSuchElementException();
		}

	}

	/**
	 * Sitœa el iterador de nuevo al inicio de la colecci—n de datos con la que se encuentra asociado. <br>
	 * <b>post: </b> El iterador se encuentra al inicio de la colecci—n de datos con la que se encuentra asociada.
	 */
	public void reiniciar( )
	{
		posActual = INICIAL;
	}

	/**
	 * Agrega un nuevo elemento al final del iterador. <br>
	 * <b>post: </b> Se adicion— el elemento especificado en la œltima posici—n del iterador, y sigPosLibre= sigPosLibre+1.
	 * @throws IteradorException Si el iterador no tiene capacidad para m‡s elementos
	 */
	public void agregar( T elemento ) 
	{
		if( numeroDeElementos <= elementos.length - 1 )
		{
			elementos[ numeroDeElementos++ ] = elemento;
		}
	}

	/**
	 * Este iterador no soporta remover el elemento, por eso lanza la excepci—n
	 */
	public void remove() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	public T[] darElementos()
	{
		return elementos;
	}

}
