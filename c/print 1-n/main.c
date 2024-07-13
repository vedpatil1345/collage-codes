#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,n;

    printf("please enter the number:");
    scanf("%d",&n);
    i=1;
    while(i<=n)
    {
        printf("%d\n",i);
        i=i+1;
    }
    return 0;
}
