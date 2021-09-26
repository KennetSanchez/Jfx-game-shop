package model;

import dataStructures.NearestPrimeFinder;
import dataStructures.Queue;
import dataStructures.Shelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GameShop {
    
    private ArrayList<Shelf<String,Game>> shelvesAL;
    private NearestPrimeFinder primeF;
    private ArrayList<Client> clients;
    private int counter;
    private Queue<Client> clientsQueue;
    private Cashier[] cashiers;

    public GameShop(){
        shelvesAL= new ArrayList<>();
        primeF = new NearestPrimeFinder();
        counter = 1;
        clients=new ArrayList<>();
        clientsQueue=new Queue<>();
    }

    public void addShelf(Shelf<String,Game> s){
        shelvesAL.add(s);
    }

    public void addCashiers(int size){
        cashiers=new Cashier[size];
        for(int i=0;i<size;i++){
            cashiers[i]=new Cashier(null);
        }
    }

    public int whichShelf(String code){
        for(int i=0;i<shelvesAL.size();i++){
            String[] parts = code.split(" ");
            if(shelvesAL.get(i).search(parts[0])!=null){
                return i;
            }
        }
        return -1;
    }

    public void insertionSortGames(String[] info){
        String id = info[0];
        int i;
        int j;
        String aux="";
        String[] data = Arrays.copyOfRange(info, 1, info.length);
        switch(data.length){
            case 1:
                data[0]+=" "+whichShelf(data[0]);
                break;
            case 2:
                int k=whichShelf(data[0]);
                data[0]+=" "+k;
                int q=whichShelf(data[1]);
                data[1]+=" "+q;
                if(q<k){
                    String aux2 = data[1];
                    data[1]=data[0];
                    data[0]=aux2;
                }
                break;
            default:
                for (i = 1; i < data.length; i++) {
                    aux = data[i];
                    j = i - 1;
                    int a=whichShelf(data[j]);
                    data[j]+=" "+a;
                    int b=whichShelf(aux);
                    aux+=" "+b;
                    while ((j >= 0) && a >= b ) {
                        data[j + 1] = data[j];
                        j = j - 1;
                    }
                    data[j + 1] = aux;
                }
        }
        clients.add(new Client(id,data,counter));//falta la suma de los juegos
        counter++;
    }

    public void bubbleSortGames(String[] info){
        String id = info[0];
        String[] data = Arrays.copyOfRange(info, 1, info.length);
        int n = data.length;
        if(n==1){
            data[0]+=" "+whichShelf(data[0]);
        }
        else{
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    int a = whichShelf(data[j]);
                    data[j]+=" "+a;
                    int b = whichShelf(data[j+1]);
                    data[j+1]+=" "+b;
                    if (a >= b) {
                        String temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
        }
        clients.add(new Client(id,data,counter));//falta la suma de los juegos
        counter++;
    }


    public void clientsGetGames(){
        for(int i=0;i<clients.size();i++){
            Client aux = clients.get(i);
            for(int j=0;j<aux.getGameList().length;j++){
                System.out.println("Se dan "+aux.getGameList()[j]);
                String[] position = aux.getGameList()[j].split(" ");
                clients.get(i).putGames(shelvesAL.get(Integer.parseInt(position[1])).delete(position[0]));
            }
        }
    }

    public void sortClientsByMinutes(){
        Comparator<Client> c = new ClientComparator();
        Collections.sort(clients,c);
    }

    public void createQueue(){
        sortClientsByMinutes();
        //System.out.println("client size "+clients.size());
        for(int i=0;i<clients.size();i++){
            clientsQueue.offer(clients.get(i));
        }
    }

    public void serveClients(){
        int clientsSize = clients.size();
        clients.clear();
        String info = "";
        int i=0;
      while(i<clientsSize){
          System.out.println("numero "+i);
          for(int j=0;j<cashiers.length;j++){
              if(cashiers[j].getClient()==null){
                  //System.out.println("no hay cliente en "+j);
                  if(!clientsQueue.isEmpty()){
                      System.out.println("entra aqui??");
                      cashiers[j].setClient(clientsQueue.poll());
                  }
              }
              else{
                  if(cashiers[j].registerAGame()){
                      i++;
                      clients.add(cashiers[j].getLastClient());
                  }
              }
          }
      }
    }

    public String showClientsResult(){
        String info = "";
        for(int i=0;i<clients.size();i++){
            info+=clients.get(i).getId()+" "+clients.get(i).getPriceToPay()+"\n";
            info+=clients.get(i).getFinalGameList()+"\n";
        }
        return info;
    }

    public void addCostumer(String id, String games){
        String [] gamesA = games.split(";");
        Client newCostumer = new Client(id, gamesA, counter);
        counter++;
        clients.add(newCostumer);

    }
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
