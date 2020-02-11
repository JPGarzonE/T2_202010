package model.data_structures;

public interface IStack<T> {

	public void push( T nodeInfo );
	
	public T pop();
	
	public int size();
	
	public boolean isEmpty();
	
	public T getTop();
	
	public DataNode<T> getTopNode();
	
}
