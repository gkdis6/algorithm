import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Integer[] arr_a = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr_a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr_a, (o1, o2) -> o2-o1);
        int result = 0;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            if(arr_a[left] + arr_a[right] > x) {
                left++;
            } else if(arr_a[left] + arr_a[right] < x) {
                right--;
            } else {
                result++;
                left++;
                right--;
            }
        }
        
        System.out.println(result);
    }
}