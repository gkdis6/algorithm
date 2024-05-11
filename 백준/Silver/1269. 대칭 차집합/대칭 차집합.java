import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<Integer> arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new HashSet<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            Integer x = Integer.parseInt(st.nextToken());
            arr.add(x);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            Integer x = Integer.parseInt(st.nextToken());
            if(arr.contains(x)) arr.remove(x);
            else count++;
        }

        System.out.println(arr.size()+count);
    }
}