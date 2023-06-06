# Dance Dance Revolution

https://www.acmicpc.net/problem/2342

```java
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
    static int[][][] dp;
    static int[] arr;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();
        // n = Integer.parseInt(st.nextToken());
        String[] s = br.readLine().split(" ");
        n = s.length-1;
        arr = new int[n];
        dp = new int[n][5][5];
        
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        
        int answer = go(0,0,0);
        System.out.println(answer);
    }

    static int go(int idx, int left, int right){
        if(idx == n) return 0;
        if(dp[idx][left][right] != 0) return dp[idx][left][right];
        int leftFoot = go(idx+1, arr[idx], right) + solve(left, arr[idx]);
        int rightFoot = go(idx+1, left, arr[idx]) + solve(right, arr[idx]);

        return dp[idx][left][right] = Math.min(leftFoot, rightFoot);
    }

    static int solve(int from, int to){
        int ret = 0;
        if(from == 0) ret = 2;
        else if(from == to) ret = 1;
        else if(Math.abs(from-to) == 2) ret = 4;
        else ret = 3;
        return ret;
    }
}
```

