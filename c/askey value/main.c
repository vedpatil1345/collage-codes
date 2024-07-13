#include <stdio.h>
#include <math.h>

int main()
{
    char ch;
    printf("Enter any character: ");
    scanf("%c", &ch);
    if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
    {
       if(ch >= 'A' && ch <= 'Z')
        printf("%c=%d", ch,ch);
       else
        printf("%c=%d",ch ,ch);
    }
    else if(ch >= '0' && ch <= '9')
    {
        printf("'%c'= %d", ch,ch);
    }
    else
    {
        printf("invalid");
    }

    return 0;
}
