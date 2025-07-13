import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }
        
        int remove = Integer.parseInt(br.readLine());
        
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            children.add(new ArrayList<>());
        }
        
        int root = -1;
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {
                root = i;
            } else {
                children.get(parent[i]).add(i);
            }
        }
        
        if (remove == root) {
            System.out.println(0);
            return;
        }
        
        boolean[] removed = new boolean[N];
        markRemoved(remove, children, removed);
        
        for (int i = 0; i < N; i++) {
            if (!removed[i] && parent[i] != -1 && removed[parent[i]]) {
            }
        }
        
        int leafCount = 0;
        for (int i = 0; i < N; i++) {
            if (!removed[i]) {
                boolean isLeaf = true;
                for (int child : children.get(i)) {
                    if (!removed[child]) {
                        isLeaf = false;
                        break;
                    }
                }
                if (isLeaf) {
                    leafCount++;
                }
            }
        }
        
        System.out.println(leafCount);
    }
    
    static void markRemoved(int node, List<List<Integer>> children, boolean[] removed) {
        removed[node] = true;
        for (int child : children.get(node)) {
            markRemoved(child, children, removed);
        }
    }
}