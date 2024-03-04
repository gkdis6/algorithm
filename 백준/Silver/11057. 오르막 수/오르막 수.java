import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] count = new int[n+1][10];
        Arrays.fill(count[0], 1);

        for(int k = 1; k<n+1; k++) {
            for (int i = 0; i < 10; i++) {
                for (int j = i; j < 10; j++) {
                    count[k][i] += count[k-1][j]%10007;
                }
            }
        }

        System.out.println(count[n][0] % 10007);
    }

}