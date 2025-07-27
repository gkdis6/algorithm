import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int diff = M - N;
            int k = (int) Math.sqrt(diff);
            
            if(diff <= k * k) {
                System.out.println(2 * k - 1);
            } else if(diff <= k * k + k) {
                System.out.println(2 * k);
            } else {
                System.out.println(2 * k + 1);
            }
        }
    }
}