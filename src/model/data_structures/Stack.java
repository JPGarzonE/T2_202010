package model.data_structures;

public class Stack<T> implements IStack<T>{

	private DataNode<T> top;
	
	public Stack(){
		top = null;
	}
	
	public void push(T nodeInfo) {
		
		DataNode<T> dataNode = new DataNode<T>(nodeInfo);
		
		if( top == null ){
			top = dataNode;
		}
		else{
			dataNode.setNext(top);
			top = dataNode;
		}
		
	}

	
	public T pop() {
		DataNode<T> topToPop = top;
		
		top = topToPop.next();
		
		return topToPop.getNodeInfo();
	}

	
	public int size() {
		
		DataNode<T> actualNode = top;
		int size = 0;
		
		if( actualNode != null ){
			size++;
		}
		
		while( actualNode.next() != null ){
			size++;
			actualNode = actualNode.next();
		}
		
		return size;
	}

	
	public boolean isEmpty() {
		
		return top == null ? true : false;
	}

	
	public T getTop() {
		
		return this.top.nodeInfo;
	}
	
	public DataNode<T> getTopNode(){
		
		return this.top;
	}

}
