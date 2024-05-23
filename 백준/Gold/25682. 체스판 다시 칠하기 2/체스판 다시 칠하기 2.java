import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        arr = new int[n+1][m+1];

        for(int i = 1; i<=n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = line.charAt(j-1);
                if((i+j)%2 == 1 && c == 'W') arr[i][j] = 1;
                else if((i+j)%2 == 0 && c == 'B') arr[i][j] = 1;
            }
        }

        for(int i = 1; i<=n; i++){
            int temp = arr[i][1];
            for(int j = 2; j<=m; j++){
                temp += arr[i][j];
                arr[i][j] = temp;
            }
        }

        for(int i = 1; i<=m; i++){
            int temp = arr[1][i];
            for(int j = 2; j<=n; j++){
                temp += arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i = k; i<=n; i++){
            for(int j = k; j<=m; j++){
                int temp = arr[i][j] - (arr[i-k][j] + arr[i][j-k] - arr[i-k][j-k]);
                min = Math.min(min, temp);
                max = Math.max(max, temp);
            }
        }

        int answer = Math.min(min, k*k-max);
        System.out.println(answer);
    }
}