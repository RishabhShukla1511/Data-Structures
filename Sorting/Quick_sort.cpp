#include<bits/stdc++.h>
using namespace std;

void print_array(int arr[],int n)
{
    cout << "The sorted numbers are:\n";
    for(int i=0;i<n;i++)
        cout << arr[i] << " ";
}

int partition(int arr[],int l,int r)
{
    int key=arr[r];
    int i=l-1;
    for(int j=l;j<r;j++)
    {
        if(arr[j]<key)
        {
            i++;
            int c=arr[j];
            arr[j]=arr[i];
            arr[i]=c;
        }
    }
    int c=arr[i+1];
    arr[i+1]=arr[r];
    arr[r]=c;
    return i+1;
}

void quick_sort(int arr[],int l,int r)
{
    if(l<r)
    {
        int p=partition(arr,l,r);
        quick_sort(arr,l,p-1);
        quick_sort(arr,p+1,r);
    }
}

int main()
{
    int n;
    cout << "Enter the size of the array\n";
    cin >> n;
    int arr[n];
    cout << "Enter the numbers\n";
    for(int i=0;i<n;i++)
        cin >> arr[i];
    quick_sort(arr,0,n-1);
    print_array(arr,n);
}