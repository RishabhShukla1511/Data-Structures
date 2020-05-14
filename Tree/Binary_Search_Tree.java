import java.util.*;

class Node
{
    int key;
    Node left,right;

    Node()
    {
        key=0;
        left=null;
        right=null;
    }

    Node(int key,Node left,Node right)
    {
        this.key=key;
        this.left=left;
        this.right=right;
    }
}

class BST{

    Node root;
    int size=-1;

    BST()
    {
        root=new Node();
        size++;
    }

    void insertrec(int key)
    {
        Node newnode=new Node(key,null,null);
        insert(this.root,newnode);
        size++;
    }

    void insert(Node root,Node newnode)
    {
        if(size==0)
            this.root=newnode;

        else    
        {
            if(root.key<=newnode.key && root.right==null)
                root.right=newnode;

            else if(root.key>newnode.key && root.left==null)
                root.left=newnode;

            else if(root.key>newnode.key)
                insert(root.left, newnode);

            else if(root.key<=newnode.key)
                insert(root.right,newnode);

            // else if(root.key==newnode.key)
            // {
            //     System.out.println("Duplicate values are not allowed in BST");
            //     size--;
            // }
        }
    }
    
    boolean checksize()
    {
        if(size==0)
        {
            System.out.println("There is no element in the Binary Search Tree");
            return false;
        }

        else
            return true;
    }

    void deleterec(int key)
    {
        if(checksize())
        {
            root=delete(root,key);
            size--;
        }
    }

    Node delete(Node root,int key)
    {
        if(root==null)
        {
            size++;
            System.out.println("Value Not found");
            return null;
        }
        
        if(root.key<key)
            root.right=delete(root.right,key);

        else if(root.key>key)
            root.left=delete(root.left,key);

        else
        {
            if(root.left==null)
                return root.right;

            else if(root.right==null)
                return root.left;

            else
            {
                root.key=minvalue(root.right);
                root.right=delete(root.right,root.key);
            }
        }

        return root;
    }

    int minvalue(Node root)
    {
        int val=root.key;
        
        while(root.left!=null)
        {
            val=root.left.key;
            root=root.left;
        }

        return val;
    }

    void searchrec(int key)
    {
        if(checksize())
            search(root,key);
        
    }

    void search(Node root,int key)
    { 
        if(root==null)
        {
            System.out.println("Value is NOT found in BST");
            return;
        }

        if(root.key==key)
        {
            System.out.println("Value is found in BST");
            return;
        }

        else if(root.key<key)
            search(root.right,key);

        else if(root.key>key)
            search(root.left,key);
    }

    void inorderrec()
    {
        if(checksize())
        {
            inorder(root);
            System.out.println();
        }
    }

    void inorder(Node root)
    {
        if(root.left!=null)
            inorder(root.left);

        System.out.print(root.key + " ");

        if(root.right!=null)
            inorder(root.right);
    }

    void preorderrec()
    {
        if(checksize())
        {
            preorder(root);
            System.out.println();
        }
    }

    void preorder(Node root)
    {
        System.out.print(root.key + " ");

        if(root.left!=null)
            preorder(root.left);

        if(root.right!=null)
            preorder(root.right);
    }

    void postorderrec()
    {
        if(checksize())
        {
            postorder(root);
            System.out.println();
        } 
    }

    void postorder(Node root)
    {
        if(root.left!=null)
            postorder(root.left);

        if(root.right!=null)
            postorder(root.right);

        System.out.print(root.key + " ");
    }

    void minimum_valuerec()
    {
        if(checksize())
            minimum_value(root);
    }

    void minimum_value(Node root)
    {
        if(root.left!=null)
            minimum_value(root.left);

        else
            System.out.println("The minimum value in BST is: " + root.key);
    }

    void maximum_valuerec()
    {
        if(checksize())
            maximum_value(root);
    }

    void maximum_value(Node root)
    {
        if(root.right!=null)
            maximum_value(root.right);

        else
            System.out.println("The maximum value in BST is: " + root.key);
    }

    void noofnodes()
    {
        if(checksize())
            System.out.println("The number of nodes in the Binary Search Tree are: " + size);
    }
}

class Binary_Search_Tree
{
    public static void main(String[] abc)
    {
        Scanner sc=new Scanner(System.in);
        BST obj = new BST();
        
        System.out.println("\n\nImplementation of Binary Search Tree in Java");
        System.out.println("\nIn this BST duplicates are allowed in order to make a BST having distinct elements\n1. UNCOMMENT LINES 62 TO 66\n2. Remove equality condition in lines 50 and 59");
        System.out.println("\nIn DUPLICATES ALLLOWED case:\n1. Duplicates are sent to the right subtree\n2. If a duplicate element is chosen to be deleted, only the first one found is deleted");
        System.out.println("\nIn NON DUPLICATES case:\n   Everything works same as it works in a normal BST\n\n");
        
        while(true)
        { 
            System.out.println("Choose an option");
            System.out.println("1. Insert\n2. Delete\n3. Search\n4. Traversal\n5. Minimum Value\n6. Maximum Value\n7. Number of Nodes\n8. Exit");
            
            int a=sc.nextInt();
            int k=0,v;

            switch (a) {

                case 1:

                    System.out.println("Enter the value to be inserted");
                    v=sc.nextInt();
                    obj.insertrec(v);
                    break;

                case 2:

                    System.out.println("Enter the value to be deleted");
                    v=sc.nextInt();
                    obj.deleterec(v);
                    break;

                case 3:

                    System.out.println("Enter the value to be searched");
                    v=sc.nextInt();
                    obj.searchrec(v);
                    break;

                case 4:

                    System.out.println("Traversals:\n1. Inorder Traversal\n2. Preorder Traversal\n3. Postorder Traversal");
                    v=sc.nextInt();

                    switch (v) 
                    {
                        case 1:

                            obj.inorderrec();
                            break;

                        case 2:

                            obj.preorderrec();
                            break;

                        case 3:

                            obj.postorderrec();
                            break;

                        default:

                            System.out.println("Invalid option");
                            break;
                    }
                    break;

                case 5:

                    obj.minimum_valuerec();
                    break;

                case 6:

                    obj.maximum_valuerec();
                    break;

                case 7:

                    obj.noofnodes();
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