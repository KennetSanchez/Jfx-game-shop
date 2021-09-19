package dataStructures;

public interface HashTableInterface<K,V>{
    public void insert(K key,V value);
    public V search(K key);
    public void delete(K key);
}
