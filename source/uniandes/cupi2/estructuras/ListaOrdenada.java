package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;



public class ListaOrdenada<T extends Comparable<T>> implements ILista<T> , Serializable
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Cabeza de la lista
	 */
	private NodoLista<T> primero;


	/**
	 * Longitud de la lista
	 */
	private int longitud;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor de la lista vac’a
	 * <post>: Se construy— una lista vac’a
	 */
	public ListaOrdenada() 
	{
		primero = null;
		longitud = 0;

	}


	// -----------------------------------------------------------------
	// MŽtodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el primer nodo de la lista. <br>
	 * <b>post: </b> Se retorn— el primer nodo de la lista.<br>
	 * @return Primer nodo de la lista. Puede ser null en caso que la lista sea vac’a.<br>
	 */
	public NodoLista<T> darPrimero() 
	{
		return primero;
	}

	/**
	 * Retorna la longitud (cantidad de elementos) de la lista ordenada. <br>
	 * <b>post: </b> Se retorn— la longitud de la lista.<br>
	 * @return Longitud de la lista. Entero mayor o igual a cero.<br>
	 */
	public int darLongitud() 
	{
		return longitud;
	}

	/**
	 * Agrega el elemento en la lista en la posici—n que le corresponde. <br>
	 * <b>post: </b> Se insert— el elemento en la posici—n que le corresponde dentro de la lista de acuerdo a la relaci—n de orden existente entre los elementos de tipo T.<br>
	 * @param nuevoElem Elemento a insertar<br>
	 */
	public void agregar(T nuevoElem) 
	{	
		NodoLista<T> nodo = new NodoLista<T>( nuevoElem );
		if( primero == null )
		{
			primero = nodo;
		}
		else if( nuevoElem.compareTo( primero.darValor( ) ) < 0 )
		{
			// Debe quedar como primer elemento de la lista
			primero.insertarAntes( nodo );
			primero = nodo;
		}
		else
		{
			NodoLista<T> p = primero;
			for( ; p.darSiguiente( ) != null && p.darSiguiente( ).darValor( ).compareTo( nuevoElem ) < 0; p = p.darSiguiente( ) );
			p.insertarDespues( nodo );
		}
		longitud++;

	}
	
	public void agregarPorCriterio(T nuevoElem, Comparator<T> comparador)
	{
		NodoLista<T> nodo = new NodoLista<T>( nuevoElem );
		if( primero == null )
		{
			primero = nodo;
		}
		else if( comparador.compare(nuevoElem, primero.darValor()) < 0 )
		{
			// Debe quedar como primer elemento de la lista
			primero.insertarAntes( nodo );
			primero = nodo;
		}
		else
		{
			NodoLista<T> p = primero;
			for( ; p.darSiguiente( ) != null && comparador.compare(p.darSiguiente().darValor(), nuevoElem) < 0; p = p.darSiguiente( ) );
			p.insertarDespues( nodo );
		}
		longitud++;
	}

	/**
	 * Elimina el elemento especificado de la lista ordenada. <br>
	 * <b>post: </b> Se elimin— el elemento especificado de la lista.<br>
	 * @param aElem Elemento a eliminar<br>
	 * @throws NoExisteException Si el elemento especificado no existe<br>
	 */
	public boolean eliminar(T aElem) 
	{

		boolean seElimino = false;

		if(primero==null) {
			return seElimino; //No elimina y se acaba el metodo
		}

		else if(primero.darValor().compareTo(aElem)==0) {
			primero = primero.darSiguiente();

			longitud--;
			seElimino=true;
		}

		else {

			NodoLista<T> actual = primero;

			while(!seElimino && actual.darSiguiente()!=null) {

				if(actual.darSiguiente().darValor().compareTo(aElem)==0) {

					actual.cambiarSiguiente(actual.darSiguiente().darSiguiente());
					longitud--;
					seElimino = true;

				}
				actual = actual.darSiguiente();
			}

		}

		return seElimino;
	}

	/**
	 * Busca un elemento en la lista ordenada. <br>
	 * <b>post: </b> Se retorn— el elemento o null si no existe. <br>
	 * @param aBuscar Modelo del elemento a buscar<br>
	 * @return Elemento en la lista, null si no existe<br>
	 */
	public T buscar(T aBuscar) {

		NodoLista<T> actual = primero;

		while(actual!=null) {

			if(actual.darValor().compareTo(aBuscar)==0) {
				return actual.darValor();
			}

			actual = actual.darSiguiente();

		}

		return null;
	}

	/**
	 * Devuelve un iterador con los elementos de la lista ordenada. <br>
	 * <b>post:</b> Se retorn— iterador con los elementos de la lista.<br>
	 * @return Iterador con los elementos de la lista, puede ser vac’o pero no null.<br>
	 */
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		IteradorSimple<T> respuesta = new IteradorSimple<T>(longitud);

		NodoLista<T> nodoActual = primero;
		while(nodoActual!=null)
		{
			respuesta.agregar(nodoActual.darValor());
			nodoActual = nodoActual.darSiguiente(); 
		}

		return respuesta;
	}
	
}
