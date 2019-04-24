package day10;

public class MyLinkedList<T> {
	private HeadLinkedNode<T> myList = new HeadLinkedNode<>();
	
	public MyLinkedList() {
	}

	public void add(Node<T> node, int position) {
		SimpleLinkedNode<T> newNode = new SimpleLinkedNode<T>(node);
		if(position <= 0) { //add first
			newNode.setNextValue(myList.getHead());
			myList.setHead(newNode);
			if(myList.getNodeNumber() == 0) {
				myList.setTail(newNode);
			}
		} else if(position >= myList.getNodeNumber()) { //add last
			if(myList.getNodeNumber() == 0) {
				myList.setHead(newNode);
				myList.setTail(newNode);
			} else {
				myList.getTail().setNextValue(newNode);
				myList.setTail(newNode);
			}
		} else { //add by index
			int index = 0;
			SimpleLinkedNode<T> prev = null;
			SimpleLinkedNode<T> curr = myList.getHead();
			while (index < position) {
				index++;
				prev = curr;
				curr = curr.getNextValue();
			}
			newNode.setNextValue(curr);
			prev.setNextValue(newNode);
		}
		myList.setNodeNumber(myList.getNodeNumber()+1);
	}
	
	public synchronized SimpleLinkedNode<T> removeFirst() {
		if(myList.getNodeNumber() == 0) { // list is empty
			return null;
		}
		SimpleLinkedNode<T> result = null;
		result = myList.getHead();
		myList.setHead(myList.getHead().getNextValue());
		if(myList.getNodeNumber() == 1) //1 element
			myList.setTail(null);
		myList.setNodeNumber(myList.getNodeNumber() -1);
		result.setNextValue(null);
		return result;
	}
}
