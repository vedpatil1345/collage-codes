//create a structure employee with name,age,id,as data member.
#include <stdio.h>
#include <stdlib.h>
struct employee{
    char name[100],id[100];
    int age;
    };
    int main()
        {
            struct employee ved,*v;
            v=&ved;
            printf("enter the name of employee:");
            scanf("%s",&v->name);
            printf("enter the age:");
            scanf("%d",&v->age);
            printf("enter the id:");
            scanf("%s",v->id);
            printf("\n-------------------------------------------------------------------------\n");
            printf("name: %s\n",v->name);
            printf("age: %d\n",v->age);
            printf("id: %s\n",v->id);
            return 0;
        }

