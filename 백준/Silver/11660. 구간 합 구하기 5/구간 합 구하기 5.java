import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] SUM = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                SUM[i][j] = SUM[i][j-1] + SUM[i-1][j] - SUM[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int min_x = Integer.parseInt(st.nextToken());
            int min_y = Integer.parseInt(st.nextToken());
            int max_x = Integer.parseInt(st.nextToken());
            int max_y = Integer.parseInt(st.nextToken());

            System.out.println(SUM[max_x][max_y] - SUM[max_x][min_y-1] - SUM[min_x-1][max_y] + SUM[min_x-1][min_y-1]);
        }
    }
}