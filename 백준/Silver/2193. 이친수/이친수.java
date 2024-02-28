import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        long[][] D =  new long[n+1][2];
        D[1][1] = 1;
        D[1][0] = 0;

        for(int i = 2; i<n+1; i++){
            D[i][0] = D[i-1][1] + D[i-1][0];
            D[i][1] = D[i-1][0];
        }
        
        System.out.println(D[n][0] + D[n][1]);
    }
}