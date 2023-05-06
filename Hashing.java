/*
Hashing
*/

import java.util.*;
class Node1
    {
	long id;
	String name;
	int balance;
	Node1(long id,String name,int bal){
		this.id=id;
		this.name=name;
		this.balance=bal;
	}
}
class Table{
	Scanner sc=new Scanner(System.in);
	int i;
	int tablesize=10;
	Node1 hashtable[]=new Node1[tablesize];
	
	void hash() 
	{
	    int count=0;
	    for(int i=0;i<tablesize;i++)
	    {
	        if(hashtable[i]!=null)
	        {
	            count=count+1;
	        }
	    }
	    if(count==10)
	    {
	        System.out.println("Table is full");
	        return;
	    }
		System.out.println("Enter the number of customers: ");
		int n=sc.nextInt();
		boolean flag=false;
		for(int i=0;i<n;i++) {
			System.out.println("Enter the name: ");
			String name=sc.next();
			System.out.println("Enter id: ");
			int id=sc.nextInt();
			System.out.println("Enter balance: ");
			int bal=sc.nextInt();
			
			Node1 newnode=new Node1(id,name,bal);
			int a=(id%tablesize);
			while(hashtable[a]!=null) {
				flag=true;
				a=(a+1)%tablesize;
			}
			hashtable[a]=newnode;
			if(flag) {
				System.out.println("Collision occurred!");
			}
			
		}
	}
	void display() {
		for(int i=0;i<10;i++) {
			System.out.println("======= Customer "+i+"=======");
			if(hashtable[i]==null) {
				System.out.println("Customer id: ");
				System.out.println("Customer name: ");
				System.out.println("Total balance: ");
				}
			else if(hashtable[i]!=null) {
				System.out.println("Customer id: "+hashtable[i].id);
				System.out.println("Customer name: "+hashtable[i].name);
				System.out.println("Total balance: "+hashtable[i].balance);
				
			}
		}
	}
	Node1 search() {
		System.out.println("Enter the customer Id to be searched: ");
		int id=sc.nextInt();
		int a=(id%tablesize);
		while(hashtable[a]!=null) {
			if(hashtable[a].id==id) {
				System.out.println("Id found!");
//                System.out.println("Customer name:-"+hashtable[a].name);
//                System.out.println("Customer balance:-"+hashtable[a].balance);
                return hashtable[a];            
                }
        }
        a=(a+1)%tablesize;
        return null;
    }
    Node1 delete() {
    	System.out.println("Enter the customer id to delete :-");
    	int id=sc.nextInt();
    	int a=(id%tablesize);
    	Node1 dummyitem=null;
    	while(hashtable[a]!=null) {
    		if(hashtable[a].id==id) {
    			Node1 temp= hashtable[a];
    			hashtable[a]=dummyitem;
    			System.out.println("Customer details deleted");
    		}
    		++a;
    		a%=tablesize;
    	}
    	return null;
    	
    }
   
}
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int ch;
        int op;
        Table t=new Table();
        
            do{
                 System.out.println("***** MENU FOR HASHING ******");
                System.out.println("1.Create\n2.Display\n3.Search\n4.Delete\n5.Exit\nEnter your choice: ");
                ch=sc.nextInt();
                switch(ch){
                    case 1:
                        t.hash();
                        break;
                    case 2:
                        t.display();
                        break;
                    case 3:
                        t.search();
                        break;
                    case 4:
                    	t.delete();
                    	break;
                    case 5:
                    	System.out.println("Thank you!");
                    	break;
                    default:
                        System.out.println("Invalid choice!");
                }System.out.println("Press 1 to continue and press 0 to exit");
                 op=sc.nextInt();
            }while(op==1);
        
    }
}

