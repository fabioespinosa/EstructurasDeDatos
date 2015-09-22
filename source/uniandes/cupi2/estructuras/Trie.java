package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Iterator;

public class Trie<T extends Comparable<T>> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodoTrie<T> raiz;
	
	
	public Trie()
	{
		raiz = new NodoTrie<T>('#');
	}
	
	public int darAltura()
	{
		return raiz.darAltura();
	}
	
	public int darPeso()
	{
		return raiz.darPeso();
	}
	
	public boolean agregar (String llave, Iterator<T> iterElementos )
	{
		return raiz.agregar(llave, iterElementos);
	}
	
	public ListaOrdenada<T> buscar( String llave )
	{
		return raiz.buscar(llave);
	}
	
	public ListaOrdenada<T> buscarPorPrefijo( String llave )
	{
		return raiz.buscarPorPrefijo(llave);
	}
	
		
	/**
	 * Main de prueba
	 * @param args
	 */
	public static void main( String[] args)
	{
		Trie<Integer> elTrie = new Trie<Integer>();
		
		String llave1 = "prueba";
		IteradorSimple<Integer>  iterElem = new IteradorSimple<Integer>(10);
		for(int i=0; i<10; i++)
		{
			
			iterElem.agregar(i);
		}
		
		elTrie.agregar(llave1, iterElem);
		
		String llave2 = "pruebaSegunda";
		IteradorSimple<Integer>  iterElem2 = new IteradorSimple<Integer>(10);
		for(int i=10; i<20; i++)
		{
			
			iterElem2.agregar(i);
		}
		
		elTrie.agregar(llave2, iterElem2);
		
		String llave3 = "prue";
		IteradorSimple<Integer>  iterElem3 = new IteradorSimple<Integer>(10);
		for(int i=20; i<30; i++)
		{
			
			iterElem3.agregar(i);
		}
		
		elTrie.agregar(llave3, iterElem3);
		
		String llave4 = "ultima";
		IteradorSimple<Integer>  iterElem4 = new IteradorSimple<Integer>(10);
		for(int i=30; i<40; i++)
		{
			
			iterElem4.agregar(i);
		}
		
		elTrie.agregar(llave4, iterElem4);
		
		Iterator<Integer> resp = elTrie.buscar(llave4).iterator();
		while(resp.hasNext())
		{
			System.out.println("Encontro a: "+resp.next());
		}
		
		System.out.println("La altura es: "+elTrie.darAltura());
		
		Iterator<Integer> iterPorPrefijo = elTrie.buscarPorPrefijo("ul").iterator();
		while(iterPorPrefijo.hasNext())
		{
			System.out.println("Encontro a: "+iterPorPrefijo.next());
		}
		
		System.out.println("El peso es: "+elTrie.darPeso());
	
	}
	
	
}
