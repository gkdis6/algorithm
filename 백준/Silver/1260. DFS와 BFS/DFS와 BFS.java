import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visitedBFS = new boolean[N + 1];
        boolean[] visitedDFS = new boolean[N + 1];

        // DFS
        stack.push(V);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visitedDFS[cur]) continue;
            visitedDFS[cur] = true;
            sb.append(cur).append(" ");
            for (int i = N; i >= 1; i--) {
                if (map[cur][i] && !visitedDFS[i]) {
                    stack.push(i);
                }
            }
        }
        sb.append("\n");
        // BFS
        queue.offer(V);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visitedBFS[cur]) continue;
            visitedBFS[cur] = true;
            sb.append(cur).append(" ");
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] && !visitedBFS[i]) {
                    queue.offer(i);
                }
            }
        }
        System.out.println(sb);
    }
}