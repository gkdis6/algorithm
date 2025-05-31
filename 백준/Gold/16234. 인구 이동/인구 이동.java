import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int n, l, r;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;
            List<List<int[]>> unions = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j);
                        if (union.size() > 1) {
                            unions.add(union);
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }

            for (List<int[]> union : unions) {
                int totalPopulation = 0;
                for (int[] country : union) {
                    totalPopulation += map[country[0]][country[1]];
                }
                int newPopulation = totalPopulation / union.size();
                for (int[] country : union) {
                    map[country[0]][country[1]] = newPopulation;
                }
            }

            result++;
        }
        System.out.println(result);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static List<int[]> bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> countries = new ArrayList<>();

        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        countries.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int[] d : dir) {
                int nx = current[0] + d[0];
                int ny = current[1] + d[1];
                if (isValid(nx, ny) && !visited[nx][ny]) {
                    int diff = Math.abs(map[current[0]][current[1]] - map[nx][ny]);
                    if (diff >= l && diff <= r) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        countries.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return countries;
    }
}
