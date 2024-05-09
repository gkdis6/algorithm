import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, Integer> arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new HashMap<String, Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            String x = st.nextToken();
            arr.put(x, arr.getOrDefault(x,0)+1);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            sb.append(arr.getOrDefault(st.nextToken(), 0) + " ");
        }
        System.out.println(sb);
    }
}