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
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[][] dp = new int[2][k];
            int[][] num = new int[2][k];
            for(int j = 0; j<2; j++){
                st = new StringTokenizer(br.readLine());
                for(int l = 0; l<k; l++){
                    num[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = num[0][0];
            dp[1][0] = num[1][0];
            if(k > 1){
                dp[0][1] = dp[1][0] + num[0][1];
                dp[1][1] = dp[0][0] + num[1][1];
            }
            for(int j = 2; j<k; j++){
                dp[0][j] = Math.max(dp[1][j-1], Math.max(dp[0][j-2], dp[1][j-2])) + num[0][j];
                dp[1][j] = Math.max(dp[0][j-1], Math.max(dp[1][j-2], dp[0][j-2])) + num[1][j];
            }
            System.out.println(Math.max(dp[0][k-1], dp[1][k-1]));
        }   
    }
}