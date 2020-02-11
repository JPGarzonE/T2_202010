package model.data_structures;

public class Queue<T> implements IQueue<T>{

	private DataNode<T> front;
	
	private DataNode<T> back;
	
	public void enqueue(T nodeInfo) {
		
		DataNode<T> dataNode = new DataNode<T>(nodeInfo);
		
		if( front == null ){
			front = dataNode;			
		}
		else if( back == null ){
			back = dataNode;
			front.setNext(back);
		}
		else{
			back.setNext(dataNode);
			back = dataNode;
		}
		
//		System.out.println("front: " + front);
//		System.out.println("actual: " + dataNode);
//		System.out.println("back: " + back);
	}

	
	public int size() {
		
		DataNode<T> actualNode = front;
		int size = 0;
		
		if( actualNode != null )
			size++;
		
		while( actualNode != null && actualNode.next() != null )
			size++;
		
		return size;
	}

	
	public boolean isEmpty() {
		
		return front == null ? true : false;
	}

	
	public T getFront() {
		
		return front.nodeInfo;
	}


	public T dequeue() {
		
		DataNode<T> nodeToDequeue = front;
		
		front = nodeToDequeue.next();
		
		return nodeToDequeue.getNodeInfo();
	}

}
