package practice;
import java.util.Scanner;

class ThreadedNode{
	int data;
	ThreadedNode left,right;
	boolean isLeft,isRight;
	ThreadedNode(int data){
		this.data=data;
		left=right=null;
		isLeft=isRight=true;
	}
}

public class Threaded {
	
	ThreadedNode root;
	Threaded(){
		root=null;
	}
	public void insertThreaded(int data) {
		root=insertRecT(root,data);
	}
	public ThreadedNode insertRecT(ThreadedNode node,int data) {
		if(node==null) {
			return new ThreadedNode(data);
		}
		if(data<node.data) {
			if(node.isLeft) {
				ThreadedNode newnode=new ThreadedNode(data);
				newnode.left=node.left;
				newnode.right=node;
				node.left=newnode;
				node.isLeft=false;
			}
			else {
				node.left=insertRecT(node.left,data);
			}
		}
		else if(data>node.data) {
			if(node.isRight) {
				ThreadedNode newnode=new ThreadedNode(data);
				newnode.right=node.right;
				newnode.left=node;
				node.right=newnode;
				node.isRight=false;
			}
			else {
				node.right=insertRecT(node.right,data);
			}
		}
		else {
			System.out.println("Data Already Present");
		}
		return node;
	}
	public ThreadedNode leftmost(ThreadedNode node) {
		while(node!=null && !node.isLeft) {
			node=node.left;
		}
		return node;
	}
	public void inorderT() {
		ThreadedNode current=leftmost(root);
		System.out.println("Inorder Traversal As Follows:");
		while(current!=null) {
			System.out.print(current.data+" ");
			if(current.isRight) {
				current=current.right;
			}
			else {
				current=leftmost(current.right);
			}
		}
	}
	
	public ThreadedNode rightmost(ThreadedNode node) {
		while(node!=null && !node.isRight) {
			node=node.right;
		}
		return node;
	}
	public void reverse() {
		ThreadedNode current=rightmost(root);
		System.out.println("Reverse Inorder Traversal As Follows:");
		while(current!=null) {
			System.out.print(current.data+" ");
			if(current.isLeft) {
				current=current.left;
			}
			else {
				current=rightmost(current.left);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Threaded p=new Threaded();
		int choice;
		do {
			System.out.println("Select:");
			System.out.println("1.Insert");
			System.out.println("2.Inorder");
			System.out.println("3.Reverse");
			System.out.println("4.Exit");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter:");
				int data=sc.nextInt();
				sc.nextLine();
				p.insertThreaded(data);
				break;
			
			case 2:		
				p.inorderT();
				break;
				
			case 3:
				p.reverse();
				break;
				
			case 4:
				System.out.println("Exited PhoneBook");
				break;
				
			default:
				System.out.println("Invalid Choice");
				
			}
			}while(choice!=4);
		sc.close();
		
	}
	
	}


