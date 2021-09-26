package dataStructures;

import model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
   Queue<Client> queueTest;
   Client temp;

   public void queueTestScenary1(){
      queueTest = new Queue<Client>();
      String[] aux={"a","b"};
      temp= new Client("a", aux, 2);
      queueTest.offer(temp);
   }


   @Test
   void checkIsEmpty(){
      queueTestScenary1();
      assertFalse(queueTest.isEmpty());
   }

   @Test
   void checkPoll(){
      queueTestScenary1();
      assertEquals(temp,queueTest.poll());
   }

   @Test
   void checkOffer(){
      queueTest=new Queue<Client>();
      String[] aux={"c","b"};
      Client offer=new Client("a",aux,2);
      queueTest.offer(offer);
      assertEquals(offer,queueTest.poll());
   }

}
