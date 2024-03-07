import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] arr, dp;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis();

        int max = 0;
        for(int i = 1; i<=n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static void lis() {
        for(int i = 1; i<=n; i++) {
            dp[i] = arr[i];
            for(int j = 1; j<i; j++) {
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
            }
        }
    }
}