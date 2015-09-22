package uniandes.cupi2.estructuras;

import java.io.Serializable;
import java.util.Iterator;

public class TablaHashing <V, K extends Comparable<K>> implements Iterable<V>, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static double FACTOR_DE_CARGA=0.75;

	private ListaOrdenada<EntradaTabla<K, V>> [] tabla;

	private int cantidadDeElementos;

	private int tamano;

	private int casillasLlenas;
	//Tama�o tiene que ser numero primo, superior al maximo numero elementos.

	//class k implementa comparable <celular>
	//se necesita una funcion que pase de la llave a un numero natural y otra funcion que lo pase a un numero de [0, M-1]
	//la clase del elemento V tiene que tener la funcion que pasa de string a int con la funcion "hashCode", tambien tiene que tener el 


	public TablaHashing(int cantidadElementos){

		tamano=cantidadElementos;
		casillasLlenas=0;
		cantidadElementos = 0;

		//asegurarme de que el tama�o sea un numero primo.

		while(!esPrimo(tamano)){
			tamano=tamano+1;
		}

		tabla = new ListaOrdenada[tamano];


		//for(int i=0;i<tamano-1;i++){
		//tabla[i] = new ListaOrdenada<EntradaTabla<K, V>>() ;  para no gastar memoria
		//}

	}



	public boolean esPrimo(int num){
		int numero = (int)Math.sqrt(num);
		for(int i = 2; i <= numero; i++){
			if((num % i) == 0) return false;
		}
		return true;
	}



	//la tabal tiene un metodo hash "int hash(K llave)" le pide al objeto k que hashCode y sobre ese le aplica el modulo sobre la capacidad. 

	public int hash(K nLlave){
		return nLlave.hashCode();
	}

	public int darPosicion(int nReal){

		return nReal%tamano;
	}

	/**
	 * Verifica que el factod de carga no se haya aumentado, ademas, verific que la cantidad de elementos no sobrepase el 75% del tamano de la tabla
	 * @param elemento
	 * @param nLlave
	 * @return
	 */
	public boolean agregarElemento(V elemento, K nLlave){
		//verifica si al agregar este elemento se pasa el factor de carga
		if(((casillasLlenas+1)/tamano)>FACTOR_DE_CARGA){
			reHashing();
		}
		

		EntradaTabla<K, V> nuevaEntrada= new EntradaTabla<K, V>(nLlave, elemento);	

		int pos = darPosicion(hash(nLlave));
		if(tabla[pos]==null) //Si no hay una lista en esa posicion, se crea una
		{
			tabla[pos] = new ListaOrdenada<EntradaTabla<K,V>>();
			casillasLlenas++;
		}

		tabla[pos].agregar(nuevaEntrada);
		cantidadDeElementos++;

		return true;
	}

	public V eliminarElementoPorLlave(K nLlave)
	{

		int pos = darPosicion(hash(nLlave));

		EntradaTabla<K, V> aBorrar= new EntradaTabla<K,V>(nLlave);

		if (tabla[pos]!=null) 
		{
			if (tabla[pos].darPrimero().darSiguiente() == null) 
			{
				V elemento = tabla[pos].darPrimero().darValor().darValor();
				tabla[pos] = null;
				casillasLlenas--;
				cantidadDeElementos--;
				return elemento;
			} 

			else 
			{	
				if (tabla[pos].buscar(aBorrar)!=null){
					V elementoEncontrado = tabla[pos].buscar(aBorrar).darValor();
					tabla[pos].eliminar(aBorrar);
					cantidadDeElementos--;
					return elementoEncontrado;
				}
				return null;
			}
		}

		else
		{
			return null;
		}

	}


	public V buscarElemento( K nLlave){

		int pos = darPosicion(hash(nLlave));

		EntradaTabla<K,V> aBorrar= new EntradaTabla<K,V>(nLlave);


		if (tabla[pos]!=null) 
		{

			if (tabla[pos].buscar(aBorrar)!=null) 
			{
				return tabla[pos].buscar(aBorrar).darValor();
			}

		}

		return null;

	}




	public Iterator<V> iterator() 
	{
		IteradorSimple<V> respuesta = new IteradorSimple<V>(cantidadDeElementos);

		for( int i = 0; i<tabla.length; i++ )
		{
			if( tabla[i]!=null )
			{
				ListaOrdenada<EntradaTabla<K, V>> casillaActual = tabla[i];
				Iterator<EntradaTabla<K, V>> iteradorCasilla = casillaActual.iterator();

				while(iteradorCasilla.hasNext())
				{
					V actual = iteradorCasilla.next().darValor();
					respuesta.agregar(actual);
				}
			}
		}

		return respuesta;
	}

	
	
	public void reHashing(){

		tamano=tamano*2;

		while(!esPrimo(tamano)){
		 tamano=tamano+1;
		}
		
		ListaOrdenada<EntradaTabla<K, V>> []contenedoraVieja= tabla;
		
		tabla= null;
		tabla= new ListaOrdenada[tamano];
		
		for (int i = 0; i < contenedoraVieja.length; i++) {
			if(contenedoraVieja[i]!=null){
				while(contenedoraVieja[i].darPrimero()!=null){
					EntradaTabla<K,V> entradaActual = contenedoraVieja[i].darPrimero().darValor();
					agregarElemento(entradaActual.darValor(), entradaActual.darLlave());
					contenedoraVieja[i].eliminar(entradaActual);
				}
			}
		}
	}
	
	
	public int darCantidadDeElementos(){
		return cantidadDeElementos;
	}
	
	
	
	
	public Iterator<K> darIteradorConLlavesDeMayorColisiones(){
		
		int mejor=0;
		
		ListaOrdenada<K> listaConLlaves = new ListaOrdenada<K>();
		ListaOrdenada<EntradaTabla<K,V>> mejorLista= new ListaOrdenada<EntradaTabla<K,V>>();
		
		for(int i=0;i<tamano;i++){
			if(tabla[i].darLongitud()>mejor){
				mejor=tabla[i].darLongitud();
				mejorLista= tabla[i];				
			}
		}
		
		for(int i=0;i<mejorLista.darLongitud();i++){
			EntradaTabla<K,V> delMomento= mejorLista.darPrimero().darValor();
			K actual= delMomento.darLlave();
			listaConLlaves.agregar(actual);
			mejorLista.eliminar(delMomento);
		}
		
		return listaConLlaves.iterator();
		
		
		
	}


}
