import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        int[][] min_dp = new int[N][3];
        int[][] max_dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = Integer.parseInt(st.nextToken());
        }
        min_dp[0][0] = dp[0][0];
        min_dp[0][1] = dp[0][1];
        min_dp[0][2] = dp[0][2];
        max_dp[0][0] = dp[0][0];
        max_dp[0][1] = dp[0][1];
        max_dp[0][2] = dp[0][2];
        for (int i = 1; i < N; i++) {
            min_dp[i][0] += Math.min(min_dp[i - 1][0], min_dp[i - 1][1]) + dp[i][0];
            min_dp[i][1] += Math.min(min_dp[i - 1][0], Math.min(min_dp[i - 1][2], min_dp[i - 1][1])) + dp[i][1];
            min_dp[i][2] += Math.min(min_dp[i - 1][2], min_dp[i - 1][1]) + dp[i][2];
            max_dp[i][0] += Math.max(max_dp[i - 1][0], max_dp[i - 1][1]) + dp[i][0];
            max_dp[i][1] += Math.max(max_dp[i - 1][0], Math.max(max_dp[i - 1][2], max_dp[i - 1][1])) + dp[i][1];
            max_dp[i][2] += Math.max(max_dp[i - 1][2], max_dp[i - 1][1]) + dp[i][2];
        }

        int min = Math.min(min_dp[N - 1][0], Math.min(min_dp[N - 1][1], min_dp[N - 1][2]));
        int max = Math.max(max_dp[N - 1][0], Math.max(max_dp[N - 1][1], max_dp[N - 1][2]));
        System.out.println(max + " " + min);
    }
}