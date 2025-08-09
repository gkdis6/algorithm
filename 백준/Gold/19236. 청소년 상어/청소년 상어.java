import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        Fish[][] board = new Fish[4][4];
        
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = new Fish(num, dir);
            }
        }
        
        // 상어가 (0,0) 물고기 먹음
        int sharkX = 0, sharkY = 0;
        int sharkDir = board[0][0].dir;
        int sum = board[0][0].num;
        board[0][0] = null; // 물고기 제거
        
        // Debug: print initial state
        // System.out.println("Initial shark at (" + sharkX + "," + sharkY + ") dir=" + sharkDir + " sum=" + sum);
        
        dfs(board, sharkX, sharkY, sharkDir, sum);
        System.out.println(maxSum);
    }
    
    static void dfs(Fish[][] board, int sharkX, int sharkY, int sharkDir, int sum) {
        maxSum = Math.max(maxSum, sum);
        
        // 물고기 이동
        Fish[][] newBoard = copyBoard(board);
        moveFish(newBoard, sharkX, sharkY);
        
        // 상어 이동
        for (int step = 1; step <= 3; step++) {
            int nx = sharkX + dx[sharkDir] * step;
            int ny = sharkY + dy[sharkDir] * step;
            
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
            if (newBoard[nx][ny] == null) continue;
            
            Fish fish = newBoard[nx][ny];
            newBoard[nx][ny] = null;
            
            dfs(newBoard, nx, ny, fish.dir, sum + fish.num);
            
            newBoard[nx][ny] = fish; // 백트래킹
        }
    }
    
    static void moveFish(Fish[][] board, int sharkX, int sharkY) {
        for (int fishNum = 1; fishNum <= 16; fishNum++) {
            int[] pos = findFishPos(board, fishNum);
            if (pos == null) continue;
            
            int x = pos[0];
            int y = pos[1];
            Fish fish = board[x][y];
            int dir = fish.dir;
            
            for (int turn = 0; turn < 8; turn++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == sharkX && ny == sharkY)) {
                    if (board[nx][ny] == null) {
                        board[x][y] = null;
                        board[nx][ny] = new Fish(fish.num, dir);
                        break;
                    } else {
                        Fish target = board[nx][ny];
                        board[x][y] = target;
                        board[nx][ny] = fish;
                        fish.dir = dir;
                        break;
                    }
                }
                dir = (dir + 1) % 8;
            }
        }
    }
    
    static int[] findFishPos(Fish[][] board, int num) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null && board[i][j].num == num) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    static Fish[][] copyBoard(Fish[][] board) {
        Fish[][] newBoard = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null) {
                    newBoard[i][j] = new Fish(board[i][j].num, board[i][j].dir);
                }
            }
        }
        return newBoard;
    }
    
    static class Fish {
        int num, dir;
        
        Fish(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }
}