import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static long[][] origin = {{1,1}, {1,0}}, arr = {{1,1}, {1,0}};
    static long n;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());

        System.out.println(pow(arr, n-1)[0][0]);
    }

    public static long[][] pow(long[][] arr, long exp){
        if(exp == 1 || exp == 0){
            return arr;
        }
        long[][] ret = pow(arr, exp/2);
        ret = multiply(ret, ret);
        if(exp%2 == 1L){
            ret = multiply(ret, origin);
        }

        return ret;
    }

    public static long[][] multiply(long[][] o1, long[][] o2){
        long[][] ret = new long[2][2];

        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                for(int k = 0; k<2; k++){
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}