import java.util.*;

class MaxHeap
{
    private int heap[];
    private int maxsize,size;

    MaxHeap(int maxsize)
    {
        this.maxsize=maxsize;
        this.size=-1;
        heap = new int[maxsize];
    }

    int getParent(int i)
    {
        return (i-1)/2;
    }

    int getLeftChild(int i)
    {
        return 2*i+1;
    }

    int getRightChild(int i)
    {
        return 2*i+2;
    }

    void swap(int pos1,int pos2)
    {
        int temp=heap[pos1];
        heap[pos1]=heap[pos2];
        heap[pos2]=temp;
    }

    void maxHeapify(int pos)
    {        
        int parent=getParent(pos);
        
        if(heap[pos]>heap[parent])
        {
            swap(pos,parent);
            maxHeapify(parent);
        }
    }

    void heapify(int pos)
    {
        int largest=pos;
        int left=getLeftChild(pos);
        int right=getRightChild(pos);

        if(left<=size && heap[left]>heap[largest])
            largest=left;
        
        if(right<=size && heap[right]>heap[largest])
            largest=right;

        if(largest!=pos)
        {
            swap(largest,pos);
            heapify(largest);
        }
    }

    boolean checkpos(int pos)
    {
        return ( pos<=size+1 && pos>=1 );
    }

    boolean isLeaf(int pos)
    {
        return ( pos>=(size+1)/2 && pos<=size+1 );
    }

    void insert(int key)
    {
        if(size+1>maxsize || maxsize<1)
            System.out.println("Heap is full failed to insert");
        else
        {
            heap[++size]=key;
            maxHeapify(size);
        }
    }

    void delete()
    {
        if(size>=0)
        {
            heap[0]=heap[size];
            heap[size]=0;
            size--;
            heapify(0);
        }
        else
            System.out.println("Max heap is empty");
    }

    void show()
    {
        if(size!=-1)
        {
            System.out.println("The Max Heap is:");
            for(int i=0;i<=size;i++)
                System.out.print(heap[i] + " ");
            System.out.println();
        }
        else
        {
            System.out.println("Max Heap is empty");
        }
    }

    void numberOfElements()
    {
        if(size==-1)
            System.out.println("Heap is empty");
        else
            System.out.println("The number of elements of Heap is " + (size+1) );
    }

    void maximumValue()
    {
        if(size==-1)
            System.out.println("Heap is empty");
        else
            System.out.println("The maximum value in the Heap is: " + heap[0]);
    }

}

public class Max_Heap {
    
    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("\nImplementation of Max Heap in Java");
        
        System.out.println("Enter the maximum size of the heap");
        int size=sc.nextInt();
        MaxHeap obj = new MaxHeap(size);

        while(true)
        { 
            System.out.println("Choose an option");
            System.out.println("1. Insert\n2. Delete root\n3. Maximum Value\n4. Number Of Elements\n5. Show\n6. Exit");
            
            int a=sc.nextInt();
            int k=0,v;

            switch (a) {

                case 1:

                    System.out.println("Enter the value to be inserted");
                    v=sc.nextInt();
                    obj.insert(v);
                    break;

                case 2:

                    obj.delete();
                    break;

                case 3:

                    obj.maximumValue();
                    break;

                case 4:

                    obj.numberOfElements();
                    break;

                case 5:

                    obj.show();
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