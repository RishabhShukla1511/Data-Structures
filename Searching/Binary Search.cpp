#include<bits/stdc++.h>

using namespace std;

// Function to implement Binary Search
int BinarySearch(int arr[],int l,int h,int val)
{
    if(l<=h)
    {
        int m=(l+h)/2;
        if(arr[m]>val)
            return BinarySearch(arr,l,m-1,val); //Since the array is sorted so if the middle value is greater than val then we need to find it in the LHS of mid element
        else if(arr[m]<val)
            return BinarySearch(arr,m+1,h,val); //Since the array is sorted so if the middle value is less than val then we need to find it in the RHS of the mid element
        else
            return m; //Value found so return it
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
    int ans=BinarySearch(arr,0,n-1,val);
    if(ans==-1)
        cout << "Element not found\n";
    else
        cout << "The element is at: " << ans+1 << " position";
}