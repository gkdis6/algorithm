import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[N];
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                sum[i] += arr[j];
                if(sum[i] == M) {
                    result++;
                }else if(sum[i] > M) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}