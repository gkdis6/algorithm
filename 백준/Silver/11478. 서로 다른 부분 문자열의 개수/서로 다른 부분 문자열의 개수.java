import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> arr;

    public static void main(String[] args) throws IOException{
//        st = new StringTokenizer(br.readLine());
        String str = br.readLine();

        arr = new HashSet<String>();
        for(int i = 0; i<str.length(); i++) {
            for(int j = i+1; j<=str.length(); j++) {
                arr.add(str.substring(i,j));
            }
        }

        System.out.println(arr.size());
    }
}