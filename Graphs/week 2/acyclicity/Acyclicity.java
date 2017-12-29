import java.util.*;

public class Acyclicity {

    private static boolean isCyclicUtil(ArrayList<Integer>[] adj, int n, boolean[] visited, boolean[] recStack) {
        visited[n] = true;
        recStack[n] = true;

        Iterator<Integer> it = adj[n].listIterator();
        while(it.hasNext()) {
            int v = it.next();
            if(!visited[v] && isCyclicUtil(adj, v, visited, recStack))
                return true;
            else if(recStack[v])
                return true;
        }
        recStack[n] = false;
        return false;
    }

    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
        boolean[] visited = new boolean[adj.length];
        boolean[] recStack = new boolean[adj.length];
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);

        for(int i = 0;i < adj.length;i++)
        if(isCyclicUtil(adj, i, visited, recStack))return 1;
        return 0;
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
        System.out.println(acyclic(adj));
    }
}

