package uniandes.cupi2.estructuras;

import java.util.Iterator;

public class GrafoDirigido <K extends Comparable<K>, V extends IInfoVertice<K>, A extends IInfoArco> implements IGrafoDirigido<K, V, A> 
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	int numeroVertices;

	TablaHashing<Vertice<K,V,A>, K> vertices;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	public GrafoDirigido(int nNumeroVertices){
		numeroVertices= nNumeroVertices;
		vertices = new TablaHashing<Vertice<K,V,A>,K>(nNumeroVertices);
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	public int darOrden(){
		return vertices.darCantidadDeElementos();
	}


	public Vertice<K, V, A> darVertice(K idVert) {
		return vertices.buscarElemento(idVert);
	}


	public Arco<K, V, A> darArco(K idOrig, K idDest) {
		Vertice<K, V, A> vertice = vertices.buscarElemento(idOrig);
		Iterator<Arco<K, V, A>> it = vertice.darSucesores();

		while(it.hasNext()){
			Arco<K,V,A> actual = it.next();
			if(actual.darDestino().darId().compareTo(idDest)==0){
				return actual;
			}
		}

		return null;
	}


	public boolean agregarVertice(V info) {
		Vertice<K,V,A> aAgregar = new Vertice<K, V, A>(info);
		return vertices.agregarElemento(aAgregar, info.darId());

	}


	public Vertice<K, V, A> eliminarVertice(K idVert) {

		Vertice<K,V,A> aElim = darVertice(idVert);

		Iterator<Arco<K,V,A>> sucesoresAElim = aElim.darSucesores();
		while(sucesoresAElim.hasNext())
		{
			Arco<K,V,A> arcoActual = sucesoresAElim.next();
			Arco seElimino = eliminarArco(arcoActual.darOrigen().darId(), arcoActual.darDestino().darId());
			if(seElimino!=null)
			{
				System.out.println("Se elimino: "+seElimino);
			}
		}

		Iterator<Arco<K,V,A>> predAElim = aElim.darPredecesores();
		while(predAElim.hasNext())
		{
			Arco<K,V,A> arcoActual = predAElim.next();
			Arco seElimino = eliminarArco(arcoActual.darOrigen().darId(), arcoActual.darDestino().darId());
			if(seElimino!=null)
			{
				System.out.println("Se elimino: "+seElimino);
			}
		}

		return vertices.eliminarElementoPorLlave(idVert);
	}


	public boolean agregarArco(K idOrig, K idDest, A info) {
		Vertice<K,V,A> origen = vertices.buscarElemento(idOrig);
		Vertice<K, V, A> destino = vertices.buscarElemento(idDest);

		if(origen!=null && destino!=null){
			Arco<K, V, A> aAgregar = new Arco<K,V,A>(origen, destino, info, info.darCosto());
			origen.agregarArcoSucesor(aAgregar);
			destino.agregarArcoPredecesor(aAgregar);
			return true;
		}
		return false;
	}


	public Arco<K, V, A> eliminarArco(K idOrig, K idDest) {
		Vertice<K,V,A> origen = vertices.buscarElemento(idOrig);
		Vertice<K, V, A> destino = vertices.buscarElemento(idDest);

		if(origen!=null && destino!=null){
			Arco<K,V,A> devuelto =origen.darArcoSucesorHacia(idDest);
			if(devuelto!=null){
				origen.eliminarArcoSucesorHacia(idDest);
				destino.eliminarArcoPredecesorDesde(idOrig);

				return devuelto;
			}
		}
		return null;
	}


	public void desmarcarVertices() {
		Iterator<Vertice<K,V,A>> it = vertices.iterator();
		while(it.hasNext()){
			Vertice<K,V,A> actual = it.next();
			actual.desMarcar();
		}
	}

	public void inicializarParaDFS()
	{
		Iterator<Vertice<K,V,A>> it = vertices.iterator();
		while(it.hasNext()){
			Vertice<K,V,A> actual = it.next();
			actual.inicializarParaDFS();
		}
	}

	public void inicializarParaBFS()
	{
		Iterator<Vertice<K,V,A>> it = vertices.iterator();
		while(it.hasNext()){
			Vertice<K,V,A> actual = it.next();
			actual.inicializarParaBFS();
		}
	}

	public void inicializarParaDijkstra()
	{
		Iterator<Vertice<K,V,A>> it = vertices.iterator();
		while(it.hasNext()){
			Vertice<K,V,A> actual = it.next();
			actual.cambiarDistancia(-1);
			actual.cambiarPadre(null);
		}
	}

	// -----------------------------------------------------------------
	// Recorridos
	// -----------------------------------------------------------------


	public Iterator<Vertice<K, V, A>> recorridoPlano() 
	{
		return vertices.iterator();
	}


	public Iterator<Vertice<K, V, A>> recorridoXProfundidad() 
	{
		Lista<Vertice<K, V, A>> resp = new Lista<Vertice<K,V,A>>();

		inicializarParaDFS();

		Iterator<Vertice<K,V,A>> iterVertices = recorridoPlano();
		while( iterVertices.hasNext() )
		{
			Vertice<K,V,A> verActual = iterVertices.next();
			if(verActual.darColor().equals(Vertice.BLANCO))
			{
				verActual.recorridoXProfundidad(resp);
			}
		}

		return resp.iterator();

	}

	public Iterator<Vertice<K, V, A>> recorridoXProfundidadDesdeFuente( K idOrig ) 
	{
		Lista<Vertice<K, V, A>> resp = new Lista<Vertice<K,V,A>>();

		inicializarParaDFS();

		Vertice<K,V,A> fuente = darVertice(idOrig);
		if(fuente==null)
		{
			return resp.iterator();
		}
		fuente.recorridoXProfundidad(resp);

		return resp.iterator();

	}


	public Lista<Vertice<K, V, A>> recorridoXNiveles(K idOrig) 
	{
		inicializarParaBFS();
		Vertice<K, V, A> fuente = darVertice(idOrig);
		if(fuente==null)
		{
			return new Lista<Vertice<K,V,A>>();
		}
		Lista<Vertice<K,V,A>> resp = fuente.recorridoXNiveles();

		return resp;
	}


	public Lista<Vertice<K, V, A>> dijkstra(K idOrig) 
	{

		inicializarParaDijkstra();
		Vertice<K,V,A> fuente = darVertice(idOrig);
		if(fuente==null)
		{
			return new Lista<Vertice<K,V,A>>();
		}
		Lista<Vertice<K,V,A>> resp = fuente.dijkstra();

		return resp;
	}



	public boolean hayCaminoSimple(K idOrig, K idDest) {
		// TODO Auto-generated method stub
		Vertice<K,V,A> verOrigen = darVertice(idOrig);
		if(verOrigen==null)
		{
			return false;
		}
		
		inicializarParaDFS();
		Lista<Vertice<K,V,A>> lista = new Lista<Vertice<K,V,A>>();
		verOrigen.recorridoXProfundidad(lista);

		Vertice<K,V,A> verticeDestino = darVertice(idDest);
		if(verticeDestino!=null)
		{
			return verticeDestino.darColor().equals(Vertice.NEGRO);
		}
		else
		{
			return false;
		}
	}


	public boolean hayCicloSimpleCon(K idOrig) {
		// TODO Auto-generated method stub
		inicializarParaDFS();
		Vertice<K,V,A> verOrigen = darVertice(idOrig);
		if(verOrigen==null)
		{
			return false;
		}
		return verOrigen.pertenezcoACicloSimple();
	}


	public boolean hayCadena(K idOrig, K idDest) 
	{
		// TODO Auto-generated method stub
		inicializarParaDFS();
		Vertice<K,V,A> verOrigen = darVertice(idOrig);
		if(verOrigen==null)
		{
			return false;
		}
		return verOrigen.hayCadena(idDest);
	}


	public Camino<K, V, A> darCaminoSimple(K idOrig, K idDest) 
	{
		// TODO Auto-generated method stub
		if( hayCaminoSimple(idOrig,idDest) )
		{
			Vertice<K, V, A> verDestino = darVertice(idDest);
			Camino<K,V,A> camino = new Camino<K, V, A>(verDestino);
			verDestino.reconstruirCamino( camino );
			return camino;
		}

		else
		{
			return null;
		}
	}


	public Camino<K, V, A> darCaminoSimpleMasCorto(K idOrig, K idDest) 
	{

		recorridoXNiveles(idOrig);
		Vertice<K,V,A> destino = darVertice(idDest);

		if(destino.darDistancia()!=-1)
		{
			Camino<K,V,A> resp = new Camino<K,V,A>(destino);
			destino.reconstruirCamino(resp);
			return resp;
		}

		else
		{
			return null;
		}

	}


	public Camino<K, V, A> darCaminoSimpleMasBarato(K idOrig, K idDest) 
	{

		dijkstra(idOrig);
		Vertice<K,V,A> destino = darVertice(idDest);

		if(destino.darDistancia()!=-1)
		{
			Camino<K,V,A> resp = new Camino<K,V,A>(destino);
			destino.reconstruirCamino(resp);
			return resp;
		}

		else
		{
			return null;
		}
	}



}
