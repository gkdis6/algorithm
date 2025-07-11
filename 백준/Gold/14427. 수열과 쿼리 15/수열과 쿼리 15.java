import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static class Pair {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    static PriorityQueue<Pair> pq;
    static int[] A;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        
        pq = new PriorityQueue<>((a, b) -> {
            if (a.value != b.value) return a.value - b.value;
            return a.index - b.index;
        });
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            pq.offer(new Pair(A[i], i + 1));
        }
        
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            if(L == 1) {
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                A[index-1] = value;
                pq.offer(new Pair(value, index));
            }else{
                System.out.println(getMin());
            }
        }
    }

    private static int getMin() {
        while (!pq.isEmpty()) {
            Pair top = pq.peek();
            if (A[top.index - 1] == top.value) {
                return top.index;
            }
            pq.poll();
        }
        return -1;
    }
}