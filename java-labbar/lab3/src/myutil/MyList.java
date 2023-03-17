package myutil;

public class MyList<E> {

    private Node<E> firstNode;

    private Node<E> getFirstNode() {
        return this.firstNode;
    }

    private void setFirstNode(Node<E> node) {
        this.firstNode = node;
    }

    public void add(E element) {
        //    Ska lägga till ett nytt element i listan
        this.setFirstNode(new Node<E>(element, this.getFirstNode()));
    }

    public E getElementAt(int i) {
        /*
            Ska returnera ett element på index i (första elementet ligger på
            index 0) utan att ta bort det ur listan. Kastar exception om i är
            större än eller lika med listans storlek.
        */
        Node<E> currentNode = this.getFirstNode();
        for(int j = 0; j < i; j++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
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
