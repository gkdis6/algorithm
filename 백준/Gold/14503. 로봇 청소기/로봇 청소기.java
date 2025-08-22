import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int init_dir = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulateRobot(arr, N, M, x, y, init_dir);

        System.out.println(result);
    }

    static void simulateRobot(int[][] arr, int N, int M, int r, int c, int d) {
        while(true) {
            if(arr[r][c] == 0) {
                result++;
                arr[r][c] = 2;
            }
            
            boolean found = false;
            for(int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    found = true;
                    break;
                }
            }
            
            if(!found) {
                int backDir = (d + 2) % 4;
                int br = r + dir[backDir][0];
                int bc = c + dir[backDir][1];
                
                if(br >= 0 && br < N && bc >= 0 && bc < M && arr[br][bc] != 1) {
                    r = br;
                    c = bc;
                } else {
                    break;
                }
            }
        }
    }

}