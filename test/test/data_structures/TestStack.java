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
		
		assertTrue("El tama�o debe ser mayor a cero", stack.size()>0 );
		assertEquals( "El tama�o deber�a ser 150", 150, stack.size() );
	}

	public void testPush()
	{
		setUp1();
		
		assertEquals( "No deben existir nodos", 0, stack.size() );
        try
        {
            stack.push( node );
            assertEquals( "Deber�a existir 1 nodo", 1, stack.size());
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
            fail( "No deber�a encontrar un nodo" );
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
            fail( "No deber�a haber ningun elemento en la lista" );
        }
        catch( Exception e1 ){
        }
	}
}
