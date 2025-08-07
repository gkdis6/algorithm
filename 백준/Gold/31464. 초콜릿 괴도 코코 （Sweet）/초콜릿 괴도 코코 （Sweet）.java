import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<int[]> result = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] charArr = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                map[i][j] = (charArr[j] == '#');
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j]) {
                    if(isValidRemoval(map, i, j, N)) {
                        result.add(new int[]{i, j});
                    }
                }
            }
        }

        System.out.println(result.size());
        for(int[] pos : result) {
            System.out.println((pos[0]+1) + " " + (pos[1]+1));
        }
    }
    
    private static boolean isValidRemoval(boolean[][] map, int removeI, int removeJ, int N) {
        map[removeI][removeJ] = false;
        
        if (!isConnected(map, N)) {
            map[removeI][removeJ] = true;
            return false;
        }
        
        int nodes = 0;
        int edges = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!map[i][j]) continue;
                nodes++;
                
                for(int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    
                    if(ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj]) {
                        if(i < ni || (i == ni && j < nj)) {
                            edges++;
                        }
                    }
                }
            }
        }
        
        boolean result = (edges == nodes - 1);
        
        map[removeI][removeJ] = true;
        return result;
    }
    
    private static boolean isConnected(boolean[][] map, int N) {
        boolean[][] visited = new boolean[N][N];
        int components = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] && !visited[i][j]) {
                    dfs(map, visited, i, j, N);
                    components++;
                    if(components > 1) return false;
                }
            }
        }
        return components == 1;
    }
    
    private static void dfs(boolean[][] map, boolean[][] visited, int i, int j, int N) {
        visited[i][j] = true;
        
        for(int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            
            if(ni >= 0 && ni < N && nj >= 0 && nj < N && 
               map[ni][nj] && !visited[ni][nj]) {
                dfs(map, visited, ni, nj, N);
            }
        }
    }
}