#include<stdio.h>
#include<conio.h>
int main(){
  
  int n,j,i,a[n],*p[n],temp;
  printf("How many elements you want to enter in array?: ");
  scanf("%d",&n);
  printf("enter array members: ");
  for(i=0;i<n;i++)
   {
   	scanf("%d",&a[i]);
   	p[i]=&a[i];
	} 
 
  printf("\n array elements in reverse order are:  ");
  for(i=0;i<=n;i++)
    {
    	 for(j=0;j<=n;j++)
    	 {
    	 	temp=a[j];
    	 	a[j]=a[j+1];
    	 	a[j+1]=temp;
		 }
	}
  for(i=0;i<=n;i++)
  {
  	printf("%d\n",*p[i]);
   } 
return 0;

}
