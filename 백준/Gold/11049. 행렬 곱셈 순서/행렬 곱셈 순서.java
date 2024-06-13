import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static int[] arr;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i+1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(find(0,n-1));
    }

    public static int find(int index, int cur){
        if(index == cur) return 0;
        if(dp[index][cur] != Integer.MAX_VALUE) return dp[index][cur];
        
        for(int i = index; i<cur; i++){
            int value = find(index,i) + find(i+1, cur) + (arr[index]*arr[i+1]*arr[cur+1]);
            dp[index][cur] = Math.min(dp[index][cur], value);
        }
        return dp[index][cur];
    }
}