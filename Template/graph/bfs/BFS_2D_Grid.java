import java.io.*;
import java.util.*;

class Point {
    int x, y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class BFS_2D_Grid {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] distance;
    static int n, m;
    
    // 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        grid = new char[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];
        
        // 2D 그리드 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        // BFS 실행 (0,0에서 시작)
        bfs2D(0, 0);
    }
    
    // 2D 그리드에서 BFS
    static void bfs2D(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        visited[startX][startY] = true;
        distance[startX][startY] = 0;
        queue.offer(new Point(startX, startY));
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (isValid(nx, ny) && !visited[nx][ny] && grid[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[current.x][current.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
    
    // 좌표 유효성 검사
    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    // 특정 목표점까지의 최단 거리
    static int bfsToTarget(int startX, int startY, int targetX, int targetY) {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[n][m];
        distance = new int[n][m];
        
        visited[startX][startY] = true;
        distance[startX][startY] = 0;
        queue.offer(new Point(startX, startY));
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            if (current.x == targetX && current.y == targetY) {
                return distance[current.x][current.y];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (isValid(nx, ny) && !visited[nx][ny] && grid[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[current.x][current.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        
        return -1; // 도달 불가능
    }
}