package uniandes.cupi2.estructuras.test;
import java.util.Iterator;

import uniandes.cupi2.estructuras.ListaOrdenada;
import junit.framework.TestCase;

/**
 * Clase de prueba para Lista
 */
public class ListaOrdenadaTest extends TestCase {
	private ListaOrdenada<String> listaOrdenada;
	
	
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
		listaOrdenada = new ListaOrdenada<String>();
		
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
		
		listaOrdenada.agregar(foto1);
		listaOrdenada.agregar(foto2);
		listaOrdenada.agregar(foto3);
		listaOrdenada.agregar(foto4);
		listaOrdenada.agregar(foto5);
		listaOrdenada.agregar(foto6);
		listaOrdenada.agregar(foto7);
		listaOrdenada.agregar(foto8);
		listaOrdenada.agregar(foto9);
		listaOrdenada.agregar(foto10);
		
	}
	
	public void testDarPrimero(){
		setupEscenario1();
		assertEquals("Se debe retornar la primer foto", foto2, listaOrdenada.darPrimero().darValor());
		
	}
	
	public void testDarLongitud(){
		setupEscenario1();
		assertEquals("Debe retornar 10, pues hay esa cantidad de elementos en la lista", 10, listaOrdenada.darLongitud());
	}
	
	
	public void testAgregar(){
		
		setupEscenario1();
		//ya que el setupEscenario1() utiliza este metodo...
		
		assertNotNull("Debe existir la segunda foto", listaOrdenada.buscar(foto2));
		String foto11= "hello";
		listaOrdenada.agregar(foto11);
		assertEquals("Debe retornar 11", 11, listaOrdenada.darLongitud());
		
		
	}
	
	public void testEliminar(){
		setupEscenario1();
		
		listaOrdenada.eliminar(foto2);
		
		assertNull("No debe existir", listaOrdenada.buscar(foto2));
		assertEquals("Debe haber 9 elementos", 9, listaOrdenada.darLongitud());
	}
	
	public void testBuscar(){
		setupEscenario1();
		String foto11= "hello";
		
		listaOrdenada.agregar(foto11);
		
		assertNotNull("No debe retornar vacio", listaOrdenada.buscar(foto11.toString()));
	}
	
	public void testDarIterador()
	{
		setupEscenario1();
		Iterator<String> iter = listaOrdenada.iterator();
		while(iter.hasNext())
		{
			System.out.println("El actual es: "+iter.next());
		}
	}
	
	
}