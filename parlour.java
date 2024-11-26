package practice;
import java.util.Scanner;
public class parlour {
	int capacity;
	int front,rear;
	String[] order_list;
	
	parlour(int c){
		capacity=c;
		front=rear=-1;
		order_list=new String[c];
	}
	
	public boolean isEmpty() {
		return front==-1;
	}
	public boolean isFull() {
		return (rear+1)%capacity==front;
	}
	public void placeOrder(String order) {
		if(isFull()) {
			System.out.println("Queue is  Full Cannot Place Order");
			return;
		}
		rear=(rear+1)%capacity;
		order_list[rear]=order;
		if(front==-1) {
			front=0;
		}
		System.out.println(order+" is placed successfully");
	}
	public void serveOrder() {
		if(isEmpty()) {
			System.out.println("Cannot Serve No order available");
			return;
		}
		String p=order_list[front];
		if(front==rear) {
			front=rear=-1;
		}
		else {
			front=(front+1)%capacity;
		}
		System.out.println(p+" Served successfully");
	}
	
	public void display() {
		System.out.println("Order List is as Follows:");
		if(isEmpty()) {
			System.out.println("No Queue to show");
			return;
		}
		int temp=front;
		do {
			System.out.print(order_list[temp]+" -> ");
			temp=(temp+1)%capacity;
		}while(temp!=(rear+1)%capacity);
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("How Many Orders:");
		int c=sc.nextInt();
		parlour p=new parlour(c);
		int choice;
		do {
			System.out.println("Select:");
			System.out.println("1.Place Order");
			System.out.println("2.Serve Order");
			System.out.println("3.Display Orders");
			System.out.println("4.Exit");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Order:");
				String order=sc.nextLine();
				p.placeOrder(order);
				break;
				
			case 2:
				p.serveOrder();
				break;
				
			case 3:
				p.display();
				break;
				
			case 4:
				System.out.println("Exited Pizza Parlour");
				break;
			
			default:
				System.out.println("Invalid Choice");
			}
			}while(choice!=4);
		}
	}
