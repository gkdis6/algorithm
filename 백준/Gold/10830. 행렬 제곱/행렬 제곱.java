import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000;
    static int[][] origin;
    static int n;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        origin = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, m);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] pow(int[][] arr, long exp){
        if(exp == 1L){
            return arr;
        }
        int[][] ret = pow(arr, exp/2);
        ret = multiply(ret, ret);
        if(exp%2 == 1L){
            ret = multiply(ret, origin);
        }

        return ret;
    }

    public static int[][] multiply(int[][] o1, int[][] o2){
        int[][] ret = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<n; k++){
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}