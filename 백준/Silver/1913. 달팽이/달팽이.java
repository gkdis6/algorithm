import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, fx, fy;
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n][n];
        makeMap(n);

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map.length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(fy+1).append(" ").append(fx+1);
        System.out.println(sb);
    }

    private static void makeMap(int n) {
        int x = 0, y = 0;
        int cur = n*n;
        int direct = 0;
        map[y][x] = cur;
        while(true){
            if(cur == 1) break;
            int next_y = y + dy[direct%4];
            int next_x = x + dx[direct%4];
            if(next_x >= n || next_y >= n || next_x < 0 || next_y < 0 || map[next_y][next_x] != 0 ){
                direct++;
            } else {
                map[next_y][next_x] = --cur;
                x = next_x;
                y = next_y;
                if(cur == k) {
                    fx = x;
                    fy = y;
                }
            }
        }
    }
}