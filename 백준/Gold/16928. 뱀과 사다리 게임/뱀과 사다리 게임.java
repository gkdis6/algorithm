import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+M][N+M];
        // int[][] snake = new int[M][M];
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // for (int i = 0; i < M; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     for (int j = 0; j < 2; j++) {
        //         snake[i][j] = Integer.parseInt(st.nextToken());
        //     }
        // }

        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next > 100) continue;

                // Check for ladders
                for (int[] l : arr) {
                    if (l[0] == next) {
                        next = l[1];
                        // break;
                    }
                }

                // Check for snakes
                // for (int[] s : snake) {
                //     if (s[0] == next) {
                //         next = s[1];
                //         break;
                //     }
                // }

                if (dist[next] == -1 || dist[next] > dist[current] + 1) {
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println(dist[100]);
    }
}