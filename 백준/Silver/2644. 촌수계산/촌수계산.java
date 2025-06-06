import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int goal_x = Integer.parseInt(st.nextToken());
        int goal_y = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }

        System.out.println(bfs(map, n, goal_x - 1, goal_y - 1));
    }

    static int bfs(int[][] map, int n, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        q.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == end) {
                return dist[current];
            }

            for (int i = 0; i < n; i++) {
                if (map[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[current] + 1;
                    q.offer(i);
                }
            }
        }

        return -1;
    }
}
