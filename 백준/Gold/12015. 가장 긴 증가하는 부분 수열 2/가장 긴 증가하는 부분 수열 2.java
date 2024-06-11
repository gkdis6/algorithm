import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static int[] arr, LIS;
    static int n;
    static long max = 0;

    public static void main(String[] args) throws IOException{
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        LIS = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LIS[0] = arr[0];
        int lengthLIS = 1;
        for(int i = 1; i<n; i++){
            int cur = arr[i];
            if(LIS[lengthLIS-1] < cur){
                LIS[++lengthLIS - 1] = cur;
            }else{
                int start = 0;
                int end = lengthLIS;
                while(start < end){
                    int mid = (start + end) >>> 1;
                    if(LIS[mid] < cur){
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }
                LIS[start] = cur;
            }
        }

        System.out.println(lengthLIS);
    }
}