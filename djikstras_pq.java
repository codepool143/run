package lol;

import java.util.PriorityQueue;
import java.util.Scanner;

public class djikstras_pq {
	public static void djikstra(int[][] graph,int source) {
		int n=graph.length;
		boolean[] visited=new boolean[n];
		int[] parent=new int[n];
		int[] distance=new int[n];
		
		for(int i=0;i<n;i++) {
			parent[i]=-1;
			distance[i]=Integer.MAX_VALUE;
		}
		distance[0]=0;
		
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
		pq.offer(new int[] {0,0});
		while(!pq.isEmpty()) {
			int current[]=pq.poll();
			int u=current[1];
			if(visited[u]) continue;
			visited[u]=true;
			
			for(int v=0;v<n;v++) {
				if(!visited[v] && graph[u][v]!=0 && graph[u][v]+distance[u]<distance[v]) {
					distance[v]=graph[u][v]+distance[u];
					parent[v]=u;
					pq.offer(new int[] {distance[v],v});
				}
			}
		}
		System.out.println("MST:");
		for(int i=0;i<n;i++) {
			
				System.out.print((char)('A'+i)+" : "+distance[i]+"   ");
				printpath(parent,i,source);
				System.out.println();
				
				
		}
		System.out.println();
	}
	public static void printpath(int[] parent,int vertex,int source) {
		if(source==vertex) {
			System.out.print((char)(source+'A'));
		}
		else {
			printpath(parent,parent[vertex],source);
			System.out.print(" -> "+(char)(vertex+'A'));
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
		System.out.println("Enter Source: ");
		char s=sc.next().charAt(0);
		int source=Character.toUpperCase(s)-'A';
		djikstra(graph,source);
	}
}
