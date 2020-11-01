#include<bits/stdc++.h>
using namespace std;

int getsumutil(int *st,int ss,int se,int qs,int qe,int si)
{
    if(qs<=ss && qe>=se)
        return st[si];
    if(se<qs || ss>qe)
        return 0;
    int mid=(ss+se)/2;
    return getsumutil(st,ss,mid,qs,qe,2*si+1)+getsumutil(st,mid+1,se,qs,qe,2*si+2);     
}

int getsum(int *st,int n,int qs,int qe)
{
    if(qs<0 || qs>n-1 || qe<0 || qe>n-1 || qs>qe)
    {
        cout << "Invalid Input\n";
        return -1;
    }
    else
        return getsumutil(st,0,n-1,qs,qe,0);
}

int createSTutil(int arr[],int *st,int l,int h,int pos)
{
    if(l==h)
    {
        st[pos]=arr[l];
        return st[pos];
    }
    else
    {
        int mid=(l+h)/2;
        st[pos]=createSTutil(arr,st,l,mid,pos*2+1)+createSTutil(arr,st,mid+1,h,pos*2+2);
        return st[pos];
    }    
}

int* createST(int arr[],int n)
{
    int h=ceil(log2(n));
    int max_size=2*pow(2,h)-1;
    int* st=new int[max_size];
    createSTutil(arr,st,0,n-1,0);
    return st;
}

int main()
{
    int n;
    cout << "Enter the number of elements\n";
    cin >> n;
    int arr[n];
    cout << "Enter the elements\n";
    for(int i=0;i<n;i++)
        cin >> arr[i];
    int *st=createST(arr,n);
    for(int i=0;i<2*pow(2,ceil(log2(n)))-1;i++)
        cout << st[i] << " ";
    cout << '\n';
    int start,end;
    cout << "Enter the start and end position of the sum query\n";
    cin >> start >> end;
    cout << getsum(st,n,start,end);
}
