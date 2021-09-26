package dataStructures;

import model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    Stack<Client> stackTest;
    Client temp;

    public void stackTestScenary1(){
        stackTest=new Stack<Client>();
        String[] aux={"a","b"};
        temp= new Client("a", aux, 2);
        stackTest.push(temp);
    }

    @Test
    void checkIsEmpty(){
        stackTestScenary1();
        assertFalse(stackTest.isEmpty());
    }

    @Test
    void checkPop(){
        stackTestScenary1();
        assertEquals(temp,stackTest.pop());
    }

    @Test
    void checkPeek(){
        stackTestScenary1();
        assertEquals(temp,stackTest.peek());

    }

    @Test
    void checkPush(){
        stackTest=new Stack<Client>();
        String[] aux={"c","b"};
        Client offer=new Client("a",aux,2);
        stackTest.push(offer);
        assertEquals(offer,stackTest.peek());
    }
}
