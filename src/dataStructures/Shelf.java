package dataStructures;

public class Shelf<K,V> implements HashTableInterface<K,V>{
    private String identifier;
    private int m;
    private GameSpace<K,V>[] table;
    private int prime;
    private int size;
    private GameSpace<K,V> deleted;



    public Shelf(String identifier,int m,NearestPrimeFinder finder){
        this.identifier=identifier;
        this.m=m;
        size=0;
        table=new GameSpace[m];
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



    @Override
    public void insert(K key, V value,int n) {
        if(size==m){
            return;
        }
        int hash1 = hash1(key.hashCode());
        int hash2 = hash2(key.hashCode());
        while(table[hash1] !=null){
            hash1 += hash2;
            hash1 %= m;
        }

        table[hash1] = new GameSpace<>(key, value,n);
        System.out.println(hash1);
        size++;
    }

    @Override
    public V search(K key) {
        int index1 = hash1(key.hashCode());
        int index2 = hash2(key.hashCode());
        for(int i=0;i<=m;i++){
            //System.out.println("buscando el numero"+((index1 + i * index2) % m));
            if(table[(index1 + i * index2) % m].getKey().equals(key)){
                return table[(index1 + i * index2) % m].getValue();
            }
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int hash1 = hash1(key.hashCode());
        int hash2 = hash2(key.hashCode());
        while (table[hash1] != null && !table[hash1].getKey().equals(key)) {
            hash1 += hash2;
            hash1 %= m;
        }
        GameSpace<K,V> obtained=table[hash1];
        if(obtained.getNumberOfItems()>0){
            obtained.reduceNumberOfItems();
            return obtained.getValue();
        }
        else{
            return null;
        }
    }

    public String getIdentifier(){
        return identifier;
    }

    public int getSize(){
        return m;
    }
}
