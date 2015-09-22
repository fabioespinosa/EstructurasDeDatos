package uniandes.cupi2.estructuras;

/**
 * Interfaz que indica todos los metodos que las listas deben tener
 * @author fabioespinsoa & sebastianSierra
 *
 * @param <T> Este identificador se usara para que las listas genericas funcionen con cualquier IObjeto
 */
public interface ILista<T extends Comparable<T>> extends Iterable<T> {

	/**
	 * Agrega un nuevo elemento al final de la lista
	 * @param nuevoElem El elemento que se desea agregar
	 * <post> Se agregó el elemento a la lista
	 */
	public void agregar(T nuevoElem);

	/**
	 * Se elimina un elemento de la lista dado por parámetro
	 * @param aElem El eleménto que se desea eliminar
	 * @return Verdadero si se logro eliminar o falso en caso contrario
	 */
	public boolean eliminar(T aElem);

	/**
	 * Devuelve la longitud de la lista
	 * @return La longitud de la lista
	 */
	public int darLongitud();

	/**
	 * Busca un elemento que llega por parámetro
	 * @param aBuscar El elemento que se desea buscar
	 * @return El elemento buscado
	 */
	public T buscar(T aBuscar);
	
	/**
	 * Devuelve el primer elemento de la lista
	 * @return El primer elemento de la lista
	 */
	public INodo<T> darPrimero();
	
}
