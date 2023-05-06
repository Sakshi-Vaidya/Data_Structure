/*Graph

Title :To implement graph data structure using adjacency list and adjucency matrix and perform traversals on
it.
 Problem statement : A news paper delivery boy every day drops news paper in a society having many lanes and
houses. Represent this as a graph using adjacency matrix or adjacency list. Perform Depth
First traversal and Breadth First traversal.
 */
import java.util.*;
class Node{
	int data;
	Node next;

	Node(int data)
	{
		this.data=data;
		next=null;
	}
}

class Graph_operation{
	int houses,lanes,src,dest;
	int graph_matrix[][];
	Scanner sc = new Scanner(System.in);
	Node[] head=new Node[10];


	void create() {
		System.out.println("Enter no. of houses = ");//vertices
		houses = sc.nextInt();
		System.out.println("Enter no. of lanes = ");//edges
		lanes = sc.nextInt();
		graph_matrix=new int[houses][houses];

		for (int i=0;i<lanes;i++)
		{
			System.out.println("Enter the source = ");
			src=sc.nextInt();
			System.out.println("Enter the destination = ");
			dest = sc.nextInt();
			graph_matrix[src][dest]=1;
			graph_matrix[dest][src]=1;
		}
	}


	void display()
	{
		System.out.println("\n0 1 2 3\n");
		for(int i=0;i<houses;i++) {
			for(int j=0;j<houses;j++)
			{
				System.out.print(graph_matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	

	void insert(int u,int v)
	{
		Node newnode=new Node(v);
		if(head[u]==null)
		{
			head[u]=newnode;
		}
		else
		{
			Node curr=head[u];
			while(curr.next!=null)
			{
				curr=curr.next;
			}
			curr.next=newnode;
		}
	}

	//bfs using queue for adjacency list...
	void bfs(int str)
	{
		System.out.println("BFS of given graph is : ");
		Queue<Integer>q=new LinkedList<Integer>();

		int visited[]=new int[houses+1];

		for(int i=0;i<houses;i++)
		{
			visited[i]=0;
		}

		q.add(str);
		visited[str]=1;
		System.out.print(str+" ");

		while(!q.isEmpty())
		{
			int a=q.remove();
			Node curr=head[a] ;
			while(curr!=null )
			{
				if(visited[curr.data]!=1)
				{
					q.add(curr.data);
					visited[curr.data]=1;
					System.out.print(curr.data+" ");
				}
				curr=curr.next;
			}

		}
	}

	//dfs using stack for adj matrix
	void dfs(int str)
	{
		System.out.println("DFS of given graph is : ");
		Stack<Integer> st=new Stack<Integer>();
		int []visited=new int [10];

		for(int i=0;i<houses;i++)
		{
			visited[i]=0;
		}

		visited[str]=1;
		st.push(str);

		while(!st.empty())
		{
			int a=st.pop();
			System.out.print(" "+a);
			for(int i=0;i<houses;i++)
			{
				if(graph_matrix[a][i]==1 && visited[i]==0)
				{
					st.push(i);
					visited[i]=1;
				}
			}
		}
	}


}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Graph_operation gp = new Graph_operation();
		
		int ch;
		do {

			System.out.println("\n1.Create graph using matrix\n2.Display graph\n3.Perform BFS\n4.Perform DFS\n5.Exit");
			System.out.println("Enter your choice = ");
			ch=sc.nextInt();

			switch(ch) {

			case 1:
				gp.create();
				break;

			case 2:
				gp.display();
				break;

			case 3:
				System.out.println("Enter the starting vertex = ");
				int str = sc.nextInt();
				gp.bfs(str);
				break;

			case 4:
				System.out.println("Enter the starting vertex = ");
				int stv = sc.nextInt();
				gp.dfs(stv);
				break;
			}
		}while(ch!=0);
		if(ch==0)
        {
            System.out.println("\nThank you !");
        }
	}

}
