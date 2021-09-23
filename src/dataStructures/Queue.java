package dataStructures;

public class Queue<T> implements QueueInterface<T> {

    private Node<T> firstClient;
    private Node<T> lastClient;
    private int queueAmount;

    public Queue() {
    firstClient=null;
    lastClient=null;
    queueAmount=0;
    }
    @Override
    public boolean isEmpty() {
        if (firstClient==null){
            return true;
        }
        return false;
    }

    @Override
    public T front() {
        return null;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public boolean enqueue() {
        return false;
    }

}
