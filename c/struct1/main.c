//wap to declare structure book having data member named book pages ,book price accept this data for three member.
#include <stdio.h>
#include <stdlib.h>
struct book{
    char name[100];
    int page;
    float price;
};
int main()
{
    struct book info[3];
    for(int i=0;i<3;i++)
    {
        printf("enter the name of book:");
        scanf("%s",&info[i].name);
        printf("enter the pages of book:");
        scanf("%d",&info[i].page);
        printf("enter the price of book:");
        scanf("%f",&info[i].price);
    }
    printf("\n-------------------------------------------------------------------------\n");

     for(int j=0;j<3;j++)
    {
         printf("book %d\n",j+1);
        printf("name: %s\n",info[j].name);
         printf("pages: %d\n",info[j].page);
        printf("price: %f\n",info[j].price);
    }
    return 0;
}
