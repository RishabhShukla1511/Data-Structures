import java.util.*;

class ArrayList{

    int size=1,currpos=-1;
    int arr[]=new int[size];
    
    ArrayList()
    {
        int brr[]=new int[size];
        arr=brr;
    }

    void increaseSize()
    {
        int brr[]=new int[size*2];
        for(int i=0;i<size();i++)
            brr[i]=arr[i];
        arr=brr;
        size*=2;
    }

    void checksize()
    {
        if(currpos>=size)
            increaseSize();
    }

    int checkPosition(int pos)
    {
        if(pos>currpos)
            return 0;
        else
            return 1;
    }

    void add(int a)
    {
        checksize();
        currpos++;
        arr[currpos]=a;
    }

    void remove(int pos)
    {
        if(checkPosition(pos-1)==0)
            System.out.println("Enter a valid position");
        else
        {
            for(int i=pos;i<=currpos;i++)
            {
                arr[i-1]=arr[i];
            }
            arr[currpos]=0;
            currpos--;
        }
    }

    int get(int pos)
    {
        if(checkPosition(pos-1)==0)
            return -1;
        else
            return arr[pos-1];
    }

    int size()
    {
        return size;
    }

    void clear()
    {
        int brr[]=new int[1];
        size=1;
        currpos=-1;
        arr=brr;
    }

    void show()
    {
        if(currpos==-1)
            System.out.println("There is no element in the ArrayList");
        else
        {
            System.out.println("The ArrayList is:");
            for(int i=0;i<=currpos;i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    void sort()
    {
        for(int i=0;i<=currpos;i++)
        {
            for(int j=0;j<=currpos;j++)
            {
                if(arr[j]>arr[i])
                {
                    int c=arr[i];
                    arr[i]=arr[j];
                    arr[j]=c;
                }
            }
        }
    }
}

public class Array_List {

    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList obj = new ArrayList();
        System.out.println("Implementation of ArrayList in Java");        
        while(true)
        {
            System.out.println("Choose an option");
            System.out.println("1. Insert\n2. Delete\n3. Sort\n4. Get\n5. Show\n6. Size\n7. Clear\n8. Exit");
            int a=sc.nextInt();
            int k=0;
            switch (a) {
                case 1:
                    System.out.println("Enter the value of the element to be inserted");
                    int v=sc.nextInt();
                    obj.add(v);
                    break;
                case 2:
                    System.out.println("Enter the position to be removed");
                    v=sc.nextInt();
                    obj.remove(v);
                    break;
                case 3:
                    obj.sort();
                    break;
                case 4:
                    System.out.println("Enter the position at which value has to be accessed");
                    v=sc.nextInt();
                    int e=obj.get(v);
                    if(e==-1)
                        System.out.println("Enter a valid position");
                    else
                        System.out.println("The value at position "+v+" is "+ e);
                    break;
                case 5:
                    obj.show();
                    break;
                case 6:
                    System.out.println("The size of the Arraylist is: ");
                    v=obj.size();
                    System.out.println(v);
                    break;
                case 7:
                    obj.clear();
                    break;
                case 8:
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
