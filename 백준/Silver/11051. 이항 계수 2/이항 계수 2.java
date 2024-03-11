import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0)
                    arr[i][j] = 1;
                else
                    arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % 10007;
            }
        }

        System.out.println(arr[n][k]);
    }
}