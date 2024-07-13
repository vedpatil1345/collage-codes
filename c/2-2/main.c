#include<stdio.h>
#include<math.h>
main(){


         int a,b,c;
         float s,area;
         printf("Enter sides of triangle");
         scanf("%d%d %d",&a,&b,&c);
         s=(float)(a+b+c)/2;
         area=(float)(sqrt(s*(s-a)*(s-b)*(s-c)));
         printf("Area of Triangle is %f",area);

         float side;
         printf("Enter Sides of Square");
         scanf("%f",&side);
         area=(float)side*side;
         printf("Area of Square is %f",area);


         float radius;
         printf("Enter Radius of Circle");
         scanf("%f",&radius);
         area=(float)3.14159*radius*radius;
         printf("Area of Circle %f",area);


         float len,breadth;
         printf("Enter Length and Breadth of Rectangle:");
         scanf("%f %f",&len,&breadth);
         area=(float)len*breadth;
         printf("Area of Rectangle is %f",area);

         float base,height;
         printf("Enter base and height of Parallelogram");
         scanf("%f %f",&base,&height);
         area=(float)base*height;
         printf("Enter area of Parallelogram is %f",area);

}
