package model;

import dataStructures.NearestPrimeFinder;
import dataStructures.Shelf;

import java.util.ArrayList;

public class GameShop {
    private ArrayList<Shelf<String,Game>> shelvesAL;
    private NearestPrimeFinder primeF;

    public GameShop(){
        shelvesAL= new ArrayList<>();
        primeF = new NearestPrimeFinder();
    }

    public void addShelf(Shelf<String,Game> s){
        shelvesAL.add(s);
    }

    //public int



    //getters and setters
    public ArrayList<Shelf<String, Game>> getShelvesAL() {
        return shelvesAL;
    }

    public NearestPrimeFinder getPrimeF() {
        return primeF;
    }

    public void setPrimeF(NearestPrimeFinder primeF) {
        this.primeF = primeF;
    }

    public void setShelvesAL(ArrayList<Shelf<String, Game>> shelvesAL) {
        this.shelvesAL = shelvesAL;
    }
}
