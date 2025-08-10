import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int u, v, cost;
        Edge(int u, int v, int cost) {
            this.u = u; this.v = v; this.cost = cost;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        parent[x] = y;
        return true;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            List<Edge> edges = new ArrayList<>();
            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x, y, z));
                totalCost += z;
            }

            edges.sort((a, b) -> a.cost - b.cost);
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int mstCost = 0;
            for (Edge edge : edges) {
                if (union(edge.u, edge.v)) {
                    mstCost += edge.cost;
                }
            }

            System.out.println(totalCost - mstCost);
        }
    }
}