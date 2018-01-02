import java.util.*;

public class Bipartite {

    private static int fillColor(ArrayList<Integer>[] adj, int[] color) {
        for(int src = 0; src < adj.length;src++) {
        //int src = 0;
            Queue<Integer> queue = new LinkedList<Integer>();

            if(color[src] == -1) {
                queue.add(src);
                color[src] = 1;

                while(queue.size() != 0) {
                    int u = queue.poll();

                    Iterator<Integer> it = adj[u].listIterator();
                    while(it.hasNext()) {
                        int n = it.next();
                        if(color[n] == -1) {
                            color[n] = 1 - color[u];
                            queue.add(n);
                        }
                        else if(color[n] == color[u])return 0;
                    }
                }
            }
        }
        return 1;
    }

    private static int bipartite(ArrayList<Integer>[] adj) {
        int[] color = new int[adj.length];
        Arrays.fill(color, -1);

        return fillColor(adj, color);
       // return (checkColor(adj, color) == true) ? 1 : 0;
        //for(int i = 0;i < color.length;i++)
            //System.out.print(color[i] + " ");
        //return -1;
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
        System.out.println("\n" + bipartite(adj));
    }
}

