import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static boolean[][] empty;
    static int[][] map;
    static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        empty = new boolean[n][m];

        List<int[]> initialIce = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    initialIce.add(new int[]{i, j});
                } else {
                    empty[i][j] = true;
                }
            }
        }

        int year = 0;
        while(true){
            int landCount = countLand();
            if(landCount >= 2) {
                System.out.println(year);
                break;
            }
            if(landCount == 0) {
                System.out.println(0);
                break;
            }

            meltIce();
            year++;
        }
    }

    static void meltIce() {
        List<int[]> currentIce = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] > 0) {
                    currentIce.add(new int[]{i, j});
                }
            }
        }

        int[][] meltAmounts = new int[n][m];
        for (int[] ice : currentIce) {
            int r = ice[0];
            int c = ice[1];
            int seaCount = 0;
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && empty[nr][nc]) {
                    seaCount++;
                }
            }
            meltAmounts[r][c] = seaCount;
        }

        for (int[] ice : currentIce) {
            int r = ice[0];
            int c = ice[1];
            map[r][c] = Math.max(0, map[r][c] - meltAmounts[r][c]);
            if (map[r][c] == 0) {
                empty[r][c] = true;
            }
        }
    }

    static int countLand() {
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    count++;
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] current = q.poll();
                        for (int[] dir : directions) {
                            int ni = current[0] + dir[0];
                            int nj = current[1] + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < m && map[ni][nj] > 0 && !visited[ni][nj]) {
                                q.offer(new int[]{ni, nj});
                                visited[ni][nj] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
