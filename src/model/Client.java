package model;


public class Client {
    private String id;
    private String[] gameList;

    public Client(String id,String[] gameList){
        this.id=id;
        this.gameList=gameList;
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
}
