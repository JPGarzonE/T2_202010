package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import model.data_structures.Queue;
import model.data_structures.DataNode;

public class TestQueue {
	
	private Queue<Object> queue;
	private DataNode<Object> node;
	
	public void setUp1()
	{
		queue = new Queue<Object>();
	}
	
	
	public void testGetSize()
	{
		setUp1();
		
		assertTrue("El tamaño debe ser mayor a cero", queue.size()>0 );
		assertEquals( "El tamaño debería ser 150", 150, queue.size() );
	}

	public void testEnQueue()
	{
		setUp1();
		
		assertEquals( "No deben existir nodos", 0, queue.size() );
        try
        {
            queue.enqueue( node );
            assertEquals( "Debería existir 1 nodo", 1, queue.size());
        }
        catch (Exception e)
        {
        	fail("Deberia existir al menos un nodo");
        }
	}

	public void testGetFront() 
	{
		setUp1();
		try
        {
            queue.getFront();
            fail( "No debería encontrar un nodo" );
        }
        catch( Exception e1 ){	
        }

        try
        {
            assertNotNull( "El siguiente no deberia ser null", node.next() );
        }
        catch( Exception e2 )
        {
            fail( "El siguiente es null" );
        }
	}

	public void testIsEmpty() 
	{
		setUp1();
		try
        {
            queue.isEmpty();
            fail( "No debería haber ningun elemento en la lista" );
        }
        catch( Exception e1 ){
        }
	}

}
