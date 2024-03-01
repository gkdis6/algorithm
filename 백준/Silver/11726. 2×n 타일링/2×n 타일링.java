import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] D = new long[1001];
        D[1] = 1;
        D[2] = 2;

        for(int i = 3; i<=n; i++){
            D[i] = (D[i-1] + D[i-2])%10007;
        }
        System.out.println(D[n]);
    }
}