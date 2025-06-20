import java.io.*;
import java.util.*;

class Main {
    static long N;
    static int P, Q;
    static HashMap<Long, Long> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map.put(0L, 1L);
        System.out.println(solve(N));
    }

    static Long solve(long n) {
        if (map.containsKey(n)) return map.get(n);
        map.put(n, solve(n / P) + solve(n / Q));
        return map.get(n);
    }
}