package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import model.data_structures.Stack;
import model.data_structures.DataNode;

public class TestStack {

	private Stack<Object> stack;
	private DataNode<Object> node;
	
	public void setUp1()
	{
		stack = new Stack<Object>();
	}
	
	
	public void testGetSize()
	{
		setUp1();
		
		assertTrue("El tamaño debe ser mayor a cero", stack.size()>0 );
		assertEquals( "El tamaño debería ser 150", 150, stack.size() );
	}

	public void testPush()
	{
		setUp1();
		
		assertEquals( "No deben existir nodos", 0, stack.size() );
        try
        {
            stack.push( node );
            assertEquals( "Debería existir 1 nodo", 1, stack.size());
        }
        catch (Exception e)
        {
        	fail("Deberia existir al menos un nodo");
        }
	}

	public void testGetTopNode() 
	{
		setUp1();
		try
        {
            stack.getTopNode();
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
            stack.isEmpty();
            fail( "No debería haber ningun elemento en la lista" );
        }
        catch( Exception e1 ){
        }
	}
}
