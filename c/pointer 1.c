/*Write a program in that take pointer variable of character, int and float data type.
Print the address and value of that variable.*/
#include<stdio.h>

int main()
{
    int a,*b,*c,*d;
    char ch;
    float f;
    printf("enter number:");
    scanf("%d",&a);
    b = &a;
    printf("enter single character:");
    scanf("%s",&ch);
    c = &ch;
    printf("enter float value:");
    scanf("%f",&d);
    d = &f;
    printf("number:%d\ncharacter:%c\nfloat:%f",*b,*c,*d);
    return 0;

}