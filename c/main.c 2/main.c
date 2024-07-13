#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i=1,num;
    long fac=1;
    printf("\nEnter any number : ");
    scanf("%d",&num);
    while(i<=num)
    {
        fac=fac*i;
        i++;
    }

    printf("The factorial of number %d is : %d",num,fac);
    return 0;
}
