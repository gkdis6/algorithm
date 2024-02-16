import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int a, b, c;
    static StringTokenizer st;
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited = new boolean[201][201];
    static boolean[] answer = new boolean[201];
    static int[] now = new int[3];

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());

        BFS();
        for(int i = 0; i<answer.length; i++){
            if(answer[i]) System.out.print(i + " ");
        }
    }

    static void BFS() {
        Queue<AB> queue = new LinkedList();
        queue.add(new AB(0,0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!queue.isEmpty()){
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;
            for (int i = 0; i < 6; i++){
                int[] next = {A, B, C};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;
                if(next[to[i]] > now[to[i]]){
                    next[from[i]] = next[to[i]] - now[to[i]];
                    next[to[i]] = now[to[i]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if(next[0] == 0) answer[next[2]] = true;
                }
            }
        }
    }

    static class AB {
        int A;
        int B;
        public AB(int A, int B){
            this.A = A;
            this.B = B;
        }
    }
}