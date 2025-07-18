import java.io.*;
import java.util.*;

class DFS_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
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
        
        // DFS 실행
        dfs(1);
    }
    
    // 기본 DFS 탐색
    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
    
    // 목표 노드까지의 경로 찾기
    static boolean dfsPath(int node, int target) {
        visited[node] = true;
        
        if (node == target) {
            return true;
        }
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfsPath(neighbor, target)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    // 백트래킹 DFS (경로 탐색)
    static void dfsBacktrack(int node, int target, int currentWeight) {
        if (node == target) {
            System.out.println(currentWeight);
            return;
        }
        
        visited[node] = true;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsBacktrack(neighbor, target, currentWeight + 1);
            }
        }
        
        visited[node] = false; // 백트래킹
    }
}