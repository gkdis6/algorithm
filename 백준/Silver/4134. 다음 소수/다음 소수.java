import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        long n = Long.parseLong(br.readLine());
        for(int i = 0; i<n; i++){
            System.out.println(findPrime(Long.parseLong(br.readLine())));
        }
    }

    private static long findPrime(long n) {
        if(n == 0) return 2;
        if(n == 1) return 2;
        for(int j = 2; j<=Math.sqrt(n); j++) {
            if(n%j == 0) {
                return findPrime(n+1);
            }
        }
        return n;
    }
}

