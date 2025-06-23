import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] board;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int maxMoves = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxMoves = Math.max(maxMoves, dfs(i, j));
            }
        }

        System.out.println(maxMoves);
        br.close();
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] > board[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
}
