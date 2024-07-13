#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b;
    float f;
    char c;

    printf("enter numbers\n\n");
    scanf("%d%d",&a,&b);
    printf("you have entered %d, %d\n\n\n",a,b);
    printf("enter the fraction number\n\n\n");
    scanf("%f",&f);
    printf("you have entered %f\n\n\n\n",f);
    printf("print a alphabate\n\n\n");
    scanf("%s",&c);
    printf("you have entered %s\n",c);
    return 0;
}
