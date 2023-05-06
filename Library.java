/*  
Title: Library Book data maintenance
Problem Statement:
College Library maintains records of books. Write a program using JAVA for following operations :
1.Add a new book details.
2.Search a book in library.
3.Sort books based on ISBN numbers.
4.List all books of specific author.
Use appropriate data structure.*/


import java.util.*;

class Book{
	String book_name;
	String book_author;
	int book_ISBN;
	
	Book()
	{
		book_name=" ";
		book_author=" ";
		book_ISBN=0;
	}
}
class Library{
	Book book[]=new Book[50];	//array of book
	Scanner sc=new Scanner(System.in);
	
	void accept_book_details(int n)
	{
		for(int i=0;i<n;i++)
		{
			book[i]=new Book();
			System.out.println("Enter book name:");
			book[i].book_name=sc.next();
			System.out.println("Enter author name:");
			book[i].book_author=sc.next();
			System.out.println("Enter ISBN number:");
			book[i].book_ISBN=sc.nextInt();
		}
	}
	void display_book_details(int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("Book name:"+book[i].book_name);
			System.out.println("Book author:"+book[i].book_author);
			System.out.println("Book ISBN:"+book[i].book_ISBN);
		}
	}
	void search_by_ISBN(int n)
	{
		int ISBN;
		System.out.println("Enter ISBN no:");
		ISBN=sc.nextInt();
		for(int i=0;i<=n;i++)
		{
			if(book[i].book_ISBN==ISBN)
			{
				//System.out.println("Book found at index:"+i+1+"	Book name:"+book[i].book_name+"	Book author:"+book[i].book_author+"Book ISBN:"+book[i].book_ISBN);
				System.out.println("Book found");
				return;
			}
		}
		System.out.println("Not found");
	}
	
	void searchByAuthor(int n) {
        int x=0;
        System.out.println("\nEnter author's name : ");
        String an = sc.next();
        //Sequential search 
        for(int i=0;i<n;i++) {

            if(book[i].book_author.contains(an)) {
                x++;
                if(x==1) {
                    System.out.println("\nBooks written by "+an+" are : ");
                }
                System.out.println(book[i].book_name);
            }
        }
        if(x==0) {
            System.out.println("No books found !\n");
        }
    }
	
	void sort_isbn(int n)
	{
		int temp=0;
		for(int i=0;i<n-1;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(book[i].book_ISBN>book[j].book_ISBN)
				{
					temp=book[i].book_ISBN;
					book[i].book_ISBN=book[j].book_ISBN;
					book[j].book_ISBN=temp;
				}
			}
		}
		System.out.println("Displaying sorted isbn list");
		for(int i=0;i<n;i++)
		{
			System.out.println(book[i].book_ISBN);
		}
	}
}
public class Main {
	public static void main(String[] args)
	{
		Library l=new Library();
		Scanner sc=new Scanner(System.in);
		int choice,k;
		int n=0;
		do
		{
			System.out.println(" 1:Enter details\n 2:Display details\n 3:Search book by ISBN\n 4:Search Book by Author\n 5:Sort books");	
			System.out.println("Enter Your Choice: ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter number of books:");
				k=sc.nextInt();
				l.accept_book_details(k);
				break;
			case 2:
				System.out.println("Enter number of books:");
				k=sc.nextInt();
				l.display_book_details(k);
				break;
			case 3:
				System.out.println("Enter number of books:");
				k=sc.nextInt();
				l.search_by_ISBN(k);
				break;
			case 4:
				System.out.println("Enter number of books:");
				k=sc.nextInt();
				l.searchByAuthor(k);
				break;
			case 5:
				System.out.println("Enter number of books:");
				k=sc.nextInt();
				l.sort_isbn(k);
				break;
			default:
				System.out.println("Please enter valid choice");
			}
			System.out.println("Enter 1 to repeat and 0 to stop:");
			n=sc.nextInt();
		}while(n!=0);
		System.out.println("Visit Again!!! Thank You...!!");
	}
}
