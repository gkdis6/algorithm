import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                if (pq.size() < N) {
                    pq.offer(num);
                } else if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        
        System.out.println(pq.peek());
    }
}