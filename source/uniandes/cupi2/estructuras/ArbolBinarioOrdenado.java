package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Iterator;

/**
* Implementacion de un arbol binario ordenado
* @param <T> Tipo de datos que contiene cada nodo del arbol. Debe implementar la interface Comparable
*/
public class ArbolBinarioOrdenado<T extends Comparable<?super T>> implements Serializable, IArbolOrdenado<T> 
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para la serializacion
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Raiz del arbol binario ordenado
	 */
	private NodoArbolBinarioOrdenado<T> raiz;

	/**
	 * Peso del arbol binario ordenado
	 */
	private int peso;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del arbol binario ordenado sin elementos. <br>
	 * <b>post: </b> Se construyo un arbol binario ordenado sin elementos.
	 */
	public ArbolBinarioOrdenado( )
	{
		raiz = null;
		peso = 0;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve la raiz del arbol. <br>
	 * <b>post: </b> Se retorno la raíz del arbol.
	 * @return Raiz del árbol.
	 */
	public NodoArbolBinarioOrdenado<T> darRaiz( )
	{
		return raiz;
	}

	/**
	* Inserta un nuevo elemento al arbol.
	* @param elemento Elemento a insertar.
	*/
	public boolean insertar( T elemento ) 
	{	
		boolean seAgrego = false;

		if( raiz == null )
		{
			// Caso 1: el árbol es vacío
			raiz = new NodoArbolBinarioOrdenado<T>( elemento );
			seAgrego = true;
		}

		else
		{
			// Caso 2: el árbol no es vacío
			seAgrego = raiz.insertar( elemento );

		}

		if (seAgrego) 
		{
			peso++;
		}

		return seAgrego;
	}

	/**
	* Eliminar un elemento del arbol.
	* @param elemento Elemento a eliminar del arbol.
	* @return el elemento a que se elimino o null si no habia dicho elemento en el arbol
	*/
	public T eliminar( T elemento )
	{

		T elementoAEliminar = null;

		if( raiz != null )
		{
			elementoAEliminar = raiz.buscar(elemento);

		}

		if( elementoAEliminar!=null )
		{
			// Caso 1: el árbol no es vacío
			raiz = raiz.eliminar( elemento );
			peso--;
		}

		return elementoAEliminar;
	}

	/**
	* Busca un elemento en el arbol dado su modelo.
	* @param elemento Descripcion del elemento que se va a buscar en el arbol. Debe contener por lo menos la informacion minima necesaria para que el metodo de comparacion del
	*        nodo pueda establecer una relacion de orden.
	* @return T elemento del arbol que corresponde al modelo o null si este no existe.
	*/
	public T buscar( T aBuscar )
	{
		if( raiz!=null)
		{
			return raiz.buscar(aBuscar);
		}
		else
		{
			return null;
		}
	}

	/**
	 * Devuelve los elementos del arbol en inorden. <br>
	 * <post>: Se retorno el iterador con los elementos del arbol en inorden.
	 * @return Iterador con los elementos del árbol en inorden
	 */
	public Iterator<T> inorden( )
	{
		IteradorSimple<T> resultado = new IteradorSimple<T>( peso );
		if( raiz != null )
		{
			raiz.inorden( resultado );
		}
		return resultado;
	}
	
	/**
	 * Devuelve los elementos del arbol en preorden. <br>
	 * <post>: Se retorno el iterador con los elementos del arbol en preorden.
	 * @return Iterador con los elementos del arbol en preorden
	 */
	public Iterator<T> preorden()
	{
		IteradorSimple<T> resultado = new IteradorSimple<T>( peso );
		if( raiz != null )
		{
			raiz.preorden( resultado );
		}
		return resultado;
	}
	
	/**
	 * Devuelve los elementos del arbol en posorden. <br>
	 * <post>: Se retorno el iterador con los elementos del arbol en posorden.
	 * @return Iterador con los elementos del arbol en inorden
	 */
	public Iterator<T> posorden()
	{
		IteradorSimple<T> resultado = new IteradorSimple<T>( peso );
		if( raiz != null )
		{
			raiz.posorden( resultado );
		}
		return resultado;
	}
	
	/**
	 * Devuelve los elementos del arbol ordenados por niveles. <br>
	 * <post>: Se retorno el iterador con los elementos del arbol ordenados por niveles
	 * @return Iterador con los elementos del árbol ordenados por niveles
	 */
	public Iterator<T> recorrerPorNiveles()
	{
		IteradorSimple<T> resultado = new IteradorSimple<T>( peso );
		if( raiz != null )
		{
			raiz.recorrerPorNiveles( resultado );
		}
		return resultado;
	}

	/**
	* Retorna la altura del arbol.
	* @return La altura del arbol.
	*/
	public int darAltura( )
	{
		if(raiz!=null)
		{
			return raiz.darAltura();
		}
		else 
		{
			return 0;
		}	
	}

	/**
	* Retorna el numero de elementos del arbol.
	* @return El numero de elementos del arbol.
	*/
	public int darPeso( )
	{
		return peso;
	}

	/**
	 * Devuelve el elemento mayor del arbol. <br>
	 * <b>post:</b> Se retorno el elemento mayor del arbol o null si el arbol esta vacio.
	 * @return El elemento mayor del arbol o null si el arbol esta vacio
	 */
	public T darMayor( )
	{
		if(raiz !=null)
		{
			return raiz.darMayor();
		}
		else 
		{
			return null;
		}
	}

	/**
	 * Devuelve el elemento menor del arbol. <br>
	 * <b>post:</b> Se retorno el elemento menor del arbol o null si el arbol esta vacio.
	 * @return El elemento  menor del arbol o null si el arbol esta vacio
	 */
	public T darMenor( )
	{
		if(raiz !=null)
		{
			return raiz.darMenor();
		}
		else 
		{
			return null;
		}
	}
}
