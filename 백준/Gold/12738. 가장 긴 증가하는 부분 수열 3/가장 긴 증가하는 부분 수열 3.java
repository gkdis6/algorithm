import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(lisOptimized(arr));
    }

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