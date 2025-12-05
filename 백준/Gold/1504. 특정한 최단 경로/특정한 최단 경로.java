import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    static final int INF = 200_000_001; // 최대 거리: 200,000 * 1,000 = 2억

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int dist1ToV1 = dijkstra(1, v1, graph, N);
        int dist1ToV2 = dijkstra(1, v2, graph, N);
        int distV1ToV2 = dijkstra(v1, v2, graph, N);
        int distV1ToN = dijkstra(v1, N, graph, N);
        int distV2ToN = dijkstra(v2, N, graph, N);

        // 경로 1: 1 → v1 → v2 → N
        long path1 = (long) dist1ToV1 + distV1ToV2 + distV2ToN;
        // 경로 2: 1 → v2 → v1 → N
        long path2 = (long) dist1ToV2 + distV1ToV2 + distV1ToN;

        long result = Math.min(path1, path2);

        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static int dijkstra(int start, int end, int[][] graph, int N) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (visited[current[0]]) continue;
            visited[current[0]] = true;

            for (int i = 1; i <= N; i++) {
                if (graph[current[0]][i] != 0 && !visited[i]) {
                    int newDist = dist[current[0]] + graph[current[0]][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.offer(new int[]{i, newDist});
                    }
                }
            }
        }
        return dist[end];
    }
}