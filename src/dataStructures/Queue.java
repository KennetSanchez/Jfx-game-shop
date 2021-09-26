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
    public T poll() {
        if(!isEmpty()){
            if(queueAmount==1){
                Node<T> temp=firstClient;
                firstClient=null;
                queueAmount--;
                return temp.getElement();
            }
            else{
                Node<T> temp=firstClient;
                firstClient=firstClient.getNext();
                queueAmount--;
                return temp.getElement();
            }
        }
        else{
            return null;
        }
    }

    @Override
    public void offer(T e) {
        if(isEmpty()){
            firstClient= new Node<>(e);
            firstClient.setNext(null);
            firstClient.setPrevious(null);
            lastClient=firstClient;
            queueAmount=queueAmount+1;
        }
        else{
            if(queueAmount==1){
                Node<T> temp= new Node<>(e);
                firstClient.setNext(temp);
                lastClient=temp;
                lastClient.setPrevious(firstClient);
                queueAmount++;
            }
            else{
                Node<T> temp= new Node<T>(e);
                Node<T> indicator= firstClient;
                while(indicator.getNext()==null){
                    indicator=indicator.getNext();
                }
                indicator.setNext(temp);
                lastClient=temp;
                lastClient.setPrevious(indicator);
                queueAmount++;

            }
        }
    }

    public Node<T> getFirstClient() {
        return firstClient;
    }

    public void setFirstClient(Node<T> firstClient) {
        this.firstClient = firstClient;
    }

    public Node<T> getLastClient() {
        return lastClient;
    }

    public void setLastClient(Node<T> lastClient) {
        this.lastClient = lastClient;
    }

    public int getQueueAmount() {
        return queueAmount;
    }

    public void setQueueAmount(int queueAmount) {
        this.queueAmount = queueAmount;
    }

}
