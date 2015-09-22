package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Iterator;

public class Cola<T> implements Serializable
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
	 * Primer elemento de la cola encadenada
	 */
	private NodoCola<T> primero;

	/**
	 * Ultimo elemento de la cola encadenada
	 */
	private NodoCola<T> ultimo;

	/**
	 * Número de elementos de la cola
	 */
	private int numElems;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor de la cola encadenada vacía. 
	 * post:  Se construyó una cola vacía. primero==null, ultimo==null, numElems = 0
	 */
	public Cola( )
	{
		primero = null;
		ultimo = null;
		numElems = 0;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	/**
	 * Retorna la longitud de la cola (número de elementos). 
	 * post:  Se retornó la longitud de la cola
	 * @return El número de elementos de la cola. Entero positivo o cero.
	 */
	public int darLongitud( )
	{
		return numElems;
	}

	/**
	 * Retorna el primer elemento y lo elimina de la cola. 
	 * post:  Se retornó y eliminó el primer elemento de la cola. Si es el único elemento, el primero y el ultimo son null. La cantidad de los elementos se reduce en 1
	 * @return El primer elemento de la cola o null si la cola se encuentra vacía
	 * 

	 */
	public T ateneder( ) 
	{
		if( primero == null )
		{
			return null;
		}
		else
		{
			NodoCola<T> p = primero;
			primero = primero.desconectarPrimero( );
			if( primero == null )
			{	
				ultimo = null;
			}
			numElems--;
			return p.darElemento();
		}
	}

	/**
	 * Inserta un elemento al final de la cola. 
	 * post:  Se agregó el elemento especificado al final de la cola. Si la cola es vacía, el primer y el ultimo elemento son iguales
	 * @param elemento El elemento a ser insertado. Diferente de null.

	 */
	public void encolar( T elemento )
	{
		NodoCola<T> nodo = new NodoCola<T>( elemento );
		if( primero == null )
		{
			primero = nodo;
			ultimo = nodo;
		}
		else
		{
			ultimo = ultimo.cambiarSiguiente( nodo );
		}
		numElems++;
	}

	/**
	 * Retorna el primer nodo de la cola. Sin eliminarlo
	 * post:  Se retornó el primer nodo de la cola.
	 * @return El primer nodo de la cola
	 */
	public NodoCola<T> darPrimero( )
	{
		return primero;
	}

	/**
	 * Retorna el último nodo de la cola. Sin eliminarlo
	 * post:  Se retornó el último nodo de la cola.
	 * @return El último nodo de la cola
	 */
	public NodoCola<T> darUltimo( )
	{
		return ultimo;
	}

	/**
	 * Indica si la cola se encuentra vacía (no tiene elementos). 
	 * post:  Se retornó true si primero==null o false en caso contrario.
	 * @return True si primero==null o false en caso contrario
	 */
	public boolean estaVacia( )
	{
		return primero == null;
	}
	
	
	
	public Iterator<T> iterator() 
	{
		
		IteradorSimple<T> respuesta = new IteradorSimple<T>(numElems);

		NodoCola<T> nodoActual = primero;
		while(nodoActual!=null)
		{
			respuesta.agregar(nodoActual.darElemento());
			nodoActual = nodoActual.darSiguiente(); 
		}

		return respuesta;
	}
	
	

}
