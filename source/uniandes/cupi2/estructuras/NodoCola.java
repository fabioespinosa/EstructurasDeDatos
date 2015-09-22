package uniandes.cupi2.estructuras;

import java.io.Serializable;


public class NodoCola<T> implements Serializable
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para la serialización
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Elemento del nodo
	 */
	private T elemento;

	/**
	 * Siguiente elemento encadenado
	 */
	private NodoCola<T> sigNodo;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor por parámetros del nodo. <br>
	 * <b>post: </b> Se construyó el nodo con el elemento especificado, sigNodo=null y elemento = pElemento.<br>
	 * @param pElemento Elemento que va a ser almacenado en el nodo. Diferente de null<br>
	 */
	public NodoCola( T pElemento )
	{
		elemento = pElemento;
		sigNodo = null;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el elemento del nodo. <br>
	 * <b>post: </b> Se retornó el elemento contenido en el nodo.<br>
	 * @return El elemento contenido en el nodo. Diferente de null<br>
	 */
	public T darElemento( )
	{
		return elemento;
	}

	/**
	 * Desconecta el nodo de la cola suponiendo que es el primero. <br>
	 * <b>pre: </b> El nodo actual es el primer nodo de la cola. <br>
	 * <b>post: </b> Se retornó el nodo con el cual comienza la cola ahora, sigNodo=null.<br>
	 * @return Nodo con el cual comienza la cola ahora.<br>
	 */
	public NodoCola<T> desconectarPrimero( )
	{
		NodoCola<T> p = sigNodo;
		sigNodo = null;
		return p;
	}



	/**
	 * Inserta el nodo especificado después del nodo actual. <br>
	 * <b>post: </b> Se insertó el nodo después del nodo actual lo que implica que sigNodo=nodo.<br>
	 * @param nodo El nodo a ser insertado<br>
	 * @return Nodo que se insertó después del nodo actual<br>
	 */
	public NodoCola<T> cambiarSiguiente( NodoCola<T> nodo )
	{
		sigNodo = nodo;
		return nodo;
	}

	/**
	 * Retorna el siguiente nodo. <br>
	 * <b>post: </b> Se retornó el siguiente nodo.<br>
	 * @return El nodo siguiente<br>
	 */
	public NodoCola<T> darSiguiente( )
	{
		return sigNodo;
	}

}