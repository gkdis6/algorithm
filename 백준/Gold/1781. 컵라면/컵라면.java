import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] problems = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(problems, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            int deadline = problems[i][0];
            int ramen = problems[i][1];
            
            pq.offer(ramen);
            
            if (pq.size() > deadline) {
                pq.poll();
            }
        }
        
        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        
        System.out.println(result);
    }
}