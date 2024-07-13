#include<stdio.h>

int main()
{
       double i,p,t,r;
       printf("enter principal amount  value :- \n");
       scanf("%lf",&p);
       printf("enter  t value:- \n ");
       scanf("%lf",&t);
       printf("enter the r value:- \n");
       scanf("%lf",&r);
       i=(p*t*r)/100;
       printf("The simple intrest is %f :-",i);
return 0;
}
