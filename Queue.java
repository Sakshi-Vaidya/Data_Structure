/*
  Title: Implementation of Queue using array or linked list.

Problem Statement:
Implement Queue as ADT using linked list or array. Use Queue ADT to simulate Pizza
delivery operations for a 'Pizza Parlor system'.
*/
import java.util.*;

class Pizza
{
    String pizzaname;
    char size;   //s=small  m=medium  l=large
    int price;
}

class PizzaParlour
{
    Scanner sc=new Scanner(System.in);
    int front,rear,size,total;
    
    Pizza order_list[];
    
    public PizzaParlour(int q_size)
    {
        front=0;
        rear=0;
        size=q_size;
        total=0;
        //q_size=50;
        order_list=new Pizza[q_size];
    }
    
    boolean isFull()
    {
        if(rear==size)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    boolean isEmpty()
    {
        if(front==rear)
        {
            return true;
        }
        else
        {
            return false;  
        }
    }
    
    void placeOrder()   //Enqueue
    {
        total=0;
        order_list=new Pizza[50];
        if(isFull()==true)
        {
            System.out.println("\nOrders are full.Please wait.Sorry for the inconvenience");
        }
        else
        {
                    System.out.println("******************** MENU ********************");
                    System.out.println("Pizza\t\t\tQuantity\t\tPrice\t\t\nMargerita\t\tsmall\t\t\t99\n         \t\tmedium\t\t\t199\n         \t\tlarge\t\t\t299");
                    System.out.println("**************************************************");
                    System.out.println("Pizza\t\t\tQuantity\t\tPrice\t\t\nOnion\t\tsmall\t\t199\n         \t\tmedium\t\t\t299\n         \t\tlarge\t\t\t399");
                    System.out.println("**************************************************");
                    System.out.println("Pizza\t\t\tQuantity\t\tPrice\t\t\nTomato\t\t\tsmall\t\t\t299\n         \t\tmedium\t\t\t399\n         \t\tlarge\t\t\t499");
                    System.out.println("**************************************************");
                    System.out.println("Enter the number of pizzas you wish to order -");
                    int pn=sc.nextInt();
                    for(int i=1;i<=pn;i++)
                    {
                        Pizza a1=new Pizza();
                        System.out.println("Enter pizza you want to order-");
                        a1.pizzaname=sc.next();
                        //str1.equals(str2);
                        if(a1.pizzaname.equalsIgnoreCase("Margerita"))
                        {
                                System.out.println("Enter the pizza size you wish to order-(s=small,m=medium,l=large)");
                                a1.size=sc.next().charAt(0);
                                if((a1.size=='s')||(a1.size=='m')||(a1.size=='l'))
                                {
                                    if(a1.size=='s')
                                    {
                                        a1.price=99;
                                    }
                                    else if(a1.size=='m')
                                    {
        
                                        a1.price=199;
                                    }
                                    else if(a1.size=='l')
                                    {
                                        a1.price=299;
                                    }
                                    order_list[rear++]=a1;
                                }
                                else
                                {
                                    System.out.println(a1.size+" size is not available.Please try again.");
                                    break;
                                }
                        }
                        else if(a1.pizzaname.equalsIgnoreCase("Onion and green capsicum"))
                        {
                                System.out.println("Enter the pizza size you wish to order-(s=small,m=medium,l=large)");
                                a1.size=sc.next().charAt(0);
                                if((a1.size=='s')||(a1.size=='m')||(a1.size=='l'))
                                {
                                    if(a1.size=='s')
                                    {
                                        a1.price=199;
                                    }
                                    else if(a1.size=='m')
                                    {
                                        a1.price=299;
                                    }
                                    else if(a1.size=='l')
                                    {
                                        a1.price=399;
                                    }
                                    order_list[rear++]=a1;
                                }
                                else
                                {
                                    System.out.println(a1.size+" size is not available.Please try again.");
                                    break;
                                }
                                
                        }
                        else if(a1.pizzaname.equalsIgnoreCase("Tomato"))
                        {
                                System.out.println("Enter the pizza size you wish to order-(s=small,m=medium,l=large)");
                                a1.size=sc.next().charAt(0);
                                if((a1.size=='s')||(a1.size=='m')||(a1.size=='l'))
                                {
                                    if(a1.size=='s')
                                    {
                                        a1.price=299;
                                    }
                                    else if(a1.size=='m')
                                    {
                                        a1.price=399;
                                    }
                                    else if(a1.size=='l')
                                    {
                                        a1.price=499;
                                    }
                                    order_list[rear]=a1;
                                    rear++;
                                }
                                else
                                {
                                    System.out.println(a1.size+" size is not available.Please try again.");
                                    break;
                                }
                                
                        }
                        else
                        {
                            System.out.println(a1.pizzaname+" pizza is not available.Please try again.");
                            break;
                        }
                        total=total+a1.price;
                        displayOrder();
                        System.out.printf("\n___________________\nTotal amount - %d\n\n",total);
                        System.out.println("Thank you for ordering ! Your order will be delivered shortly.");
                        
                               
                    }
                    
        }
    }
    
    void deliverOrder()  //Dequeue
    {
        if(isEmpty()==true)
        {
            System.out.println("All the orders are successfully delivered.There are no orders to be delivered.Thank you!");
        }
        else
        {
            for(int j=front;j<rear;j++)
                        {
                            if(j==0)
                            {
                                System.out.println("\nDelivered items are -");
                            }
                            System.out.printf("\n%d pizza name-%s\nPizza size-%c\nPizza price-%d\n",j+1,order_list[j].pizzaname,order_list[j].size,order_list[j].price);
                            front++;
                        }
                        System.out.printf("\n___________________\nTotal amount paid- %d\n\n",total);
                        total=0;
        }
    }
    
    
    void displayOrder()   //all the orders present in the Queue
    {
        //front=0;
        for(int i=front;i<rear;i++)
        {
            if(i==0)
            {
                System.out.println("\nOrdered items are -");
            }
            System.out.printf("\n%d pizza name-%s\nPizza size-%c\nPizza price-%d\n",i+1,order_list[i].pizzaname,order_list[i].size,order_list[i].price);
        }
    }
   
} 

public class Main
{
    public static void main (String[] args)
    {
        PizzaParlour p=new PizzaParlour(50);
        Pizza a1=new Pizza();
        Scanner sc=new Scanner(System.in);
        
        int x=1,ch=0;
        do{
            System.out.println("\n**********MENU**********\n1.Place order for pizza\n2.Deliver order of pizza\n");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    {
                        p.placeOrder();
                        break;
                    }
                case 2:
                    {
                        p.deliverOrder();
                        break;
                    }
                default:
                    System.out.println("\nINVALID INPUT");
            }
            System.out.println("\nDo you want to continue ?\nPress 1 to continue\nPress 0 to exit\n");
			x=sc.nextInt();
        }while(x!=0);
        if(x==0)
        {
            System.out.println("\nThank you !\nVisit again soon !!!!!!!!!!!\n\n");
        }
    }
}
