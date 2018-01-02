import java.util.*;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int d) {
        int[] distance = new int[adj.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        distance[s] = 0;

        while(queue.size() != 0) {
        	s = queue.poll();

        	Iterator<Integer> it = adj[s].listIterator();
        	while(it.hasNext()) {
        		int n = it.next();
        		if(distance[n] == Integer.MAX_VALUE) {
        			distance[n] = distance[s] + 1;
        			queue.add(n);
        		}
        	}
        }

        //for(int i = 0;i < distance.length;i++) System.out.println("distance of " + i + " = " + distance[i]);
        if(distance[d] == Integer.MAX_VALUE) return -1;
        return distance[d];
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
        System.out.println(distance(adj, x, y));
    }
}

