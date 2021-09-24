package dataStructures;

public class Stack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int stackAmount;

    public Stack(){
        topNode=null;
        topNode.setPrevious(null);
        topNode.setNext(null);
        stackAmount=0;
    }

    @Override
    public boolean isEmpty() {
        return stackAmount == 0;
    }

    @Override
    public Node<T> pop() {
        if(!(isEmpty())){
            Node<T> temp=topNode;
            topNode=topNode.getNext();
            topNode.setPrevious(null);
            stackAmount--;
            return temp;
        }
        else{
            return null;
        }
    }

    @Override
    public Node<T> peek() {
        if(!(isEmpty())){
           return topNode;
        }
        else{
            return null;
        }
    }

    @Override
    public void push(Node<T> e) {
        if(isEmpty()){
            topNode=e;
            topNode.setPrevious(null);
            topNode.setNext(null);
            stackAmount=stackAmount+1;
        }
        else{
                Node<T> temp=topNode;
                topNode=e;
                topNode.setNext(temp);
                temp.setPrevious(topNode);
                stackAmount++;
        }
    }
}
