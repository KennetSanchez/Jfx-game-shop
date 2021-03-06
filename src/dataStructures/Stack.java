package dataStructures;
//aa
public class Stack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int stackAmount;

    public Stack(){
        topNode=null;
        stackAmount=0;
    }

    @Override
    public boolean isEmpty() {
        return stackAmount == 0;
    }

    @Override
    public T pop() {
        if(!(isEmpty())){
            if(stackAmount==1){
                Node<T> temp=topNode;
                topNode=null;
                stackAmount--;
                return temp.getElement();
            }
            else{
                Node<T> temp=topNode;
                topNode=topNode.getNext();
                topNode.setPrevious(null);
                stackAmount--;
                return temp.getElement();
            }
        }
        else{
            return null;
        }
    }

    @Override
    public T peek() {
        if(!(isEmpty())){
           return topNode.getElement();
        }
        else{
            return null;
        }
    }
//aa
    @Override
    public void push(T e) {
        if(isEmpty()){
            Node<T> temp= new Node<T>(e);
            topNode=temp;
            topNode.setPrevious(null);
            topNode.setNext(null);
            stackAmount=stackAmount+1;
        }
        else{
                Node<T> temp2= new Node<T>(e);
                Node<T> temp=topNode;
                topNode=temp2;
                topNode.setNext(temp);
                temp.setPrevious(topNode);
                stackAmount++;
        }
    }

    public int getStackAmount() {
        return stackAmount;
    }

    public void setStackAmount(int stackAmount) {
        this.stackAmount = stackAmount;
    }
}
