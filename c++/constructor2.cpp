#include <iostream>
using namespace std;

class Circle {
private:
    double radius;

public:
    
    Circle() {
        radius = 0.0;
    }

  
    Circle(const Circle& other) {
        radius = other.radius;
    }

  
    Circle(double r) {
        radius = r;
    }

   
    double compute() {
        return 3.14159 * radius * radius;
    }

    
    void display() {
        cout << "Radius: " << radius << endl;
        cout << "Area: " << compute() << endl;
    }
};

int main() {
 
    Circle c1(5.0);
    Circle c2(c1);


    c1.display();
    c2.display();

    return 0;
}

