import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int max_val = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    count++;
                    int cur_val = 1;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int[] dir : directions) {
                            int ni = current[0] + dir[0];
                            int nj = current[1] + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < m && map[ni][nj] == 1 && !visited[ni][nj]) {
                                visited[ni][nj] = true;
                                queue.offer(new int[]{ni, nj});
                                cur_val++;
                            }
                        }
                    }
                    max_val = Math.max(max_val, cur_val);
                }
            }
        }
        System.out.println(count);
        System.out.println(max_val);
    }
}