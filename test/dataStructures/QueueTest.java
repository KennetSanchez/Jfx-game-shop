package dataStructures;

import model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
   Queue<Client> queueTest;
   int maxQueue = 1000;
   Client temp;

   public void queueTestScenary1() {
      queueTest = new Queue<Client>();
      String[] aux = {"1", "2"};
      temp = new Client("a", aux, 2);
      queueTest.offer(temp);
   }

   public void queueTestScenary2() {
      queueTest = new Queue<Client>();
      for (int m = 0; m < maxQueue; m++) {
         int j = 0;
         int i = 0;
         int k = 0;
         String[] temp2 = {"" + i, "" + j};
         temp = new Client("" + k, temp2, j);
         queueTest.offer(temp);
         j++;
         i++;
         k++;
      }
   }


   @Test
   void checkIsEmpty() {
      queueTestScenary1();
      assertFalse(queueTest.isEmpty());
   }

   @Test
   void checkPollStandard() {
      queueTestScenary1();
      assertEquals(temp, queueTest.poll());
   }

   @Test
   void checkPollLimit() {
      queueTestScenary2();
      Queue queueTest2 = new Queue<Client>();
      for (int m = 0; m < maxQueue; m++) {
         int j = 0;
         int i = 0;
         int k = 0;
         String[] temp2 = {"" + i, "" + j};
         temp = new Client("" + k, temp2, j);
         queueTest2.offer(temp);
         j++;
         i++;
         k++;
      }
      Client clientTest = (Client) queueTest2.poll();
      Client clientTest2 = (Client) queueTest.poll();
      assertEquals(clientTest2.getId(), clientTest.getId());
   }

   @Test
   void checkPollSpecial() {
      queueTestScenary2();
      queueTest.poll();
      queueTest.poll();
      Client clientTest = queueTest.getFirstClient().getElement();
      assertEquals(clientTest, (Client) queueTest.poll());
   }

   @Test
   void checkOffer() {
      queueTest = new Queue<Client>();
      String[] aux = {"c", "b"};
      Client offer = new Client("a", aux, 2);
      queueTest.offer(offer);
      assertEquals(offer, queueTest.poll());
   }

   @Test
   void checkOfferLimit() {
      queueTestScenary2();
      Client offer = queueTest.getFirstClient().getElement();
      assertEquals(offer, queueTest.poll());
   }

   @Test
   void checkOfferSpecial() {
      queueTestScenary2();
      String[] aux = {"c", "b"};
      Client offer = new Client("a", aux, 2);
      queueTest.offer(offer);
      assertEquals(offer.getId(), queueTest.getLastClient().getElement().getId());
   }

}
