import java.io.*;
import java.util.*;

class DP_LIS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println("LIS 길이: " + lisLength(arr));
        System.out.println("LIS 길이 (최적화): " + lisOptimized(arr));
    }
    
    // LIS - O(n^2)
    static int lisLength(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
    
    // LIS - O(n log n) 최적화
    static int lisOptimized(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int pos = Collections.binarySearch(lis, arr[i]);
            
            if (pos < 0) {
                pos = -(pos + 1);
            }
            
            if (pos == lis.size()) {
                lis.add(arr[i]);
            } else {
                lis.set(pos, arr[i]);
            }
        }
        
        return lis.size();
    }
}