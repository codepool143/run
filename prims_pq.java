package lol;
import java.util.Scanner;
import java.util.PriorityQueue;

public class prims_pq{
	public static void prims(int[][] graph) {
		int n=graph.length;
		boolean[] visited=new boolean[n];
		int[] parent=new int[n];
		int[] minEdge=new int[n];
		
		for(int i=0;i<n;i++) {
			parent[i]=-1;
			minEdge[i]=Integer.MAX_VALUE;
		}
		minEdge[0]=0;
		int totalCost=0;
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
		pq.offer(new int[] {0,0});
		while(!pq.isEmpty()) {
			int current[]=pq.poll();
			int u=current[1];
			if(visited[u]) continue;
			visited[u]=true;
			totalCost+=minEdge[u];
			
			for(int v=0;v<n;v++) {
				if(!visited[v] && graph[u][v]!=0 && graph[u][v]<minEdge[v]) {
					minEdge[v]=graph[u][v];
					parent[v]=u;
					pq.offer(new int[] {minEdge[v],v});
				}
			}
		}
		System.out.println("MST:");
		for(int i=0;i<n;i++) {
			if(parent[i]!=-1) {
				System.out.println((char)('A' + parent[i])+" -> "+(char)('A'+i)+" : "+graph[i][parent[i]]);
			}
		}
		System.out.println("Total MST Cost: "+totalCost);
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
		prims(graph);
	}

}