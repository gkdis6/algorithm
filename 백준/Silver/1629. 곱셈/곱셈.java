import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long k;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        System.out.println(sq(n, m));
    }

    private static long sq(long n, long m){
        if(m == 1) return n % k;
        long cur = sq(n, m/2);

        if(m % 2 == 1) return (cur * cur % k) * n % k;
        return cur * cur % k;
    }
}