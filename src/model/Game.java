package model;

public class Game {
    private String name;
    private String code;
    private double price;

    public Game(String name,String code,double price){
        this.name=name;
        this.code=code;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
