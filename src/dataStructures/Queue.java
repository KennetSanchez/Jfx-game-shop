package dataStructures;

public class Queue<T> implements QueueInterface<T> {

    private Node<T> firstClient;
    private Node<T> lastClient;
    private int queueAmount;

    public Queue() {
    firstClient=null;
    lastClient=null;
    queueAmount=0;
    }
    @Override
    public boolean isEmpty() {
        return firstClient == null;
    }



    @Override
    public Node<T> poll() {
        if(!isEmpty()){
           Node<T> temp=firstClient;
           firstClient=firstClient.getNext();
           return temp;
        }
        else{
            return null;
        }
    }

    @Override
    public void offer(Node<T> e) {
        if(isEmpty()){
            firstClient= e;
            firstClient.setNext(null);
            firstClient.setPrevious(null);
            lastClient=e;
            queueAmount=queueAmount+1;
        }
        else{
            if(queueAmount==1){
                firstClient.setNext(e);
                lastClient=e;
                lastClient.setPrevious(firstClient);
                queueAmount++;
            }
            else{
                Node<T> indicator= firstClient;
                while(indicator.getNext()==null){
                    indicator=indicator.getNext();
                }
                indicator.setNext(e);
                lastClient=e;
                lastClient.setPrevious(indicator);
                queueAmount++;

            }
        }
    }

}
