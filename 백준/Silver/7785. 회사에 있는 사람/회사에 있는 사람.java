import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> arr = new HashSet<String>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if("enter".equals(st.nextToken())) arr.add(name);
            else arr.remove(name);
        }

        arr.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}