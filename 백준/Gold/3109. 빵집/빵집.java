import java.io.*;
import java.util.*;

class Main {
    static char[][] map;
    static boolean[][] visited;
    static int N, K;
    static int[][] dir = {{-1,1}, {0,1}, {1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][K];
        visited = new boolean[N][K];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < K; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(dfs(i, 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int r, int c) {
        if(c == K-1) {
            return true;
        }

        for(int d = 0; d < 3; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(nr >= 0 && nr < N && nc >= 0 && nc < K &&
               map[nr][nc] == '.' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                if(dfs(nr, nc)) {
                    return true;
                }
            }
        }
        return false;
    }
}