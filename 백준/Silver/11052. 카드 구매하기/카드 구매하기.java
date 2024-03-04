import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] P = new int[n+1];
        int[] D = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        D[1] = P[1];
        //D[2] = 2*P[1], P[2]
        //D[3] = 3*P[1], P[1]+P[2]
        //D[4] = 4*P[1], P[1]+P[3], 2*p[2]
        for(int i = 1; i<=n; i++){
            int max = 0;
            for(int j = 1; j<=i/2; j++){
                max = Math.max(D[i-j]+D[j], max);
            }
            D[i] = Math.max(P[i], max);
        }
        System.out.println(D[n]);
    }
}