#include<iostream>
using namespace std;

class base{
	private:
	int a,b;
	protected:
	int sum;
	void plus()
	{
		sum=a+b;
	}
	public:
	int sub;
	void min(){
		sub=a-b;
	}
	void setdata(){
	 	cout<<"enter two numbers:";
	 	cin>>a>>b;
	 	plus();
	 	min();
	 }
};
class derive:public base{
	public:
	void display(){
		
			cout<<"private member can't be inherited."<<endl;
			cout<<"protected member sum="<<sum<<endl;
			cout<<"public member sub="<<sub<<endl;
		}
};
int main(){
	derive d;
	d.setdata();
	d.display();
	
	return 0;
}
