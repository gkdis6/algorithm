import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum_map = new int[n][m];
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    sum_map[i][j] = map[i][j];
                } else if(i == 0) {
                    sum_map[i][j] = sum_map[i][j - 1] + map[i][j];
                } else if(j == 0) {
                    sum_map[i][j] = sum_map[i - 1][j] + map[i][j];
                } else {
                    sum_map[i][j] = sum_map[i - 1][j] + sum_map[i][j - 1] - sum_map[i - 1][j - 1] + map[i][j];
                }
                for(int k = 0; k <= i; k++) {
                    for(int l = 0; l <= j; l++) {
                        int current_sum = sum_map[i][j];
                        if(k > 0) {
                            current_sum -= sum_map[k - 1][j];
                        }
                        if(l > 0) {
                            current_sum -= sum_map[i][l - 1];
                        }
                        if(k > 0 && l > 0) {
                            current_sum += sum_map[k - 1][l - 1];
                        }
                        max_sum = Math.max(max_sum, current_sum);
                    }
                }
            }
        }
        System.out.println(max_sum);
    }
}