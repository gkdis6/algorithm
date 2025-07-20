import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
            int left = i;
            int right = N - 1;
            
            while(left <= right) {
                int mid = (left + right) / 2;
                int diff = arr[mid] - arr[i];
                
                if(diff >= M) {
                    answer = Math.min(answer, diff);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}