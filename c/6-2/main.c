#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a=0,b=1,c,i,num;
    printf("enter the number of elements:");
    scanf("%d",&num);
    printf("\n %d \n %d \n",a,b);
    for(i=2;i<num;++i)
    {
        c=a+b;
        printf(" %d \n",c);
        a=b;
        b=c;
    }
    return 0;
}
