import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] A;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A= new int[100001];
        visited = new boolean[100001];

        BFS(N);
        System.out.println(A[M]);
    }
    private static void BFS(int i) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        visited[i] = true;
        while(!que.isEmpty()) {
            int now = que.poll();
            if(now == M) return;
            if(now-1 >= 0 && !visited[now-1]){
                visited[now-1] = true;
                A[now-1] = A[now]+1;
                que.add(now-1);
            }
            if(now+1 <= 100000 && !visited[now+1]){
                visited[now+1] = true;
                A[now+1] = A[now]+1;
                que.add(now+1);
            }
            if(2*now <= 100000 && !visited[2*now]){
                visited[2*now] = true;
                A[2*now] = A[now]+1;
                que.add(2*now);
            }
        }
    }
}