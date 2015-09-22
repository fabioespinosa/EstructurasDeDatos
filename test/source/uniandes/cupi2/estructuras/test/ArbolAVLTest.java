package uniandes.cupi2.estructuras.test;

import java.util.Iterator;

import uniandes.cupi2.estructuras.ArbolAVL;
import junit.framework.TestCase;

public class ArbolAVLTest extends TestCase {
	
	
	private ArbolAVL<String> arbolBinario;
	
	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private String string5;

	
	
	public void setupEscenario1()
	{
		arbolBinario = new ArbolAVL<String>();
		
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
		arbolBinario = new ArbolAVL<String>();
		
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
	
	public void setupEscenario3()
	{
		arbolBinario = new ArbolAVL<String>();
		
		string1 = "8";
		arbolBinario.insertar(string1);
		
		string2 = "7";
		arbolBinario.insertar(string2);
		
		string3 = "3";
		arbolBinario.insertar(string3);
		
		string4 = "6";
		arbolBinario.insertar(string4);
		
		string5 = "9";
		arbolBinario.insertar(string5);
		
		String string6 = "1";
		arbolBinario.insertar(string6);
		
		String string7 = "5";
		arbolBinario.insertar(string7);
		
		String string8 = "2";
		arbolBinario.insertar(string8);
		
		String string9 = "4";
		arbolBinario.insertar(string9);
	}
	
	public void test2()
	{
		System.out.println("-----COminezo test2");
		setupEscenario3();
		assertEquals("La raiz debe ser 7", string2, arbolBinario.darRaiz().darValor());
		//assertEquals("El izq debe ser 3", string3, arbolBinario.darRaiz().darIzquierdo().darValor());
		//assertEquals("El der debe ser 8",string1, arbolBinario.darRaiz().darDerecho().darValor());
		//assertEquals("El balance debe ser 2", 1, arbolBinario.darRaiz().darBalance());
		System.out.println("-----Cominezo test2");
	}
	
	public void test1 (){
		
		arbolBinario = new ArbolAVL<String>();
		
		string1 = "1primerString";
		arbolBinario.insertar(string1);
		
		string2 = "0segundoString";
		arbolBinario.insertar(string2);
		
		string3 = "2tercerString";
		arbolBinario.insertar(string3);
		
		assertEquals("Se debe encontrar al string1", string1, arbolBinario.buscar(string1));
		assertEquals("Se debe encontrar al string2", string2, arbolBinario.buscar(string2));
		assertEquals("Se debe encontrar al string3", string3, arbolBinario.buscar(string3));
		
		assertEquals("Si es avl debe ser 0", 0, (arbolBinario.darRaiz().darIzquierdo().darAltura()-arbolBinario.darRaiz().darDerecho().darAltura()));
		

	}
	
	public void testAVL(){
		setupEscenario1();
		assertEquals("Si es avl debe ser -1", -1, (arbolBinario.darRaiz().darIzquierdo().darAltura()-arbolBinario.darRaiz().darDerecho().darAltura()));
		
		setupEscenario2();
		assertEquals("Si es avl debe ser -1", -1, (arbolBinario.darRaiz().darIzquierdo().darAltura()-arbolBinario.darRaiz().darDerecho().darAltura()));
		
		arbolBinario.eliminar(string1);
		assertEquals("Si es avl debe ser -1", -1, (arbolBinario.darRaiz().darBalance())); 

		arbolBinario.eliminar(string2);


		
		assertNull("Ya se elimino", arbolBinario.buscar(string2));
		assertEquals("Tiene que haber 3 elementos", 3, arbolBinario.darPeso());
		assertEquals("Si es avl debe ser 0", 0, (arbolBinario.darRaiz().darBalance())); 
		assertEquals("Si es avl debe ser -1", string4, (arbolBinario.darRaiz().darDerecho().darValor())); 


		
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
	
	
	public void testRecorrerPorNiveles(){
		setupEscenario1();
		
		Iterator<String> iter = arbolBinario.recorrerPorNiveles();
		assertEquals("Se debe encontrar al string2", string2, iter.next());
		assertEquals("Se debe encontrar al string1", string1, iter.next());
		assertEquals("Se debe encontrar al string4", string4, iter.next());
		assertEquals("Se debe encontrar al string3", string3, iter.next());
		assertEquals("Se debe encontrar al string5", string5, iter.next());
	}
	
	
	public void testIteratorPreOrden(){
		setupEscenario1();
		
		Iterator<String> iter = arbolBinario.preorden();
		assertEquals("Se debe encontrar al string2", string2, iter.next());
		assertEquals("Se debe encontrar al string1", string1, iter.next());
		assertEquals("Se debe encontrar al string4", string4, iter.next());
		assertEquals("Se debe encontrar al string3", string3, iter.next());
		assertEquals("Se debe encontrar al string5", string5, iter.next());
	}
	
	public void testIteratorPosOrden(){
		setupEscenario1();
		
		Iterator<String> iter = arbolBinario.posorden();
		assertEquals("Se debe encontrar al string1", string1, iter.next());
		assertEquals("Se debe encontrar al string3", string3, iter.next());
		assertEquals("Se debe encontrar al string5", string5, iter.next());
		assertEquals("Se debe encontrar al string4", string4, iter.next());
		assertEquals("Se debe encontrar al string2", string2, iter.next());
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
		
		assertEquals("Hay 5 elementos en el arbol", 3, arbolBinario.darAltura());

		
	}
	
}
