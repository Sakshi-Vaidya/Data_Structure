/*
Title: Implementation of Stack using array or linked list.

Problem Statement:
Implement Stack as ADT using linked list or array. Use same ADT to
evaluate given expression and reverse a given string.
*/
import java.util.Scanner;
class stack {

	int max_size;
	int[] stk;
	int top;
	int r;
	int i;

	stack(int s)
	{
		max_size=s;
		stk=new int [max_size];
		top=-1;
	}

	void is_full()
	{
		if (top == max_size-1)
		{
			System.out.println("Stack Overflow !");
		}
		else
		{
			System.out.println("Stack Underflow !");
		}
	}

	void is_empty()
	{
		if (top == -1)
		{
			System.out.println("Stack Underflow !");
		}
		else
		{
			System.out.println("Stack overflow !");
		}
	}

	void push(int Element)
	{
		if (top == max_size-1)
		{
			System.out.println("Stack Overflow !");
		}
		else
		{
			top = top+1;
			stk[top]= Element;

		}
	}

	int pop()
	{
		if ( top == -1)
		{
			System.out.println("Stack Underflow !");
			return 0;
		}
		else
		{

			return stk[top--];
		}
	}
	char pop_str()
	{
		if ( top == -1)
		{
			System.out.println("Stack Underflow !");
			return 0;
		}
		else
		{
			return (char)stk[top--];
		}
	}

	void evaluate(String ip_expression)
	{
		int length = ip_expression.length();
		for (int i = 0; i< length ; i++)
		{
			char ch = ip_expression.charAt(i);
			if (Character.isDigit(ch))
			{
				push(Character.getNumericValue(ch));
			}

			else
			{
				int op2 = pop();
				int op1 = pop();

				switch (ip_expression.charAt(i))
				{
				case '+':
					r = op1 + op2;
					push (r);
					break;
				case '-':
					r = op1 - op2;
					push (r);
					break;
				case '*':
					r = op1 * op2;
					push (r);
					break;
				case '/':
					r = op1 / op2;
					push (r);
					break;

				default:
					System.out.println("\nType not found !");
					break;
				}

			}
		}
		System.out.print("\nThe evaluation of the given postfix expression : "+pop());
	}

	void reverse()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string : ");
		String str = sc.next();
		int len = str.length();

		for (int i=0; i<len ;i++ )
		{
			push(str.charAt(i));
		}

		while(top == -1)
		{
			System.out.println("\nStack is empty !");
		}
		System.out.print("\nThe reverse string is : ");
		for(int i=0;i<len ;i++)
		{
			System.out.print(pop_str());
		}
	}
}

public class Main
{
	public static void main (String[]args)
	{
		int max_size ;
		String postfix_exp;

		Scanner scn = new Scanner(System.in);

		System.out.print("Enter the max size of stack : ");
		max_size = scn.nextInt();

		stack stk = new stack( max_size);
		stk.push(2);
		stk.is_full();
		stk.pop();
		stk.is_empty();

		int ans ;
		do
		{
			//stack stk1 = new stack( max_size);

			System.out.println("\nStack operations: " );
			System.out.println("1.To evaluate a postfix expression. " );
			System.out.println("2.To reverse a expression. " );
			System.out.print("Enter your choice : " );
			int choice = scn.nextInt();
			switch(choice)
			{
			case 1:
				System.out.print("Enter the postfix expression to be evaluated : ");
				postfix_exp = scn.next();
				stk.evaluate(postfix_exp);
				break;
			case 2:
				stk.reverse();
				break;
			default:
				System.out.println("Invalid choice !");
			}
			System.out.print("\nWould you like to continue? (If yes,enter 1)");
			ans = scn.nextInt();
		}while(ans!= 0);
		System.out.println("Thank Tou !!!");
	}
}
