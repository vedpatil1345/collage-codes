#include<iostream>
using namespace std;
class baseClass {
protected:
int i;
public:
baseClass(int x)
{
i=x;
cout << "Base class Constructor and i = "<< i <<endl;
}
};
class derivedClass: public baseClass {
int j;
public:
derivedClass(int x, int y): baseClass(y)
{
j=x;
cout << "Derive class Constructor and j = " << j;
}
};
int main()
{
derivedClass ob(5,10);
return 0;
}

