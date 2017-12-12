import java.util.ArrayList;
import java.util.*;

public class Reachability {
    static int flag = 0;
    private static void isReachable(ArrayList<Integer>[] adj, int src, int dest, boolean[] visited) {
    
    	visited[src] = true;
    	//System.out.print(src + " ");
    	Iterator<Integer> it =  adj[src].listIterator();
    	while(it.hasNext()) {
    		int n = it.next();
    		if(n == dest){
    			//System.out.println("des = " + dest);
    			flag = 1;
    			return;
    		}
    		if(!visited[n])
    			//if(n == dest)return 1;
    			isReachable(adj, n, dest, visited);
    	}
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        boolean[] visited = new boolean[adj.length];
        //System.out.println(isReachable(adj, x, y, visited));
        isReachable(adj, x, y, visited);
        System.out.print(flag);
    }
}

