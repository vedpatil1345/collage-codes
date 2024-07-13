#include<iostream>
using namespace std;
void power();
void power(double m,int n){
	double c=1;
	for(int i=0;i<n;i++){
		c=c*m;
	}
	cout<<m<<"^"<<n<<"="<<c<<endl;
}
void power(int m,int n)
{
	int c=1;
	for(int i=0;i<n;i++)
	{
		c=c*m;
	}
	cout<<m<<"^"<<n<<"="<<c<<endl;
}
int main()
{
	int m,n;
	double a;
	cout<<"enter number:";
	cin>>a;
	cout<<"enter power:";
	cin>>n;
	power(a,n);
		cout<<"enter number:";
	cin>>m;
	cout<<"enter power:";
	cin>>n;
	power(m,n);
}
