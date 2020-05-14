#include<bits/stdc++.h>
using namespace std;

int swap(int* a,int* b)
{
    int* c=a;
    a=b;
    b=c;
}

void print_array(int arr[],int n)
{
    cout << "The sorted numbers are:\n";
    for(int i=0;i<n;i++)
        cout << arr[i] << " ";
}

void insertion_sort(int arr[],int n)
{
    for(int i=1;i<n;i++)
    {
        int j=i-1,key=arr[i];   
        while(j>=0 && arr[j]>key)
        {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
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
    insertion_sort(arr,n);
    print_array(arr,n);
}