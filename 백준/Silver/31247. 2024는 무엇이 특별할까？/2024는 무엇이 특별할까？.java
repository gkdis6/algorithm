import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());;

            if (K > 1000000) { //2^10 -> 1024 => 10^3
                System.out.println(0);
                continue;
            }
            long powK = 1L << K;
            long powKPlus1 = powK << 1;
            long result = (N / powK) - (N / powKPlus1);
            System.out.println(result);
        }
    }
}