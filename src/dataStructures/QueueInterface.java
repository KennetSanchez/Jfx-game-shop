package dataStructures;

public interface QueueInterface<T> {

    public boolean isEmpty();
    public T poll();
    public void offer(T e);

}
