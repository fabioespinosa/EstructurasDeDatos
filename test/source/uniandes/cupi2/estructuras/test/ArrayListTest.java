package uniandes.cupi2.estructuras.test;

import java.util.Iterator;

import junit.framework.TestCase;
import uniandes.cupi2.estructuras.ArrayList;
import uniandes.cupi2.estructuras.ListaOrdenada;

public class ArrayListTest extends TestCase {
	private ArrayList<String> arrayList;
	
	
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
		arrayList = new ArrayList<String>();
		
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
		
		arrayList.add(foto1);
		arrayList.add(foto2);
		arrayList.add(foto3);
		arrayList.add(foto4);
		arrayList.add(foto5);
		arrayList.add(foto6);
		arrayList.add(foto7);
		arrayList.add(foto8);
		arrayList.add(foto9);
		arrayList.add(foto10);
		
	}
	
	public void test1(){
		setupEscenario1();
		String aa="";
		for (int i = 0; i < arrayList.size(); i++) {
			String actual = arrayList.get(i);
			if(actual.equals("nn")){
				assertEquals("Se debe retornar la primer foto", foto9, actual);
				aa=actual;
			}
		}
		assertEquals("Se debe retornar la primer foto", foto9, aa);
		
		assertEquals("Se debe retornar la primer foto", foto4, arrayList.get(3));

		arrayList.add(3, "oOo");
		
		assertEquals("Se debe retornar la primer foto", "oOo", arrayList.get(3));
		assertEquals("Se debe retornar la primer foto", foto4, arrayList.get(4));
		assertEquals("Se debe retornar la primer foto", foto3, arrayList.get(2));

		assertEquals("Se debe retornar la primer foto", 11, arrayList.veriSize());
		assertEquals("Se debe retornar la primer foto", 3, arrayList.indexOf("oOo"));

		ArrayList<String> otro= arrayList;
		assertTrue("tienen que ser iguales  ", arrayList.equals(otro));

		arrayList.set(10, "kkk");
		assertEquals("Se debe retornar la primer foto", 11, arrayList.veriSize());
		assertEquals("Se debe retornar la primer foto", "kkk", arrayList.get(10));
		assertEquals("Se debe retornar la primer foto", null, arrayList.get(11));
		assertEquals("Se debe retornar la primer foto", foto9, arrayList.get(9));


	}
	
	public void testDarPrimero(){
		setupEscenario1();
		assertEquals("Se debe retornar la primer foto", foto1, arrayList.darPrimero().darValor());
		
	}
	
	public void testDarLongitud(){
		setupEscenario1();
		assertEquals("Debe retornar 10, pues hay esa cantidad de elementos en la lista", 10, arrayList.size());
	}
	
	
	public void testAgregar(){
		
		setupEscenario1();
		//ya que el setupEscenario1() utiliza este metodo...
		
		assertNotNull("Debe existir la segunda foto", arrayList.get(foto2));
		String foto11= "hello";
		arrayList.add(foto11);
		assertEquals("Debe retornar 11", 11, arrayList.size());
		
		
	}
	

	
	public void testEliminar(){
		setupEscenario1();
		
		arrayList.remove(foto2);
		
		assertNull("No debe existir", arrayList.get(foto2));
		assertEquals("Debe haber 9 elementos", 9, arrayList.size());
	}
	
	public void testBuscar(){
		setupEscenario1();
		String foto11= "hello";
		
		arrayList.add(foto11);
		
		assertNotNull("No debe retornar vacio", arrayList.get(foto11.toString()));
		
		
	}
	
//	public void testDarIterador()
//	{
//		setupEscenario1();
//		Iterator<String> iter = arrayList.iterator();
//		while(iter.hasNext())
//		{
//			System.out.println("El actual es: "+iter.next());
//		}
//	}

	
}
