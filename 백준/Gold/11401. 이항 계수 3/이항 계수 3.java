import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long p = 1000000007;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long number = factorial(n);
        long denom = factorial(k) * factorial(n-k) % p;

        System.out.println(number * pow(denom, p-2) %p);
    }

    private static long pow(long denom, long l) {
        if(l == 1) return denom % p;

        long temp = pow(denom, l/2);

        return (temp * temp % p) * (long) (Math.pow(denom, l % 2)) % p;
    }

    private static long factorial(long n) {
        long fac = 1L;

        while(n > 1) {
            fac = (fac * n) %p;
            n--;
        }
        return fac;
    }
}