#include<iostream>
using namespace std;
int main()
{
	float a,b,c;
	char ch;
    cout<<"enter the symbol of process"<< endl;
    cin>>ch;
switch(ch)
    {
    	case '+':
    		cout<<"enter numbers:"<<endl;
    		cin>>a>>b;
    		cout<<a<<"+"<<b<<"="<<a+b<<endl;
    		break;
    	case '-':
    		cout<<"enter numbers:"<<endl;
    		cin>>a>>b;
    		cout<<a<<"-"<<b<<"="<<a-b<<endl;
    		break;
    	case '*':
    		cout<<"enter numbers:"<<endl;
    		cin>>a>>b;
    		cout<<a<<"*"<<b<<"="<<a*b<<endl;
    		break;
    	case '/':
    		cout<<"enter numbers:"<<endl;
    		cin>>a>>b;
    		if(b==0){
    			cout<<"please enter non zero denominator:";
    			cin>>b;
			}
    		
    		cout<<a<<"/"<<b<<"="<<a/b<<endl;
    		break;    		
		
	}
    return 0;
}
