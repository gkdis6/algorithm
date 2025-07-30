import java.io.*;
import java.util.*;

class BFS_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] distance;
    static int n;
    
    public static void main(String[] args) throws IOException {
        // 그래프 초기화
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 정보 입력
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        
        // BFS 실행
        bfs(1);
    }
    
    // 기본 BFS 탐색
    // Time Complexity: O(V + E) where V is vertices and E is edges
    // Space Complexity: O(V) for queue and visited arrays
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        distance[start] = 0;
        queue.offer(start);         // O(1)
        
        while (!queue.isEmpty()) {
            int node = queue.poll();    // O(1)
            System.out.print(node + " ");
            
            // Visit all adjacent vertices
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);  // O(1)
                }
            }
        }
    }
    
    // 최단 거리 찾기
    // Time Complexity: O(V + E) where V is vertices and E is edges
    // Space Complexity: O(V) for queue and visited arrays
    static int bfsShortestPath(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);    // O(V)
        Arrays.fill(distance, -1);      // O(V)
        
        visited[start] = true;
        distance[start] = 0;
        queue.offer(start);             // O(1)
        
        while (!queue.isEmpty()) {
            int node = queue.poll();    // O(1)
            
            if (node == target) {
                return distance[node];
            }
            
            // Visit all adjacent vertices
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);  // O(1)
                }
            }
        }
        
        return -1; // 연결되지 않음
    }
}