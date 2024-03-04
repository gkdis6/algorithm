
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

        int[] p = new int[n+1];
        int[] SUM = new int[m+1];
        SUM[0] = 1;

        for(int i = 1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            for(int j = p[i]; j<=m; j++){
                SUM[j] += SUM[j-p[i]];
            }
        }

        System.out.println(SUM[m]);
    }
}