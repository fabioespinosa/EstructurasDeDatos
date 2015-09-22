package uniandes.cupi2.estructuras.test;

import java.util.Iterator;

import uniandes.cupi2.estructuras.Arco;
import uniandes.cupi2.estructuras.Camino;
import uniandes.cupi2.estructuras.GrafoDirigido;
import uniandes.cupi2.estructuras.Vertice;
import uniandes.cupi2.estructuras.entidades.ArcoPrueba;
import uniandes.cupi2.estructuras.entidades.VerticePrueba;
import junit.framework.TestCase;

public class GrafoDirigidoTest extends TestCase {

	private GrafoDirigido<String, VerticePrueba<String>, ArcoPrueba> grafo;

	private ArcoPrueba arco1;

	private ArcoPrueba arco2;

	private ArcoPrueba arco3;

	private ArcoPrueba arco4;

	private ArcoPrueba arco5;

	private ArcoPrueba arco6;

	private ArcoPrueba arco7;

	private ArcoPrueba arco8;


	private VerticePrueba<String> vertice1;
	private VerticePrueba<String> vertice2;
	private VerticePrueba<String> vertice3;
	private VerticePrueba<String> vertice4;
	private VerticePrueba<String> vertice5;
	private VerticePrueba<String> vertice6;

	public void setupEscenario1()
	{
		grafo = new GrafoDirigido<String, VerticePrueba<String>, ArcoPrueba>(10);
		
		vertice1 = new VerticePrueba<String>("u");
		vertice2 = new VerticePrueba<String>("v");
		vertice3 = new VerticePrueba<String>("w");
		vertice4 = new VerticePrueba<String>("x");
		vertice5 = new VerticePrueba<String>("y");
		vertice6 = new VerticePrueba<String>("z");

		
		grafo.agregarVertice(vertice1);
		grafo.agregarVertice( vertice2);
		grafo.agregarVertice(vertice3);
		grafo.agregarVertice(vertice4);
		grafo.agregarVertice(vertice5);
		grafo.agregarVertice(vertice6);
		
		arco1= new ArcoPrueba(1);
		grafo.agregarArco("u", "v", arco1);
		
		arco2= new ArcoPrueba(1);
		grafo.agregarArco("u", "x", arco2);
		
		arco3= new ArcoPrueba(1);
		grafo.agregarArco("v", "y", arco3);
		
		arco4= new ArcoPrueba(1);
		grafo.agregarArco("w", "y", arco4);
		
		arco5= new ArcoPrueba(1);
		grafo.agregarArco("w", "z", arco5);
		
		arco6= new ArcoPrueba(1);
		grafo.agregarArco("x", "v", arco6);
		
		arco7= new ArcoPrueba(1);
		grafo.agregarArco("y", "x", arco7);
		
		arco8= new ArcoPrueba(1);
		grafo.agregarArco("z", "z", arco8);

	}

	public void setupEscenarioDFS()
	{
		grafo = new GrafoDirigido<String, VerticePrueba<String>, ArcoPrueba>(10);
		grafo.agregarVertice( new VerticePrueba<String>("u"));
		grafo.agregarVertice(new VerticePrueba<String>("v"));
		grafo.agregarVertice(new VerticePrueba<String>("w"));
		grafo.agregarVertice(new VerticePrueba<String>("x"));
		grafo.agregarVertice(new VerticePrueba<String>("y"));
		grafo.agregarVertice(new VerticePrueba<String>("z"));

		grafo.agregarArco("u", "v", new ArcoPrueba(1));
		grafo.agregarArco("u", "x", new ArcoPrueba(1));

		grafo.agregarArco("v", "y", new ArcoPrueba(1));

		grafo.agregarArco("w", "y", new ArcoPrueba(1));
		grafo.agregarArco("w", "z", new ArcoPrueba(1));

		grafo.agregarArco("x", "v", new ArcoPrueba(1));

		grafo.agregarArco("y", "x", new ArcoPrueba(1));

		grafo.agregarArco("z", "z", new ArcoPrueba(1));
	}

	public void setupEscenarioBFS()
	{
		grafo = new GrafoDirigido<String, VerticePrueba<String>, ArcoPrueba>(12);

		grafo.agregarVertice(new VerticePrueba<String>("r"));
		grafo.agregarVertice(new VerticePrueba<String>("s"));
		grafo.agregarVertice(new VerticePrueba<String>("t"));
		grafo.agregarVertice(new VerticePrueba<String>("u"));
		grafo.agregarVertice(new VerticePrueba<String>("v"));
		grafo.agregarVertice(new VerticePrueba<String>("w"));
		grafo.agregarVertice(new VerticePrueba<String>("x"));
		grafo.agregarVertice(new VerticePrueba<String>("y"));

		grafo.agregarArco("r", "s", new ArcoPrueba(1));
		grafo.agregarArco("r", "v", new ArcoPrueba(1));

		grafo.agregarArco("s", "r", new ArcoPrueba(1));
		grafo.agregarArco("s", "w", new ArcoPrueba(1));

		grafo.agregarArco("t", "w", new ArcoPrueba(1));
		grafo.agregarArco("t", "x", new ArcoPrueba(1));
		grafo.agregarArco("t", "u", new ArcoPrueba(1));

		grafo.agregarArco("u", "x", new ArcoPrueba(1));
		grafo.agregarArco("u", "y", new ArcoPrueba(1));
		grafo.agregarArco("u", "t", new ArcoPrueba(1));

		grafo.agregarArco("v", "r", new ArcoPrueba(1));

		grafo.agregarArco("w", "s", new ArcoPrueba(1));
		grafo.agregarArco("w", "t", new ArcoPrueba(1));
		grafo.agregarArco("w", "x", new ArcoPrueba(1));

		grafo.agregarArco("x", "w", new ArcoPrueba(1));
		grafo.agregarArco("x", "t", new ArcoPrueba(1));
		grafo.agregarArco("x", "y", new ArcoPrueba(1));
		grafo.agregarArco("x", "u", new ArcoPrueba(1));

		grafo.agregarArco("y", "x", new ArcoPrueba(1));
		grafo.agregarArco("y", "u", new ArcoPrueba(1));
	}

	public void setupEscenarioDijkstra()
	{
		grafo = new GrafoDirigido<String, VerticePrueba<String>, ArcoPrueba>(8);
		grafo.agregarVertice(new VerticePrueba<String>("s"));
		grafo.agregarVertice(new VerticePrueba<String>("t"));
		grafo.agregarVertice(new VerticePrueba<String>("x"));
		grafo.agregarVertice(new VerticePrueba<String>("y"));
		grafo.agregarVertice( new VerticePrueba<String>("z"));

		grafo.agregarArco("s", "t", new ArcoPrueba(10));
		grafo.agregarArco("s", "y", new ArcoPrueba(5));

		grafo.agregarArco("t", "y", new ArcoPrueba(2));
		grafo.agregarArco("t", "x", new ArcoPrueba(1));

		grafo.agregarArco("x", "z", new ArcoPrueba(4));

		grafo.agregarArco("y", "t", new ArcoPrueba(3));
		grafo.agregarArco("y", "x", new ArcoPrueba(9));
		grafo.agregarArco("y", "z", new ArcoPrueba(2));

		grafo.agregarArco("z", "s", new ArcoPrueba(7));
		grafo.agregarArco("z", "x", new ArcoPrueba(6));

	}

	public void testAgregar()
	{

		setupEscenario1();
		
		assertEquals("Tiene que existir el primer vertice", vertice1, grafo.darVertice(vertice1.darId()).darInfo());
		assertEquals("Tiene que existir el primer vertice", null, grafo.darArco("u", "k"));
	}
	
	public void testDesmarcarTodos(){
		setupEscenario1();
		grafo.darVertice(vertice1.darId()).marcar();
		grafo.darVertice(vertice5.darId()).marcar();
		
		grafo.desmarcarVertices();
		
		assertFalse("Ya esta desmarcado", grafo.darVertice(vertice1.darId()).darMarcado());
		assertFalse("Ya esta desmarcado", grafo.darVertice(vertice5.darId()).darMarcado());

		
	}

	public void testEliminarVertice()
	{
		setupEscenario1();
		grafo.eliminarVertice(vertice1.darId());
		
		assertNull("Ya se elimino", grafo.darVertice(vertice1.darId()));
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iter = grafo.recorridoPlano();
		while(iter.hasNext())
		{
			Vertice<String, VerticePrueba<String>, ArcoPrueba> actual = iter.next();
			assertFalse("No deberia haber camino", grafo.hayCaminoSimple(actual.darId(), vertice1.darId()));
			assertFalse("No deberia haber camino", grafo.hayCaminoSimple(vertice1.darId(), actual.darId()));
			assertFalse("No deberia haber cadena", grafo.hayCadena(actual.darId(), vertice1.darId()));
			assertFalse("No deberia haber cadena", grafo.hayCadena(vertice1.darId(), actual.darId()));
			
		}
		
		assertEquals("Este no se ha eliminado", vertice2, grafo.darVertice(vertice2.darId()).darInfo());
		
		grafo.eliminarVertice(vertice2.darId());
		assertNull("Ya se elimino", grafo.darVertice(vertice2.darId()));
		iter = grafo.recorridoPlano();
		while(iter.hasNext())
		{
			Vertice<String, VerticePrueba<String>, ArcoPrueba> actual = iter.next();
			assertFalse("No deberia haber camino", grafo.hayCaminoSimple(actual.darId(), vertice2.darId()));
			assertFalse("No deberia haber camino", grafo.hayCaminoSimple(vertice2.darId(), actual.darId()));
			assertFalse("No deberia haber cadena", grafo.hayCadena(actual.darId(), vertice2.darId()));
			assertFalse("No deberia haber cadena", grafo.hayCadena(vertice2.darId(), actual.darId()));
			
		}
		
		grafo.eliminarVertice(vertice4.darId());
		assertNull("Ya se elimino", grafo.darVertice(vertice4.darId()));
		while(iter.hasNext())
		{
			Vertice<String, VerticePrueba<String>, ArcoPrueba> actual = iter.next();
			assertFalse("No deberia haber camino", grafo.hayCaminoSimple(actual.darId(), vertice4.darId()));
			assertFalse("No deberia haber camino", grafo.hayCaminoSimple(vertice4.darId(), actual.darId()));
			assertFalse("No deberia haber cadena", grafo.hayCadena(actual.darId(), vertice4.darId()));
			assertFalse("No deberia haber cadena", grafo.hayCadena(vertice4.darId(), actual.darId()));
			
		}
	}
	
	public void testEliminarArco(){
		setupEscenario1();
		
		grafo.eliminarArco("u", "v");
		assertNull("No existe este arco", grafo.darArco("u", "v"));
		assertEquals("Existe arco1",arco2,  grafo.darArco("u", "x").darInfo());
		
		grafo.eliminarArco("u", "x");
		assertNull("No existe este arco", grafo.darArco("u", "x"));
		assertEquals("Existe arco1",arco4,  grafo.darArco("w", "y").darInfo());

	}

	
	public void testAgregarArco(){
		setupEscenario1();
		assertNull("No existe este arco", grafo.darArco("u", "k"));
		assertEquals("Existe arco1",arco1,  grafo.darArco("u", "v").darInfo());
		assertEquals("Existe arco1",arco2,  grafo.darArco("u", "x").darInfo());
		assertEquals("Existe arco1",arco3,  grafo.darArco("v", "y").darInfo());
		assertEquals("Existe arco1",arco4,  grafo.darArco("w", "y").darInfo());

		
	}

	public void testRecorridoPlano()
	{
		setupEscenarioDFS();
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iter = grafo.recorridoPlano();
		while(iter.hasNext())
		{
			System.out.println(iter.next().darId());
		}

	}

	public void testRecorridoXProfundidad()
	{
		setupEscenarioDFS();
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iter = grafo.recorridoXProfundidad();
		while(iter.hasNext())
		{
			System.out.println(iter.next().darId());
		}
	}
	
	public void testRecorridoXProfundidadDesdeFuente()
	{
		setupEscenarioDFS();
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iter = grafo.recorridoXProfundidadDesdeFuente("u");
		
		Vertice actual = iter.next();
		assertEquals("El vertice actual debería ser u", "u", actual.darId());
		assertNull("El actual no debería tener padre", actual.darPadre());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser v", "v", actual.darId());
		assertEquals("El padre deberia ser u", "u", actual.darPadre().darId());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser y", "y", actual.darId());
		assertEquals("El padre deberia ser v", "v", actual.darPadre().darId());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser x", "x", actual.darId());
		assertEquals("El padre deberia ser y", "y", actual.darPadre().darId());
		
	}

	public void testRecorridoXNiveles()
	{
		setupEscenarioBFS();
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iter = grafo.recorridoXNiveles("s").iterator();
		
		Vertice actual = iter.next();
		assertEquals("El vertice actual debería ser s", "s", actual.darId());
		assertNull("El actual no debería tener padre", actual.darPadre());
		assertEquals("La distancia deberia ser 0", 0.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser r", "r", actual.darId());
		assertEquals("El padre deberia ser s", "s", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 1", 1.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser w", "w", actual.darId());
		assertEquals("El padre deberia ser s", "s", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 1", 1.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser v", "v", actual.darId());
		assertEquals("El padre deberia ser r", "r", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 2", 2.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser t", "t", actual.darId());
		assertEquals("El padre deberia ser w", "w", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 2", 2.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser x", "x", actual.darId());
		assertEquals("El padre deberia ser w", "w", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 2", 2.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser u", "u", actual.darId());
		assertEquals("El padre deberia ser t", "t", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 3", 3.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser y", "y", actual.darId());
		assertEquals("El padre deberia ser x", "x", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 3", 3.0, actual.darDistancia());
		
		
	}

	public void testDijkstra()
	{
		setupEscenarioDijkstra();
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iter = grafo.dijkstra("s").iterator();
		
		Vertice actual = iter.next();
		assertEquals("El vertice actual debería ser s", "s", actual.darId());
		assertNull("El actual no debería tener padre", actual.darPadre());
		assertEquals("La distancia deberia ser 0", 0.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser y", "y", actual.darId());
		assertEquals("El padre deberia ser s", "s", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 5", 5.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser z", "z", actual.darId());
		assertEquals("El padre deberia ser y", "y", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 7", 7.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser t", "t", actual.darId());
		assertEquals("El padre deberia ser y", "y", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 8", 8.0, actual.darDistancia());
		
		actual = iter.next();
		assertEquals("El vertice actual debería ser x", "x", actual.darId());
		assertEquals("El padre deberia ser t", "t", actual.darPadre().darId());
		assertEquals("La distancia deberia ser 9", 9.0, actual.darDistancia());
		
	}
	
	public void testHayCaminoSimple()
	{
		setupEscenarioDFS();
		assertTrue("Deberia haber camino simple", grafo.hayCaminoSimple("w", "v"));
		assertFalse("No deberia haber camino simple", grafo.hayCaminoSimple("w", "u"));
		
	}
	
	public void testHayCicloSimple()
	{
		setupEscenarioDFS();
		assertTrue("Deberia haber ciclo simple con", grafo.hayCicloSimpleCon("v"));
		assertTrue("Deberia haber ciclo simple con", grafo.hayCicloSimpleCon("x"));
		assertTrue("Deberia haber ciclo simple con", grafo.hayCicloSimpleCon("y"));
		assertTrue("Deberia haber ciclo simple con", grafo.hayCicloSimpleCon("z"));
		
		assertFalse("No deberia haber ciclo simple con", grafo.hayCicloSimpleCon("u"));
		assertFalse("No deberia haber ciclo simple con", grafo.hayCicloSimpleCon("w"));
	}

	public void testDesmarcarVertices()
	{
		setupEscenario1();
		grafo.darVertice(vertice1.darId()).marcar();
		grafo.darVertice(vertice5.darId()).marcar();
		
		grafo.desmarcarVertices();
		
		assertFalse("Ya esta desmarcado", grafo.darVertice(vertice1.darId()).darMarcado());
		assertFalse("Ya esta desmarcado", grafo.darVertice(vertice5.darId()).darMarcado());
	}

	public void testDarCaminoSimple()
	{
		setupEscenarioDFS();
		Camino<String, VerticePrueba<String>, ArcoPrueba> camino = grafo.darCaminoSimple("w", "v");
		assertEquals("La longitud deberia ser 3", 3, camino.darLongitud());
		
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iterVer = camino.darVertices();
		
		Vertice actual = iterVer.next();
		assertEquals("El vertice actual debería ser w", "w", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser y", "y", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser x", "x", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser v", "v", actual.darId());
		
		assertNull("No deberia haber caminio", grafo.darCaminoSimple("z", "u"));
	}
	
	public void testHayCadena()
	{
		setupEscenarioDFS();
		assertTrue("Deberia haber cadena", grafo.hayCadena("z", "u"));
		
		VerticePrueba<String> nuevo = new VerticePrueba<String>("a");
		grafo.agregarVertice(nuevo);
		
		assertFalse("No deberia haber cadena", grafo.hayCadena("z", "a"));
	}

	public void testdarCaminoSimpleMasCorto()
	{
		setupEscenarioBFS();
		Camino<String, VerticePrueba<String>, ArcoPrueba> camino = grafo.darCaminoSimpleMasCorto("s", "u");
		assertEquals("La longitud del camino deberia ser 3", 3, camino.darLongitud());
		
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iterVer = camino.darVertices();
		
		Vertice actual = iterVer.next();
		assertEquals("El vertice actual debería ser s", "s", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser w", "w", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser t", "t", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser u", "u", actual.darId());
		
		setupEscenarioDFS();
		camino = grafo.darCaminoSimpleMasCorto("z", "u");
		assertNull("No deberia haber camino", camino);
	}

	public void testDarCaminoSimpleMasBarato()
	{
		setupEscenarioDijkstra();
		Camino<String, VerticePrueba<String>, ArcoPrueba> camino = grafo.darCaminoSimpleMasBarato("s", "x");
		assertEquals("La longitud del camino deberia ser 3", 3, camino.darLongitud());
		assertEquals("El costo deberia ser 9", 9.0, camino.darCosto());
		
		Iterator<Vertice<String, VerticePrueba<String>, ArcoPrueba>> iterVer = camino.darVertices();
		
		Vertice actual = iterVer.next();
		assertEquals("El vertice actual debería ser s", "s", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser y", "y", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser t", "t", actual.darId());
		
		actual = iterVer.next();
		assertEquals("El vertice actual debería ser x", "x", actual.darId());
		
		setupEscenarioDFS();
		camino = grafo.darCaminoSimpleMasBarato("z", "u");
		assertNull("No deberia haber camino", camino);
	}



}
