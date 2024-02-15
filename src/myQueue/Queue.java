package myQueue;

public class Queue<T> {
    public Node<T> head, tail;
    public Queue(){
        head=null;
        tail=null;
    }
    public void enqueue(T data){
        if (data==null) return;
        if (head==null){
            head=new Node<>(data);  //zobaciky ked vytvaram objekt ktory ma v sebe genericky typ
            tail=head;
        }
        else{
            tail.next=new Node<>(data);
            tail=tail.next;
        }
    }
    public Node<T> dequeue(){
        if(head==null) return null;
        if (head==tail){
            Node<T> dequeued=head;
            head=null;
            tail=null;
            return dequeued;
        }
        Node<T> dequeued=head;
        head=head.next;
        return dequeued;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void printQueue(){
        Node a=head;
        while (a!=null){
            System.out.print(a.data+" ");
            a=a.next;
        }
        System.out.println();
    }

}
