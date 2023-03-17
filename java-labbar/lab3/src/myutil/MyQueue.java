package myutil;

public class MyQueue<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;

    public MyQueue() {

    }

    private Node<E> getFirstNode() {
        return this.firstNode;
    }

    private void setFirstNode(Node<E> node) {
        this.firstNode = node;
    }

    private Node<E> getLastNode() {
        return this.lastNode;
    }

    private void setLastNode(Node<E> node) {
        this.lastNode = node;
    }

    public void enqueue(E element) {
        Node<E> newLastNode = new Node<E>(element, null);
        Node<E> currentLastNode = this.getLastNode();
        if (currentLastNode == null) {
            this.setFirstNode(newLastNode);
        } else {
            currentLastNode.setNext(newLastNode);
        }
        this.setLastNode(newLastNode);
    }

    public E dequeue(E element) {
        //    Kastar exception on det inte finns något att avköa
        Node<E> prevFirstNode = this.getFirstNode();
        if (prevFirstNode == null) {
            //throw new DequeueEmptyQueueException();
        }
        this.setFirstNode(prevFirstNode.getNext());
        return prevFirstNode.getData();
    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public int size() {
        int size = 0;
        Node<E> currentNode = this.getFirstNode();
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }
}
