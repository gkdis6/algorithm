import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long gcd = arr[1] - arr[0];
        for(int j = 2; j < N; j++) {
            gcd = gcd(gcd, arr[j] - arr[j - 1]);
        }

        List<Long> divisors = new ArrayList<>();
        for (long i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                if (i > 1) divisors.add(i);
                if (i != gcd / i && gcd / i > 1) {
                    divisors.add(gcd / i);
                }
            }
        }

        Collections.sort(divisors);
        for (long d : divisors) {
            System.out.print(d + " ");
        }
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}