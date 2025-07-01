import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp_left = new int[N];
        int[] dp_right = new int[N];

        dp_left[0] = arr[0];
        int max_sum = arr[0];

        for (int i = 1; i < N; i++) {
            dp_left[i] = Math.max(arr[i], dp_left[i-1] + arr[i]);
            max_sum = Math.max(max_sum, dp_left[i]);
        }

        dp_right[N-1] = arr[N-1];
        for (int i = N - 2; i >= 0; i--) {
            dp_right[i] = Math.max(arr[i], dp_right[i+1] + arr[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            max_sum = Math.max(max_sum, dp_left[i-1] + dp_right[i+1]);
        }
        
        System.out.println(max_sum);
    }
}
