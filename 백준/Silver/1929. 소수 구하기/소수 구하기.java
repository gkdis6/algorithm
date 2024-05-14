import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = n; i<=m; i++){
            findPrime(i);
        }
    }

    private static void findPrime(int n) {
        if(n == 1) return;
        for(int j = 2; j<=Math.sqrt(n); j++) {
            if(n%j == 0) {
                return;
            }
        }
        System.out.println(n);
    }
}

