import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0 ; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;

        for(int i = 0; i<n-1 ; i++){
            gcd = gcd(gcd,arr[i+1]-arr[i]);
        }

        System.out.println((arr[n-1]-arr[0])/gcd+1-arr.length);
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}