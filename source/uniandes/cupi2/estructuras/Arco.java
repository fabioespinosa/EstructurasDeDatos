package uniandes.cupi2.estructuras;

public class Arco<K extends Comparable<K>, V extends IInfoVertice<K>, A extends IInfoArco> {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	private A infoArco;
	
	private Vertice<K,V,A> origen;
	
	private Vertice<K,V,A> destino;
	
	private double costo;
	
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
	
	public Arco(Vertice<K,V,A> orig, Vertice<K,V,A> dest, A info, double nCosto){
		infoArco=info;
		origen=orig;
		destino= dest;
		costo = nCosto;
	}
	
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	public Vertice<K,V,A> darOrigen(){
		return origen;
	}
	
	public Vertice<K,V,A> darDestino(){
		return destino;
	}
	
	public A darInfo(){
		return infoArco;
	}
	
	public double darCosto(){
		return costo;
	}
	
	public String toString()
	{
		return "<"+origen.darId()+","+destino.darId()+">";
	}
}
