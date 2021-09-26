package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    Client temp;

    public void clientTestScenary1(){
        String[] aux={"a","b"};
        temp=new Client("a",aux,1);
    }

    @Test
    void checkPutGames(){
        clientTestScenary1();
        Game aux=new Game("abc",2000.1);
        temp.getBasket().push(aux);
        assertEquals(aux,temp.getBasket().peek());
    }

}
