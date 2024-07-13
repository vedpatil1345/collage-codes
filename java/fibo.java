import java.util.Scanner;
public class fibo{
public static void main(String[] args){
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter leanght of series:");
	int a= sc.nextInt();
	int f1=0,f2=1,f3;
	System.out.print(f1 +" "+ f2);
	for(int i=1;i<a-1;i++){
	f3=f1+f2;
	f1=f2;
	f2=f3;
	System.out.print(" " + f3);
	}
	
}}