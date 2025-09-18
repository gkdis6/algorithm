import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        char[] arr = br.readLine().toCharArray();
        char cur = arr[0];
        int count = 0;

        for(char c : arr) {
            if(cur != c) {
                count++;
                cur = c;
            }
        }
        System.out.println(count % 2 == 1 ? count/2 + 1 : count/2);
    }
}