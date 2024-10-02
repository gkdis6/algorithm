import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, l;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            map = new int[k][k];
            for(int j = 0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                for(int h = 0; h<k; h++) {
                    map[j][h] = Integer.parseInt(st.nextToken());
                }
            }

            roll(l);
            for(int j = 0; j<k; j++) {
                for(int h = 0; h<k; h++) {
                    System.out.print(map[j][h]+" ");
                }
                System.out.println();
            }
        }
    }

    private static void roll(int degree){
        boolean isMinus = degree < 0;
        int[] dy = isMinus ? new int[]{-1, -1, 0, 1, 1, 1, 0, -1} : new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int[] dx = isMinus ? new int[]{0, 1, 1, 1, 0, -1, -1, -1} : new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

        int times = Math.abs(degree/45);
        int center = k/2;
        for(int tr = 0; tr<times; tr++) {
            for (int i = 1; i < (k + 1) / 2; i++) {
                int pre = map[center - i][center - i];
                for (int j = 0; j < 8; j++) {
                    int cur = map[center + (i * dx[j])][center + (i * dy[j])];
                    map[center + (i * dx[j])][center + (i * dy[j])] = pre;
                    pre = cur;
                }
            }
        }
    }
}

