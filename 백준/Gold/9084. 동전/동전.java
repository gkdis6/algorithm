import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            dp[0] = 1;

            for (int coin : arr) {
                for (int k = coin; k <= M; k++) {
                    dp[k] += dp[k - coin];
                }
            }
            System.out.println(dp[M]);
        }
    }
}
