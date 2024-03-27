import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int[][] arr, dp;
    static int[] x_array = {1, 0, -1, 0};
    static int[] y_array = {0, 1, 0, -1};
    static int n, m, count;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for(int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<=n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(1,1));
    }

    public static int dfs(int y, int x){
        if(y == n && x == m) return 1;
        if(dp[y][x] != -1) return dp[y][x];
        dp[y][x] = 0;
        for(int i = 0; i<4; i++){
            if(x+x_array[i] > m || y+y_array[i] > n || x+x_array[i] < 1 || y+y_array[i] < 1) continue;
            if(arr[y+y_array[i]][x+x_array[i]] < arr[y][x]) {
                dp[y][x] += dfs(y+y_array[i], x+x_array[i]);
            }
        }
        return dp[y][x];
    }

}