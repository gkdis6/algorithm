import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, String> arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new HashMap<String, String>();
        for(int i = 1; i<=n; i++) {
            String x = br.readLine();
            arr.put(x, String.valueOf(i));
            arr.put(String.valueOf(i), x);
        }

        for(int i = 0; i<m; i++){
            System.out.println(arr.get(br.readLine()));
        }
    }
}