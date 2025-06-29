import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}
