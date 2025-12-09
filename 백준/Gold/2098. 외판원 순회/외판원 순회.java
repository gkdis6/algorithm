import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[1 << N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(tsp(1, 0));
    }

    static int tsp(int visited, int current) {
        if (visited == (1 << N) - 1) {
            return W[current][0] != 0 ? W[current][0] : INF;
        }

        if (dp[visited][current] != -1) {
            return dp[visited][current];
        }

        dp[visited][current] = INF;

        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && W[current][next] != 0) {
                int newVisited = visited | (1 << next);
                dp[visited][current] = Math.min(
                    dp[visited][current],
                    tsp(newVisited, next) + W[current][next]
                );
            }
        }

        return dp[visited][current];
    }
}