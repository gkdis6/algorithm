import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            que.add(i);
        }

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<m; j++){
                que.add(que.poll());
            }
            que2.add(que.poll());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(que2.size() > 0){
            sb.append(que2.poll());
            if(que2.size() > 0) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}

