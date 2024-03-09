import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (arr[i] > arr[i - j * j] + 1) {
                    arr[i] = arr[i - j * j] + 1;
                }
            }
        }

        System.out.println(arr[n]);
    }
}