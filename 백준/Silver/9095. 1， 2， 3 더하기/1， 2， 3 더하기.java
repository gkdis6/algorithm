import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] D = new int[12];
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for(int i = 4; i<12; i++){
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(D[m]);
        }
    }
}