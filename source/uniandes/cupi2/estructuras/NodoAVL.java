package uniandes.cupi2.estructuras;

import java.io.Serializable;


public class NodoAVL <T extends Comparable<? super T>> implements Serializable {



	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante de serializacion
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constante que indica que el arbol esta balanceado hacia la izquierda
	 */
	private final static int BALAN_IZQ =1;

	/**
	 * Constante que indica que el arbol esta balanceado
	 */
	private final static int BALANCEADO =0;

	/**
	 * constante que indica que el arbol esta balanceado hacia la derecha
	 */
	private final static int BALAN_DER =-1;


	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * El Elemento contenido en el nodo
	 */
	private T valor;

	/**
	 * El nodo de la derecha
	 */
	private NodoAVL<T> derecha;

	/**
	 * El nodo de la izquierda
	 */
	private NodoAVL<T> izquierda;

	/**
	 * El estado actual del balance del nodo
	 */
	private int balance;


	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Crea un nuevo nodo
	 * @param T nValor. El elemento que este nodo va a guardar
	 */
	public NodoAVL (T nValor){
		valor= nValor;

		derecha=null;

		izquierda=null;
		
		balance=0;

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve el elemento guardado en este nodo
	 * @return El elemento guardado en este nodo
	 */
	public T darValor(){
		return valor;
	}

	/**
	 * Devuelve el nodo de la derecha
	 * @return El nodo de la derecha
	 */
	public NodoAVL<T> darDerecho(){
		return derecha;
	}

	/**
	 * Devuelve el nodo de la izquierda
	 * @return El nodo de la izquierda
	 */
	public NodoAVL<T> darIzquierdo(){
		return izquierda;
	}

	public int darBalance(){
		return balance;
	}

	/**
	 * Agrega un nuevo elemento en el árbol cuya raíz es el nodo actual. <br>
	 * <b>pre:</b> pElemento!=null. <br>
	 * <b>post:</b> Se insertó el elemento especificado en el árbol.
	 * @param pElemento elemento que se va a agregar
	 * @throws ElementoExisteException Excepción lanzada si el elemento ya existe en el árbol
	 */
	public boolean insertarElemento( T pElemento ) 
	{
		// Compara el valor con el valor del nodo
		int resultado = valor.compareTo( pElemento );
		if( resultado == 0 )
		{
			// Caso 1: El elemento está en el nodo raíz
			return false;
		}
		else if( resultado > 0 )
		{
			// Caso 2: El elemento se debe insertar en el subárbol izquierdo
			if( izquierda == null )
			{
				izquierda = new NodoAVL<T>( pElemento );
				return true;
			}
			else
			{
				return izquierda.insertarElemento( pElemento );
			}
		}
		else
		{
			// Caso 3: El elemento se debe insertar en el subárbol derecho
			if( derecha == null )
			{
				derecha = new NodoAVL<T>( pElemento );
				return true;
			}
			else
			{
				return derecha.insertarElemento( pElemento );
			}
		}
	}

	public void recalcularBalance()
	{
		int altIzq = 0;
		int altDer = 0;
		if(izquierda!=null){
			altIzq = izquierda.darAltura();
			izquierda.recalcularBalance();
		}
		if(derecha!=null){
			altDer = derecha.darAltura();
			derecha.recalcularBalance();
		} 
		balance = altIzq-altDer; 
	}


	public NodoAVL<T> balancear(){
		if(balance<=1 && balance>=-1){
			System.out.println("Balancear this Ok recursion");
			if(izquierda!=null){
				izquierda = izquierda.balancear();
			}
			if(derecha!=null){
				derecha = derecha.balancear();
			}
			return this;
		} 
		else if(balance==2){
			if(izquierda.balance==1){
				System.out.println("Balancear izquierdo: rotarDerecha");
				return roteDerecha();
			}
			else if(izquierda.balance==-1){
				System.out.println("Bancear izquierdo: IzquierdaDerecha");
				return roteIzquierdaDerecha();
			} 
			else{
				System.out.println("Balancear izquierdo: recursivo");
				izquierda = izquierda.balancear();
				return this;
			}
		}
		else if(balance==-2) {
			if(derecha.balance==1){
				System.out.println("Bancear derecha: DerechaIzquierda");
				return roteDerechaIzquierda();
			}
			else if(derecha.balance==-1){
				System.out.println("Balancear derecha: rotarIzquierda");
				return roteIzquierda();

			}
			else{ 
				derecha = derecha.balancear();
				return this;
			}
		}
		System.out.println("No deberia llegar aqui con balance: "+balance);
		return this;
	}






	/**
	 * Elimina el elemento dado como parámetro, del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se eliminó el elemento si existía en árbol cuya raíz es el nodo actual.
	 * @param pElemento Elemento que se va a eliminar
	 * @return Raíz del árbol producto de eliminar del árbol que comienza en el nodo actual el elemento que llega como parámetro
	 * @throws ElementoNoExisteException Excepción lanzada si el elemento no se encontró en el árbol
	 */
	public NodoAVL<T> eliminar( T pElemento ) 
	{
		// Compara el valor con el valor del nodo
		int resultado = valor.compareTo( pElemento );
		if( resultado == 0 )
		{
			// Caso 1: El elemento está en el nodo raíz
			if((izquierda == null) && (derecha == null))
			{
				return null;
			}

			if( izquierda == null )
			{
				return derecha;
			}
			else if( derecha == null )
			{
				return izquierda;
			}
			else
			{
				if(balance<0){
					valor = derecha.darMenor();
					derecha = derecha.eliminar( valor );

					return this;
				}
				else{
					valor = izquierda.darMayor( );
					izquierda = izquierda.eliminar( valor );
					return this;
				}
			}
		}
		else if( resultado > 0 )
		{
			// Caso 2: El elemento debe estar en el subárbol izquierdo
			izquierda = izquierda.eliminar( pElemento );
			return this;

		}
		else
		{
			// Caso 3: El elemento debe estar en el subárbol derecho
			derecha = derecha.eliminar( pElemento );
			return this;

		}
	}






	/**
	 * Busca el elemento que entra por parametro
	 * @param aBuscar. El elemento a Buscar
	 * @return. En caso de encontrar el elemento lo devuelve, de lo contrario devuelve null.
	 */
	public T buscar(T aBuscar){
		int dondeEsta = valor.compareTo(aBuscar);
		if(dondeEsta==0){
			return valor;
		}
		else if (dondeEsta>0){
			if(izquierda==null){
				return null;
			}
			else{
				return izquierda.buscar(aBuscar);
			}
		}
		else{
			if(derecha==null){
				return null;
			}
			else{
				return derecha.buscar(aBuscar);
			}
		}
	}



	/**
	 * Devuelve la altura del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se retornó la altura del árbol cuya raíz es el nodo actual. Entero mayor o igual a 1
	 * @return Altura del árbol cuya raíz es el nodo actual
	 */
	public int darAltura( )
	{	
		int canIzq = 0;

		if(izquierda!=null)
		{
			canIzq = izquierda.darAltura();
		}

		int canDer = 0;

		if(derecha!=null)
		{
			canDer = derecha.darAltura();
		}

		if(canIzq >= canDer)
		{
			return canIzq+1;
		}
		else
		{
			return canDer+1;
		}

	}

	/**
	 * Retorna el elemento mayor del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se retornó el elemento mayor del árbol cuya raíz es el nodo actual o null si el árbol es vacio.
	 * @return Elemento mayor del árbol cuya raíz es el nodo actual o null si el árbol es vacío
	 */
	public T darMayor( )
	{
		NodoAVL<T> mayor = mayorElemento( );

		if(mayor!=null)
		{
			return mayor.darValor();
		}
		else 
		{
			return null;
		}
	}

	/**
	 * Retorna el elemento menor del árbol cuya raíz es el nodo actual. <br>
	 * <b>post:</b> Se retornó el elemento menor del árbol cuya raíz es el nodo actual o null si el árbol es vacio.
	 * @return Elemento menor del árbol cuya raíz es el nodo actual o null si el árbol es vacío
	 */
	public T darMenor( )
	{
		NodoAVL<T> menor = menorElemento( );

		if(menor!=null)
		{
			return menor.darValor();
		}
		else 
		{
			return null;
		}
	}


	public NodoAVL<T> roteIzquierda(){
		NodoAVL<T> temp = derecha;

		derecha = temp.izquierda;
		temp.izquierda=this;

		return temp;
	}

	public NodoAVL<T> roteDerecha(){
		NodoAVL<T> temp = izquierda;
		izquierda = temp.derecha;
		temp.derecha = this;

		return temp;
	}

	public NodoAVL<T> roteIzquierdaDerecha(){
		izquierda = izquierda.roteIzquierda();
		return roteDerecha();
	}

	public NodoAVL<T> roteDerechaIzquierda(){
		derecha= derecha.roteDerecha();
		return roteIzquierda();
	}


	// -----------------------------------------------------------------
	// Iteradores
	// -----------------------------------------------------------------

	/**
	 * Agrega los valors al iterador que llega como parámetro, utilizando para esto un recorrido en inorden. <br>
	 * <b>pre:</b> resultado!=null. <br>
	 * <b>post:</b> Se retornó el resultado del recorrido.
	 * @param resultado Resultado del recorrido
	 */
	public void inorden( IteradorSimple<T> resultado )
	{
		// Agrega los valors del subárbol izquierdo
		if( izquierda != null )
		{
			izquierda.inorden( resultado );
		}

		// Agrega el valor que se encuentra en el nodo
		resultado.agregar( valor );

		// Agrega los valors del subárbol derecho
		if( derecha != null )
		{
			derecha.inorden( resultado );
		}
	}

	public void preorden( IteradorSimple<T> resultado )
	{
		// Agrega el valor que se encuentra en el nodo
		resultado.agregar( valor );

		// Agrega los valors del subárbol izquierdo
		if( izquierda != null )
		{
			izquierda.preorden( resultado );
		}

		// Agrega los valors del subárbol derecho
		if( derecha != null )
		{
			derecha.preorden( resultado );
		}
	}

	public void posorden( IteradorSimple<T> resultado )
	{
		// Agrega los valors del subárbol izquierdo
		if( izquierda != null )
		{
			izquierda.posorden( resultado );
		}

		// Agrega los valors del subárbol derecho
		if( derecha != null )
		{
			derecha.posorden( resultado );
		}

		resultado.agregar( valor );
	}

	public void recorrerPorNiveles ( IteradorSimple<T> resultado )
	{
		Cola<NodoAVL<T>> colaArbol = new Cola<NodoAVL<T>>();
		colaArbol.encolar(this);

		while( !colaArbol.estaVacia() )
		{
			NodoAVL<T> nodoActual = colaArbol.ateneder();
			resultado.agregar(nodoActual.darValor());

			if( nodoActual.darIzquierdo()!=null )
			{
				colaArbol.encolar(nodoActual.darIzquierdo());
			}

			if( nodoActual.darDerecho()!=null )
			{
				colaArbol.encolar(nodoActual.darDerecho());
			}
		}
	}

	// -----------------------------------------------------------------
	// Operaciones Auxiliares
	// -----------------------------------------------------------------

	/**
	 * Retorna el nodo con el mayor elemento del árbol. <br>
	 * <b>post:</b> Se retornó el nodo con el mayor elemento del árbol.
	 * @return Nodo Nodo con el mayor elemento del árbol
	 */
	private NodoAVL<T> mayorElemento( )
	{
		if(derecha == null)
		{
			return this;
		}
		else 
		{
			return derecha.mayorElemento();
		}

	}

	/**
	 * Retorna el nodo menor elemento del árbol. <br>
	 * <b>post:</b> Se retornó el nodo con el menor elemento del árbol.
	 * @return Nodo El nodo con el menor elemento del árbol
	 */
	private NodoAVL<T> menorElemento( )
	{
		if(izquierda == null)
		{
			return this;
		}
		else 
		{
			return izquierda.menorElemento();
		}
	}

	public void verificarInvariante()
	{
		assert (balance<=1 && balance>=-1): "No es avl el nodo con balance: "+balance+" y valor: "+valor.toString();
		if(izquierda!=null)
		{
			izquierda.verificarInvariante();
		}
		if(derecha!=null)
		{
			derecha.verificarInvariante();
		}
	}

}
