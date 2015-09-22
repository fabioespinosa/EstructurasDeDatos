package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Iterator;

public class ArbolAVL <T extends Comparable<? super T>> implements IArbolOrdenado<T>, Serializable {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	/**
	 * Constante de serializacion
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * La raiz del arbol
	 */
	private NodoAVL<T> raiz;
	
	/**
	 * La cantidad de nodos en el arbol
	 */
	private int peso;
	
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
	
	/**
	 * Crea un nuevo ArbolAVL con la raiz vacia
	 */
	public ArbolAVL()
	{
		raiz=null;
		peso=0;
	}
	
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
	
	/**
	 * Devuelve la raiz del arbol
	 * @return la raiz del arbol
	 */
	public NodoAVL<T> darRaiz(){
		return raiz;
	}
	
	@Override
	public int darPeso() {
		return peso;
	}
	
	@Override
	public int darAltura() {
		if(raiz!=null){
			return raiz.darAltura();
		}
		else{
			return 0;
		}
	}

	@Override
	public T buscar(T elemento) {
		if(raiz!=null){
			return raiz.buscar(elemento);
		}
		else{
			return null;
		}
	}

	@Override
	public boolean insertar(T elemento) {
		boolean devuelto=false;
		if(raiz==null){
			raiz= new NodoAVL<T>(elemento);
			raiz.recalcularBalance();
			peso++;
			return true;
		}
		else{
				devuelto = raiz.insertarElemento(elemento); 
				if (devuelto) {
					raiz.recalcularBalance();
					//raiz = raiz.balancear();
					raiz.recalcularBalance();
					peso++;
					//verificarInvariante();
				}
			}
		return devuelto;
	}

	@Override
	public T eliminar(T elemento) {
		
		T elementoAEliminar=null;
		
		if(raiz!=null){
			elementoAEliminar= raiz.buscar(elemento);
			if(elementoAEliminar!=null){
				//el elemento existe en el arbol
				raiz= raiz.eliminar(elemento);
				if (raiz!=null) {
					raiz.recalcularBalance();
					//raiz = raiz.balancear();
					raiz.recalcularBalance();
				}
				peso--;
				return elementoAEliminar;
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
	}
	
	
	
	public T darMayor(){
		return (raiz!=null)? raiz.darMayor() : null;
	}
	
	public T darMenor(){
		return (raiz!=null)? raiz.darMenor() : null;
	}
	
	
	
    // -----------------------------------------------------------------
    // Iteradores
    // -----------------------------------------------------------------
	
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
	
	
	
	private void verificarInvariante()
	{
		
		if(raiz!=null)
		{
			raiz.verificarInvariante();
		}
		
	}
	

}
