import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<List<Node>> tree;
    static int maxDistance = 0;
    static int farthestNode = 0;

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, 0, visited);

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(farthestNode, 0, visited);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int currentDistance, boolean[] visited) {
        visited[node] = true;

        if (currentDistance > maxDistance) {
            maxDistance = currentDistance;
            farthestNode = node;
        }

        for (Node neighbor : tree.get(node)) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, currentDistance + neighbor.weight, visited);
            }
        }
    }
}
