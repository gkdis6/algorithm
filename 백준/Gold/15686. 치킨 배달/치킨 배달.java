import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> houses = new ArrayList<>();
        List<int[]> chickens = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (board[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        
        int min_distance = Integer.MAX_VALUE;
        
        for (int mask = 0; mask < (1 << chickens.size()); mask++) {
            if (Integer.bitCount(mask) > m) continue;
            if (Integer.bitCount(mask) == 0) continue;
            
            int total_distance = 0;
            for (int[] house : houses) {
                int min_chicken_distance = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if ((mask & (1 << i)) != 0) {
                        int[] chicken = chickens.get(i);
                        int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                        min_chicken_distance = Math.min(min_chicken_distance, distance);
                    }
                }
                total_distance += min_chicken_distance;
            }
            min_distance = Math.min(min_distance, total_distance);
        }
        
        System.out.println(min_distance);
    }
}