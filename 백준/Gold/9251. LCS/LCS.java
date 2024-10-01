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
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();
        // n = Integer.parseInt(st.nextToken());
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        int length1 = first.length;
        int length2 = second.length;

        int[][] dp = new int[length1+1][length2+1];

        for(int i = 1; i<=length1; i++){
            for(int j = 1; j<=length2; j++){
                if(first[i-1] == second[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[length1][length2]);
    }
}