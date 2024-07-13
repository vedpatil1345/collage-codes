#include<iostream>
using namespace std;
class cube{
	public:
		int side;
		cube(int x)
		{
			side=x;
		}
		~cube(){
			cout<<"distructor is called"<<endl;
		}
		
};
int main(){
	cube s1(10),s2(20);
	cout<<"side is "<<s1.side<<" and "<<s2.side<<"."<<endl;
}
