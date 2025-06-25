import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTotalCost = Integer.MAX_VALUE;

        for (int startColor = 0; startColor < 3; startColor++) {
            int[][] dp = new int[N][3];
            for (int j = 0; j < 3; j++) {
                if (j == startColor) {
                    dp[0][j] = costs[0][j];
                } else {
                    dp[0][j] = 1000 * 1000 + 1;
                }
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == startColor) {
                    continue;
                }
                minTotalCost = Math.min(minTotalCost, dp[N-1][lastColor]);
            }
        }

        System.out.println(minTotalCost);
    }
}
