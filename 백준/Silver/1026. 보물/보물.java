import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr_a = new int[N];
        Integer[] arr_b = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr_a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr_b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_a);
        Arrays.sort(arr_b, (a, b) -> b - a);

        int result = 0;
        for(int i = 0; i < N; i++) {
            result += arr_a[i] * arr_b[i];
        }
        System.out.println(result);
    }
}