import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static ArrayList<ArrayList<int[]>> graph;
    public static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int maxWeight = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, weight});
            graph.get(b).add(new int[]{a, weight});
            maxWeight = Math.max(maxWeight, weight);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        int left = 1, right = maxWeight;
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(canReach(start, end, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canReach(int start, int end, int minWeight) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == end) return true;

            for(int[] edge : graph.get(curr)) {
                int next = edge[0];
                int weight = edge[1];
                if(!visited[next] && weight >= minWeight) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return false;
    }
}