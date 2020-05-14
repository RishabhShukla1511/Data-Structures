#include<bits/stdc++.h>
using namespace std;

void selection_sort(int arr[],int n)
{
    for(int i=0;i<n-1;i++)
    {
        int min=arr[i],pos=i;
        for(int j=i+1;j<n;j++)
        {
            if(arr[j]<min)
            {
                min=arr[j];
                pos=j;
            }
        }
        int c=arr[i];
        arr[i]=arr[pos];
        arr[pos]=c;
    }
}

void print_array(int arr[],int n)
{
    cout << "The sorted numbers are:\n";
    for(int i=0;i<n;i++)
        cout << arr[i] << " ";
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
    selection_sort(arr,n);
    print_array(arr,n);
}