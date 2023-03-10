package myutil;

public class Node<E> {

	private E data;
	private Node<E> nextNode;

	
	public Node () {
		this.nextNode=null;
	}
	
	public Node(E object) {
		this.data = object;
		this.nextNode = null;
	}

	public void setData(E data) {
		this.data = data;
	}

	public E getData() {
		return this.data;
	}

	public void setNext(Node<E> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<E> getNext() {
		return this.nextNode;
	}

}
