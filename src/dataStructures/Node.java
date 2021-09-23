package dataStructures;

public class Node <T>{
    private T element;
    private Node<T> next;
    private Node<T> previous;

    public Node(T element){
        this.element=element;
        this.next=null;
        this.previous=null;
    }


    public void setNext(Node<T> e){
        this.next=e;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setPrevious(Node<T> e){
        this.previous=e;
    }

    public Node<T> getPrevious(){
        return previous;
    }

    public void setElement(T t){
        this.element=t;
    }

    public T getElement(){
        return element;
    }

}
