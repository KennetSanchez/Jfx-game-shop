package dataStructures;

public interface HashTableInterface<K,V>{
    public void insert(K key,V value,int n);
    public V search(K key);
    public V delete(K key);
}
