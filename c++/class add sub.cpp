#include<iostream>
using namespace std;
class arithmetic{
float a,b,c;	
	public:
	void setdata()
	{
		
		cout<<"enter numbers:";
		cin>>a>>b;		
	}
	void add()
	{
		c=a+b;
	}
	void sub()
	{
		c=a-b;
	}
	void display()
	{
		cout<<c<<endl;
	}
};
int main()
{
	arithmetic v;
	v.setdata();
	v.add();
cout<<"addition of numbers is ";
	v.display();
	v.sub();
cout<<"substraction of numbers is ";
	v.display();
	
}
