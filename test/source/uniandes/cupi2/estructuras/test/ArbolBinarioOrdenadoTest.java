package uniandes.cupi2.estructuras.test;

import java.util.Iterator;

import uniandes.cupi2.estructuras.ArbolBinarioOrdenado;
import uniandes.cupi2.estructuras.TablaHashing;
import junit.framework.TestCase;

public class ArbolBinarioOrdenadoTest extends TestCase {

	private ArbolBinarioOrdenado<String> arbolBinario;
	
	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private String string5;

	
	
	public void setupEscenario1()
	{
		arbolBinario = new ArbolBinarioOrdenado<String>();
		
		string1 = "1primerString";
		arbolBinario.insertar(string1);
		
		string2 = "2segundoString";
		arbolBinario.insertar(string2);
		
		string3 = "3tercerString";
		arbolBinario.insertar(string3);
		
		string4 = "4cuartoString";
		arbolBinario.insertar(string4);
		
		string5 = "5quintoString";
		arbolBinario.insertar(string5);
		
	}
	
	public void setupEscenario2()
	{
		arbolBinario = new ArbolBinarioOrdenado<String>();
		
		string1 = "1primerString";
		arbolBinario.insertar(string1);
		
		string2 = "0segundoString";
		arbolBinario.insertar(string2);
		
		string3 = "2tercerString";
		arbolBinario.insertar(string3);
		
		string4 = "4cuartoString";
		arbolBinario.insertar(string4);
		
		string5 = "3quintoString";
		arbolBinario.insertar(string5);
		
	}
	
	public void testAgregar()
	{
		setupEscenario1();
		assertEquals("Se debe encontrar al string1", string1, arbolBinario.buscar(string1));
		assertEquals("Se debe encontrar al string2", string2, arbolBinario.buscar(string2));
		assertEquals("Se debe encontrar al string3", string3, arbolBinario.buscar(string3));
		assertEquals("Se debe encontrar al string4", string4, arbolBinario.buscar(string4));
		assertEquals("Se debe encontrar al string5", string5, arbolBinario.buscar(string5));

		
	}
	
	public void testEliminar()
	{
		setupEscenario1();
		
		assertNotNull("Se debe poder eliminar", arbolBinario.eliminar(string1));
		assertNull("El objeto no debe exisitir", arbolBinario.buscar(string1));
		
		
		assertNotNull("Se debe poder eliminar", arbolBinario.eliminar(string2));
		assertEquals("El objeto no debe exisitir", null, arbolBinario.buscar(string2));
		assertEquals("Debe seguir existiendo el otro", string5, arbolBinario.buscar(string5));
	}
	
	public void testIteratorInOrden()
	{
		setupEscenario1();
		
		Iterator<String> iter = arbolBinario.inorden();
		assertEquals("Se debe encontrar al string1", string1, iter.next());
		assertEquals("Se debe encontrar al string2", string2, iter.next());
		assertEquals("Se debe encontrar al string3", string3, iter.next());
		assertEquals("Se debe encontrar al string4", string4, iter.next());
		assertEquals("Se debe encontrar al string5", string5, iter.next());

	}
	
	public void testIteratorPreOrden(){
		setupEscenario1();
		
		Iterator<String> iter = arbolBinario.preorden();
		assertEquals("Se debe encontrar al string1", string1, iter.next());
		assertEquals("Se debe encontrar al string2", string2, iter.next());
		assertEquals("Se debe encontrar al string3", string3, iter.next());
		assertEquals("Se debe encontrar al string4", string4, iter.next());
		assertEquals("Se debe encontrar al string5", string5, iter.next());
	}
	
	public void testIteratorPosOrden(){
		setupEscenario1();
		
		Iterator<String> iter = arbolBinario.posorden();
		assertEquals("Se debe encontrar al string5", string5, iter.next());
		assertEquals("Se debe encontrar al string4", string4, iter.next());
		assertEquals("Se debe encontrar al string3", string3, iter.next());
		assertEquals("Se debe encontrar al string2", string2, iter.next());
		assertEquals("Se debe encontrar al string1", string1, iter.next());
	}
	
	public void testRecorrerPorNiveles(){
		setupEscenario2();
		
		Iterator<String> iter = arbolBinario.recorrerPorNiveles();
		assertEquals("Se debe encontrar al string1", string1, iter.next());
		assertEquals("Se debe encontrar al string2", string2, iter.next());
		assertEquals("Se debe encontrar al string3", string3, iter.next());
		assertEquals("Se debe encontrar al string4", string4, iter.next());
		assertEquals("Se debe encontrar al string5", string5, iter.next());
	}
	
	
	public void testDarMayor(){
		setupEscenario1();
		
		
		assertEquals("El mayor es el string5", string5, arbolBinario.darMayor());
	}
	
	public void testDarMenor(){
		setupEscenario1();
		
		assertEquals("El menor es el string1", string1, arbolBinario.darMenor());

		
	}
	
	public void testDarPeso(){
		setupEscenario1();
		
		assertEquals("Hay 5 elementos en el arbol", 5, arbolBinario.darPeso());

		
	}
	
	public void testDarAltura(){
		setupEscenario2();
		
		assertEquals("Hay 5 elementos en el arbol", 4, arbolBinario.darAltura());

		
	}
	
	
}
