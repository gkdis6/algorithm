import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<List<Node>> tree;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(left).add(new Node(right, weight));
            tree.get(right).add(new Node(left, weight));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dfs(start, end, new boolean[N + 1], 0);
        }
    }

    static void dfs(int node, int target, boolean[] visited, int currentWeight) {
        visited[node] = true;

        if (node == target) {
            System.out.println(currentWeight);
            return;
        }

        for (Node neighbor : tree.get(node)) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, target, visited, currentWeight + neighbor.weight);
            }
        }
        visited[node] = false;
    }
}