import java.util.*;

class Queue{

    int size=1,rear=-1,front=0;
    int arr[]=new int[size];
    
    Queue()
    {
        int brr[]=new int[size];
        arr=brr;
    }

    void increaseSize()
    {
        int brr[]=new int[size*2];
        for(int i=0;i<size;i++)
            brr[i]=arr[i];
        arr=brr;
        size*=2;
    }

    void checksize()
    {
        if(rear>=size)
            increaseSize();
    }

    void enqueue(int a)
    {
        checksize();
        rear++;
        arr[rear]=a;
    }

    void dequeue()
    {
        if(front>rear)
            System.out.println("Queue is Empty Insert elements in it");
        else
        {
            arr[front]= 0;
            front++;
        }
    }

    void front()
    {
        if(front>rear)
        {
            System.out.println("Queue is Empty Insert elements in it");
        }
        else
        {
            System.out.println("The element at the front of the Queue is: "+arr[front]);
        }
    }

    void rear()
    {
        if(front>rear)
        {
            System.out.println("Queue is Empty Insert elements in it");
        }
        else
        {
            System.out.println("The element at the rear of the Queue is: "+arr[rear]);
        }
    }

    void size()
    {
        if(front<=rear)
            System.out.println( "The size of the Queue is: "+ (rear-front+1) );
        else    
            System.out.println("Queue is empty");           
    }

    int is_Empty()
    {
        if(front>rear)
            return 1;
        else
            return 0;
    }
}

public class Queue_ArrayList {
    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        Queue obj = new Queue();
        System.out.println("Implementation of Queue using ArrayList in Java"); 
        System.out.println("Using ArrayList To Implement Queue Is Not Space efficient");        
        while(true)
        { 
            System.out.println("Choose an option");
            System.out.println("1. Push\n2. Pop\n3. Front Element\n4. Rear Element\n5. Is_Empty\n6. Size\n7. Exit");
            int a=sc.nextInt();
            int k=0;
            switch (a) {
                case 1:
                    System.out.println("Enter the value of the element to be pushed in the Queue");
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
                    if(obj.is_Empty()==1)
                        System.out.println("The Queue is empty");
                    else
                        System.out.println("The Queue is Not empty");
                    break;
                case 6:
                    obj.size();
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
