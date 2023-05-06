import java.util.Scanner;

class AccountNode{
	int accNo;
	String name;
	String address;
	Double balance;
	AccountNode next;

	AccountNode(int accNo,String name,String address,Double balance)
	{
		this.accNo = accNo;
		this.name = name;
		this.address = address;
		this.balance = balance;
		this.next = null;
	}
}

class Bank{
	AccountNode head = null;

	void insert_details(int acNo, String name, String address, Double bal)
	{
		AccountNode newNode=new AccountNode(acNo, name, address, bal);
		if(head == null)								//if head node is null assign head to new node
		{
			head = newNode;
		} else{
			AccountNode ptr = head;						//if head is not null traverse till null and add new details
			while(ptr.next != null)
			{
				ptr = ptr.next;
			}
			ptr.next = newNode;
		}
	}

	void delete_details(int accountNo)
	{
		if (head == null){
			System.out.println("No account found!");
		} else {
			AccountNode ptr = head;
			while (ptr != null){
				if(head.accNo == accountNo){			//head node can be deleted 
					head = head.next;
					return;								//if condition comes to true it again and again comes to if so return
				}else if (ptr.next.accNo == accountNo){
					if(ptr.next.next != null){			//while ptr's next node to be deleted check that node is null or not
						ptr.next = ptr.next.next;
						return;
					}else{
						ptr.next = null;				//if node to be delete if its next is null then make ptr next null
						return;
					}
				}else{
					ptr = ptr.next;						//traverse till null
				}
			}
		}
	}
	void display()
	{
		System.out.println("Following is bank record:");
		System.out.println("AccountNo \t\t Name \t\t Address \t\t Balance");
		if(head==null)
		{
			System.out.println("Sorry no data available");
		}
		AccountNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.accNo+" \t\t "+temp.name+" \t\t"+temp.address+" \t\t "+temp.balance);
			temp=temp.next;
		}
	}
	void deposit(int accNo,int amount)					//give account number and amount to deposit
	{
		AccountNode ptr = head;							//set ptr to head
		while(ptr!=null)								//check till ptr not equal to null
		{
			if(ptr.accNo == accNo)						//if our existed account number matches accepted account number
			{
				ptr.balance = ptr.balance+amount;		//balance will increase so it will prev balance plus deposited amount
				System.out.println("Amount deposited succesfully in account number:"+ptr.accNo+"	Name: "+ptr.name+"	Current balance is: "+ptr.balance);
				return;
			}else {
				ptr = ptr.next;
			}
		}
		System.out.println("No such account in our bank.Sorry:)");
	}
	void withdrawl(int accNo,int amt)
	{
		AccountNode ptr = head;
		while(ptr!=null)								//check till ptr not equal to null
		{
			if(ptr.accNo == accNo)						//if our account number matches accepted account number
			{
				ptr.balance = ptr.balance - amt;		//balance will decrease so it will prev balance minus withdrawl amount
				System.out.println("Amount withdrawl succesfully..Current balance is: "+ptr.balance);
				return;
			} else {
				ptr = ptr.next;							//move pointer to next
			}
		}
		System.out.println("No such account in our bank.Sorry:)");
	}
}
public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		int userInput = 0;
		Bank b = new Bank();								//class object should declared outside do while loop cuz object is changing whenever we create new object
		System.out.println("Welcome to Bank !");
		do {
			int userChoice = 0;

			System.out.println("\n1.Create new account \n2.Display \n3.Deposit Amt \n4.Withdraw \n5.Delete Account");
			System.out.println("Enter your choice :");
			userChoice = sc.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("------- Creating new account -------");
				System.out.println("Enter accNo, Name, address, balance");
				b.insert_details(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());			//take inputs from user
				break;
			case 2:
				System.out.println("------- Displaying Accounts -------");
				b.display();
				break;
			case 3:
				System.out.println("------- Deposit amount -------");
				System.out.println("Enter accNo and amount");
				b.deposit(sc.nextInt(), sc.nextInt());
				break;
			case 4:
				System.out.println("------- Withdraw amount -------");
				System.out.println("Enter accNo and amount to be withdrawn");
				b.withdrawl(sc.nextInt(), sc.nextInt());
				break;
			case 5:
				System.out.println("------- Delete account -------");
				System.out.println("Enter accNo to be deleted");
				b.delete_details(sc.nextInt());
				break;
			default:
				System.out.println("You're done!!");
			}
			System.out.println("Do you want to continue? 1:YES 0:NO");
			userInput = sc.nextInt();			
		}while(userInput == 1);
		System.out.println("Bye bye!");
	}
}
