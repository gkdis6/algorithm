import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static int[] arr;
    static boolean[][] result;
    static int n, k;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        result = new boolean[n+1][40001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<k; i++){
            int t = Integer.parseInt(st.nextToken());
            if(result[n][t]) System.out.print("Y ");
            else System.out.print("N ");
        }

    }

    public static void find(int cur, int index){
        if(result[index][cur]) return;
        result[index][cur] = true;
        if(index == n) return;
        find(cur + arr[index], index+1);
        find(cur, index+1);
        find(Math.abs(cur - arr[index]), index+1);
    }
}