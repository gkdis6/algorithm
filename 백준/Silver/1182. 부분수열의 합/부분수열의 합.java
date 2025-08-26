import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S;
    static int[] nums;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0, 0);
        System.out.println(count);
    }
    
    static void backtrack(int index, int sum, int selected) {
        if (index == N) {
            if (sum == S && selected > 0) {
                count++;
            }
            return;
        }
        
        backtrack(index + 1, sum + nums[index], selected + 1);
        backtrack(index + 1, sum, selected);
    }
}