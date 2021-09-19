package dataStructures;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Game;

public class Shelve<K,V> implements HashTableInterface<K,V>{
    private String identifier;
    private int m;
    private ArrayList<GameSpace<K,V>> table;
    private int prime;
    private int size;
    private GameSpace<K,V> deleted;


    public Shelve(String identifier,int m,NearestPrimeFinder finder){
        this.identifier=identifier;
        this.m=m;
        size=0;
        if(m<=2){
            prime=m;
        }
        else{
            prime = finder.nearestPrime(m);
        }

    }

    public int hash1(int key){
        return(key%m);
    }

    public int hash2(int key){
        return(prime-(key%prime));
    }

    public void  addGames(Game game){

    }


    @Override
    public void insert(K key, V value) {
        if(size==m){
            return;
        }
        int hash1 = hash1(key.hashCode());
        int hash2 = hash2(key.hashCode());
        while(table.get(hash1)!=null){
            hash1 += hash2;
            hash1 %= m;
        }

        table.set(hash1,new GameSpace<>(key, value));
        size++;
    }

    @Override
    public V search(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }
}
