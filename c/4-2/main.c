#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c;
    printf("enter three numbers\n");
    scanf("%d%d%d",&a,&b,&c);
    if (a>b)
    {
    if (a>c)
        printf("%d is bigest number/n",a);
    else
        printf("%d is bigest number/n",c);

    }
    else
    {
        if (b>c)
            printf("%d is bigest number/n",b);
        else
            printf("%d is bigest number/n",c);

    }

    return 0;
}
