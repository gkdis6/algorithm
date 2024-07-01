import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer> list[];
    static int n;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        visit = new boolean[n+1];
        list = new ArrayList[n+1];

        for(int i = 0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i = 2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int index){
        visit[index] = true;

        for(int i: list[index]){
            if(!visit[i]){
                parent[i] = index;
                dfs(i);
            }
        }
    }
}