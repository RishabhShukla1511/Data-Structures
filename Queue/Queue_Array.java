import java.util.*;

class Queue
{
    int size,noofelements=0,read=0,write=-1;
    int arr[];

    void setSize(int size)
    {
        this.size=size;
        arr = new int[size];
    }

    boolean checksize()
    {
        if(noofelements==size) // OR WHEN (WRITE+1)%N==READ
        {    
            System.out.println("Queue Overflow");
            return false;
        } 
        else
            return true;
    }

    void enqueue(int v)
    {
        if(checksize())
        {
            write++;
            if(write==size)
                write=0;
            if(checksize())
                arr[write]=v;
            noofelements++;
        }
    }

    void dequeue()
    {
        read++;
        if(read==size)
            read=0;
        if(is_Empty())
        {
            System.out.println("Stack Underflow");
        }
        noofelements--;
    }

    void front()
    {
        if(noofelements==0)
        {
            System.out.println("Queue Underflow");
        }
        else
            System.out.println("The element in the front of the queue is: " + arr[read]);
    }

    boolean is_Empty()
    {
        if(noofelements==0) // OR READ==WRITE
            return true;
        else
            return false;
    }
}

public class Queue_Array {
    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        Queue obj = new Queue();
        System.out.println("Implementation of Circular Queue using Array in Java"); 
        System.out.println("Enter the maximum length of queue required");
        int size=sc.nextInt();    
        obj.setSize(size);
        while(true)
        { 
            System.out.println("Choose an option");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Front Element\n4. Is Empty\n5. Exit");
            int a=sc.nextInt();
            int k=0;
            switch (a) {
                case 1:
                    if(obj.checksize())
                    {
                        System.out.println("Enter the value of the element to be enqueued");
                        int v=sc.nextInt();
                        obj.enqueue(v);
                    }
                    break;
                case 2:
                    if(!obj.is_Empty())
                        obj.dequeue();
                    else
                        System.out.println("Queue Underflow");
                    break;
                case 3:
                    obj.front();
                    break;
                case 4:
                    if(obj.is_Empty())
                        System.out.println("Queue Underflow");
                    else
                        System.out.println("Queue is not empty");
                    break;
                case 5:
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