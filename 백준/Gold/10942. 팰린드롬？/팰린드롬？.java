import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dp[start][end] ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }
}
