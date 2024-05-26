import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sum = new long[n+1];
        long[] cnt = new long[m];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            sum[i] = (Integer.parseInt(st.nextToken()) + sum[i-1]) % m;
            if(sum[i] == 0) result++;
            cnt[(int) sum[i]]++;
        }
        for(int i = 0; i<m; i++){
            if(cnt[i] > 1) result += (cnt[i] * (cnt[i] -1) /2);
        }
        System.out.println(result);
    }
}