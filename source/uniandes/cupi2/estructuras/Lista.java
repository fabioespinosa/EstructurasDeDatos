package uniandes.cupi2.estructuras;

import java.util.Iterator;


public class Lista <T> {

	private Nodo<T> primero;

	private Nodo<T> ultimo;

	private int cantElementos;

	public Lista(){
		primero = null;
		ultimo=null;
		cantElementos=0;
	}

	public Iterator<T> iterator() {
		IteradorSimple<T> iterador = new IteradorSimple<T>(cantElementos);

		Nodo<T> actual = primero;
		while(actual!=null){
			
			iterador.agregar(actual.darValor());
			actual= actual.darSiguiente();
		}

		return iterador;

	}

	public void agregar(T nuevoElem) {

		Nodo<T> aAgregar = new Nodo<T>(nuevoElem);

		if(primero==null){
			primero= aAgregar;
			ultimo= aAgregar;
		}

		else
		{
			aAgregar.cambiarAnterior(ultimo);	
			ultimo.cambiarSiguiente(aAgregar);

			ultimo= aAgregar;
		}
		cantElementos++;
	}

	public void agregarAlComienzo(T nuevoElem){
		Nodo<T> aAgregar = new Nodo<T>(nuevoElem);

		if(primero==null){
			primero= aAgregar;
			ultimo= aAgregar;
		}

		else 
		{
			aAgregar.cambiarSiguiente(primero);	
			primero.cambiarAnterior(aAgregar);

			primero= aAgregar;
		}
		cantElementos++;
	}

	public boolean eliminar(T aElem) {
		boolean seElimino = false;

		if(primero==null) {
			return seElimino; //No elimina y se acaba el metodo
		}

		else if(primero.darValor().equals(aElem)) {
			primero = primero.darSiguiente();

			cantElementos--;
			seElimino=true;
		}

		else {

			Nodo<T> actual = primero;

			while(!seElimino && actual.darSiguiente()!=null) {

				if(actual.darSiguiente().darValor().equals(aElem)) {

					actual.cambiarSiguiente(actual.darSiguiente().darSiguiente());
					cantElementos--;
					seElimino = true;

				}
				actual = actual.darSiguiente();
			}

		}

		return seElimino;
	}


	public int darLongitud() {
		return cantElementos;
	}


	public T buscar(T aBuscar) {
		Nodo<T> aRecorrer = primero;

		while(aRecorrer!=null){
			if(aRecorrer.darValor().equals(aBuscar)){
				return aRecorrer.darValor();
			}
			aRecorrer= aRecorrer.darSiguiente();
		}
		return null;
	}


	public Nodo<T> darPrimero() {
		return primero;
	}

	public Nodo<T> darUltimo(){
		return ultimo;
	}




}
