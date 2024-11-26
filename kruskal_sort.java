package lol;
import java.util.Scanner;
import java.util.Arrays;

class Edge{
	int src,des,weight;
	Edge(int s,int d,int w){
		src=s;
		des=d;
		weight=w;
	}
}

class Disjoint{
	int[] parent,rank;
	Disjoint(int n){
		parent=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
			rank[i]=0;
		}
	}
	public int find(int node) {
		if(parent[node]!=node) {
			parent[node]=find(parent[node]);
		}
		return parent[node];
	}
	
	public void union(int s,int d) {
		int u=find(s);
		int v=find(d);
		if(u!=v) {
			if(rank[u]>rank[v]) {
				parent[v]=u;
			}
			else if(rank[v]>rank[u]) {
				parent[u]=v;
			}
			else {
				parent[v]=u;
				rank[u]++;
			}
		}
	}
}
public class kruskal {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Num of vertices:");
		int n=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter num of edges:");
		int e=sc.nextInt();
		sc.nextLine();
		Edge[] edges=new Edge[e];
		for(int i=0;i<e;i++) {
			System.out.println("Enter Edge "+(i+1)+" : ");
			System.out.print("Enter Source: ");
			char source=sc.next().charAt(0);
			System.out.print("Enter Destination: ");
			char des=sc.next().charAt(0);
			System.out.print("Enter Weight: ");
			int w=sc.nextInt();
			
			int s=Character.toUpperCase(source)-'A';
			int d=Character.toUpperCase(des)-'A';
			
			edges[i]=new Edge(s,d,w);
		}
		
		Edge[] mst=new Edge[n-1];
		int mstindex=0,total=0;
		
		Arrays.sort(edges,(a,b)->Integer.compare(a.weight, b.weight));
		Disjoint ds=new Disjoint(n);
		for(int i=0;i<e && mstindex<n-1;i++) {
			Edge edge=edges[i];
			int s=ds.find(edge.src);
			int d=ds.find(edge.des);
			
			if(s!=d) {
				mst[mstindex++]=edge;
				total+=edge.weight;
				ds.union(s, d);
			}
			
		}
		System.out.println("MST:");
		for(int i=0;i<n-1;i++) {
			char s=(char)(mst[i].src + 'A');
			char d=(char)(mst[i].des + 'A');
			System.out.println(s+" -> "+d+"==="+mst[i].weight);
		}
		System.out.println("Total Cost: "+total);
		
	}
}
