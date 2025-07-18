import java.io.*;
import java.util.*;

class Node {
    int vertex;
    int weight;
    
    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class DFS_WeightedGraph {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> tree;
    static boolean[] visited;
    static int n;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        
        // 가중치 그래프 입력
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(left).add(new Node(right, weight));
            tree.get(right).add(new Node(left, weight));
        }
        
        visited = new boolean[N + 1];
        
        // 쿼리 처리
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            Arrays.fill(visited, false);
            dfs(start, end, 0);
        }
    }
    
    // 가중치 그래프에서 두 노드 사이의 거리 찾기
    static void dfs(int node, int target, int currentWeight) {
        if (node == target) {
            System.out.println(currentWeight);
            return;
        }
        
        visited[node] = true;
        
        for (Node neighbor : tree.get(node)) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, target, currentWeight + neighbor.weight);
            }
        }
        
        visited[node] = false;
    }
}