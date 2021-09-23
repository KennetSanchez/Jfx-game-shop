package dataStructures;

public interface QueueInterface<T> {

    public boolean isEmpty();
    public Node<T> poll();
    public void offer(Node<T> e);

}
