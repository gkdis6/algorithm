import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] capacity;
    static int[][] flow;
    static Map<Character, Integer> nodeMap = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        capacity = new int[52][52];
        flow = new int[52][52];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char from = st.nextToken().charAt(0);
            char to = st.nextToken().charAt(0);
            int cap = Integer.parseInt(st.nextToken());
            
            int fromIdx = getNodeIndex(from);
            int toIdx = getNodeIndex(to);
            
            capacity[fromIdx][toIdx] += cap;
            capacity[toIdx][fromIdx] += cap;
        }
        
        int source = getNodeIndex('A');
        int sink = getNodeIndex('Z');
        
        System.out.println(maxFlow(source, sink));
    }
    
    static int getNodeIndex(char c) {
        if (!nodeMap.containsKey(c)) {
            if (c >= 'A' && c <= 'Z') {
                nodeMap.put(c, c - 'A');
            } else {
                nodeMap.put(c, c - 'a' + 26);
            }
        }
        return nodeMap.get(c);
    }
    
    static int maxFlow(int source, int sink) {
        int totalFlow = 0;
        
        while (true) {
            int[] parent = new int[52];
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            parent[source] = source;
            
            while (!queue.isEmpty() && parent[sink] == -1) {
                int curr = queue.poll();
                
                for (int next = 0; next < 52; next++) {
                    if (parent[next] == -1 && capacity[curr][next] - flow[curr][next] > 0) {
                        parent[next] = curr;
                        queue.offer(next);
                    }
                }
            }
            
            if (parent[sink] == -1) break;
            
            int pathFlow = Integer.MAX_VALUE;
            for (int curr = sink; curr != source; curr = parent[curr]) {
                int prev = parent[curr];
                pathFlow = Math.min(pathFlow, capacity[prev][curr] - flow[prev][curr]);
            }
            
            for (int curr = sink; curr != source; curr = parent[curr]) {
                int prev = parent[curr];
                flow[prev][curr] += pathFlow;
                flow[curr][prev] -= pathFlow;
            }
            
            totalFlow += pathFlow;
        }
        
        return totalFlow;
    }
}