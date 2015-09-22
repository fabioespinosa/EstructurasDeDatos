package uniandes.cupi2.estructuras;

import java.io.Serializable;

public class EntradaTabla <K extends Comparable<K>,V > implements Comparable<EntradaTabla<K, V>>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private K llave;
	
	private V valor;
	
	public EntradaTabla(K nLlave, V nValor){
		
		llave= nLlave;
		valor= nValor;
		
	}
	
	public EntradaTabla( K tLlave )
	{
		valor = null;
		llave = tLlave;
	}
	
	public K darLlave(){
		return llave;
	}
	
	public V darValor(){
		return valor;
	}
	
	public void cambiarLlave(K nuevaLlave){
		llave= nuevaLlave;
	}
	
	public void cambiarValor(V nuevoValor){
		valor= nuevoValor;
	}

	
	public int compareTo(EntradaTabla<K, V> otra) 
	{
		
		if(llave.compareTo(otra.darLlave())<0)
		{
			return -1;
		}
		
		else if(llave.compareTo(otra.darLlave())==0)
		{
			return 0;
		}
		
		else 
		{
			return 1;
		}
	}
	
	
}
