package uniandes.cupi2.estructuras;

import java.io.Serializable;

public class NodoArbolBinarioOrdenado<T extends Comparable<? super T>> implements Serializable
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
	 * Elemento almacenado en el nodo
	 */
	private T elemento;

	/**
	 * Nodo a la derecha
	 */
	private NodoArbolBinarioOrdenado<T> derechaNodo;

	/**
	 * Nodo a la izquierda
	 */
	private NodoArbolBinarioOrdenado<T> izquierdaNodo;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del nodo. <br>
	 * <b>post:</b> Se creo un nodo con el elemento especificado y con derNodo=null y izqNodo= null.
	 * @param pElemento Elemento que va a ser almacenado en el nodo
	 */
	public NodoArbolBinarioOrdenado( T pElemento )
	{
		elemento = pElemento;
		derechaNodo = null;
		izquierdaNodo = null;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve el elemento del nodo. <br>
	 * <b>post:</b> Se retorno el elemento del nodo.
	 * @return Elemento del nodo
	 */
	public T darElemento( )
	{
		return elemento;
	}

	/**
	 * Devuelve el hijo derecho del nodo. <br>
	 * <b>post:</b> Se retornó el hijo derecho del nodo. Puede ser null.
	 * @return Hijo derecho del nodo
	 */
	public NodoArbolBinarioOrdenado<T> darDerecho( )
	{
		return derechaNodo;
	}

	/**
	 * Devuelve el hijo izquierdo del nodo. <br>
	 * <b>post:</b> Se retornó el hijo izquierdo del nodo. Puede ser null.
	 * @return Hijo izquierdo del nodo
	 */
	public NodoArbolBinarioOrdenado<T> darIzquierdo( )
	{
		return izquierdaNodo;
	}

	/**
	 * Agrega un nuevo elemento en el árbol cuya raíz es el nodo actual. <br>
	 * <b>pre:</b> pElemento!=null. <br>
	 * <b>post:</b> Se insertó el elemento especificado en el árbol.
	 * @param pElemento elemento que se va a agregar
	 * @throws ElementoExisteException Excepción lanzada si el elemento ya existe en el árbol
	 */
	public boolean insertar( T pElemento ) 
	{
		// Compara el valor con el valor del nodo
		int resultado = elemento.compareTo( pElemento );
		if( resultado == 0 )
		{
			// Caso 1: El elemento está en el nodo raíz
			return false;
		}
		else if( resultado > 0 )
		{
			// Caso 2: El elemento se debe insertar en el subárbol izquierdo
			if( izquierdaNodo == null )
			{
				izquierdaNodo = new NodoArbolBinarioOrdenado<T>( pElemento );
				return true;
			}
			else
			{
				return izquierdaNodo.insertar( pElemento );
			}
		}
		else
		{
			// Caso 3: El elemento se debe insertar en el subárbol derecho
			if( derechaNodo == null )
			{
				derechaNodo = new NodoArbolBinarioOrdenado<T>( pElemento );
				return true;
			}
			else
			{
				return derechaNodo.insertar( pElemento );
			}
		}
	}

	/**
	 * Elimina el elemento dado como parámetro, del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se eliminó el elemento si existía en árbol cuya raíz es el nodo actual.
	 * @param pElemento Elemento que se va a eliminar
	 * @return Raíz del árbol producto de eliminar del árbol que comienza en el nodo actual el elemento que llega como parámetro
	 * @throws ElementoNoExisteException Excepción lanzada si el elemento no se encontró en el árbol
	 */
	public NodoArbolBinarioOrdenado<T> eliminar( T pElemento ) 
	{
		// Compara el valor con el valor del nodo
		int resultado = elemento.compareTo( pElemento );
		if( resultado == 0 )
		{
			// Caso 1: El elemento está en el nodo raíz
			if((izquierdaNodo == null) && (derechaNodo == null))
			{
				return null;
			}

			if( izquierdaNodo == null )
			{
				return derechaNodo;
			}
			else if( derechaNodo == null )
			{
				return izquierdaNodo;
			}
			else
			{
				elemento = izquierdaNodo.darMayor( );
				izquierdaNodo = izquierdaNodo.eliminar( elemento );
				return this;
			}
		}
		else if( resultado > 0 )
		{
			// Caso 2: El elemento debe estar en el subárbol izquierdo
			izquierdaNodo = izquierdaNodo.eliminar( pElemento );
			return this;

		}
		else
		{
			// Caso 3: El elemento debe estar en el subárbol derecho
			derechaNodo = derechaNodo.eliminar( pElemento );
			return this;

		}
	}

	/**
	 * Busca el elemento cuyo modelo viene dado como parámetro, en el árbol cuya raíz es el nodo actual. <br>
	 * <b>pre:</b> modelo!=null. <br>
	 * <b>post:</b> Se retornó el elemento que cumple con el modelo o null si no encuentra ninguno.
	 * @param modelo Modelo del elemento que se va a buscar
	 * @return Elemento que cumple con el modelo o null si no encuentra ninguno
	 */
	public T buscar( T modelo )
	{
		// Compara el valor con el valor del nodo
		int resultado = elemento.compareTo( modelo );
		if( resultado == 0 )
		{
			// Caso 1: El elemento está en el nodo raíz
			return elemento;
		}
		else if( resultado > 0 )
		{
			// Caso 2: El elemento debería estar en el subárbol izquierdo
			if(izquierdaNodo!=null)
			{
				return izquierdaNodo.buscar(modelo);
			}
			else
			{
				return null;
			}


		}
		else
		{
			// Caso 3: El elemento debería estar en el subárbol derecho
			if(derechaNodo!=null)
			{
				return derechaNodo.buscar(modelo);
			}
			else
			{
				return null;
			}
		}
	}

	/**
	 * Agrega los elementos al iterador que llega como parámetro, utilizando para esto un recorrido en inorden. <br>
	 * <b>pre:</b> resultado!=null. <br>
	 * <b>post:</b> Se retornó el resultado del recorrido.
	 * @param resultado Resultado del recorrido
	 */
	public void inorden( IteradorSimple<T> resultado )
	{
		// Agrega los elementos del subárbol izquierdo
		if( izquierdaNodo != null )
		{
			izquierdaNodo.inorden( resultado );
		}

		// Agrega el elemento que se encuentra en el nodo
		resultado.agregar( elemento );

		// Agrega los elementos del subárbol derecho
		if( derechaNodo != null )
		{
			derechaNodo.inorden( resultado );
		}
	}

	public void preorden( IteradorSimple<T> resultado )
	{
		// Agrega el elemento que se encuentra en el nodo
		resultado.agregar( elemento );

		// Agrega los elementos del subárbol izquierdo
		if( izquierdaNodo != null )
		{
			izquierdaNodo.preorden( resultado );
		}

		// Agrega los elementos del subárbol derecho
		if( derechaNodo != null )
		{
			derechaNodo.preorden( resultado );
		}
	}

	public void posorden( IteradorSimple<T> resultado )
	{
		// Agrega los elementos del subárbol izquierdo
		if( izquierdaNodo != null )
		{
			izquierdaNodo.posorden( resultado );
		}

		// Agrega los elementos del subárbol derecho
		if( derechaNodo != null )
		{
			derechaNodo.posorden( resultado );
		}

		resultado.agregar( elemento );
	}

	public void recorrerPorNiveles ( IteradorSimple<T> resultado )
	{
		Cola<NodoArbolBinarioOrdenado<T>> colaArbol = new Cola<NodoArbolBinarioOrdenado<T>>();
		colaArbol.encolar(this);
		
		while( !colaArbol.estaVacia() )
		{
			NodoArbolBinarioOrdenado<T> nodoActual = colaArbol.ateneder();
			resultado.agregar(nodoActual.darElemento());
			
			if( nodoActual.darIzquierdo()!=null )
			{
				colaArbol.encolar(nodoActual.darIzquierdo());
			}
			
			if( nodoActual.darDerecho()!=null )
			{
				colaArbol.encolar(nodoActual.darDerecho());
			}
		}
	}

	/**
	 * Devuelve la altura del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se retornó la altura del árbol cuya raíz es el nodo actual. Entero mayor o igual a 1
	 * @return Altura del árbol cuya raíz es el nodo actual
	 */
	public int darAltura( )
	{	
		int canIzq = 0;

		if(izquierdaNodo!=null)
		{
			canIzq = izquierdaNodo.darAltura();
		}

		int canDer = 0;

		if(derechaNodo!=null)
		{
			canDer = derechaNodo.darAltura();
		}

		if(canIzq >= canDer)
		{
			return canIzq+1;
		}
		else
		{
			return canDer+1;
		}

	}

	/**
	 * Retorna el elemento mayor del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se retornó el elemento mayor del árbol cuya raíz es el nodo actual o null si el árbol es vacio.
	 * @return Elemento mayor del árbol cuya raíz es el nodo actual o null si el árbol es vacío
	 */
	public T darMayor( )
	{
		NodoArbolBinarioOrdenado<T> mayor = mayorElemento( );

		if(mayor!=null)
		{
			return mayor.darElemento();
		}
		else 
		{
			return null;
		}
	}

	/**
	 * Retorna el elemento menor del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se retornó el elemento menor del árbol cuya raíz es el nodo actual o null si el árbol es vacio.
	 * @return Elemento menor del árbol cuya raíz es el nodo actual o null si el árbol es vacío
	 */
	public T darMenor( )
	{
		NodoArbolBinarioOrdenado<T> menor = menorElemento( );

		if(menor!=null)
		{
			return menor.darElemento();
		}
		else 
		{
			return null;
		}
	}

	// -----------------------------------------------------------------
	// Operaciones Auxiliares
	// -----------------------------------------------------------------

	/**
	 * Retorna el nodo con el mayor elemento del árbol. <br>
	 * <b>post:</b> Se retornó el nodo con el mayor elemento del árbol.
	 * @return Nodo Nodo con el mayor elemento del árbol
	 */
	private NodoArbolBinarioOrdenado<T> mayorElemento( )
	{
		if(derechaNodo == null)
		{
			return this;
		}
		else 
		{
			return derechaNodo.mayorElemento();
		}

	}

	/**
	 * Retorna el nodo menor elemento del árbol. <br>
	 * <b>post:</b> Se retornó el nodo con el menor elemento del árbol.
	 * @return Nodo El nodo con el menor elemento del árbol
	 */
	private NodoArbolBinarioOrdenado<T> menorElemento( )
	{
		if(izquierdaNodo == null)
		{
			return this;
		}
		else 
		{
			return izquierdaNodo.menorElemento();
		}
	}

}
