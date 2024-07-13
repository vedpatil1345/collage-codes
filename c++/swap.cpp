#include<iostream>
using namespace std;
int swap1(int,int);
int swap2(int &,int &);

int swap1(int x,int y)
{
int temp;
temp=x;
x=y;
y=temp;
cout<<"\nafter swap "<<x<<y;
}
int swap2(int &x,int &y)
{
int temp;
temp=x;
x=y;
y=temp;
cout<<"\nafter swap "<<x<<y;
}


int main()
{

int x,y,n;

cout<<"enter two values to be swapped\n";
cin>>x>>y;
cout<<"\nfor CALL BY VALUE press1";
cout<<"\nfor CALL BY REFERENCE press2\n";
cin>>n;
switch(n)
{
case 1:

cout<<"\nCALL BY VALUE\n";
cout<<"\nvalues before swap"<<x<<"\t"<<y;
swap1(x,y);
cout<<"\nafter swap "<<x<<y;
break;
case 2:
cout<<"\nCALL BY REFERENCE\n";
cout<<"\nvalue before swap "<<x<<y;
swap2(x,y);
cout<<"\nafter swap"<<x<<y;
break;
}
return 0;
}


