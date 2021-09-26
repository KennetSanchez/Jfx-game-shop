package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashierTest {
    Cashier temp;
    String[] a={"a","b"};
    Client aux;
    public void CashierTestScenary1(){
       aux = new Client("12345",a,2);
        temp=new Cashier(aux);
    }

    @Test
    void checkRegisterGame(){
        CashierTestScenary1();
        temp.setGameList(a.toString());
        assertTrue(temp.registerAGame());
    }
}
