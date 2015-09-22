package uniandes.cupi2.estructuras;

import java.util.Iterator;


public class Vertice<K extends Comparable<K>, V extends IInfoVertice<K>, A extends IInfoArco> implements Comparable<Vertice<K, V, A>> {

	public final static String GRIS = "Gris";
	public final static String NEGRO = "Negro";
	public final static String BLANCO = "Blanco";


	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 *  La información del vertice
	 */
	private V infoVertice;

	/**
	 * El identificador del vertice
	 */
	private K id;

	/**
	 * Un indicador si esta marcado o no
	 */
	private boolean marcado;

	private String color;

	private Vertice<K, V, A> padre;
	
	private double distancia; 

	/**
	 * Lista de Sucesores, arcos
	 */
	private Lista<Arco<K,V,A>> sucesores;

	/**
	 * Lista de predecesores, arcos
	 */
	private Lista<Arco<K,V,A>> predecesores;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Construye un nuevo vertice con la lista de sucesores y predecesores vacia
	 * @param info La información del nuevo vertice
	 */
	public Vertice(V info){
		infoVertice=info;
		sucesores= new Lista<Arco<K,V,A>>();
		predecesores= new Lista<Arco<K,V,A>>();
		id=info.darId();
	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve la información del vertice
	 * @return la informacion del vertice
	 */
	public V darInfo(){
		return infoVertice;
	}

	/**
	 * Devuelve el identidicador del vertice
	 * @return
	 */
	public K darId(){
		return id;
	}

	/**
	 * Devuelve el indicador de si esta marcado o no
	 * @return indicador de marcación
	 */
	public boolean darMarcado(){
		return marcado;
	}
	
	public double darDistancia()
	{
		return distancia;
	}
	
	public String darColor()
	{
		return color;
	}
	
	public Vertice<K,V,A> darPadre()
	{
		return padre;
	}

	/**
	 * Devuelve un iterador con los arcos sucesores del vertice
	 * @return Iterador con los arcos sucesores del vertice
	 */
	public Iterator<Arco<K,V,A>> darSucesores(){
		return sucesores.iterator();
	}

	/**
	 * Devuelve un iterador con los arcos predecesores del vertice
	 * @return Iterador con los arcos predecesores del vertice
	 */
	public Iterator<Arco<K,V,A>> darPredecesores(){
		return predecesores.iterator();
	}
	
	public void cambiarDistancia( double nueva )
	{
		distancia = nueva;
	}
	
	public void cambiarColor( String pColor )
	{
		color = pColor;
	}
	
	public void cambiarPadre( Vertice<K,V,A> nVer )
	{
		padre = nVer;
	}

	/**
	 * Indica si un vertice es adyacente a este, es decir, si esta ya sea en los sucesores o predecesores o en ambos.
	 * @param idVert El identificador del vertie que se quiere comprobar
	 * @return un indicador de si son o no adyacentes
	 */
	public boolean somosAdyacentes(K idVert){
		if(darArcoSucesorHacia(idVert)!=null || darArcoPredecesorDesde(idVert)!=null){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Busca y devuelve un arco de un vertice sucesor, si no lo encuentra devuelve null
	 * @param idDest El identificador del vertice que se quiere buscar en los arcos sucesores
	 * @return El arco que une al vertice buscado con este
	 */
	public Arco<K,V,A> darArcoSucesorHacia(K idDest){
		Iterator<Arco<K,V,A>> it= sucesores.iterator();

		while(it.hasNext()){
			Arco<K,V,A> actual = it.next();
			if(actual.darDestino().darId().compareTo(idDest)==0){
				return actual;
			}
		}
		return null;
	}

	/**
	 * Busca y devuelve un arco desde un vertice predecesor, si no lo encuentra devuelve null
	 * @param idOrig El identificador del vertice que se quiere buscar en los arcos predecesores
	 * @return El arco que une al vertice buscado con este
	 */
	public Arco<K,V,A> darArcoPredecesorDesde(K idOrig){
		Iterator<Arco<K,V,A>> it= predecesores.iterator();

		while(it.hasNext()){
			Arco<K,V,A> actual = it.next();
			if(actual.darOrigen().darId().compareTo(idOrig)==0){
				return actual;
			}
		}
		return null;
	}

	/**
	 * Busca y devuelve un arco ya sea en los sucesores o predecesores que una a un vertice que entra por parametro con este
	 * @param id El identificador del vertice que se quiere buscar en los arcos predecesores/sucesores
	 * @return El arco que une al vertice buscado con este
	 */
	public Arco<K,V,A> darArco(K id){
		Arco<K,V,A> sucesor = darArcoSucesorHacia(id);
		if(sucesor!=null){
			return sucesor;
		}
		else{
			return darArcoPredecesorDesde(id);
		}
	}

	/**
	 * Marca este vertice
	 */
	public void marcar(){
		marcado=true;
	}

	/**
	 * Desmarca este vertice 
	 */
	public void desMarcar(){
		marcado=false;
	}

	public void inicializarParaDFS()
	{
		color = BLANCO;
		padre = null;
	}
	
	public void inicializarParaBFS()
	{
		color = BLANCO;
		padre = null;
		distancia = -1;
	}


	/**
	 * Agrega un arco sucesor a la lista de los arcos sucesores
	 * @param arco El arco a agregar
	 */
	public void agregarArcoSucesor( Arco<K,V,A> arco){
		sucesores.agregar(arco);
	}

	/**
	 * Agrega un arco predecesor a la lista de los arcos predecesores
	 */
	public void agregarArcoPredecesor( Arco<K,V,A> arco){
		predecesores.agregar(arco);
	}

	/**
	 * Elimina un arco sucesor indicando el vertice al que este apunta
	 * @param idDest El vertice al que apunta el arco que se quiere eliminar
	 * @return El arco eliminado, o null si no lo encontro
	 */
	public Arco<K,V,A> eliminarArcoSucesorHacia(K idDest){
		Iterator<Arco<K,V,A>> it= sucesores.iterator();

		while(it.hasNext()){
			Arco<K,V,A> actual = it.next();
			if(actual.darDestino().darId().compareTo(idDest)==0){
				sucesores.eliminar(actual);
				return actual;
			}
		}
		return null;
	}

	/**
	 * Elimina un arco predecesor indicando el vertice al que este apunta
	 * @param idDest El vertice al que apunta el arco que se quiere eliminar
	 * @return El arco eliminado, o null si no lo encontro
	 */
	public Arco<K,V,A> eliminarArcoPredecesorDesde(K idOrig){
		Iterator<Arco<K,V,A>> it= predecesores.iterator();

		while(it.hasNext()){
			Arco<K,V,A> actual = it.next();
			if(actual.darOrigen().darId().compareTo(idOrig)==0){
				predecesores.eliminar(actual);
				return actual;
			}
		}
		return null;
	}


	// -----------------------------------------------------------------
	// Recorridos
	// -----------------------------------------------------------------

	public boolean hayCaminoSimpleA(K idDest)
	{
		boolean encontro = false;
		this.color = GRIS;

		Iterator<Arco<K, V, A>> iterSucesores = sucesores.iterator();
		while(iterSucesores.hasNext() && !encontro)
		{

			Vertice<K, V, A> verActual = iterSucesores.next().darDestino();
			if( verActual.darId().compareTo(idDest) == 0)
			{
				verActual.padre = this;
				encontro = true;
			}

			else if (verActual.color.equals(BLANCO) )
			{
				verActual.padre = this;
				encontro = verActual.hayCaminoSimpleA(idDest);
			}

		}

		color = NEGRO;
		return encontro;
	}

	public boolean pertenezcoACicloSimple()
	{
		Iterator<Arco<K,V,A>> itSucesores = sucesores.iterator();
		while(itSucesores.hasNext())
		{
			Vertice<K,V,A> verActual = itSucesores.next().darDestino();

			if( verActual.hayCaminoSimpleA(id) )
			{
				return true;
			}
		}

		return false;
	}

	public boolean hayCadena(K idDest)
	{
		boolean encontro = false;
		this.color = GRIS;

		Iterator<Arco<K, V, A>> iterSucesores = sucesores.iterator();
		while(iterSucesores.hasNext() && !encontro)
		{

			Vertice<K, V, A> verActual = iterSucesores.next().darDestino();
			if( verActual.darId().compareTo(idDest) == 0)
			{	
				
				verActual.padre = this;
				encontro = true;
			}

			else if (verActual.color.equals(BLANCO) )
			{
				verActual.padre = this;
				encontro = verActual.hayCadena(idDest);
			}
			
			if(encontro)
			{
				System.out.println("Encontro en suc: "+id);
			}

		}

		Iterator<Arco<K, V, A>> iterPred = predecesores.iterator();
		while(iterPred.hasNext() && !encontro)
		{

			Vertice<K, V, A> verActual = iterPred.next().darOrigen();
			if( verActual.darId().compareTo(idDest) == 0)
			{
				verActual.padre = this;
				encontro = true;
			}

			else if (verActual.color.equals(BLANCO) )
			{
				verActual.padre = this;
				encontro = verActual.hayCadena(idDest);
			}
			
			if(encontro)
			{
				System.out.println("Encontro en pred: "+id);
			}

		}
		
		color = NEGRO;
		
		
		return encontro;
	}

	public Camino<K,V,A> darCaminoSimpleA(K idDest)
	{	
		return null;
	}

	public Camino<K,V,A> darCaminoSimpleMasCortoA(K idDest){
		return null;
	}

	public Camino<K,V,A> darCaminoSimpleMasBaratoA(K idDest){
		return null;
	}

	public void recorridoXProfundidad(Lista<Vertice<K,V,A>> vertices)
	{
		vertices.agregar( this );
		System.out.println("El ver actual es: "+id +"  Tiene: "+sucesores.darLongitud()+" sucesores");
		color = GRIS;

		Iterator<Arco<K, V, A>> iterSucesores = sucesores.iterator();
		while( iterSucesores.hasNext() )
		{
			Vertice<K, V, A> verActual = iterSucesores.next().darDestino();
			System.out.println("el suc actual es: "+verActual.darId());
			if (verActual.color.equals(BLANCO) )
			{
				verActual.padre = this;
				verActual.recorridoXProfundidad(vertices);
			}

		}
		color = NEGRO;
		
	}

	public Lista<Vertice<K,V,A>> recorridoXNiveles()
	{
		Lista<Vertice<K,V,A>> resp = new Lista<Vertice<K,V,A>>();
		
		cambiarColor(Vertice.GRIS);
		cambiarDistancia(0);

		Cola<Vertice<K, V, A>> frenteDeExploracion = new Cola<Vertice<K,V,A>>();
		frenteDeExploracion.encolar(this);

		while( !frenteDeExploracion.estaVacia() )
		{
			Vertice<K, V, A> verActual = frenteDeExploracion.ateneder();

			Iterator<Arco<K, V, A>> iterSucesoresActual = verActual.darSucesores();
			while( iterSucesoresActual.hasNext() )
			{
				Vertice<K, V, A> sucActual = iterSucesoresActual.next().darDestino();
				if( sucActual.darColor().equals(Vertice.BLANCO) )
				{
					sucActual.cambiarColor(Vertice.GRIS);
					sucActual.cambiarDistancia( verActual.darDistancia() + 1 );
					sucActual.cambiarPadre( verActual );
					frenteDeExploracion.encolar(sucActual);
				}
			}
			verActual.cambiarColor(Vertice.NEGRO);
			resp.agregar(verActual);
		}
		
		return resp;
	}

	public Lista<Vertice<K,V,A>> dijkstra( )
	{
		distancia = 0;
		Lista<Vertice<K,V,A>> listaResp = new Lista<Vertice<K,V,A>>();
		ListaOrdenada<Vertice<K,V,A>> frenteDeExploracion = new ListaOrdenada<Vertice<K,V,A>>();
		frenteDeExploracion.agregar( this );

		while( frenteDeExploracion.darLongitud()!=0 )
		{
			
			Vertice<K, V, A> menor = frenteDeExploracion.darPrimero().darValor();
			frenteDeExploracion.eliminar(menor);
			listaResp.agregar(menor);

			Iterator<Arco<K, V, A>> iterSuc = menor.darSucesores();
			while(iterSuc.hasNext())
			{
				Arco<K,V,A> arcoActual = iterSuc.next();
				Vertice<K,V,A> sucesorActual = arcoActual.darDestino();
				
				if(sucesorActual.darDistancia() == -1 || sucesorActual.darDistancia() > (menor.darDistancia() + arcoActual.darCosto()))
				{
					sucesorActual.cambiarDistancia( menor.darDistancia() + arcoActual.darCosto() );
					sucesorActual.cambiarPadre(menor);
					frenteDeExploracion.eliminar(sucesorActual);
					frenteDeExploracion.agregar(sucesorActual);
				}
			}

		}
		return listaResp;
	}

	public void reconstruirCamino( Camino<K,V,A> camino )
	{
		if( padre!=null )
		{
			camino.agregarArcoComienzo( darArcoPredecesorDesde( padre.darId() ) );
			padre.reconstruirCamino( camino );
		}

	}
	
	public int compareTo(Vertice<K, V, A> aCom)
	{
		return (int)(distancia-aCom.distancia);
	}


}
