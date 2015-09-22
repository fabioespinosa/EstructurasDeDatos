package uniandes.cupi2.estructuras;

public interface ITablaHashing <V, K> {

	public int hash(K nLlave);
	
	public int darPosicion(int nReal);
	
	public boolean agregarElemento(V elemento, K nLlave);
	
	public boolean eliminarElementoPorLlave(K nLlave);
	
	public V buscarElemento( K nLlave);
	
}
