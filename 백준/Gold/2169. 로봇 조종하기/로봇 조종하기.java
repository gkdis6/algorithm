import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }
        for (int i = 1; i < N; i++) {
            int[] left = new int[M];
            int[] right = new int[M];
            left[0] = dp[i - 1][0] + arr[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + arr[i][j];
            }
            right[M - 1] = dp[i - 1][M - 1] + arr[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + arr[i][j];
            }
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }
        System.out.println(dp[N - 1][M - 1]);
    }
}