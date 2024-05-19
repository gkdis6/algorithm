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

        int[] arr = new int[n+1];
        int[] SUM = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            SUM[i] = SUM[i-1] + arr[i];
        }

        for(int i = 1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(SUM[b] - SUM[a-1]);
        }
    }
}