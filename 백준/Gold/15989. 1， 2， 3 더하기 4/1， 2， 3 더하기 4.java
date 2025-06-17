import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        dp[0] = 1;

        for (int j = 1; j <= 3; j++) {
            for (int i = j; i <= 10000; i++) {
                dp[i] += dp[i - j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
