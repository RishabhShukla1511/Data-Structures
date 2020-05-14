import java.util.*;

class Node{
    
    int key;
    Node next;

    Node()
    {
        key=0;
        next=null;
    }

    Node(int key,Node next)
    {
        this.key=key;
        this.next=next;
    }
}

class Queue{

    int size=0;
    Node head,tail;
    
    Queue()
    {
        head=new Node();
        tail=new Node();
    }

    void enqueue(int v)
    {
        Node newnode = new Node(v,null);
        if(size==0)
        {
            newnode.next=null;
            head=newnode;
            tail=newnode;
        }
        else
        {
            newnode.next=null;
            tail.next=newnode;
            tail=newnode;
        }
        size++;
    }

    Boolean checksize()
    {
        if(size==0)
        {
            System.out.println("Insert elements in the Queue first");
            return false;
        }
        return true;
    }
    
    void dequeue()
    {
        if(checksize())
        {
            head=head.next;
            size--;
        }
    }

    void front()
    {
        if(checksize())
            System.out.println("The front element in queue is: " + head.key);
    }

    void rear()
    {
        if(checksize())
            System.out.println("The rear element in queue is: " + tail.key);
    }

    void get_size()
    {
        if(size==0)
            System.out.println("The Queue is empty");
        else
            System.out.println("The size of the Queue is: " + size);
    }

    Boolean is_Empty()
    {
        if(size==0)
            return true;
        else
            return false;
    }

}

public class Queue_LinkedList {
    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        Queue obj = new Queue();
        System.out.println("Implementation of Queue using LinkedList in Java");        
        while(true)
        { 
            System.out.println("Choose an option");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Front Element\n4. Rear Element\n5. Is_Empty\n6. Size\n7. Exit");
            int a=sc.nextInt();
            int k=0;
            switch (a) {
                case 1:
                    System.out.println("Enter the value of the element to be enqueued");
                    int v=sc.nextInt();
                    obj.enqueue(v);
                    break;
                case 2:
                    obj.dequeue();
                    break;
                case 3:
                    obj.front();
                    break;
                case 4:
                    obj.rear();
                    break;
                case 5:
                    if(obj.is_Empty())
                        System.out.println("The Queue is empty");
                    else
                        System.out.println("The Queue is Not empty");
                    break;
                case 6:
                    obj.get_size();
                    break;
                case 7:
                    k=1;
                    break;
                default:
                    System.out.println("Choose among the given options");
                    break;
            }  
            if(k==1)
                break; 
        }
        sc.close();
    }
}