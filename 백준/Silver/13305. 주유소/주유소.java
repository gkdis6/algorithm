import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] distance;
    static long[] cost;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        distance = new long[n-1];
        cost = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;
        long min = Long.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++) {
            cost[i] = Long.parseLong(st.nextToken());
            min = Math.min(cost[i], min);
            result += min * distance[i];
        }

        System.out.println(result);
    }
}