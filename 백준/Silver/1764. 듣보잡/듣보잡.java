import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new HashSet<String>();
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            arr.add(x);
        }

        Set<String> contain = new HashSet<>();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(arr.contains(s)) contain.add(s);
        }

        System.out.println(contain.size());
        contain.stream().sorted().forEach(System.out::println);
    }
}