import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        int[] ranks = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(weight, height);
            ranks[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(nodes[i].weight < nodes[j].weight && nodes[i].height < nodes[j].height) {
                    ranks[i]++;
                }else if(nodes[i].weight > nodes[j].weight && nodes[i].height > nodes[j].height) {
                    ranks[j]++;
                }
            }
            System.out.print(ranks[i] + " ");
        }

    }

    static class Node {
        int weight;
        int height;

        public Node(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}