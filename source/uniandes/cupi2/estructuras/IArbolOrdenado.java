package uniandes.cupi2.estructuras;

/**
* Representa un arbol que ordene sus elementos de alguna forma.
* @param <T> Tipo de elemento a guardar en el arbol.
*/
public interface IArbolOrdenado <T extends Comparable<? super T>> extends IArbol<T>
{	
	/**
	* Inserta un nuevo elemento en el arbol.
	* @param elemento Elemento a insertar.
	 * @return 
	*/
	public boolean insertar( T elemento );
	
	/**
	* Eliminar un elemento del arbol.
	* @param elemento Elemento a eliminar del arbol.
	* @return el elemento a que se elimino o null si no habia dicho elemento en el arbol
	*/
	public T eliminar ( T elemento );
	
	
}
