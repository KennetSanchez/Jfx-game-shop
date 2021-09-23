package dataStructures;

public class Node <T>{
    private T element;
    private T next;
    private T previous;
    public Node(T element){
        this.element=element;
        this.next=null;
        this.previous=null;
    }


    public void setNext(T e){
        this.next=e;
    }
    public T getNext(){
        return next;
    }

    public void setPrevious(T e){
        this.previous=e;
    }

    public T getPrevious(){
        return previous;
    }

    public void setElement(T t){
        this.element=t;
    }

    public T getElement(){
        return element;
    }

}
