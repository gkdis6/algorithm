import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board = new char[5][5];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        int result = 0;
        boolean[] selected = new boolean[25];
        result = combination(0, 0, selected);
        System.out.println(result);
    }
    
    static int combination(int idx, int count, boolean[] selected) {
        if (count == 7) {
            return isValid(selected) ? 1 : 0;
        }
        if (idx == 25) {
            return 0;
        }
        
        int result = 0;
        selected[idx] = true;
        result += combination(idx + 1, count + 1, selected);
        selected[idx] = false;
        result += combination(idx + 1, count, selected);
        
        return result;
    }
    
    static boolean isValid(boolean[] selected) {
        int sCount = 0;
        List<Integer> positions = new ArrayList<>();
        
        for (int i = 0; i < 25; i++) {
            if (selected[i]) {
                positions.add(i);
                int x = i / 5;
                int y = i % 5;
                if (board[x][y] == 'S') {
                    sCount++;
                }
            }
        }
        
        if (sCount < 4) return false;
        
        return isConnected(positions);
    }
    
    static boolean isConnected(List<Integer> positions) {
        if (positions.size() != 7) return false;
        
        Set<Integer> posSet = new HashSet<>(positions);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(positions.get(0));
        visited.add(positions.get(0));
        
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / 5;
            int y = pos % 5;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nextPos = nx * 5 + ny;
                
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && 
                    posSet.contains(nextPos) && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    queue.offer(nextPos);
                }
            }
        }
        
        return visited.size() == 7;
    }
}