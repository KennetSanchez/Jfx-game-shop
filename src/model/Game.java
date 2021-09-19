package model;

//Sorry for that, I need to commit
public class Game {
    private String code;
    private double price;
    private int quantity;

    public Game(String code,double price,int quantity){
        this.code=code;
        this.price=price;
        this.quantity=quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
