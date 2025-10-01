import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] count = new int[n+1];
        for(int i=0; i<n; i++) {
            count[arr[i]]++;
        }
        int result = 0;
        for(int i=0; i<n; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i] && count[arr[j]] > max) {
                    max = count[arr[j]];
                }
            }
            count[arr[i]] = max+1;
            result = Math.max(result, count[arr[i]]);
        }
        System.out.println(n - result);
    }
}