package myutil;



public class Node<E> {
    private E data;
    private Node<E> next;

    public Node () {
        this.next=null;
    }

    public Node(E object, Node<E> nextNode) {
        this.data = object;
        this.next = nextNode;
    }
    public Node<E> getNext() {
        return this.next;
    }

    public E getData() {
        return this.data;
    }

    public void setNext(Node<E> nextNode) {
        this.next = nextNode;
    }

    public void setData(E data) {
        this.data = data;
    }
}
