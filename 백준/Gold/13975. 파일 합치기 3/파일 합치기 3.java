import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            PriorityQueue<Long> pq = new PriorityQueue<>();
            int T = Integer.parseInt(br.readLine());
            for(int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    long num = Long.parseLong(st.nextToken());
                    pq.add(num);
                }
                long sum = 0;
                while(pq.size() > 1) {
                    long a = pq.poll();
                    long b = pq.poll();
                    long cost = a + b;
                    sum += cost;
                    pq.add(cost);
                }
                bw.write(sum + "\n");
                pq.clear();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
