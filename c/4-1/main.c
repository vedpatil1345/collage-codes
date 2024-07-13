#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a;
    printf("enter the number\n");
    scanf("%d",&a);
    if (a>0)
        printf("entered number is positive\n");
    else if (a<0)
        printf("entered number is negative\n");
    else
        printf("entered number is 0");
    return 0;
}
