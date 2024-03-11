import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static Integer[] dp;
    static int n;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new Integer[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i<=n; i++) {
            cycle(i);
        }
        int max = 1;
        for(int i = 1; i<=n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int cycle(int n) {
        if(dp[n] == null) {
            dp[n] = 1;
            for(int i = n; i>0; i--) {
                if(arr[n]<arr[i]) {
                    dp[n] = Math.max(dp[n], cycle(i)+1);
                }
            }
        }
        return dp[n];
    }
}