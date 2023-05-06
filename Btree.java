/*
 Title :To implement Binary Tree and perform recursive and non-recursive traversals on it.
 Problem statement : Create a binary tree and perform in order,pre order and post order traversals.
 */
import java.util.Scanner;
import java.util.Stack;

class Node{
	Node left;	
	Node right;
	int data;
	Node root;
	
	Node(int data)
	{
		this.data = data;
	}
}
public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
	    Node root = null;
		int ch = 0;
		do {
			int user = 0;
			System.out.println("Enter \n 1 for creating a tree \n 2 for inorder \n 3 for preorder \n 4 for postorder:");
			user = sc.nextInt();
			switch(user)
			{
			case 1:
				System.out.println("--------Creating a tree------------");
				root = createTree();
				break; 	
			case 2:
				System.out.println("--------InOrder---------");
				inOrder(root);
				break;
			case 3:
				System.out.println("--------PreOrder---------");
				preOrder(root);
				break;
			case 4:
				System.out.println("--------PostOrder---------");
				postorder_nonrecursive(root);
				break;
			}System.out.println("\n Do you want to continue? Enter 1 for yes and 0 for no:");
			ch = sc.nextInt();
		}while(ch==1);
	System.out.println("Thank You !!");	
	}
	
	static Node createTree()
	{
		Node root = null;
		int data;
		System.out.println("Enter data:");
		data = sc.nextInt();
		if(data == -1)
		{
			return null;
		}
		root = new Node(data);
		
		System.out.println("Going left to "+data);
		root.left = createTree();
		
		System.out.println("Going right to "+data);
		root.right = createTree();
		
		return root;
	}
	
	static void inOrder(Node root)
	{
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	static void preOrder(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
//	static void postOrder(Node root)
//	{
//		if(root == null)
//		{
//			return;
//		}
//		postOrder(root.left);
//		postOrder(root.right);
//		System.out.print(root.data+" ");
//	}
	 static void postorder_nonrecursive(Node root)
	{
		if (root==null)
		{
			System.out.println("The tree is empty.\n");
			return;
		}
		System.out.println("Non-recurisve post order traversal of the tree:");
		Stack <Node> s1 = new Stack<Node>();
		Stack <Integer> s2 = new Stack<Integer>();
		s1.push(root);
		while(!s1.isEmpty())
		{
			Node ptr = s1.pop();
			s2.push(ptr.data);
			if (ptr.left!=null)
			{
				s1.push(ptr.left);
			}
			if (ptr.right!= null)
			{
				s1.push(ptr.right);
			}
		}
		while (!s2.isEmpty())
		{
			System.out.print(s2.pop() + " ");
		}
	}
}
