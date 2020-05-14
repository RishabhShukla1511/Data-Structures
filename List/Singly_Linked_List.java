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

class SinglyLinkedlist{
    int size=0;
    Node head;
    
    SinglyLinkedlist()
    {
        head=new Node();
    }

    void add(int v,int pos)
    {
        Node newnode = new Node(v,null);
        if(checkposition(pos)==1)
        {
            if(size==0)
            {
                newnode.next=null;
                head=newnode;
            }
            else
            {
                if(pos==1)
                {
                    newnode.next=head;
                    head=newnode;
                }
                else
                {
                    Node x=head;
                    for(int i=0;i<size;i++)
                    {
                        if(i==pos-2)
                        {
                            newnode.next=x.next;
                            x.next=newnode;
                            break;
                        }
                        x=x.next;
                    }
                }
            }
            size++;
        }
    }

    int checkposition(int pos)
    {
        if(pos<1 || pos>size+1)
        {
            System.out.println("Enter a valid position");
            return 0;
        }
        return 1;
    }

    int checkposition_delete(int pos)
    {
        if(pos<1 || pos>size)
        {
            System.out.println("Enter a valid position");
            return 0;
        }
        return 1;
    }

    int checksize()
    {
        if(size==0)
        {
            System.out.println("Insert elements in the Linkedlist first");
            return 0;
        }
        return 1;
    }
    
    void remove(int pos)
    {
        if(checkposition_delete(pos)==1 && checksize()==1)
        {
            if(pos==1)
            {
                Node x=head;
                head=x.next;
                x=null;
            }
            else
            {
                Node x=head;
                for(int i=0;i<size;i++)
                {
                    if(i==pos-2)
                    {
                        Node temp=x.next;
                        x.next=x.next.next;
                        temp=null;
                        break;
                    }
                    x=x.next;
                }
            }
            size--;
        }
    }

    int search(int v)
    {
        int pos=-1;
        Node x=head;
        for(int i=0;i<size;i++)
        {
            if(x.key==v)
            {
                pos=i+1;
                break;
            }
            x=x.next;
        }
        return pos;
    }

    int size()
    {
        return size;
    }

    void show()
    {
        if(size==0)
        {
            System.out.println("There is no element in the Linkedlist");
        }
        else
        {
            System.out.println("The Linkedlist is: ");
            Node x=head;
            for(int i=0;i<size;i++)
            {   
                System.out.print(x.key + " ");
                x=x.next;
            }
            System.out.println();
        }
    }

    void clear()
    {
        size=0;
        Node x=head;
        head.key=0;
        head.next=null;
        for(int i=0;i<size;i++)
        {
            Node temp=x.next;
            x=null;
            x=temp;
        }
    }
}

public class Singly_Linked_List {
    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        SinglyLinkedlist obj = new SinglyLinkedlist();
        System.out.println("Implementation of LinkedList in Java");        
        while(true)
        {
            System.out.println("Choose an option");
            System.out.println("1. Insert\n2. Delete\n3. Search\n4. Show\n5. Size\n6. Clear\n7. Exit");
            int a=sc.nextInt();
            int k=0;
            switch (a) {
                case 1:
                    System.out.println("Enter the value and the position of the element to be inserted");
                    int v=sc.nextInt();
                    int pos=sc.nextInt();
                    obj.add(v,pos);
                    break;
                case 2:
                    System.out.println("Enter the position to be removed");
                    v=sc.nextInt();
                    obj.remove(v);
                    break;
                case 3:
                    System.out.println("Enter the value to be searched");
                    v=sc.nextInt();
                    int e=obj.search(v);
                    if(e==-1)
                        System.out.println(v + " Does not exist in the Linkedlist");
                    else
                        System.out.println("First position at which "+v+" exists in the Linkedlist is "+e);
                    break;
                case 4:
                    obj.show();
                    break;
                case 5:
                    System.out.println("The size of the Linkedlist is: ");
                    v=obj.size();
                    System.out.println(v);
                    break;
                case 6:
                    obj.clear();
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