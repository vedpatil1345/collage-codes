#include<iostream>
using namespace std;

class student{
	protected:
	int rollno;
	public:
	void getdata(){
		cout<<"enter roll no:";
		cin>>rollno;
	}
};
class test:public student{	
	public:
	int	marks1, marks2;
	void getdata(){
		cout<<"enter marks"<<endl;
		cout<<"sub1:";
		cin>>marks1;
		cout<<"sub2:";
		cin>>marks2;
	}
};
class sports{
	public:
		string performence;
		void getdata(){
			cout<<"enter sports performence:";
			cin>>performence;
		}
};
class result:public test,public sports{
	public:
		int total;
	void total1(){
		total=marks1+marks2;
	}
	void display(){
		cout<<"subject		marks"<<endl;
		cout<<"sub1		"<<marks1<<endl;
		cout<<"sub2		"<<marks2<<endl;
		
		cout<<"	  total="<<total<<endl;
		cout<<"sports		"<<performence<<endl;
	}
};
int main(){
	result r;
	r.student::getdata();
	r.test::getdata();
r.sports::getdata();
	r.total1();
	r.display();
	
	return 0;
}
