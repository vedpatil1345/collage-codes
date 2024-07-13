#include<iostream>
using namespace std;
class temp{
		float c,f;
		public:
			void cel()
			{
				cout << "enter temp in C:";
				cin>>c;
				f=(1.8*c)+32;
    			cout<<c<<"c="<<f<<"f."<<endl;
			}
			void far()
			{
				cout << "enter temp in f:";
				cin>>f;
				c=0.555555555555555*(f-32);
    			cout<<f<<"f="<<c<<"c."<<endl;
			}
			
};
int main()
{
	char ch;
	temp t;
	cout<<"enter process:"<<endl<<"if celcius to farenheit 'c'"<<endl<<"if farenheit to celcius 'f'"<<endl;
	cin>>ch;
	if(ch=='c')
	{
		t.cel();
	}
   else if(ch=='f')
   {
   	    t.far();
   }
   else{
   	cout<<"enter valid input."<<endl;
   }
    return 0;
}
