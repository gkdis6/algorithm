import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static class WolfNode {
        int idx, cost, state;
        WolfNode(int idx, int cost, int state) {
            this.idx = idx;
            this.cost = cost;
            this.state = state;
        }
    }

    public static void main(String[] args) throws IOException {
        initGraph();

        int[] foxDist = dijkstraFox(1);
        int[][] wolfDist = dijkstraWolf(1);

        int result = countFoxWins(foxDist, wolfDist);
        System.out.println(result);
    }

    static void initGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2;

            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }
    }

    static int[] dijkstraFox(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.idx] < cur.cost) continue;

            for (Node next : graph.get(cur.idx)) {
                int newCost = cur.cost + next.cost;
                if (dist[next.idx] > newCost) {
                    dist[next.idx] = newCost;
                    pq.offer(new Node(next.idx, newCost));
                }
            }
        }

        return dist;
    }

    static int[][] dijkstraWolf(int start) {
        int[][] dist = new int[V + 1][2]; // 0: 빠르게 도착, 1: 느리게 도착
        for (int i = 0; i <= V; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<WolfNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[start][0] = 0;
        pq.offer(new WolfNode(start, 0, 0));

        while (!pq.isEmpty()) {
            WolfNode cur = pq.poll();
            if (dist[cur.idx][cur.state] < cur.cost) continue;

            for (Node next : graph.get(cur.idx)) {
                int nextState = 1 - cur.state;
                int nextCost = cur.cost + (cur.state == 0 ? next.cost / 2 : next.cost * 2);

                if (dist[next.idx][nextState] > nextCost) {
                    dist[next.idx][nextState] = nextCost;
                    pq.offer(new WolfNode(next.idx, nextCost, nextState));
                }
            }
        }

        return dist;
    }

    static int countFoxWins(int[] foxDist, int[][] wolfDist) {
        int count = 0;
        for (int i = 2; i <= V; i++) {
            if (foxDist[i] < Math.min(wolfDist[i][0], wolfDist[i][1])) {
                count++;
            }
        }
        return count;
    }
}