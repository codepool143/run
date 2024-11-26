package practice;
import java.util.Scanner;

public class MaxHeap {
	
	public static void heapify(int[] a,int i,int n) {
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<n && a[left]>a[largest]) {
			largest=left;
		}
		if(right<n && a[right]>a[largest]) {
			largest=right;
		}
		if(largest!=i) {
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			heapify(a,largest,n);
		}
	}
	
	public static void build(int[] a) {
		int n=a.length;
		for(int i=(n/2)-1;i>=0;i--) {
			heapify(a,i,n);
		}
	}
	
	public static int[] heap(int[] a) {
		int n=a.length;
		build(a);
		for(int i=n-1;i>0;i--) {
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			heapify(a,0,i);
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Studs:");
		int n=sc.nextInt();
		sc.nextLine();
		int[] marks=new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter Marks of Student "+(i+1)+" : ");
			int mark=sc.nextInt();
			sc.nextLine();
			marks[i]=mark;
		}
		marks=heap(marks);
		System.out.println("Highest Marks: "+marks[n-1]);
		System.out.println("Lowest Marks: "+marks[0]);
	}
	
}
