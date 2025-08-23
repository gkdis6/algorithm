import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static char[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }
        
        System.out.println(maxDistance);
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        int maxDist = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            maxDist = Math.max(maxDist, dist);
            
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[nx][ny] == 'L' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        
        return maxDist;
    }
}