package uniandes.cupi2.estructuras;

import java.io.Serializable;



public class NodoLista <T extends Comparable<T>> implements INodo<T>, Serializable {

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
	private NodoLista<T> anterior;

	/**
	 * El nodo siguiente
	 */
	private NodoLista<T> siguiente;

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
	public NodoLista(T nuevo) 
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
	public NodoLista<T> darSiguiente(){
		return siguiente;
	}

	/**
	 * Retorna el nodo anterior
	 * @return el nodo anterior
	 */
	public NodoLista<T> darAnterior(){
		return anterior;
	}

	/**
	 * Cambia el siguiente nodo por el que entra por parametro
	 * @param nuevoSig. EL nuevo nodo siguiente.
	 */
	public void cambiarSiguiente(NodoLista<T> nuevoSig){
		siguiente=nuevoSig;
	}

	/**
	 * Cambia el nodo anterior por el que entra por parametro
	 * @param nuevoAnt. EL nuevo nodo anterior.
	 */
	public void cambiarAnterior(NodoLista<T> nuevoAnt){
		anterior=nuevoAnt;
	}

	/**
	 * Inserta el nodo antes del actual. <br>
	 * <b>pre: </b> nodo!=null. <br>
	 * <b>post: </b> Se insertó el nodo especificado antes del actual.
	 * @param nodo Nodo a insertar
	 */
	public void insertarAntes( NodoLista<T> nodo )
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
	 * Inserta el nodo después del actual. <br>
	 * <b>pre: </b> nodo!=null. <br>
	 * <b>post: </b> Se insertó el nodo especificado después del nodo actual.
	 * @param nodo Nodo a insertar
	 */
	public void insertarDespues( NodoLista<T> nodo )
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