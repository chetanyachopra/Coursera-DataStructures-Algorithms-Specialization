import java.util.*;
import java.util.Collections;
import java.util.Scanner;

public class StronglyConnected {
	 int V;
     ArrayList<Integer>[] adj;
	
	StronglyConnected(int v) {
		V = v;
		adj = (ArrayList<Integer>[])new ArrayList[V];
		for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<Integer>();
	}

	private  void fillOrder(int n, boolean[] visited, Stack<Integer> stack) {
		visited[n] = true;

		Iterator<Integer> it = adj[n].listIterator();
		while(it.hasNext()) {
			int next = it.next();
			if(!visited[next])
				fillOrder(next, visited, stack);
		}
		stack.push(new Integer(n));
	}

	private  StronglyConnected getTranspose() {
		StronglyConnected graph = new StronglyConnected(V);
		for(int i = 0;i < V;i++) 
		{
			Iterator<Integer> it = adj[i].listIterator();
			while(it.hasNext()){
				graph.adj[it.next()].add(i);
			}
		}
		return graph;
	}

	private  void DFSUtil(int n, boolean[] visited) {
		visited[n] = true;
	//	System.out.print(n + 1 + " ");
		
		Iterator<Integer> it = adj[n].listIterator();
		
		while(it.hasNext()) {
			int v = it.next();
			if(!visited[v]){
				DFSUtil(v, visited);
			}
		}

	}

    private  int numberOfStronglyConnectedComponents() {
        //write your code here
         int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[adj.length];
        Arrays.fill(visited, false);

        for(int i = 0;i < adj.length;i++) {
        	if(!visited[i])
        		fillOrder(i, visited, stack);
        }

        StronglyConnected graph = getTranspose();
        Arrays.fill(visited, false);

  //  while(stack.empty() == false)
    //    System.out.print( (stack.pop() + 1) + "\n");

        while(stack.empty() == false) {
        	int n = stack.pop();
        //	for(int i = 0;i < V;i++)
        //	System.out.print(visited[i]+" ");
        //	System.out.println();
        		if(!visited[n]){
        			graph.DFSUtil(n, visited);
        			count++;
        			//System.out.println("");
        		}
            }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edges = scanner.nextInt();
        
        StronglyConnected g = new StronglyConnected(edges);
        
        g.V = edges;
        int m = scanner.nextInt();
      	
        
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            g.adj[x - 1].add(y - 1);
        }
        System.out.println( g.numberOfStronglyConnectedComponents());
    }
}

