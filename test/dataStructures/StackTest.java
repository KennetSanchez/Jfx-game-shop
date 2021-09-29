package dataStructures;

import model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    Stack<Client> stackTest;
    Client temp;
    int maxStack=999;

    public void stackTestScenary1(){
        stackTest=new Stack<Client>();
        String[] aux={"a","b"};
        temp= new Client("a", aux, 2);
        stackTest.push(temp);
    }
    public void stackTestScenary2(){
        stackTest=new Stack<Client>();
        for (int m = 0; m < maxStack; m++) {
            int j = 0;
            int i = 0;
            int k = 0;
            String[] temp2 = {"" + i, "" + j};
            temp = new Client("" + k, temp2, j);
            stackTest.push(temp);
            j++;
            i++;
            k++;
        }
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
    void checkPopLimit(){
        stackTestScenary2();
        Client tempClient=stackTest.peek();
        assertEquals(tempClient,stackTest.pop());
    }

    @Test
    void checkPopSpecial(){
        stackTestScenary2();
        stackTest.pop();
        stackTest.pop();
        Client tempClient=stackTest.peek();
        assertEquals(tempClient,stackTest.pop());
    }

    @Test
    void checkPeek(){
        stackTestScenary1();
        assertEquals(temp,stackTest.peek());
    }

    @Test
    void checkPeekLimit(){
        stackTestScenary2();
        temp=stackTest.peek();
        assertEquals(temp,stackTest.pop());
    }

    @Test
    void checkPeekSpecial(){
        stackTestScenary2();
        stackTest.pop();
        Client temp2=stackTest.peek();
        temp=stackTest.pop();
        assertEquals(temp,temp2);
    }

    @Test
    void checkPush(){
        stackTest=new Stack<Client>();
        String[] aux={"c","b"};
        Client offer=new Client("a",aux,2);
        stackTest.push(offer);
        assertEquals(offer,stackTest.peek());
    }

    @Test
    void checkPushLimit(){
        stackTestScenary2();
        for (int m = 0; m < maxStack; m++) {
            int j = 0;
            int i = 0;
            int k = 0;
            String[] temp2 = {"" + i, "" + j};
            temp = new Client("" + k, temp2, j);
            stackTest.push(temp);
            j++;
            i++;
            k++;
        }

        assertTrue(stackTest.getStackAmount()>999);
    }

    @Test
    void checkPushSpecial(){
        stackTestScenary2();
        for (int m = 0; m < maxStack; m++) {
            int j = 0;
            int i = 0;
            int k = 0;
            String[] temp2 = {"" + i, "" + j};
            temp = new Client("" + k, temp2, j);
            stackTest.push(temp);
            j++;
            i++;
            k++;
            for (int x=0;i<stackTest.getStackAmount();x++){
                stackTest.pop();
            }
        }
        assertTrue(stackTest.getStackAmount()==1);
    }
}
