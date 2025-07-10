import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i < (1 << N); i++) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += A[j];
                    min = Math.min(min, A[j]);
                    max = Math.max(max, A[j]);
                }
            }
            if (sum >= L && sum <= R && max - min >= X) {
                count++;
            }
        }
        System.out.println(count);
    }
}