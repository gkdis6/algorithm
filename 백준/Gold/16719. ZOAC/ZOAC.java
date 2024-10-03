import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String str;
    static char[] chars;
    static PriorityQueue<Character> pq = new PriorityQueue<>();
    static boolean[] visited;


    public static void main(String[] args) throws IOException{
        str = br.readLine();

        chars = str.toCharArray();
        visited = new boolean[chars.length];


        pick(0, str.length() - 1);
        System.out.println(sb.toString());
    }

    private static void pick(int left, int right) {
        if (right < left) return;
        int idx = left;
        for(int i = left; i <= right; i++){
            if(str.charAt(idx) > str.charAt(i)){
                idx = i;
            }
        }
        visited[idx] = true;

        for(int i = 0; i < str.length(); i++){
            if(visited[i]){
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");
        pick(idx+1, right);
        pick(left, idx-1);
    }

}

