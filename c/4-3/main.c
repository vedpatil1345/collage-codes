#include <stdio.h>

int main()
{
    char ch;
    printf("Enter any character: ");
    scanf("%c", &ch);
    if((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90))
    {
       if(ch >= 97 && ch <= 122)
        printf("'%c' is capital alphabet.", ch);
       else
        printf("'%c' is small alphabet.", ch);
    }
    else if(ch >= 48 && ch <= 57)
    {
        printf("'%c' is digit.", ch);
    }
    else
    {
        printf("'%c' is special character.", ch);
    }

    return 0;
}
