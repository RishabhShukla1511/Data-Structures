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

class Stack{
    int size=0;
    Node head;
    
    Stack()
    {
        head=new Node();
    }

    void push(int v)
    {
        Node newnode = new Node(v,null);
        if(size==0)
        {
            newnode.next=null;
            head=newnode;
        }
        else
        {
            newnode.next=head;
            head=newnode;
        }
        size++;
    }
    
    void pop()
    {
        if(size==0)
            System.out.println("Stack is Empty Insert elements in it");       
        else
        { 
            Node x=head;
            head=x.next;
            x=null;
            size--;
        }
    }

    void top()
    {
        if(size==0)
        {
            System.out.println("Stack is Empty Insert elements in it");       
        }
        else
        {
            System.out.println("The element at the top of the Stack is: "+ head.key);
        }
    }

    void size()
    {
        if(size==0)
            System.out.println("Stack is empty");
        else
            System.out.println("The size of the Stack is: "+ size);
    }

    int is_Empty()
    {
        if(size==0)
            return 1;
        else
            return 0;
    }
}

public class Stack_LinkedList {
    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        Stack obj = new Stack();
        System.out.println("Implementation of Stack using LinkedList in Java");        
        while(true)
        { 
            System.out.println("Choose an option");
            System.out.println("1. Push\n2. Pop\n3. Top\n4. Is_Empty\n5. Size\n6. Exit");
            int a=sc.nextInt();
            int k=0;
            switch (a) {
                case 1:
                    System.out.println("Enter the value of the element to be pushed in the Stack");
                    int v=sc.nextInt();
                    obj.push(v);
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.top();
                    break;
                case 4:
                    if(obj.is_Empty()==1)
                        System.out.println("The Stack is empty");
                    else
                        System.out.println("The Stack is Not empty");
                    break;
                case 5:
                    obj.size();
                    break;
                case 6:
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