#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,num;
    long fac=1;
    printf("\n please enter the number to find factorial");
    scanf ("%d",&num);
    for (i=1;i<=num;i++)

{

fac=fac*i;
}
printf ("\n factorial of %d = %d",num,fac);

    return 0;
}
