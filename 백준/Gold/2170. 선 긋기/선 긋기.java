import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        long sum = 0;
        long cur = Long.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new int[]{s, e});
        }
        while(!pq.isEmpty()) {
            int[] curP = pq.poll();
            if(curP[0] >= cur) {
                sum += curP[1] - curP[0];
                cur = curP[1];
            }else if(curP[1] > cur) {
                sum += curP[1] - cur;
                cur = curP[1];
            }
        }
        System.out.println(sum);
    }
}