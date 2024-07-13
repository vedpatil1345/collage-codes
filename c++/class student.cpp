/*Create a class student with student name and age as data members. Define functions
to read and display the data members.*/
#include <iostream>
using namespace std;
class student{
	char name[100];
	float age;
	public:
	void scan()
	{
		cout<<"enter the name:";
		cin>>name;
		cout<<"enter the age:";
		cin>>age;
	}
	void print()
	{
		cout<<"name:"<<name<<endl;
		cout<<"age:"<<age<<endl;
	}
};
int main()
{
	student s;
	s.scan();
	s.print();
	return 0;
	
}
