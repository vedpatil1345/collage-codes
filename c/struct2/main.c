//create structure array of 5 person named person that would contain name , date of joining, salary.

#include <stdio.h>
#include <stdlib.h>
struct person{
    char name[100],date[50];
    float salary;
};
int main()
{
    struct person info[5];
    for(int i=0;i<5;i++)
    {
        printf("enter the name of person:");
        scanf("%s",&info[i].name);
        printf("enter the date of joining of person:");

        scanf("%s",&info[i].date);
        printf("enter the salary of person:");
        scanf("%f",&info[i].salary);
    }
    printf("\n-------------------------------------------------------------------------\n");

     for(int j=0;j<5;j++)
    {
         printf("person %d\n",j+1);
        printf("name: %s\n",info[j].name);
         printf("date of joining: %s\n",info[j].date);
        printf("salary: %f\n",info[j].salary);
    }
    return 0;
}
