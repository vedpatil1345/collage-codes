/*Create a 'DISTANCE' class with : - feet and inches as data members, - member function 
to input distance- member function to output distance- member function to add two 
distance objects. Write a main function to create objects of DISTANCE class. Input two 
distances and output the sum.*/
#include <iostream>
using namespace std;
class dist{
	private:
		int feet,inch;
	public:
		dist(int f=0,int i=0){
			feet=f;
			inch=i;
	}

		void add(dist d1, dist d2)
		{
			feet = d1.feet + d2.feet;
			inch = d1.inch + d2.inch;
			feet = feet + (inch / 12);
			inch= inch % 12;
		}
		void out(){
			cout<<"distance="<<feet<<":"<<inch<<endl;
		}
};

int main()
{
	dist d1(5,10),d2(2,5),d3;
	d3.add(d1,d2);
	d1.out();
	d2.out();
	d3.out();
	return 0;
}
