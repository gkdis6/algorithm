import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum_map = new int[n][n];
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    sum_map[i][j] = map[i][j];
                } else if(i == 0) {
                    sum_map[i][j] = sum_map[i][j - 1] + map[i][j];
                } else if(j == 0) {
                    sum_map[i][j] = sum_map[i - 1][j] + map[i][j];
                } else {
                    sum_map[i][j] = sum_map[i - 1][j] + sum_map[i][j - 1] - sum_map[i - 1][j - 1] + map[i][j];
                }
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    int r2 = i + k - 1;
                    int c2 = j + k - 1;

                    int current_sum = sum_map[r2][c2];
                    if (i > 0) {
                        current_sum -= sum_map[i - 1][c2];
                    }

                    if (j > 0) {
                        current_sum -= sum_map[r2][j - 1];
                    }

                    if (i > 0 && j > 0) {
                        current_sum += sum_map[i - 1][j - 1];
                    }

                    max_sum = Math.max(max_sum, current_sum);
                }
            }
        }

        System.out.println(max_sum);
    }
}
