import java.util.Scanner;
public class cmdcalc{
public static void main(String[] args){
	int a,b;
	char ch;
	a=Integer.parseInt(args[0]);

	b=Integer.parseInt(args[2]);
	
	ch=args[1].charAt(0);
	switch(ch)
	{
	case '+':
	System.out.print(a);
	System.out.print(ch);
	System.out.print(b);
	System.out.print("="+(a+b));
	break;
	case '-':
	System.out.print(a);
	System.out.print(ch);
	System.out.print(b);
	System.out.print("="+(a-b));
	break;
	case '*':
	int m = a*b;
	System.out.print(a);
	System.out.print(ch);
	System.out.print(b);
	System.out.print("="+Math.multiplyExact(a,b));
	break;
	case '/':
	System.out.print(a);
	System.out.print(ch);
	System.out.print(b);
	System.out.print("="+(a/b));
	break;
	default:
	System.out.println("please enter valid operand;");
	}
}
}