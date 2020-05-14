#include<bits/stdc++.h>
using namespace std;

void print_array(int arr[],int n)
{
    cout << "The sorted numbers are:\n";
    for(int i=0;i<n;i++)
        cout << arr[i] << " ";
}

void merge(int arr[],int l,int m,int r)
{
    int s1=m-l+1,s2=r-m;
    int left[s1],right[s2];
    
    for(int i=0;i<s1;i++)
        left[i]=arr[l+i];
    for(int i=0;i<s2;i++)
        right[i]=arr[m+i+1];

    int i=0,j=0;
    while(i<s1 && j<s2)
    {
        if(left[i]<right[j])
        {
            arr[l]=left[i];
            i++;
        }
        else
        {
            arr[l]=right[j];
            j++;
        }
        l++;
    }

    while(i<s1)
    {
        arr[l]=left[i];
        i++;
        l++;
    }

    while(j<s2)
    {
        arr[l]=right[j];
        j++;
        l++;
    }
}

void merge_sort(int arr[],int l,int r)
{
    if(l<r)
    {
        int m=(l+r)/2;
        merge_sort(arr,l,m);
        merge_sort(arr,m+1,r);

        merge(arr,l,m,r);
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
    merge_sort(arr,0,n-1);
    print_array(arr,n);
}