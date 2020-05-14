import java.util.*;

class Stack{

    int size=1,currpos=-1;
    int arr[]=new int[size];
    
    Stack()
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
        if(currpos>=size)
            increaseSize();
    }

    void push(int a)
    {
        currpos++;
        checksize();
        arr[currpos]=a;
    }

    void pop()
    {
        if(currpos==-1)
            System.out.println("Stack is Empty Insert elements in it");
        else
        {
            arr[currpos]= 0;
            currpos--;
        }
    }

    void top()
    {
        if(currpos!=-1)
        {
            System.out.println("The element at the top of the Stack is: "+arr[currpos]);
        }
        else
        {
            System.out.println("Stack is Empty Insert elements in it");
        }
    }

    void size()
    {
        if(currpos!=-1)
            System.out.println("The size of the Stack is: "+(currpos+1));
        else    
            System.out.println("Stack is empty");           
    }

    int is_Empty()
    {
        if(currpos==-1)
            return 1;
        else
            return 0;
    }
}

public class Stack_ArrayList {

    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        Stack obj = new Stack();
        System.out.println("Implementation of Stack using ArrayList in Java");        
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
