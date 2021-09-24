package model;

import dataStructures.NearestPrimeFinder;
import dataStructures.Shelf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShelfTest {
    String key;
    int value;
    NearestPrimeFinder primeFinder = new NearestPrimeFinder();
    Shelf<String,Integer> testShelf=new Shelf<>("a",5,primeFinder);;

    public void shelfTestScene1(){
        key="llave";
        value=32;
    }

    @Test
    void checkInsertion(){
        shelfTestScene1();
        testShelf.insert(key,value,5);
        assertEquals(32,testShelf.search(key));
    }

    @Test
    void takeOutAGame(){
        shelfTestScene1();
        testShelf.insert(key,value,1);
        assertEquals(32,testShelf.delete(key));
        assertEquals(null,testShelf.delete(key));

    }
            //scene
}
