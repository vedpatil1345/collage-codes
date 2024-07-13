#include <stdio.h>
#include <math.h>
int main()
{
    int a,b,result,v,z;
    float c,w;
    double x;
    char y;
    printf("enter two numbers. \n");
    scanf("%d %d",&a,&b);
    printf("arithmatic\n");
    c = a+b;

    printf("a+b = %f \n",c);
    printf("------------------------\n");
    c = a-b;
    printf("------------------------\n");
    c = a*b;
    printf("a*b = %f \n",c);
    printf("------------------------\n");
    c = a/b;
    printf("a/b = %f \n",c);
    printf("------------------------\n");
    c = a%b;
    printf("Remainder when a divided by b = %f \n",c);
    printf("------------------------\n");
    printf("relational\n");

    if (a>b)
        printf("%d is grater than %d\n",a,b);
    else
        printf("%d is grater than %d\n",b,a);
    printf("------------------------\n");

    if (a!=b)
        printf("%d is not equal to %d\n",a,b);
    else
        printf("%d is equal to %d\n",a,b);
    a=5;
    b=4;
    c=6;
    z=6;
    int d=8;
    printf("++a = %d \n", ++a);
    printf("--b = %d \n", --b);
    printf("++c = %f \n", ++c);
    printf("--d = %f \n", --d);

    c = a;
    printf("c = %d\n", c);
    c += a;
    printf("c = %d\n", c);
    c -= a;
    printf("c = %d\n", c);
    c *= a;
    printf("c = %d\n", c);
    c /= a;
    printf("c = %d\n", c);
    z %= a;
    printf("z = %d\n", z);
    a=5;
    b=4;
    c=6;
    printf("%d == %d is %d \n", a, b, a == b);
    printf("%d == %d is %d \n", a, c, a == c);
    printf("%d > %d is %d \n", a, b, a > b);
    printf("%d > %d is %d \n", a, c, a > c);
    printf("%d < %d is %d \n", a, b, a < b);
    printf("%d < %d is %d \n", a, c, a < c);
    printf("%d != %d is %d \n", a, b, a != b);
    printf("%d != %d is %d \n", a, c, a != c);
    printf("%d >= %d is %d \n", a, b, a >= b);
    printf("%d >= %d is %d \n", a, c, a >= c);
    printf("%d <= %d is %d \n", a, b, a <= b);
    printf("%d <= %d is %d \n", a, c, a <= c);

    a = 5,
    b = 5,
    c = 10,

    result = (a == b) && (c > b);
    printf("(a == b) && (c > b) is %d \n", result);

    result = (a == b) && (c < b);
    printf("(a == b) && (c < b) is %d \n", result);

    result = (a == b) || (c < b);
    printf("(a == b) || (c < b) is %d \n", result);

    result = (a != b) || (c < b);
    printf("(a != b) || (c < b) is %d \n", result);

    result = !(a != b);
    printf("!(a != b) is %d \n", result);

    result = !(a == b);
    printf("!(a == b) is %d \n", result);

    printf("Size of int=%lu bytes\n",sizeof(v));
    printf("Size of float=%lu bytes\n",sizeof(w));
    printf("Size of double=%lu bytes\n",sizeof(x));
    printf("Size of char=%lu byte\n",sizeof(y));




    return 0;
}
