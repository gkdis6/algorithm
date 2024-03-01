import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[][] D = new long[31][31];

        for(int i = 0; i<31; i++){
            D[0][i] = 1;
        }
        
        for(int i = 1; i<=30; i++){
            for(int j = 1; j<=30; j++){
                D[j][i] = D[j][i-1] + D[j-1][i-1];
            }
        }

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            System.out.println(D[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
        }
    }
}