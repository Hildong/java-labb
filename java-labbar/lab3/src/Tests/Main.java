package Tests;
import myutil.Node;
import myutil.MyStack;
public class Main {

    public static void main(String[] args) {
        Node node = new Node("hello", null);
        System.out.println(node.getData());
        node.setNext(new Node("World", node));
        System.out.println(node.getNext().getData());
        System.out.println(node.getNext().getNext().getData());

    }
}