import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0) {
                if(que.isEmpty()) sb.append("0\n");
                else sb.append(que.poll()+"\n");
            }else {
                que.add(cur);
            }
        }
        System.out.println(sb);
    }
}