package uniandes.cupi2.estructuras;

import java.util.Iterator;

public interface Iterador<T> extends Iterator<T>
{	
	/**
	 * Muestra si hay un siguiente elemento
	 * @return true en caso de que lo haya, false en caso contrario
	 */
	public boolean hasNext();
	
	/**
	 * Devuelve el siguiente elemento de tipo T
	 * @return El siguiente elemento de tipo T o null en caso de que no lo haya.
	 */
	public T next();
	
	/**
	 * Regresa al comienzo del iterador
	 */
	public void reiniciar();

}
