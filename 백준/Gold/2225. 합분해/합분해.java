import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int k = 1; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[n] = (dp[n] + dp[n - 1]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}
