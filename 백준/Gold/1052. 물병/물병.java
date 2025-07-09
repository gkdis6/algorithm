import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String binary = Integer.toBinaryString(N);
        int count = Integer.bitCount(N);

        int result = 0;

        while(count > K) {
            int lastOne = binary.length() - binary.lastIndexOf('1')-1;
            result += (1 << lastOne);
            N += (1 << lastOne);
            binary = Integer.toBinaryString(N);
            count = Integer.bitCount(N);
        }

        System.out.println(result);
    }
}