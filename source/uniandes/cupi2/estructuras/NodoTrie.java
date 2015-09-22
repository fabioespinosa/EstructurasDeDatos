package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Iterator;

public class NodoTrie<T extends Comparable<T>> implements Comparable<NodoTrie<T>>, Serializable
{
	private char caracter;
	private boolean ocupado;
	private ListaOrdenada<NodoTrie<T>> hijos;
	private ListaOrdenada<T> elementos;

	public NodoTrie( char pCaracter )
	{
		caracter = pCaracter;
		ocupado = false;
		hijos = new ListaOrdenada<NodoTrie<T>>();
		elementos = new ListaOrdenada<T>();
	}

	public int darAltura()
	{
		int mayorAlturaHijo = 0;
		Iterator<NodoTrie<T>> it = hijos.iterator();

		while( it.hasNext() )
		{
			NodoTrie<T> hijoActual = it.next();
			int alturaActual = hijoActual.darAltura();
			if(alturaActual >mayorAlturaHijo)
			{
				mayorAlturaHijo = alturaActual;
			}
		}

		return mayorAlturaHijo+1;
	}

	public int darPeso()
	{
		int pesoActual = elementos.darLongitud();
		
		Iterator<NodoTrie<T>> iterHijos = hijos.iterator();
		while( iterHijos.hasNext() )
		{
			pesoActual+=iterHijos.next().darPeso();
		}
		
		return pesoActual;
	}


	/**
	 * En hijo-hermano
	 */

	//	public int darAltura()
	//	{
	//		int mayorAlturaHijo=0;
	//		int mayorAlturaHermano=0;
	//
	//		if(hijo!=null)
	//		{
	//			mayorAlturaHijo = hijo.darAltura();
	//
	//		}
	//
	//		if(hermano!=null)
	//		{
	//			mayorAlturaHermano = hermano.darAltura();
	//		}
	//
	//		if(mayorAlturaHijo+1>mayorAlturaHermano)
	//		{
	//			return mayorAlturaHijo+1;
	//		}
	//
	//		else 
	//		{
	//			return mayorAlturaHermano;
	//		}
	//	}

	public ListaOrdenada<T> buscar( String llave )
	{
		char letra = llave.charAt(0);
		NodoTrie<T> hijo = hijos.buscar( new NodoTrie<T>(letra) );  //No es recursivo
		if(hijo==null)
		{
			return new ListaOrdenada<T>();
		}
		else if( llave.length() == 1)
		{
			return hijo.elementos;
		}
		else 
		{
			return hijo.buscar(llave.substring(1));
		}
	}


	public int compareTo(NodoTrie<T> o) 
	{
		return Character.toLowerCase(caracter)-Character.toLowerCase(o.caracter);
	}

	//TODO Actualizar el estado del nodo
	public boolean agregar (String llave, Iterator<T> iterElementos )
	{
		char letra = llave.charAt(0);
		NodoTrie<T> hijo = hijos.buscar( new NodoTrie<T>(letra) );
		if( llave.length() == 1 )
		{
			if( hijo == null)
			{
				NodoTrie<T> nuevoHijo = new NodoTrie<T>( letra );

				while(iterElementos.hasNext())
				{
					nuevoHijo.elementos.agregar(iterElementos.next());
				}

				nuevoHijo.ocupado = true;
				hijos.agregar(nuevoHijo);
				System.out.println("Se creo nuevo con char: "+nuevoHijo.caracter +" y se agregaron elementos");
				return true;
			}

			else
			{
				while(iterElementos.hasNext())
				{
					hijo.elementos.agregar(iterElementos.next());
				}

				hijo.ocupado = true;
				System.out.println("Se recupero con char: "+hijo.caracter +" y se agregaron elementos");
				return true;
			}

		}

		else 
		{
			if( hijo == null)
			{
				NodoTrie<T> nuevoHijo = new NodoTrie<T>( letra );
				hijos.agregar(nuevoHijo);
				System.out.println("Se creo nuevo con char: "+nuevoHijo.caracter);
				return nuevoHijo.agregar(llave.substring(1), iterElementos);
			}

			else
			{	
				System.out.println("Se recupero con char: "+hijo.caracter);
				return hijo.agregar(llave.substring(1), iterElementos);
			}
		}
	}

	public ListaOrdenada<T> buscarPorPrefijo( String llave )
	{
		char letra = llave.charAt(0);
		NodoTrie<T> hijo = hijos.buscar( new NodoTrie<T>(letra) );  //No es recursivo
		//System.out.println("Encontro al hijo: "+hijo.caracter);
		if(hijo==null)
		{
			return new ListaOrdenada<T>();
		}
		else if( llave.length() == 1)
		{
			ListaOrdenada<T> listaRespuesta = new ListaOrdenada<T>();
			hijo.agregarAIterador(listaRespuesta);
			return listaRespuesta;
		}
		else 
		{
			return hijo.buscarPorPrefijo(llave.substring(1));
		}
	}
	
	

	public void agregarAIterador( ListaOrdenada<T> listaRespuesta )
	{

		Iterator<T> iterElementos = elementos.iterator();
		while( iterElementos.hasNext() )
		{
			listaRespuesta.agregar( iterElementos.next() );
		}

		Iterator<NodoTrie<T>> iterHijos = hijos.iterator();
		while( iterHijos.hasNext() )
		{
			NodoTrie<T> hijo = iterHijos.next();
			hijo.agregarAIterador(listaRespuesta);
		}

	}

	/**
	 * En hijo-hermano
	 * @param llave
	 * @return
	 */
	//	public Iterator<T> buscar( String llave )
	//	{
	//		if( caracter == llave.charAt(0) )
	//		{
	//
	//			if( llave.length() == 1)
	//			{
	//				return elementos.iterator();
	//			}
	//			else if( hijo!=null )
	//			{
	//				return hijo.buscar( llave.substring(1) )
	//			}
	//			else 
	//			{
	//				return new IteradorSimple();
	//			}
	//
	//
	//		}
	//
	//		else
	//		{
	//			if( hermano!=null )
	//			{
	//				return hermano.buscar(llave);
	//			}
	//		}
	//
	//		return new IteradorSimple();
	//	}


}
