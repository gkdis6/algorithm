import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(),".");
            st.nextToken();
            pq.add(st.nextToken());
        }
        while(pq.size()>0){
            String cur = pq.poll();
            int count = 1;
            while(cur.equals(pq.peek())){
                pq.poll();
                count++;
            }
            System.out.println(cur + " " + count);
        }
    }
}

