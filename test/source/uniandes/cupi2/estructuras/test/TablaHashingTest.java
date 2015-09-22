package uniandes.cupi2.estructuras.test;

import java.util.Iterator;

import uniandes.cupi2.estructuras.TablaHashing;
import junit.framework.TestCase;

public class TablaHashingTest extends TestCase
{
	private TablaHashing<String, Integer> tablaHash;
	
	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private String string5;

	
	private Integer int1;
	private Integer int2;
	private Integer int3;
	private Integer int4;
	private Integer int5;
	
	
	public void setupEscenario1()
	{
		tablaHash = new TablaHashing<String, Integer>(11);
		
		string1 = "primerString";
		int1 = new Integer(1);
		tablaHash.agregarElemento(string1, int1);
		
		string2 = "segundoString";
		int2 = new Integer(2);
		tablaHash.agregarElemento(string2, int2);
		
		string3 = "tercerString";
		int3 = new Integer(3);
		tablaHash.agregarElemento(string3, int3);
		
		string4 = "cuartoString";
		int4 = new Integer(4);
		tablaHash.agregarElemento(string4, int4);
		
		string5 = "quintoString";
		int5 = new Integer(13);
		tablaHash.agregarElemento(string5, int5);
		
	}
	
	public void testAgregar()
	{
		setupEscenario1();
		assertEquals("Se debe encontrar al string1", string1, tablaHash.buscarElemento(int1));
		assertEquals("Se debe encontrar al string5", string5, tablaHash.buscarElemento(int5));
		assertEquals("Se debe encontrar al string3", string3, tablaHash.buscarElemento(int3));
		assertEquals("Se debe encontrar al string1", string4, tablaHash.buscarElemento(int4));
		
		//Probar coliciones
		assertEquals("Se debe encontrar al string2", string2, tablaHash.buscarElemento(int2));
	}
	
	public void testEliminar()
	{
		setupEscenario1();
		
		assertEquals("Se debe poder eliminar",string1,  tablaHash.eliminarElementoPorLlave(int1));
		assertNull("El objeto no debe exisitir", tablaHash.buscarElemento(int1));
		
		//Probar coliciones
		assertEquals("Se debe poder eliminar", string2, tablaHash.eliminarElementoPorLlave(int2));
		assertEquals("El objeto no debe exisitir", null, tablaHash.buscarElemento(int2));
		assertEquals("Debe seguir existiendo el otro", string5, tablaHash.buscarElemento(int5));
		assertEquals("Se debe poder eliminar", string5, tablaHash.eliminarElementoPorLlave(int5));
		assertNull("El objeto no debe exisitir", tablaHash.buscarElemento(int5));
		
	}
	
	public void testDarIterador()
	{
		setupEscenario1();
		
		Iterator<String> iter = tablaHash.iterator();
		while(iter.hasNext())
		{
			System.out.println("El String actual: "+iter.next());
		}
	}
	
	
	
	
}
