import java.util.ArrayList;
import java.util.*;

public class ConnectedComponents {

    private static void numberOfComponentsUtil(ArrayList<Integer>[] adj, int x, boolean[] visited) {
        visited[x] = true;
       // System.out.print(x + " ");

        Iterator<Integer> it =  adj[x].listIterator();
        while(it.hasNext()) {
            int n = it.next();
            if(!visited[n])
                numberOfComponentsUtil(adj, n, visited);
        }
    }


    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        boolean[] visited = new boolean[adj.length];

        for(int i = 0;i < adj.length;i++) {
            if(!visited[i]){
                numberOfComponentsUtil(adj, i, visited);
                //System.out.println("");
                result++;
            }
        }

        return result;
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

        System.out.println(numberOfComponents(adj));
    }
}

