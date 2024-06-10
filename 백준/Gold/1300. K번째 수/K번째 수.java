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
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        find();
    }

    public static void find(){
        long start = 1;
        long end = k;
        while(start < end){
            long findPiece = 0;
            long mid = (start + end)/2;
            for(int i = 1; i<=n; i++){
                findPiece += Math.min(mid/i, n);
            }
            if(k <= findPiece){
                end = mid; //값을 줄이기
            }else{
                start = mid +1; //값을 키우기
            }
        }
        System.out.println(start);
    }
}