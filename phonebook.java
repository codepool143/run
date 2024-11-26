package practice;
import java.util.Scanner;

class BSTNode{
	long phone;
	String name;
	BSTNode left,right;
	BSTNode(long phone,String name){
		this.phone=phone;
		left=right=null;
		this.name=name;
	}
}

public class phonebook {
	
	BSTNode root;
	phonebook(){
		root=null;
	}
	public void insert(long phone,String name) {
		root=insertRec(root,phone,name);
	}
	public BSTNode insertRec(BSTNode node,long phone,String name) {
		if(node==null) {
			System.out.println("Contact Inserted Successfully");
			return new BSTNode(phone,name);
		}
		if(phone<node.phone) {
			node.left=insertRec(node.left,phone,name);
		}
		else if(phone>node.phone) {
			node.right=insertRec(node.right,phone,name);
		}
		else {
			System.out.println("Contact Already Present in PhoneBook");
		}
		return node;
	}
	public void search(long phone) {
		BSTNode node=searchRec(root,phone);
		if(node==null) {
			System.out.println("Contact Not Found");
		}
		else {
			System.out.println("Contact Found:");
			System.out.println("Name: "+node.name);
			System.out.println("Phone NUmber: "+node.phone);
		}
	}
	public BSTNode searchRec(BSTNode node,long phone) {
		if(node==null || node.phone==phone) {
			return node;
		}
		else if(phone<node.phone) {
			return searchRec(node.left,phone);
		}
		else {
			return searchRec(node.right,phone);
		}
	}
	public void update(long old,long newnum) {
		root=updateRec(root,old,newnum);
		}
	public BSTNode updateRec(BSTNode node,long phone,long newnum) {
		if(node==null) {
			System.out.println("No Contact Found to update");
			return null;
		}
		if(phone<node.phone) {
			node.left=updateRec(node.left,phone,newnum);
		}
		else if(phone>node.phone) {
			node.right=updateRec(node.right,phone,newnum);
		}
		else {
			node.phone=newnum;
			System.out.println("Contact Updated Successfully.");
		}
		return node;
	}
	public void delete(long phone) {
		root=deleteRec(root,phone);
	}
	public BSTNode deleteRec(BSTNode node,long phone) {
		if(node==null) {
			System.out.println("No Contact found to delete");
			return null;
		}
		else if(phone<node.phone) {
			node.left=deleteRec(node.left,phone);
		}
		else if(phone>node.phone) {
			node.right=deleteRec(node.right,phone);
		}
		else {
			if(node.left==null && node.right==null) {
				return null;
			}
			else if(node.left==null) {
				return node.right;
			}
			else if(node.right==null) {
				return node.left;
			}
			else {
				BSTNode MaxBSTNode=findMax(node.left);
				node.phone=MaxBSTNode.phone;
				node.name=MaxBSTNode.name;
				node.left=deleteRec(node.left,MaxBSTNode.phone);
			}
			System.out.println("Contact Removed Successfully");
		}
		return node;
	}
	public BSTNode findMax(BSTNode node) {
		while(node.left!=null) {
			node=node.left;
		}
		return node;
	}
	public void inorder() {
		inorderRec(root);
	}
	public void inorderRec(BSTNode root) {
		if(root!=null) {
			inorderRec(root.left);
			System.out.println(root.name+"  "+root.phone);
			inorderRec(root.right);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		phonebook p=new phonebook();
		int choice;
		do {
			System.out.println("Select:");
			System.out.println("1.Insert Contact");
			System.out.println("2.Remove Contact");
			System.out.println("3.Search Contact");
			System.out.println("4.Update Contact");
			System.out.println("5.Exit");
			System.out.println("6.Display");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Contact Number:");
				long phone=sc.nextLong();
				sc.nextLine();
				System.out.println("Enter Name:");
				String name=sc.nextLine();
				p.insert(phone,name);
				break;
			
			case 2:
				System.out.println("Enter Number to delete:");
				long phonedelete=sc.nextLong();
				sc.nextLine();				
				p.delete(phonedelete);
				break;
				
			case 3:
				System.out.println("Enter NUmber to Search:");
				long phonesearch=sc.nextLong();
				sc.nextLine();
				p.search(phonesearch);
				break;
				
			case 4:
				System.out.println("Enter Number to Update");
				long phoneold=sc.nextLong();
				sc.nextLine();
				System.out.println("Enter Number with to Update");
				long phonenew=sc.nextLong();
				sc.nextLine();
				p.update(phoneold,phonenew);
				break;
				
			case 5:
				System.out.println("Exited PhoneBook");
				break;
				
			case 6:
				System.out.println("Contact List as Follows:");
				p.inorder();
				break;
			
			case 7:
				System.out.println("Invalid Choice");
				
			}
			}while(choice!=5);
		
	}
	}
