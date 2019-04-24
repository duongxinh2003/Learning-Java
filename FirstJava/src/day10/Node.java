package day10;

public class Node<T> {
	public T value;
	
	public Node() {
	}
	
	public Node(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
}
