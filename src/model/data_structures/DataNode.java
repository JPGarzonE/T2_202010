package model.data_structures;

public class DataNode<T> {

	public DataNode<T> next;
	
	public T nodeInfo;
	
	public DataNode(T nodeInfo){
		this.nodeInfo = nodeInfo;
	}

	public DataNode<T> next() {
		return next;
	}

	public T getNodeInfo() {
		return nodeInfo;
	}

	public void setNext(DataNode<T> next) {
		this.next = next;
	}

	public void setNodeInfo(T nodeInfo) {
		this.nodeInfo = nodeInfo;
	}
	
}
