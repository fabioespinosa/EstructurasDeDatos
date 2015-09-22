package uniandes.cupi2.estructuras;
import java.util.Iterator;

public class ArrayList<T> {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Tamaño del arraylist
	 */
	private int size;

	/**
	 * Primer nodo del arraylist
	 */
	private Nodo<T> primero;

	/**
	 * Ultimo nodo del arraylist
	 */
	private Nodo<T> ultimo;


	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Construye un arraylist vacío
	 */
	public ArrayList(){
		size=0;
		primero=null;
		ultimo=null;
	}


	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve el primer nodo del arraylist
	 * @return El primer nodo del arraylist
	 */
	public Nodo<T> darPrimero() {
		return primero;
	}

	/**
	 * Devuelve el último nodo del arraylist
	 * @return El ultimo nodo del arraylist
	 */
	public Nodo<T> darUltimo() {
		return ultimo;
	}

	/**
	 * Devuelve el tamaño del arraylist
	 * @return El tamaño del arraylist
	 */
	public int size(){
		return size;
	}

	public int veriSize(){
		Nodo<T> actual = primero;
		int contador=0;
		while(actual!=null){
			contador++;
			actual=actual.darSiguiente();
		}
		return contador;
	}

	public boolean isEmpty(){
		return (primero==null)? true: false;
	}

	/**
	 * Agrega un elemento al final del arraylist
	 * @param elem
	 */
	public void add(T elem){
		Nodo<T> buscado = new Nodo<T>(elem);
		if(primero==null){
			primero=buscado;
			ultimo=buscado;
		}
		else{
			ultimo.cambiarSiguiente(buscado);
			buscado.cambiarAnterior(ultimo);
			ultimo=buscado;
		}
		size++;
	}

	public void add(int index, T elem){
		Nodo<T> aAgregar = new Nodo<T>(elem);

		if(primero==null && index==0){
			primero=aAgregar;
			ultimo=aAgregar;
		}
		if(index==size-1){
			ultimo.cambiarSiguiente(aAgregar);
			aAgregar.cambiarAnterior(ultimo);
			ultimo=aAgregar;
		}

		int contador=0;
		Nodo<T> buscado = primero;
		while(contador<=index && buscado!=null){
			if(index==contador){

				Nodo<T> anterior= buscado.darAnterior();

				anterior.cambiarSiguiente(aAgregar);
				aAgregar.cambiarAnterior(anterior);

				buscado.cambiarAnterior(aAgregar);
				aAgregar.cambiarSiguiente(buscado);


				size++;
			}
			buscado=buscado.darSiguiente();
			contador++;
		}
	}



	public T set(int index, T elem){
		Nodo<T> aAgregar = new Nodo<T>(elem);

		if(primero==null){
			return null;
		}
		else if(index==0){
			Nodo<T> viejoPrimero = primero;
			aAgregar.cambiarSiguiente(primero.darSiguiente());
			primero.darSiguiente().cambiarAnterior(aAgregar);
			primero=aAgregar;
			return viejoPrimero.darValor();
		}
		else if(index==size-1){
			Nodo<T> viejoUltimo = ultimo;
			ultimo.darAnterior().cambiarSiguiente(aAgregar);
			aAgregar.cambiarAnterior(ultimo.darAnterior());
			ultimo=aAgregar;
			System.out.println("pasa");
			return viejoUltimo.darValor();
		}
		else{
			int contador=0;
			Nodo<T> buscado = primero;
			while(contador<=index && buscado!=null){
				if(index==contador){

					Nodo<T> anterior= buscado.darAnterior();
					Nodo<T> siguiente= buscado.darSiguiente();

					anterior.cambiarSiguiente(aAgregar);
					aAgregar.cambiarAnterior(anterior);


					siguiente.cambiarAnterior(aAgregar);
					aAgregar.cambiarSiguiente(siguiente);	


					return buscado.darValor();
				}
				buscado=buscado.darSiguiente();
				contador++;
			}
			return null;
		}
	}

	public T remove(int num){
		if(num>=size || num<0|| primero==null){
			return null;
		}
		else if(num==0){
			T viejoPrimero=primero.darValor();
			primero=primero.darSiguiente();
			primero.cambiarAnterior(null);
			size--;
			return viejoPrimero;
		}
		else if(num==size-1){
			T viejoUltimo= ultimo.darValor();
			ultimo=ultimo.darAnterior();
			ultimo.cambiarSiguiente(null);
			size--;
			return viejoUltimo;
		}
		else{
			int contador=0;
			Nodo<T> buscado = primero;
			while(contador<=num){
				if(contador==num){
					Nodo<T> anterior = buscado.darAnterior();
					Nodo<T> siguiente = buscado.darSiguiente();
					if(anterior!=null){
						anterior.cambiarSiguiente(siguiente);
					}
					if(siguiente!=null){
						siguiente.cambiarAnterior(anterior);
					}
					size--;
				}
				contador++;
				buscado=buscado.darSiguiente();
			}
			return null;
		}
	}

	public T remove(T elem){

		if(primero==null){
			return null;
		}
		else if(primero.darValor().equals(elem)){
			T viejoPrimero=primero.darValor();
			primero=primero.darSiguiente();
			primero.cambiarAnterior(null);
			size--;
			return viejoPrimero;
		}
		else if(ultimo.darValor().equals(elem)){
			T viejoUltimo= ultimo.darValor();
			ultimo=ultimo.darAnterior();
			ultimo.cambiarSiguiente(null);
			size--;
			return viejoUltimo;
		}
		else{
			Nodo<T> buscado = primero;
			while(buscado!=null){
				if(buscado.darValor().equals(elem)){
					Nodo<T> anterior = buscado.darAnterior();
					Nodo<T> siguiente = buscado.darSiguiente();

					anterior.cambiarSiguiente(siguiente);
					siguiente.cambiarAnterior(anterior);

					size--;
				}
				buscado=buscado.darSiguiente();
			}
			return null;
		}
	}

	public boolean removeAll(){

		if(size>0){
			size=0;
			primero=null;
			ultimo=null;
			return true;
		}
		return false;

	}



	public boolean addAll(ArrayList<T> nueva){
		if(nueva.darPrimero()!=null){
			if(primero!=null){
				ultimo.cambiarSiguiente(nueva.darPrimero());
				ultimo.darSiguiente().cambiarAnterior(ultimo);
				ultimo=nueva.darUltimo();
				size+=nueva.size();
				return true;
			}
			else{
				primero=nueva.darPrimero();
				ultimo= nueva.darUltimo();
				size=nueva.size();
				return true;
			}
		}
		return false;
	}


	public T get( int num){
		if(num>=size || num<0){
			return null;
		}
		int contador=0;
		Nodo<T> buscado = primero;
		while(contador<=num){
			if(contador==num){
				return buscado.darValor();
			}
			buscado=buscado.darSiguiente();
			contador++;
		}
		return null;
	}

	public T get( T elem){
		Nodo<T> buscado = primero;
		while(buscado!=null){
			if(buscado.darValor().equals(elem)){
				return buscado.darValor();
			}
			buscado=buscado.darSiguiente();
		}
		return null;
	}

	public int indexOf(T elem){
		Nodo<T> buscado = primero;
		int contador=0;
		while(buscado!=null){
			if(buscado.darValor().equals(elem)){
				return contador;
			}
			contador++;
			buscado=buscado.darSiguiente();
		}
		return -1;

	}

	public boolean contains(T elem){
		Nodo<T> buscado = primero;
		while(buscado!=null){
			if(buscado.darValor().equals(elem)){
				return true;
			}
			buscado=buscado.darSiguiente();
		}
		return false;

	}


	public boolean equals(ArrayList<T> aComp){
		if(aComp.size()== size){
			for(int i=0;i<size;i++){
				T actual =aComp.get(i);
				T actualMio =get(i);
				if(!actual.equals(actualMio)){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public Iterator<T> iterator(){
		IteradorSimple<T> it = new IteradorSimple<T>(size);
		Nodo<T> buscado = primero;
		while(buscado!=null){
			it.agregar(buscado.darValor());
		}
		return it;

	}
}
