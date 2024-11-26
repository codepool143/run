package practice;
import java.util.Scanner;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}

public class stack {
	
	Node top;
	stack(){
		top=null;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public void push(int data) {
		Node newnode=new Node(data);
		if(isEmpty()) {
			top=newnode;
			System.out.println(data+ " is pushed successfully");
			return;
		}
		newnode.next=top;
		top=newnode;
		System.out.println(data+ " is pushed successfully");
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty nothing to pop");
			return -1;
		}
		int p=top.data;
		top=top.next;
		System.out.println(p+" is popped successfully");
		return p;
	}
	
	public void display() {
		System.out.println("Stack is as Follows:");
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		Node temp=top;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		stack s=new stack();
		int choice;
		do {
			System.out.println("Select:");
			System.out.println("1.Push");
			System.out.println("2.Pop");
			System.out.println("3.Display");
			System.out.println("4.exit");
			System.out.println();
			choice=sc.nextInt();
			sc.nextLine();		switch(choice) {
			
		case 1:
			System.out.println("Enter Element to Push");
			int data=sc.nextInt();
			s.push(data);
			break;
			
		case 2:
			s.pop();
			break;
			
		case 3:
			s.display();
			break;
		
		case 4:
			System.out.println("Exited....");
			break;
			
		default:
			System.out.println("Invalid Choice");
			break;
		
		}
		}while(choice!=4);
	}

}
