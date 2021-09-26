package model;

public class Cashier {
    private Client client;
    private double price;
    private String gameList;
    private Client lastClient;

    public Cashier(Client client){
        this.client=client;
        price = 0;
        gameList="";
    }

    public void setClient(Client client){
        this.client=client;
    }

    public boolean registerAGame(){
        if(client.getBasket().peek()!=null){
            Game currentGame= client.getBasket().pop();
            price+=currentGame.getPrice();
            gameList+=currentGame.getCode()+" ";
            System.out.println("falso");
            return false;
        }
        else{
            client.setPriceToPay(price);
            client.setFinalGameList(gameList);
            lastClient=client;
            client=null;
            System.out.println("verdadero");
            return true;
        }
    }

    public Client getClient() {
        return client;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
