package uniandes.cupi2.estructuras;

/**
* Representa un arbol. 
* @param <T> Tipo de informacion almacenada por el arbol.
*/
public interface IArbol<T> 
{
	/**
	* Retorna la altura del arbol.
	* @return La altura del arbol.
	*/
	public int darAltura();
	
	/**
	* Retorna el numero de elementos del arbol.
	* @return El numero de elementos del arbol.
	*/
	public int darPeso();
	
	/**
	* Busca un elemento en el arbol dado su modelo.
	* @param elemento Descripcion del elemento que se va a buscar en el arbol. Debe contener por lo menos la informacion minima necesaria para que el metodo de comparacion del
	*        nodo pueda establecer una relacion de orden.
	* @return T elemento del arbol que corresponde al modelo o null si este no existe.
	*/
	public T buscar ( T elemento ); 
	
}
