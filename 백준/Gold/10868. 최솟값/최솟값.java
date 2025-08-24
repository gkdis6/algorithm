import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        tree = new int[N*4];

        for(int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        build(1,1,N);

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = query(1,1,N,a,b);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void build(int node, int start, int end) {
           if (start == end) {
               tree[node] = arr[start];
           } else {
               int mid = (start + end) / 2;
               build(2 * node, start, mid);
               build(2 * node + 1, mid + 1, end);
               tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
           }
       }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return Integer.MAX_VALUE;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int p1 = query(2 * node, start, mid, l, r);
        int p2 = query(2 * node + 1, mid + 1, end, l, r);
        return Math.min(p1, p2);
    }
}