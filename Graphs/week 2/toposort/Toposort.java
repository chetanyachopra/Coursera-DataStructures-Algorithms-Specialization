import java.util.*;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        Arrays.fill(visited, false);

        ArrayList<Integer> order = new ArrayList<Integer>();
        //write your code here
        for(int i = 0;i < adj.length;i++) {
            if(!visited[i])
                dfs(adj, visited, order, i);
        }
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] visited, ArrayList<Integer> order, int s) {
      //write your code here
        visited[s] = true;

        Iterator<Integer> it = adj[s].listIterator();
        while(it.hasNext()) {
            int n = it.next();
            if(!visited[n])
                dfs(adj, visited, order, n);
        }
        order.add(0, s);
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

