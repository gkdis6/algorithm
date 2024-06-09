import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static long[] arr;
    static int n, k;
    static long max = 0;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new long[k];
        for(int i = 0; i<k; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        find(arr);
    }

    public static void find(long[] arr){
        long start = 1;
        long end = arr[k-1] - arr[0] + 1;
        while(start < end){
            int findPiece = 1;
            long mid = (start + end)/2;
            long cur = arr[0];
            for(int i = 1; i<k; i++){
                if(arr[i] - cur >= mid) {
                    findPiece++;
                    cur = arr[i];
                }
            }
            if(n > findPiece){
                end = mid; //값을 줄이기
            }else{
                start = mid +1; //값을 키우기
            }
        }
        System.out.println(start -1);
    }
}