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
        
        boolean result = isTree(map, N);
        
        map[removeI][removeJ] = true;
        return result;
    }
    
    private static boolean isTree(boolean[][] map, int N) {
        boolean[][] visited = new boolean[N][N];
        int startI = -1, startJ = -1;
        
        for(int i = 0; i < N && startI == -1; i++) {
            for(int j = 0; j < N && startJ == -1; j++) {
                if(map[i][j]) {
                    startI = i;
                    startJ = j;
                }
            }
        }
        
        if(startI == -1) return false;
        
        if(hasCycle(map, visited, startI, startJ, -1, -1, N)) {
            return false;
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] && !visited[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean hasCycle(boolean[][] map, boolean[][] visited, int i, int j, int parentI, int parentJ, int N) {
        visited[i][j] = true;
        
        for(int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            
            if(ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj]) {
                if(ni == parentI && nj == parentJ) continue;
                
                if(visited[ni][nj] || hasCycle(map, visited, ni, nj, i, j, N)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
}