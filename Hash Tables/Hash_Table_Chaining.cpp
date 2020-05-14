#include<bits/stdc++.h>

using namespace std;

int main()
{
    cout << "Implementation of Hashing using Chaining\n";
    cout << "Since Modulo Functions work the best for hashing enter the value i.e Bucket\n";
    int size;
    cin >> size;
    vector<int>v[size];
    while(1)
    {
        cout << "Choose an option\n1. Insert\n2. Delete\n3. Search\n4. Show Hash table\n5. Exit\n";
        int a;
        cin >> a;
        if(a==1)
        {
            cout << "Enter the value to be inserted\n";
            int key;
            cin >> key;
            int index=key%size;
            v[index].push_back(key);
        }
        else if(a==2)
        {
            cout << "Enter the value to be deleted\n";
            int key;
            cin >> key;
            int k=0;
            for(int i=0;i<size;i++)
            {
                for(int j=0;j<v[i].size();j++)
                {
                    if(v[i][j]==key)
                    {
                        v[i].erase(v[i].begin()+j);
                        k=1;
                        break;
                    }
                }
                if(k==1)
                    break;
            }
            if(k==0)
                cout << key << " not found in Hash Table\n";
        }
        else if(a==3)   
        {
            cout << "Enter the value to be searched\n";
            int key;
            cin >> key;
            int k=0;
            for(int i=0;i<size;i++)
            {
                for(int j=0;j<v[i].size();j++)
                {
                    if(v[i][j]==key)
                    {
                        k=1;
                        break;
                    }
                }
                if(k==1)
                    break;
            }
            if(k==0)
                cout << key << " not found in Hash Table\n";
            else
                cout << key <<  " is found in Hash Table\n";
            
        }
        else if(a==4)
        {
            cout << "The Hash Table is:\n\n";
            for(int i=0;i<size;i++)
            {
                cout << i;
                if(v[i].size()!=0)
                    cout << " = ";
                for(int j=0;j<v[i].size();j++)
                {
                    cout << v[i][j];
                
                    if(j!=v[i].size()-1)
                        cout << " --> ";
                
                }
                cout << '\n';
            }
            cout << '\n';
        }
        else if(a==5)
        {
            break;
        }
        else
        {
            cout << "Enter a valid option\n";
        }
    }
}
