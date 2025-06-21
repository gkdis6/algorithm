import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] memory, cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        memory = new int[N];
        cost = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxCost = 100 * N;
        
        dp = new int[N + 1][maxCost + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int c = 0; c <= maxCost; c++) {
                dp[i][c] = dp[i-1][c];
                
                if (c >= cost[i-1]) {
                    dp[i][c] = Math.max(dp[i][c], dp[i-1][c - cost[i-1]] + memory[i-1]);
                }
            }
        }
        
        int answer = maxCost;
        for (int c = 0; c <= maxCost; c++) {
            if (dp[N][c] >= M) {
                answer = c;
                break;
            }
        }
        
        System.out.println(answer);
    }
}