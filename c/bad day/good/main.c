#include <stdio.h>
#include <stdlib.h>

int main()
{
    int  time;
    printf("enter the time\n");
    scanf("%d",&time);
    if (time<30)
        printf("good day");
    else
        printf("bad day");
    return 0;
}
