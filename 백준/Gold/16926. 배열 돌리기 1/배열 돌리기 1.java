import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, r;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roll(r);
        for(int j = 0; j< n; j++) {
            for(int h = 0; h< m; h++) {
                System.out.print(map[j][h]+" ");
            }
            System.out.println();
        }
    }

    private static void roll(int times){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int tr = 0; tr<times; tr++) {
            int min = Math.min(n,m);
            for (int i = 0; i < min / 2; i++) {
                int pre = map[i][i];
                for(int j = 0, ptr = 0, curX = i, curY = i; j < 2*n+2*m-4-8*i; j++) {
                    if(curY +dy[ptr] < i || curY + dy[ptr] >= n-i || curX + dx[ptr] < i || curX + dx[ptr] >= m-i) ptr = (ptr + 1)%4;
                    curY = curY+dy[ptr];
                    curX = curX+dx[ptr];
                    int cur = map[curY][curX];
                    map[curY][curX] = pre;
                    pre = cur;
                }
            }
        }
    }
}

