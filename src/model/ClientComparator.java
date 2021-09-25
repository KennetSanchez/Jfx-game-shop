package model;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {


    @Override
    public int compare(Client o1, Client o2) {
        int minuteo1 = o1.getMinute();
        int minuteo2 = o2.getMinute();
        if(minuteo1==minuteo2){
            return 0;
        }
        else if(minuteo1<minuteo2){
            return -1;
        }
        else{
            return 1;
        }
    }
}
