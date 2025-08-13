import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n, m;
    static char[][] board;
    static int holeR, holeC;
    static boolean[][][][] visited;
    
    static class State {
        int rr, rc, br, bc, step;
        
        State(int rr, int rc, int br, int bc, int step) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.step = step;
        }
    }
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new char[n][m];
        visited = new boolean[n][m][n][m];
        
        int initRR = 0, initRC = 0, initBR = 0, initBC = 0;
        
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'R') {
                    initRR = i;
                    initRC = j;
                    board[i][j] = '.';
                } else if(board[i][j] == 'B') {
                    initBR = i;
                    initBC = j;
                    board[i][j] = '.';
                } else if(board[i][j] == 'O') {
                    holeR = i;
                    holeC = j;
                }
            }
        }
        
        System.out.println(bfs(initRR, initRC, initBR, initBC));
    }
    
    static int bfs(int rr, int rc, int br, int bc) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(rr, rc, br, bc, 0));
        visited[rr][rc][br][bc] = true;
        
        while(!queue.isEmpty()) {
            State current = queue.poll();
            
            if(current.step >= 10) continue;
            
            for(int dir = 0; dir < 4; dir++) {
                int[] redResult = moveBall(current.rr, current.rc, dir);
                int[] blueResult = moveBall(current.br, current.bc, dir);
                
                int newRR = redResult[0];
                int newRC = redResult[1];
                int newBR = blueResult[0];
                int newBC = blueResult[1];
                
                boolean redInHole = (newRR == holeR && newRC == holeC);
                boolean blueInHole = (newBR == holeR && newBC == holeC);
                
                if(blueInHole) continue;
                
                if(redInHole) {
                    return 1;
                }
                
                if(newRR == newBR && newRC == newBC) {
                    int redDist = redResult[2];
                    int blueDist = blueResult[2];
                    
                    if(redDist > blueDist) {
                        newRR -= direction[dir][0];
                        newRC -= direction[dir][1];
                    } else {
                        newBR -= direction[dir][0];
                        newBC -= direction[dir][1];
                    }
                }
                
                if(!visited[newRR][newRC][newBR][newBC]) {
                    visited[newRR][newRC][newBR][newBC] = true;
                    queue.offer(new State(newRR, newRC, newBR, newBC, current.step + 1));
                }
            }
        }
        
        return 0;
    }
    
    static int[] moveBall(int r, int c, int dir) {
        int nr = r;
        int nc = c;
        int distance = 0;
        
        while(true) {
            int nextR = nr + direction[dir][0];
            int nextC = nc + direction[dir][1];
            
            if(board[nextR][nextC] == '#') break;
            
            nr = nextR;
            nc = nextC;
            distance++;
            
            if(board[nr][nc] == 'O') break;
        }
        
        return new int[]{nr, nc, distance};
    }
}