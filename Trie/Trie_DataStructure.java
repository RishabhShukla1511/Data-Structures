import java.util.*;

class Trie_Node
{
    final static int Alphabet_size=26;
    Boolean isEndofword;
    Trie_Node[] children;
    
    Trie_Node()
    {
        children = new Trie_Node[Alphabet_size];
        isEndofword = false;

        for(int i=0;i<Alphabet_size;i++)
            children[i] = null;
    }
}

class Trie
{

    Trie_Node root;

    Trie()
    {
        root=new Trie_Node();
    }

    void insertrec(String key)
    {
        insert(this.root,key);
    }

    void insert(Trie_Node root,String key)
    {
        for(int i=0;i<key.length();i++)
        {
            int index=(int)(key.charAt(i))-97;

            if(root.children[index]==null)
                root.children[index]=new Trie_Node();

            root=root.children[index];
        }
        root.isEndofword=true;
    }

    void deleterec(String key)
    {
        this.root=delete(this.root,key,0);
    }

    boolean is_empty(Trie_Node root)
    {
        if(root==null)
            return true;
        for(int i=0;i<Trie_Node.Alphabet_size;i++)
        {
            if(root.children[i]!=null)
                return false;
        }
        return true;            
    }

    Trie_Node delete(Trie_Node root,String key, int depth)
    {
        if(is_empty(root))
            return null;

        if(depth==key.length())
        {
            if(root.isEndofword)
                root.isEndofword=false;

            if(is_empty(root))
                root=null;

            return root;
        }

        int index=(int)(key.charAt(depth))-97;
        root.children[index]=delete(root.children[index],key,depth+1);

        if(is_empty(root) && root.isEndofword==false)
            root=null;

        return root;
    }

    void searchrec(String key,String realkey)
    {
        search(this.root,key,realkey);
    }

    void search(Trie_Node root, String key,String realkey)
    {
        int index,k=0;
        for(int i=0;i<key.length();i++)
        {
            index=(int)(key.charAt(i))-97;

            if(root.children[index]!=null)
                root=root.children[index];
            else 
            {
                k=1;
                break;
            }
        }
        if(k==0 && root.isEndofword)
            System.out.println(realkey + " found in Trie");
        else
            System.out.println(realkey + " NOT found in Trie");
    }

    void showrec()
    {
        if(is_empty(root))
            System.out.println("Trie is empty");
        else
        {
            show(root,"");
            System.out.println();
        }
    }

    void show(Trie_Node root,String l)
    {  
        for(int i=0;i<Trie_Node.Alphabet_size;i++)
        {
            if(root.children[i]!=null)
            {
                l+=(char)(i+97);
                if(root.children[i].isEndofword)
                    System.out.print("\"" + l + "\" ");
                else
                    System.out.print(l + " ");
                l="";
                show(root.children[i],l);
            }
        }
    }
}

public class Trie_DataStructure {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Trie obj = new Trie();
        
        System.out.println("\n\nImplementation of Trie(CASE INSENSITIVE) in Java\n\nThey are used in reTRIEval of data\nUses:\n1. Web Autocomplete\n2. Genome Sequencing  .......\n");
        
        while(true)
        { 
            System.out.println("Choose an option");
            System.out.println("1. Insert\n2. Delete\n3. Search\n4. Traversal\n5. Exit");
            
            int a=Integer.parseInt(sc.nextLine());
            int k=0;
            String key;

            switch (a) {

                case 1:

                    System.out.println("Enter the value to be inserted");
                    key=sc.nextLine();
                    key=key.toLowerCase();
                    obj.insertrec(key);
                    break;

                case 2:

                    if(obj.is_empty(obj.root))
                        System.out.println("Trie is empty");
                    else
                    {
                        System.out.println("Enter the value to be deleted");
                        key=sc.nextLine();
                        key=key.toLowerCase();
                        obj.deleterec(key);
                    }
                    break;

                case 3:

                    if(obj.is_empty(obj.root))
                        System.out.println("Trie is empty");
                    else
                    {
                        System.out.println("Enter the value to be searched");
                        key=sc.nextLine();
                        String realkey=key;
                        key=key.toLowerCase();
                        obj.searchrec(key,realkey);
                    }
                    break;

                case 4:

                    obj.showrec();
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