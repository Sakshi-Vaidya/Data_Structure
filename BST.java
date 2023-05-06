/*

To implement Binary Search Tree and perform operations on it.

Problem Statement:
Create a Dictionary that stores keywords and its meanings, using appropriate data structure.
Implement its operations such as add, delete, display, search and update its values.

*/
import java.util.Scanner;
import java.lang.String;

class Node{
    Node left, right;
    String word, meaning;

    Node(String word){      // empty constructor
        this(word, "");
    }
    
    // constructor of class node
    Node(String word, String meaning){
        left = right = null;
        this.word = word;
        this.meaning = meaning;
    }

    // method to display word and its meaning
    void display(){
        System.out.println("Word: " + this.word + "\tMeaning: " + this.meaning);
    }
}

class BinarySearchTree{
    Scanner sc = new Scanner(System.in);
    Node root;                             // first node of tree

    // construtor of BinarySearchTree
    BinarySearchTree(){                    // empty constructor
        root = null;                       // no nodes in the tree yet
    }
     
    // method to create BST
    void create(){
        String word,meaning;
        char ch;
        do{
            System.out.println("Enter the word: ");
            word = sc.nextLine();
            System.out.println("Enter its meaning: ");
            meaning = sc.nextLine();
            Node temp = new Node(word, meaning);

            if(root == null){        //if the root node is empty
                root = temp;
            }
            else{
                Node ptr = root;
                while(ptr != null){

                    if(temp.word.compareTo(ptr.word) < 0){
                        if (ptr.left == null){
                            ptr.left = temp;
                            break;
                        }
                        else{
                            ptr = ptr.left;
                        }
                    }
                    else if(temp.word.compareTo(ptr.word) > 0){
                        if (ptr.right == null){
                            ptr.right = temp;
                            break;
                        }
                        else{
                            ptr = ptr.right;
                        }
                    }
                    else{
                        System.out.println("Already present");
                        break;
                    }
                }
            }
            System.out.print("\nDo you want to add more nodes ?\nPress 'Y' to continue\nPress 'N' to exit :");
			ch = sc.nextLine().charAt(0);
			System.out.println("");
		} while (ch != 'N' && ch != 'n');
    }

    // method to display the BST
    public void inorder(){
        inorder(this.root);
    }

    private void inorder(Node node){
        if (node != null){
            inorder(node.left);
            node.display();
            inorder(node.right);
        }
    }

    // method to search a word
    void search(){
        System.out.println("Enter the word to search: ");
        String word1 = sc.nextLine();
        Node ptr = root;
        while(ptr != null){

            if(word1.equals(ptr.word)){           // if word is similar to root node
                System.out.println("Found the word.");
                System.out.println("Its Meaning: " + ptr.meaning);
                return;
            }
            else if(word1.compareTo(ptr.word) < 0){        
                ptr = ptr.left;                    // if word is present at left side
            }
            else{
                ptr = ptr.right;                  // if word is present at right side
            }
        }
        System.out.println("Word Not Found!!!");        // if word is not present
    }

    // method to update a word's meaning
    void update(){
        System.out.println("Enter the word to update: ");
        String word1 = sc.nextLine();
        Node ptr = root;
        while(ptr != null){
            if(word1.equals(ptr.word)){
                System.out.println("Enter its meaning: ");
                ptr.meaning = sc.nextLine();
                return;
            }
            else if(word1.compareTo(ptr.word) < 0){
                ptr = ptr.left;
            }
            else{
                ptr = ptr.right;
            }
        }
        System.out.println("Word Not Found");    
    }

    // method to delete a word and it's meaning
    public void delete(){
        System.out.print("Enter the word to delete: ");
        String key = sc.nextLine();
        this.root = delete(this.root, key);
    }

    private Node delete(Node root, String key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key.compareTo(root.word) < 0)
            root.left = delete(root.left, key);
        else if (key.compareTo(root.word) > 0)
            root.right = delete(root.right, key);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            Node temp = getSuccessor(root.right);
            root.word = temp.word;
            root.meaning = temp.meaning;
 
            // Delete the inorder successor
            root.right = delete(root.right, root.word);
        }
         return root;
    }
 
    private Node getSuccessor(Node node)
    {
        String word = node.word;
        String meaning = node.meaning;

        while (node.left != null)
        {
            word = node.left.word;
            meaning = node.left.meaning;
            node = node.left;
        }
        return new Node(word, meaning);
    }
}

public class Main{
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();      // object of BinarySearchTree class
        Scanner sc = new Scanner(System.in);
        int ch;
        do{
            System.out.println("\t\tMENU\n*********************************************\nEnter 1 to create a dictionary\n" +
                               "Enter 2 to search a word\n"  +  
                               "Enter 3 to update dictionary\n" +
                               "Enter 4 to display the dictionary\n" +
                               "Enter 5 to delete a word\n" +
                               "Enter 0 to quit.\n*********************************************");
            System.out.println("Enter the choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            if (ch == 0)
                break;

            switch(ch){
                case 1 :
                    tree.create();         // calling create function
                    break;
                case 2: 
                    tree.search();         // calling search function
                    break;
                case 3:
                    tree.update();         // calling update function
                    break;
                case 4:
                    tree.inorder();        // calling inorder function
                    break;
                case 5:
                    tree.delete();         // calling delete function
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } while(ch!= 0);
        sc.close();
    }
}


