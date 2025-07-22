import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int L = Integer.parseInt(br.readLine());
        int[][] dir = new int[L][2];
        
        Map<String, Integer> directionMap = new HashMap<>();
        directionMap.put("D", 1);
        directionMap.put("L", -1);

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i][0] = Integer.parseInt(st.nextToken());
            dir[i][1] = directionMap.get(st.nextToken());
        }
        System.out.println(snakeGame(N, K, arr, L, dir));
    }

    public static int snakeGame(int N, int K, int[][] arr, int L, int[][] dir) {
        int[][] board = new int[N][N];
        for (int[] apple : arr) {
            board[apple[0] - 1][apple[1] - 1] = 1;
        }
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        int time = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int[][] visited = new int[N][N];
        visited[0][0] = 1;
        int directionChangeIndex = 0;

        while (true) {
            time++;
            int newX = snake.getLast()[0] + directions[dirIndex][0];
            int newY = snake.getLast()[1] + directions[dirIndex][1];

            if (newX < 0 || newX >= N || newY < 0 || newY >= N || visited[newX][newY] == 1) {
                return time;
            }

            snake.add(new int[]{newX, newY});
            visited[newX][newY] = 1;

            if (board[newX][newY] == 1) {
                board[newX][newY] = 0;
            } else {
                visited[snake.getFirst()[0]][snake.getFirst()[1]] = 0;
                snake.pollFirst();
            }

            if (directionChangeIndex < L && time == dir[directionChangeIndex][0]) {
                dirIndex = (dirIndex + dir[directionChangeIndex][1] + 4) % 4;
                directionChangeIndex++;
            }
        }
    }
}