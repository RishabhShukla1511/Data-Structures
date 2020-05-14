#include<bits/stdc++.h>
using namespace std;

int swap(int* a,int* b)
{
    int c=a;
    a=b;
    b=c;
}

void print_array(int arr[],int n)
{
    cout << "The sorted numbers are:\n";
    for(int i=0;i<n;i++)
        cout << arr[i] << " ";
}

void bubble_sort(int arr[],int n)
{
    for(int i=0;i<n-1;i++)
    {
        for(int j=0;j<n-i-1;j++)
        {
            if(arr[j]>arr[i])
                swap(&arr[i],&arr[j]);
        }
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
    bubble_sort(arr,n);
    print_array(arr,n);
}