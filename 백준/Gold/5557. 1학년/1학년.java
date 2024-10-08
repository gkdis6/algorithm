import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {

    static int n;
    static long[][] dp;
    static int[] arr;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new long[n][21];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0][arr[0]] = 1;

        int plus, minus;

        for(int i = 1; i < n-1; i++){
            for(int j = 0; j <= 20; j++){
                if(dp[i-1][j] != 0){
                    plus = j + arr[i];
                    minus = j - arr[i];

                    if(plus >= 0 && plus <= 20) dp[i][plus] += dp[i-1][j];
                    if(minus >= 0 && minus <= 20) dp[i][minus] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);
    }
}