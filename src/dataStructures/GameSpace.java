package dataStructures;

public class GameSpace<K,V> {
    private V value;
    private K key;

    public GameSpace(K key,V value){
        this.key=key;
        this.value=value;
    }
}
