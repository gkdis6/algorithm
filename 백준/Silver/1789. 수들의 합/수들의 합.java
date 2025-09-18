import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());
        int count = 0;
        while(N - count > 0) {
            count++;
            N -= count;
        }
        System.out.println(count);
    }
}