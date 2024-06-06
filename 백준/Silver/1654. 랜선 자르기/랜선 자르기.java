import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static int[] arr;
    static int n, k;
    static long max = 0;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for(int i = 0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        find(arr);
    }

    public static void find(int[] arr){
        long start = 0;
        long end = max+1;
        while(start < end){
            long findPiece = 0;
            long mid = (start + end)/2;
            for(int i = 0; i<k; i++){
                findPiece += arr[i]/mid;
            }
            if(n > findPiece){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        System.out.println(start -1);
    }
}