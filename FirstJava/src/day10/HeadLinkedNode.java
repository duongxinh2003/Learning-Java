package day10;

public class HeadLinkedNode<T> {
	private int nodeNumber = 0;
	private SimpleLinkedNode<T> head;
	private SimpleLinkedNode<T> tail;
	
	public HeadLinkedNode() {
		this.nodeNumber = 0;
		this.head = null;
		this.tail = null;
	}

	public int getNodeNumber() {
		return nodeNumber;
	}

	public void setNodeNumber(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}

	public SimpleLinkedNode<T> getHead() {
		return head;
	}

	public void setHead(SimpleLinkedNode<T> head) {
		this.head = head;
	}

	public SimpleLinkedNode<T> getTail() {
		return tail;
	}

	public void setTail(SimpleLinkedNode<T> tail) {
		this.tail = tail;
	}
	
	
}
