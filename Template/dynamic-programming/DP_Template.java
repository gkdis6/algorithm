import java.io.*;
import java.util.*;

class DP_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        
        // 피보나치 수열 DP
        System.out.println("피보나치: " + fibonacci(n));
        
        // 계단 오르기 DP
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("계단 오르기: " + climbStairs(stairs));
        
        // 배낭 문제 DP
        knapsackExample();
    }
    
    // 1차원 DP - 피보나치
    static int fibonacci(int n) {
        if (n <= 1) return n;
        
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
    // 1차원 DP - 계단 오르기
    static int climbStairs(int[] stairs) {
        if (n == 1) return stairs[1];
        if (n == 2) return stairs[1] + stairs[2];
        
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }
        
        return dp[n];
    }
    
    // 2차원 DP - 배낭 문제
    // Time Complexity: O(n * capacity) where n is number of items
    // Space Complexity: O(n * capacity) for dp array
    static void knapsackExample() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int capacity = Integer.parseInt(br.readLine());
        
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[n + 1][capacity + 1];
        
        // Fill dp table - O(n * capacity)
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + values[i]); // O(1)
                } else {
                    dp[i][w] = dp[i-1][w];  // O(1)
                }
            }
        }
        
        System.out.println("배낭 문제 최댓값: " + dp[n][capacity]);
    }
}