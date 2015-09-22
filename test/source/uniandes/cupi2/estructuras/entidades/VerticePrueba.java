package uniandes.cupi2.estructuras.entidades;

import uniandes.cupi2.estructuras.IInfoVertice;

public class VerticePrueba<K> implements IInfoVertice<K>
{
	private K id;
	
	public VerticePrueba(K nId)
	{
		id = nId;
	}
	
	public K darId() 
	{
		// TODO Auto-generated method stub
		return id;
	}

}
