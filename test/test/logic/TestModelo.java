package test.logic;

import static org.junit.Assert.*;

import model.logic.Feature;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	private Modelo modelo;
	private Feature dato;
	
	@Before
	public void setUp1() {
		modelo= new Modelo();
	}


	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.getFeaturesSize());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		setUp1();
		
		assertTrue("El precio debe ser mayor a cero", modelo.getFeaturesSize()>0 );
		assertEquals( "El tamaño debería ser 150", 150, modelo.getFeaturesSize() );
	}

	
	public void getFrontQueue(){
		setUp1();
		try
        {
            modelo.getFrontQueue();
            fail( "No debería encontrar un dato" );
        }
        catch( Exception e1 ){	
        }

        try
        {
            assertNull( "No deberia haber nada antes", modelo.getFrontQueue() );
        }
        catch( Exception e2 )
        {
            fail( "Hay un dato antes" );
        }
	}
	
	public void getTopStack(){
		setUp1();
		try
        {
            modelo.getTopStack();
            fail( "No debería encontrar un dato" );
        }
        catch( Exception e1 ){	
        }

        try
        {
            assertNull( "No deberia haber nada antes", modelo.getTopStack() );
        }
        catch( Exception e2 )
        {
            fail( "Hay un dato antes" );
        }
	}

}
