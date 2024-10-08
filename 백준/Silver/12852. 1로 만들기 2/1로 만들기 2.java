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
        Value[] dp = new Value[n+1];
        dp[1] = new Value(0, "1");
        for(int i = 2; i<=n; i++){
            int cnt = Integer.MAX_VALUE;
            int before = 0;
            if (i % 3 == 0) {
                cnt = dp[i / 3].num;
                before = i / 3;
            }

            if (i % 2 == 0) {
                if (cnt > dp[i / 2].num) {
                cnt = dp[i / 2].num;
                before = i / 2;
                }
            }

            if (cnt > dp[i - 1].num) {
                before = i - 1;
            }

            dp[i] = new Value(dp[before].num + 1, i + " " + dp[before].process);
        }
        System.out.println(dp[n].num);
        System.out.println(dp[n].process);
    }

    public static class Value {
        int num;
        String process;

        Value(int num, String process) {
            this.num = num;
            this.process = process;
        }
    }
}