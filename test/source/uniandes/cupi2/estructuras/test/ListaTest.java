package uniandes.cupi2.estructuras.test;

import java.util.Iterator;

import uniandes.cupi2.estructuras.Lista;
import junit.framework.TestCase;

/**
 * Clase de prueba para Lista
 */
public class ListaTest extends TestCase {
	private Lista<String> lista;
	
	
	private String foto1;
	private String foto2;
	private String foto3;
	private String foto4;
	private String foto5;
	private String foto6;
	private String foto7;
	private String foto8;
	private String foto9;
	private String foto10;
	

	
	public void setupEscenario1(){
		lista = new Lista<String>();
		
		foto1= "aA";
		foto2= "Ab";
		foto3= "bb";
		foto4= "cc";
		foto5= "dd";
		foto6="De";
		foto7="fg";
		foto8= "hh";
		foto9= "nn";
		foto10= "zZ";
		
		lista.agregar(foto1);
		lista.agregar(foto2);
		lista.agregar(foto3);
		lista.agregar(foto4);
		lista.agregar(foto5);
		lista.agregar(foto6);
		lista.agregar(foto7);
		lista.agregar(foto8);
		lista.agregar(foto9);
		lista.agregar(foto10);
		
	}
	
	public void setupEscenario2(){
		lista = new Lista<String>();
		
		foto1= "aA";
		foto2= "Ab";
		foto3= "bb";
		foto4= "cc";
		foto5= "dd";
		foto6="De";
		foto7="fg";
		foto8= "hh";
		foto9= "nn";
		foto10= "zZ";
		
		lista.agregarAlComienzo(foto1);
		lista.agregarAlComienzo(foto2);
		lista.agregarAlComienzo(foto3);
		lista.agregarAlComienzo(foto4);
		lista.agregarAlComienzo(foto5);
		lista.agregarAlComienzo(foto6);
		lista.agregarAlComienzo(foto7);
		lista.agregarAlComienzo(foto8);
		lista.agregarAlComienzo(foto9);
		lista.agregarAlComienzo(foto10);
		
	}
	
	public void testDarPrimero(){
		setupEscenario1();
		assertEquals("Se debe retornar la primer foto", foto1, lista.darPrimero().darValor());
		
	}
	
	public void testDarLongitud(){
		setupEscenario1();
		assertEquals("Debe retornar 10, pues hay esa cantidad de elementos en la lista", 10, lista.darLongitud());
	}
	
	
	public void testAgregar(){
		
		setupEscenario1();
		//ya que el setupEscenario1() utiliza este metodo...
		
		assertNotNull("Debe existir la segunda foto", lista.buscar(foto2));
		String foto11= "hello";
		lista.agregar(foto11);
		assertEquals("Debe retornar 11", 11, lista.darLongitud());
	}
	
	public void testAgregarAlComienzo(){
		setupEscenario2();
		
		assertEquals("Se debe retornar la ultima foto", foto10, lista.darPrimero().darValor());
		assertEquals("Se debe retornar la ultima foto", foto9, lista.darPrimero().darSiguiente().darValor());
		assertEquals("Se debe retornar la ultima foto", foto1, lista.darUltimo().darValor());

	}
	
	public void testEliminar(){
		setupEscenario1();
		
		lista.eliminar(foto2);
		
		assertNull("No debe existir", lista.buscar(foto2));
		assertEquals("Debe haber 9 elementos", 9, lista.darLongitud());
		
		
	}
	
	public void testBuscar(){
		setupEscenario1();
		String foto11= "hello";
		
		lista.agregar(foto11);
		
		assertNotNull("No debe retornar vacio", lista.buscar(foto11.toString()));
	}
	
	public void testDarIterador()
	{
		setupEscenario1();
		Iterator<String> iter = lista.iterator();
		while(iter.hasNext())
		{
			System.out.println("El actual es: "+iter.next());
		}
	}
	

	
	
}