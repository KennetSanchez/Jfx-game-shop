package dataStructures;

import model.Game;

public class GameSpace<K,V> {
    private V value;
    private K key;

    public GameSpace(K key,V value){
        this.key=key;
        this.value=value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}
