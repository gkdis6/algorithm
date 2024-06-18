import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static int[] arr;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        int[] cnt = new int[1_000_001];
        int[] answer = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]){
                answer[stack.pop()] = arr[i];
            }

            stack.add(i);
        }

        while(!stack.isEmpty()) answer[stack.pop()] = -1;

        for(int i = 0; i<n; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}