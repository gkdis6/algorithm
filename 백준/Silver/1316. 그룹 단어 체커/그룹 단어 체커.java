import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
//        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 1; i <= n; i++){
            char[] chars = br.readLine().toCharArray();
            boolean[] visited = new boolean[26];
            char pre = ' ';
            boolean flag = true;
            for(int j = 0; j < chars.length; j++){
                if(pre == chars[j]) continue;
                pre = chars[j];
                if(visited[chars[j] - 'a']) {
                    flag = false;
                    break;
                }
                visited[chars[j] - 'a'] = true;
            }
            if(flag) answer++;
        }

        System.out.println(answer);

    }
}

