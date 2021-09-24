package dataStructures;

import model.Game;

public class GameSpace<K,V> {
    private V value;
    private K key;
    private int numberOfItems;

    public GameSpace(K key,V value,int numberOfItems){
        this.key=key;
        this.value=value;
        this.numberOfItems=numberOfItems;
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

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public void reduceNumberOfItems(){
        numberOfItems--;
    }
}
