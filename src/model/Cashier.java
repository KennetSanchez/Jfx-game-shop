package model;

import dataStructures.Stack;

public class Cashier {
    private Client client;
    private int price;
    private String gameList;
    private Client lastClient;
    private Stack<Game> cashierBasket;

    public Cashier(Client client){
        this.client=client;
        price = 0;
        gameList="";
        cashierBasket=new Stack<>();
    }

    public void setClient(Client client){
        this.client=client;
    }

    public boolean registerAGame(){
        if(client.getBasket().peek()!=null){
            Game currentGame= client.getBasket().pop();
            price+=currentGame.getPrice();
            cashierBasket.push(currentGame);
            return false;
        }
        else{
            client.setPriceToPay(price);
            extractGames();
            gameList=gameList.substring(0, gameList.length() - 1);
            client.setFinalGameList(gameList);
            lastClient=client;
            price =0;
            gameList="";
            client=null;
            return true;
        }
    }

    public void extractGames(){
        while(!cashierBasket.isEmpty()){
            gameList+=cashierBasket.pop().getCode()+" ";
        }
    }

    public Client getClient() {
        return client;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGameList() {
        return gameList;
    }

    public void setGameList(String gameList) {
        this.gameList = gameList;
    }

    public Client getLastClient() {
        return lastClient;
    }

    public void setLastClient(Client lastClient) {
        this.lastClient = lastClient;
    }
}
