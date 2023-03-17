package myutil;

public class MyStack<E> {

    private Node<E> firstNode;

    public MyStack() {

    }

    private Node<E> getFirstNode() {
        return this.firstNode;
    }

    private void setFirstNode(Node<E> node) {
        this.firstNode = node;
    }

    public void push(E element) {
        this.setFirstNode(new Node<E>(element, this.getFirstNode()));
    }

    public E pop(E element) {
        //Kastar exception om det ej finns något att poppa
        final Node<E> prevFirstNode = this.getFirstNode();
        if (prevFirstNode == null) {
            //throw new PopEmptyStackException();
        }
        this.setFirstNode(prevFirstNode.getNext());
        return prevFirstNode.getData();
    }

    public boolean isEmpty() {
        return this.getFirstNode() == null;
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
