#include<bits/stdc++.h>

using namespace std;

int LinearSearch(int arr[],int val,int n)
{
    for(int i=0;i<n;i++)
    {
       if(arr[i]==val)
        {
            return i+1;
        }
    }
    return -1;
}

int main()
{
    cout << "Enter the size of the input data\n";
    int n;
    cin >> n;
    int arr[n];
    cout << "Enter the numbers\n";
    for(int i=0;i<n;i++)
    {
        cin >> arr[i];
    }
    cout << "Enter the value to be searched\n";
    int val;
    cin >> val;
    int ans=LinearSearch(arr,val,n);
    if(ans==-1)
        cout << "Element not found\n";
    else
        cout << "The element is at: " << ans;
}