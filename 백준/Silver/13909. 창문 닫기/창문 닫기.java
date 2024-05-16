import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
//        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 1; i*i<=n; i++){
            count++;
        }
        System.out.println(count);
    }
}

