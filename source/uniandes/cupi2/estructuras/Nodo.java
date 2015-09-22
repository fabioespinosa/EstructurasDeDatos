package uniandes.cupi2.estructuras;

import java.io.Serializable;



public class Nodo <T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/** 
	 * El nodo anterior
	 */
	private Nodo<T> anterior;

	/**
	 * El nodo siguiente
	 */
	private Nodo<T> siguiente;

	/**
	 * El elemento que contiene
	 */
	private T elemento;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del nodo
	 * @param nuevo El elemento de tipo IObjeto que va a guardar el nodo
	 * <post>: Se construyo un nodo con el elemento que entra por parametro
	 */
	public Nodo(T nuevo) 
	{

		elemento=nuevo;
		siguiente=null;
		anterior=null;

	}

	/**
	 * Retorna el elemento guardado en el nodo de tipo IObjeto
	 */
	public T darValor(){
		return elemento;
	}

	/**
	 * Retorna el siguiente nodo
	 * @return el nodo siguiente
	 */
	public Nodo<T> darSiguiente(){
		return siguiente;
	}

	/**
	 * Retorna el nodo anterior
	 * @return el nodo anterior
	 */
	public Nodo<T> darAnterior(){
		return anterior;
	}

	/**
	 * Cambia el siguiente nodo por el que entra por parametro
	 * @param nuevoSig. EL nuevo nodo siguiente.
	 */
	public void cambiarSiguiente(Nodo<T> nuevoSig){
		siguiente=nuevoSig;
	}

	/**
	 * Cambia el nodo anterior por el que entra por parametro
	 * @param nuevoAnt. EL nuevo nodo anterior.
	 */
	public void cambiarAnterior(Nodo<T> nuevoAnt){
		anterior=nuevoAnt;
	}

	/**
	 * Inserta el nodo antes del actual. <br>
	 * <b>pre: </b> nodo!=null. <br>
	 * <b>post: </b> Se insert� el nodo especificado antes del actual.
	 * @param nodo Nodo a insertar
	 */
	public void insertarAntes( Nodo<T> nodo )
	{
		nodo.siguiente = this;
		nodo.anterior = anterior;
		if( anterior != null )
		{
			anterior.siguiente = nodo;
		}
		anterior = nodo;
	}

	/**
	 * Inserta el nodo despu�s del actual. <br>
	 * <b>pre: </b> nodo!=null. <br>
	 * <b>post: </b> Se insert� el nodo especificado despu�s del nodo actual.
	 * @param nodo Nodo a insertar
	 */
	public void insertarDespues( Nodo<T> nodo )
	{
		nodo.siguiente = siguiente;
		nodo.anterior = this;
		if( siguiente != null )
		{
			siguiente.anterior = nodo;
		}
		siguiente = nodo;
	}
}