import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new String[n];

        for(int i = 0; i<n; i++) {
            String line = br.readLine();
            arr[i] = line;
        }

        int count = 0;
        for(int i = 0; i<m; i++) {
            String line = br.readLine();
            if(Arrays.stream(arr).anyMatch(line::equals)) count++;
        }

        System.out.println(count);

    }
}