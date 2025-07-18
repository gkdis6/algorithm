import java.io.*;
import java.util.*;

class Edge {
    int to;
    int weight;
    
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int distance;
    
    Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

class Dijkstra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }
        
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        
        dijkstra(start);
        
        // 결과 출력
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;
            
            for (Edge edge : graph.get(currentVertex)) {
                int nextVertex = edge.to;
                int weight = edge.weight;
                
                if (dist[currentVertex] + weight < dist[nextVertex]) {
                    dist[nextVertex] = dist[currentVertex] + weight;
                    pq.offer(new Node(nextVertex, dist[nextVertex]));
                }
            }
        }
    }
}