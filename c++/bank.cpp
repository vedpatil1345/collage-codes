/* Create a String class that includes all the string-related functions. Like Length, copy, 
compare, concatenation, sub string search (Without using inbuilt string functions).*/
#include<iostream>
#include<iomanip>
using namespace std;
class bank{
	char name[50];
	long int acc_no;
	char acc_type[20];
	double balance, withdraw, deposite;
	
	public:
		void initial()
		{
			balance=2500;
			cout<<"enter your name:";
			cin>>name;
			cout<<"enter account number:";
			cin>>acc_no;
			cout<<"enter account type:";
			cin>>acc_type;
		}
		void d(){
			cout<<"deposite amount: ";
			cin>>deposite;
			balance=balance+deposite;
			cout<<"balance:"<<balance<<endl;
			
		}
		void w(){
			cout<<"balance:"<<balance<<endl;
			cout<<"withdarwl amount: ";
			cin>>withdraw;
			if(balance<withdraw)
			{
				cout<<"you don't have enough"<<endl;
			}
			else{
					balance=balance-withdraw;
			}

		}
		void b(){
			cout<<"\n\n\nname"<<setw(15)<<"balance"<<endl;
			cout<<name<<setw(15)<<balance<<endl;
		
		}
};
int main()
{
	bank b;
	char ch;
	b.initial();
	start:
	cout<<"\n\n\n\nbalance check(b)\nwithdraw(w)\ndeposite(d)\n:";
	cin>>ch;
	switch(ch)
	{
		case 'b':
			b.b();
			goto start;
			break;
		case 'd':
			b.d();
			goto start;
			break;
		case 'w':
			b.w();
			goto start;
			break;
	}
	return 0;
}
