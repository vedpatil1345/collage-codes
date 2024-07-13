#include <iostream>
using namespace std;

class Time{
    private:
        int hh;
        int mm;
        int ss;
    public:
        
        Time(int h =0,int m = 0, int s = 0){
            hh = h;
            mm = m;
            ss = s;
        }
        Time add(Time t1, Time t2){
            Time temp;
            ss = t2.ss + t1.ss;
            mm = t2.mm + t1.mm;
            hh = t2.hh + t1.hh;

        
                mm += ss / 60;
                ss = ss % 60;
            
            
                hh += mm / 60;
                mm = mm % 60;
            
            return temp;
        }
        void display(){
            cout<<"HH:MM:SS = "<<hh<<":"<<mm<<":"<<ss<<endl;
        }
};


int main(){
    Time t1(4,35,55), t2(5, 24, 5), t3;
    cout<<"Two times are:"<<endl;
    t1.display();
    t2.display();
    t3.add(t1,t2);
    cout<<"SUM is:"<<endl;
    t3.display();
    return 0;
}
