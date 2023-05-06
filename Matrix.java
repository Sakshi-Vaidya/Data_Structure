Title: Matrix Operations using 2-dimensional Array.
Objectives:
1. To understand the standard linear data structure using sequential
organization
2. To learn various operations on arrays as sequential data structure
Outcome:
1.Select linear data structures for given problem.
2.Implement the solution for the given problem using programming
langugage.

Problem Statement:
Write java program to perform following operations on matrices:
1. Check matrix is square matrix .
2. Check matrix is upper triangular.
3. Compute transpose of matrix .
4. Add two matrices .
5. Multiply two matrices.


/* Assignment 1
 Name: Vaidya Sakshi Ravindra
 Roll no: UCE2022003 
 Batch: A4
 */
import java.util.*;
class Matrix{
	Scanner scan = new Scanner (System.in);
	int i, j, r, c, r1, c1;
	int row, column;
	int arr1[][];
	int arr2[][];
	int arr3[][];
	void accept ()
	{
		System.out.println ("Enter number of rows :");
		row = scan.nextInt ();
		System.out.println ("Enter number of columns :");
		column = scan.nextInt ();
		arr1 = new int[row][column];
		System.out.println ("Enter elements :");
		for (i = 0; i < row; i++)

			for (j = 0; j < column; j++)
				arr1[i][j] = scan.nextInt ();
	}
	void display ()
	{
		System.out.println ("\nElements of array are - ");
		for (i = 0; i < row; i++)
		{
			for (j = 0; j < column; j++)
				System.out.print (arr1[i][j] + " ");
			System.out.println ();
		}
		System.out.println ("\n");
	}
	void square ()
	{
		if (i == j)
			System.out.println ("\nThe given matrix is a square matrix .");
		else
			System.out.println ("\nThe given matrix is not a square matrix .");
	}
	void upper ()
	{

		int isUpper = 1;
		if (i == j)
		{
			for (i = 0; i < row; i++)
			{
				for (j = 0; j < column; j++)
				{
					if((j<i) && (arr1[i][j]!=0))
						isUpper = 1;
					else
						isUpper = 0;
				}
			}
			if (isUpper == 1)
				System.out.println ("\nThe given matrix is not an Upper triangle .");
			else
				System.out.println ("\nThe given matrix is an Upper triangle . ");

		}
		else
			System.out.println ("\nThe given matrix is not an Upper triangle . ");
	}
	void transpose ()

	{
		for (i = 0; i < column; i++)
		{
			for (j = 0; j < row; j++)
			{
				System.out.print (arr1[j][i] + " ");
			}
			System.out.println ();
		}
	}
	void add ()
	{
		System.out.println
		("\nEnter the details for the second matrix (they should match the dimensions of previous matrix)");
		System.out.println ("Enter number of rows : ");
		r = scan.nextInt ();
		System.out.println ("Enter number of columns : ");
		c = scan.nextInt ();
		if(r==row&&c==column){
			arr2 = new int[r][c];
			System.out.println ("Enter elements - ");

			for (i = 0; i < row; i++)
			{
				for (j = 0; j < column; j++)
				{
					arr2[i][j] = scan.nextInt ();
				}
			}
			int[][] c = new int[row][column];
			for (i = 0; i < row; i++)
			{
				for (j = 0; j < column; j++)
				{
					c[i][j] = arr2[i][j] + arr1[i][j];
					System.out.print (c[i][j] + " ");
				}
				System.out.println ();
			}
		}else
			System.out.println("\nInvalid matrix");
	}
	void multiply ()
	{

		System.out.println ("\nEnter the details for the second matrix :");
		System.out.println ("Enter number of rows : ");
		r1 = scan.nextInt ();
		System.out.println ("Enter number of columns : ");
		c1 = scan.nextInt ();
		if (column == r)
		{
			arr3 = new int[r][c];
			System.out.println ("Enter elements - ");
			for (i = 0; i < r; i++)
			{
				for (j = 0; j < c; j++)
				{
					arr3[i][j] = scan.nextInt ();
				}
			}
			int ch[][]=new int[row][c];
			for (int i = 0; i < row; i++)
			{
				for (int j = 0; j < c; j++)
				{
					ch[i][j] = 0;

					for (int k = 0; k < r; k++)
					{
						ch[i][j] += arr1[i][k] * arr3[k][j];
					}
					System.out.print (ch[i][j] + " ");
				}
				System.out.println ();
			}
		}
		else
			System.out.println ("\nInvalid matrix");
	}
}
public class Main
{
	public static void main (String args[])
	{
		Scanner sc = new Scanner (System.in);
		Matrix obj = new Matrix ();
		obj.accept ();
		obj.display ();
		int fav;

		fav = 0;
		do
		{
			System.out.println ("\nEnter your choice");
			System.out.println ("1.Check if matrix is square matrix.");
			System.out.println ("2.Check if matrix is upper triangular.");
			System.out.println ("3.Compute transpose of the matrix.");
			System.out.println ("4.Add two matrices.");
			System.out.println ("5.Multiply two matrices.");
			int choice = sc.nextInt ();
			switch (choice)
			{
			case 1:
				obj.square ();
				break;
			case 2:obj.upper ();
			break;
			case 3:obj.transpose ();
			break;
			case 4:obj.add ();
			break;
			case 5:obj.multiply ();

			break;
			}
			System.out.println ("\nDo you want to continue?");
			System.out.println ("Press 1 to continue.");
			System.out.println ("Press 2 to end.");
			fav = sc.nextInt ();
		}
		while (fav == 1);
		if (fav == 2)
			System.out.println ("THANK YOU");
	}
}
