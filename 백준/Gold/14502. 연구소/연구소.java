import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] lab;
    static int maxSafeArea = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                } else if (lab[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        
        buildWalls(0, 0);
        System.out.println(maxSafeArea);
    }
    
    static void buildWalls(int count, int start) {
        if (count == 3) {
            int safeArea = simulate();
            maxSafeArea = Math.max(maxSafeArea, safeArea);
            return;
        }
        
        for (int i = start; i < emptySpaces.size(); i++) {
            int[] pos = emptySpaces.get(i);
            lab[pos[0]][pos[1]] = 1;
            buildWalls(count + 1, i + 1);
            lab[pos[0]][pos[1]] = 0;
        }
    }
    
    static int simulate() {
        int[][] tempLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempLab[i] = lab[i].clone();
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : viruses) {
            queue.offer(new int[]{virus[0], virus[1]});
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) {
                    safeCount++;
                }
            }
        }
        
        return safeCount;
    }
}