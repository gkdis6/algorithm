import java.io.*;
import java.util.*;

class Cell implements Comparable<Cell> {
    int r, c, waterLevel;

    Cell(int r, int c, int waterLevel) {
        this.r = r;
        this.c = c;
        this.waterLevel = waterLevel;
    }

    @Override
    public int compareTo(Cell other) {
        return Integer.compare(this.waterLevel, other.waterLevel);
    }
}

class WaterTrap_2D_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] heightMap;
    static int[][] waterLevel;
    static int N, M;

    // 상하좌우 방향
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        heightMap = new int[N][M];
        waterLevel = new int[N][M];

        // 높이 맵 입력 (숫자 또는 문자)
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                heightMap[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }

        int totalWaterTrapped = calculateWaterTrapped();
        System.out.println(totalWaterTrapped);
    }

    // 2D 배열에서 물이 고일 수 있는 총량 계산
    static int calculateWaterTrapped() {
        // 우선순위 큐 (수위가 낮은 순서로 처리)
        PriorityQueue<Cell> pq = new PriorityQueue<>();

        // 물 높이 배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(waterLevel[i], Integer.MAX_VALUE);
        }

        // 경계 셀들을 우선순위 큐에 추가
        addBoundaryCells(pq);

        // Dijkstra-like 알고리즘으로 최소 수위 계산
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int r = current.r;
            int c = current.c;
            int currentWaterLevel = current.waterLevel;

            // 이미 더 좋은 경로가 있다면 건너뛰기
            if (currentWaterLevel > waterLevel[r][c]) {
                continue;
            }

            // 인접한 4방향 확인
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (!isValidPosition(nr, nc)) {
                    continue;
                }

                // 새로운 수위는 현재 수위와 인접 셀의 높이 중 큰 값
                int newWaterLevel = Math.max(heightMap[nr][nc], currentWaterLevel);

                // 더 낮은 수위를 찾았다면 업데이트
                if (newWaterLevel < waterLevel[nr][nc]) {
                    waterLevel[nr][nc] = newWaterLevel;
                    pq.offer(new Cell(nr, nc, newWaterLevel));
                }
            }
        }

        // 총 고인 물의 양 계산
        return calculateTotalWater();
    }

    // 경계 셀들을 우선순위 큐에 추가
    static void addBoundaryCells(PriorityQueue<Cell> pq) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 경계 셀인지 확인
                if (isBoundaryCell(i, j)) {
                    waterLevel[i][j] = heightMap[i][j];
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                }
            }
        }
    }

    // 경계 셀 여부 확인
    static boolean isBoundaryCell(int r, int c) {
        return r == 0 || r == N - 1 || c == 0 || c == M - 1;
    }

    // 좌표가 유효한지 확인
    static boolean isValidPosition(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    // 총 고인 물의 양 계산
    static int calculateTotalWater() {
        int totalWater = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                totalWater += waterLevel[i][j] - heightMap[i][j];
            }
        }
        return totalWater;
    }

    // 특정 위치에서 고인 물의 양
    static int getWaterAtPosition(int r, int c) {
        if (!isValidPosition(r, c)) {
            return 0;
        }
        return waterLevel[r][c] - heightMap[r][c];
    }

    // 디버깅용: 수위 맵 출력
    static void printWaterLevel() {
        System.out.println("Water Level Map:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(waterLevel[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 디버깅용: 고인 물의 양 맵 출력
    static void printTrappedWater() {
        System.out.println("Trapped Water Map:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(getWaterAtPosition(i, j) + " ");
            }
            System.out.println();
        }
    }
}