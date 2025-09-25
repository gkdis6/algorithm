import java.io.*;
import java.util.*;

class Main {
    static class Cell {
        int r, c, waterLevel;

        Cell(int r, int c, int waterLevel) {
            this.r = r;
            this.c = c;
            this.waterLevel = waterLevel;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] waterLevel = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(waterLevel[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.waterLevel - b.waterLevel);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i == 0 || i == N-1 || j == 0 || j == M-1) {
                    waterLevel[i][j] = map[i][j];
                    pq.offer(new Cell(i, j, map[i][j]));
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()) {
            Cell cur = pq.poll();
            int r = cur.r;
            int c = cur.c;
            int curWaterLevel = cur.waterLevel;

            if(curWaterLevel > waterLevel[r][c]) continue;

            for(int d = 0; d < 4; d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                int newWaterLevel = Math.max(map[nr][nc], curWaterLevel);

                if(newWaterLevel < waterLevel[nr][nc]) {
                    waterLevel[nr][nc] = newWaterLevel;
                    pq.offer(new Cell(nr, nc, newWaterLevel));
                }
            }
        }

        int totalWater = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                totalWater += waterLevel[i][j] - map[i][j];
            }
        }

        System.out.println(totalWater);
    }
}