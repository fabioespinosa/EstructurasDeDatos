package uniandes.cupi2.estructuras;

import java.util.Iterator;

public class Camino<K extends Comparable<K>, V extends IInfoVertice<K>, A extends IInfoArco> {

	private double costo;
	
	private int longitud;
	
	private Vertice<K, V, A> origen;
	
	private Vertice<K, V, A> destino;
	
	private Lista<Arco<K,V,A>> arcos;
	
	public Camino(Vertice<K,V,A> inicio)
	{
		arcos = new Lista<Arco<K,V,A>>();
		origen=inicio;
		destino=inicio;
		longitud=0;
		costo=0;
	}
	
	public int darLongitud(){
		return longitud;
	}
	
	public double darCosto(){
		return costo;
	}
	
	public Iterator<Vertice<K, V, A>> darVertices(){
		IteradorSimple<Vertice<K,V,A>> vertices = new IteradorSimple<Vertice<K,V,A>>(arcos.darLongitud()+1);
		Iterator<Arco<K,V,A>> it= arcos.iterator();
		
		while(it.hasNext()){
			Arco<K,V,A> actual = it.next();
			vertices.agregar(actual.darOrigen());
		}
		vertices.agregar(destino);
		return vertices;
	}
	
	public Iterator<Arco<K, V, A>> darArcos(){
		return arcos.iterator();
	}
	
	public void agregarArcoFinal(Arco<K, V, A> arco){
		arcos.agregar(arco);
		destino=arco.darDestino();
		longitud++;
		costo+=arco.darCosto();
	}
	
	public void agregarArcoComienzo(Arco<K, V, A> arco){
		arcos.agregarAlComienzo(arco);
		origen=arco.darOrigen();
		longitud++;
		costo+=arco.darCosto();
	}
}
