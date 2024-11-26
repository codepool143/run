package practice;
import java.util.Scanner;
public class djikstras {
	public static void djikstra(int[][] graph,int source) {
		int n=graph.length;
		boolean[] visited=new boolean[n];
		int[] parent=new int[n];
		int[] distance=new int[n];
		
		for(int i=0;i<n;i++) {
			parent[i]=-1;
			distance[i]=Integer.MAX_VALUE;
		}
		distance[source]=0;
		
		for(int count=0;count<n;count++) {
			int u=-1;
			for(int i=0;i<n;i++) {
				if(!visited[i] && (u==-1 || distance[u]>distance[i])) {
					u=i;
				}
			}
			visited[u]=true;
			
			for(int v=0;v<n;v++) {
				if(!visited[v] && graph[u][v]!=0 && graph[u][v]+distance[u]<distance[v]) {
					distance[v]=graph[u][v]+distance[u];
					parent[v]=u;
				}
			}
		}
		System.out.println("MST:");
		for(int i=0;i<distance.length;i++) {
				System.out.print((char)('A'+i)+" : "+distance[i]+"    ");
				printpath(parent,i,source);
				System.out.println();
		}
	}
	public static void printpath(int[] parent,int vertex,int source) {
		if(vertex==source) {
			System.out.print((char)('A'+source));
		}
		else {
			printpath(parent,parent[vertex],source);
			System.out.print(" -> "+(char)('A'+vertex));
		}
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of Cities: ");
		int n=sc.nextInt();
		sc.nextLine();
		int[][] graph=new int[n][n];
		System.out.println("Enter Number of Roads: ");
		int e=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<e;i++) {
			System.out.println("Enter Edge "+(i+1)+" : ");
			System.out.print("Enter Source: ");
			char source=sc.next().charAt(0);
			System.out.print("Enter Destination: ");
			char destination=sc.next().charAt(0);
			System.out.print("Enter Weight");
			int w=sc.nextInt();
			
			int s=Character.toUpperCase(source)-'A';
			int d=Character.toUpperCase(destination)-'A';
			
			graph[s][d]=w;
			graph[d][s]=w;
		}
		System.out.println();
		System.out.print("Enter Source: ");
		char source=sc.next().charAt(0);
		int s=Character.toUpperCase(source)-'A';
		djikstra(graph,s);
	}

}
