import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N = 12, M = 6, result = 0;
    static char[][] map = new char[N][M];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        while (true) {
            if (!pop()) {
                break;
            }
            result++;
            down();
        }
        System.out.println(result);
    }

    static void down() {
        for (int j = 0; j < M; j++) {
            int emptyRow = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] != '.') {
                    map[emptyRow][j] = map[i][j];
                    if (emptyRow != i) {
                        map[i][j] = '.';
                    }
                    emptyRow--;
                }
            }
        }
    }

    static boolean pop() {
        boolean[][] visited = new boolean[N][M];
        boolean popped = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '.' && !visited[i][j]) {
                    List<int[]> toPop = new ArrayList<>();
                    char color = map[i][j];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    toPop.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        for (int[] dir : new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
                            int ni = pos[0] + dir[0], nj = pos[1] + dir[1];
                            if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == color && !visited[ni][nj]) {
                                visited[ni][nj] = true;
                                queue.add(new int[]{ni, nj});
                                toPop.add(new int[]{ni, nj});
                            }
                        }
                    }

                    if (toPop.size() >= 4) {
                        popped = true;
                        for (int[] p : toPop) {
                            map[p[0]][p[1]] = '.';
                        }
                    }
                }
            }
        }
        return popped;
    }
}

