import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Pair[] arr = new Pair[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i] = new Pair(a, b);
            }
            
            Arrays.sort(arr, (p1, p2) -> p1.a - p2.a);

            int count = 1;
            int minB = arr[0].b;

            for (int i = 1; i < N; i++) {
                if (arr[i].b < minB) {
                    count++;
                    minB = arr[i].b;
                }
            }
            
            System.out.println(count);
        }
    }

    static class Pair {
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
