package model;


import dataStructures.Queue;
import dataStructures.Stack;

public class Client {
    private String id;
    private String[] gameList;
    private int minute;
    private Stack<Game> basket;
    private double priceToPay;
    private String finalGameList;

    public Client(String id,String[] gameList,int minute){
        this.id=id;
        this.gameList=gameList;
        this.minute=minute;
        basket=new Stack<>();
        priceToPay=0;
        finalGameList="";
    }

    public void putGames(Game newGame){
        if(newGame!=null){
            basket.push(newGame);
            minute++;
        }
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getGameList() {
        return gameList;
    }
    public void setGameList(String[] gameList) {
        this.gameList = gameList;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Stack<Game> getBasket() {
        return basket;
    }

    public void setBasket(Stack<Game> basket) {
        this.basket = basket;
    }
    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }

    public String getFinalGameList() {
        return finalGameList;
    }

    public void setFinalGameList(String finalGameList) {
        this.finalGameList = finalGameList;
    }
}
