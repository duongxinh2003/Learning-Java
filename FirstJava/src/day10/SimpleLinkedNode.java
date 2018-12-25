package day10;

public class SimpleLinkedNode<T> {
	private Node<T> value;
	private SimpleLinkedNode<T> nextValue;
	
	public SimpleLinkedNode() {
	}

	public SimpleLinkedNode(Node<T> value) {
		this.value = value;
	}

	public Node<T> getValue() {
		return value;
	}

	public void setValue(Node<T> value) {
		this.value = value;
	}

	public SimpleLinkedNode<T> getNextValue() {
		return nextValue;
	}

	public void setNextValue(SimpleLinkedNode<T> nextValue) {
		this.nextValue = nextValue;
	}
	
	
}
