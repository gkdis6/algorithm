import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean isEven;
    static int[] check;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int times = Integer.parseInt(st.nextToken());

        for(int i = 0; i<times; i++){
            makeGraph();

            for(int j = 1; j<=n; j++){
                if(isEven) DFS(j);
                else break;
            }
            // check[1] = 0;
            System.out.println(isEven ? "YES" : "NO");
        }

    }

    static void makeGraph() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        check = new int[n+1];
        isEven = true;

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
    }

    static void DFS(int node){
        visited[node] = true;
        for(int i : graph[node]){
            if(!visited[i]){
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }else if(check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}