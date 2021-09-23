package dataStructures;

public interface QueueInterface<T> {

    public boolean isEmpty();
    public T front();
    public T dequeue();
    public boolean enqueue();

}
