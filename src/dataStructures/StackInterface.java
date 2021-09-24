package dataStructures;

public interface StackInterface<T>{

    public boolean isEmpty();
    public Node<T> pop();
    public Node<T> peek();
    public void push(Node<T> e);
}
