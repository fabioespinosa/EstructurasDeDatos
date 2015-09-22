package uniandes.cupi2.estructuras;

import java.util.Iterator;

public interface IGrafoDirigido <K extends Comparable<K>, V extends IInfoVertice<K>, A extends IInfoArco> {

	
	public int darOrden();
	
	public Vertice<K,V,A> darVertice(K idVert);
	
	public Arco<K,V,A> darArco(K idOrig, K idDest);
	
	public boolean agregarVertice( V info);
	
	public Vertice<K,V,A> eliminarVertice(K idVert);
	
	public boolean agregarArco(K idOrig, K idDest, A info);
	
	public Arco<K,V,A> eliminarArco(K idOrig, K idDest);
	
	
	public Iterator<Vertice<K,V,A>> recorridoPlano();
	
	public Iterator <Vertice<K,V,A>> recorridoXProfundidad( );
	
	public Lista<Vertice<K,V,A>> recorridoXNiveles(K idOrig);
	
	public Lista<Vertice<K,V,A>> dijkstra (K idOrig);
	
	
	public void desmarcarVertices();
	
	
	public boolean hayCaminoSimple(K idOrig, K idDest);
	
	public boolean hayCicloSimpleCon(K idOrig);
	
	public boolean hayCadena(K idOrig, K idDest);
	
	public Camino<K,V,A> darCaminoSimple(K idOrig, K idDest);
	
	public Camino<K,V,A> darCaminoSimpleMasCorto(K idOrig, K idDest);

	public Camino<K,V,A> darCaminoSimpleMasBarato(K idOrig, K idDest);

	
}
