import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 10001); // Initialize with a large value
            map[i][i] = 0; // Distance to self is 0
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][k] != 10001 && map[k][j] != 10001) { // Check if paths exist
                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }
        }

        int min_sum = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i<n; i++) {
            int sum = Arrays.stream(map[i]).sum(); // Calculate the sum of distances for each node
            if(min_sum > sum) {
                min_sum = sum;
                result = i + 1;
            }
        }
        System.out.println(result);
    }
}
