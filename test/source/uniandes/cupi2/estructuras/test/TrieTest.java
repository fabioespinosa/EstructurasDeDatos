package uniandes.cupi2.estructuras.test;

import java.util.Iterator;

import uniandes.cupi2.estructuras.IteradorSimple;
import uniandes.cupi2.estructuras.Trie;
import junit.framework.TestCase;

public class TrieTest extends TestCase
{
	private Trie<Integer> elTrie;
	private String llave1;
	private IteradorSimple<Integer>  iterElem1;
	private String llave2;
	private IteradorSimple<Integer>  iterElem2;
	private String llave3;
	private IteradorSimple<Integer>  iterElem3;
	private String llave4;
	private IteradorSimple<Integer>  iterElem4;

	public void setupEscenario1()
	{	
		elTrie = new Trie<Integer>();

		llave1 = "prueba";
		iterElem1 = new IteradorSimple<Integer>(10);
		for(int i=0; i<10; i++)
		{

			iterElem1.agregar(i);
		}

		llave2 = "pruebaSegunda";
		iterElem2 = new IteradorSimple<Integer>(10);
		for(int i=10; i<20; i++)
		{

			iterElem2.agregar(i);
		}

		llave3 = "prue";
		iterElem3 = new IteradorSimple<Integer>(10);
		for(int i=20; i<30; i++)
		{

			iterElem3.agregar(i);
		}

		llave4 = "ultima";
		iterElem4 = new IteradorSimple<Integer>(10);
		for(int i=30; i<40; i++)
		{

			iterElem4.agregar(i);
		}
	}

	public void testDarAltura()
	{	
		setupEscenario1();
		elTrie.agregar(llave1, iterElem1);
		assertEquals("La altura debe ser ser 7", 7, elTrie.darAltura());

		elTrie.agregar(llave2, iterElem2);
		assertEquals("La altura debe ser 14", 14, elTrie.darAltura());

		elTrie.agregar(llave3, iterElem3);
		assertEquals("La altura no debio haber cambiado", 14, 14);

		elTrie.agregar(llave4, iterElem4);
		assertEquals("La altura no debio haber cambiado", 14, 14);
	}

	public void testDarPeso()
	{
		setupEscenario1();
		elTrie.agregar(llave1, iterElem1);
		assertEquals("El peso debe ser 10", 10, elTrie.darPeso());

		elTrie.agregar(llave2, iterElem2);
		assertEquals("El peso debe ser 20", 20, elTrie.darPeso());

		elTrie.agregar(llave3, iterElem3);
		assertEquals("El peso debe ser 30", 30, elTrie.darPeso());

		elTrie.agregar(llave4, iterElem4);
		assertEquals("El peso debe ser 40", 40, elTrie.darPeso());
	}
	
	public void testAgregar()
	{
		setupEscenario1();
		elTrie.agregar(llave1, iterElem1);
		assertEquals("El peso debe ser 10", 10, elTrie.darPeso());
		assertEquals("La altura debe ser ser 7", 7, elTrie.darAltura());

		elTrie.agregar(llave2, iterElem2);
		assertEquals("El peso debe ser 20", 20, elTrie.darPeso());
		assertEquals("La altura debe ser 14", 14, elTrie.darAltura());

		elTrie.agregar(llave3, iterElem3);
		assertEquals("El peso debe ser 30", 30, elTrie.darPeso());
		assertEquals("La altura debe ser 14", 14, elTrie.darAltura());
		
		elTrie.agregar(llave4, iterElem4);
		assertEquals("El peso debe ser 40", 40, elTrie.darPeso());
		assertEquals("La altura debe ser 14", 14, elTrie.darAltura());
	}
	
	public void testBuscar()
	{
		setupEscenario1();
		elTrie.agregar(llave1, iterElem1);
		Iterator<Integer> resp = elTrie.buscar(llave1).iterator();
		
		for( int i = 0; i<10; i++)
		{
			assertEquals("La respuesta debe tener a "+i, i, (int)resp.next());
		}
		
		elTrie.agregar(llave2, iterElem2);
		resp = elTrie.buscar(llave2).iterator();
		
		for( int i = 10; i<20; i++)
		{
			assertEquals("La respuesta debe tener a "+i, i, (int)resp.next());
		}
		
		elTrie.agregar(llave3, iterElem3);
		resp = elTrie.buscar(llave3).iterator();
		
		for( int i = 20; i<30; i++)
		{
			assertEquals("La respuesta debe tener a "+i, i, (int)resp.next());
		}
		
		elTrie.agregar(llave4, iterElem4);
		resp = elTrie.buscar(llave4).iterator();
		
		for( int i = 30; i<40; i++)
		{
			assertEquals("La respuesta debe tener a "+i, i, (int)resp.next());
		}
		
		resp = elTrie.buscar("los").iterator();
		while(resp.hasNext())
		{
			fail("No debio entrar aqui");
		}
	}
	
	public void testBuscarPorPrefijo()
	{
		setupEscenario1();
		elTrie.agregar(llave1, iterElem1);
		elTrie.agregar(llave2, iterElem2);
		elTrie.agregar(llave3, iterElem3);
		elTrie.agregar(llave4, iterElem4);
		
		Iterator<Integer> resp = elTrie.buscarPorPrefijo("pru").iterator();
		for( int i = 0; i<30; i++)
		{
			assertEquals("La respuesta debe tener a "+i, i, (int)resp.next());
		}
		
		resp = elTrie.buscarPorPrefijo("ul").iterator();
		for( int i = 30; i<40; i++)
		{
			assertEquals("La respuesta debe tener a "+i, i, (int)resp.next());
		}
		
		resp = elTrie.buscarPorPrefijo(llave2).iterator();
		for( int i = 10; i<20; i++)
		{
			assertEquals("La respuesta debe tener a "+i, i, (int)resp.next());
		}
		
		resp = elTrie.buscarPorPrefijo("los").iterator();
		while(resp.hasNext())
		{
			fail("No debio entrar aqui");
		}
	}
}
