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
    private ArrayList<Game> shelfGames;

    public GameShop(){
        shelvesAL= new ArrayList<>();
        primeF = new NearestPrimeFinder();
        counter = 1;
        clients=new ArrayList<>();
        clientsQueue=new Queue<>();
    }

    public ArrayList<Game> getGamesAL(Shelf shelf){
        shelfGames = shelf.getGamesAL();

        return shelfGames;
    }

    public void addGame(Shelf shelf, String code, double price, int quantity){
        Game newGame = new Game(code, price);
        newGame.setQuantity(quantity);
        shelf.insert(code,newGame, quantity);
        shelf.addGameToAL(newGame);
    }

    public void addShelf(String id, int size){
        Shelf newShelf = new Shelf(id, size, getPrimeF());
        shelvesAL.add(newShelf);
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
        clients.add(new Client(id,data,counter));
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
        clients.add(new Client(id,data,counter));
        counter++;
    }

    public void insertionSortGames(String inf){
        String[] info = inf.split(" ");
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
        Client newClient = new Client(id,data,counter);
        newClient.setSA(1);
        clients.add(newClient);
        counter++;
    }

    public void bubbleSortGames(String inf){
        String[] info = inf.split(" ");
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
        Client newClient = new Client(id,data,counter);
        newClient.setSA(2);
        clients.add(newClient);
        counter++;
    }

    public void clientsGetGames(){
        for(int i=0;i<clients.size();i++){
            Client aux = clients.get(i);
            for(int j=0;j<aux.getGameList().length;j++){
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

          for(int j=0;j<cashiers.length;j++){
              if(cashiers[j].getClient()==null){

                  if(!clientsQueue.isEmpty()){

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

    ArrayList<String> buyersId = new ArrayList<>();
    ArrayList<Integer> buyersPrice = new ArrayList<>();
    ArrayList<String> buyersGameList = new ArrayList<>();

    public String showClientsResult(){
        String info = "";
        for(int i=0;i<clients.size();i++){
            info+=clients.get(i).getId()+" "+clients.get(i).getPriceToPay()+"\n";
            info+=clients.get(i).getFinalGameList()+"\n";
        }
        return info;
    }

    public void refreshBuyers(){
        String info = "";
        for(int i=0;i<clients.size();i++){
            buyersId.add(clients.get(i).getId());
            buyersPrice.add(clients.get(i).getPriceToPay());
            buyersGameList.add(clients.get(i).getFinalGameList());
        }
    }

    //----------------------------------------- GETTERS AND SETTERS FOR TABLE VIEWS -----------------------------------------

    public ArrayList<String> getBuyersId(){
        return buyersId;
    }

    public ArrayList<Integer> getBuyersPrice(){
        return buyersPrice;
    }

    public ArrayList<String> getBuyersGameList(){
        return buyersGameList;
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

    public ArrayList<Client> getCostumers (){
        return clients;
    }
}
