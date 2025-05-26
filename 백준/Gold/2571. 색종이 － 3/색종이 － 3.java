import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] paper = new int[100][100];
    static int maxArea = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int r = y; r < y + 10; r++) {
                for (int c = x; c < x + 10; c++) {
                    paper[r][c] = 1;
                }
            }
        }

        int[] heights = new int[100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, getMaxAreaInHistogram(heights));
        }

        System.out.println(maxArea);
    }

    private static int getMaxAreaInHistogram(int[] h) {
        Stack<Integer> s = new Stack<>();
        int maxHistArea = 0;
        int i = 0;
        int n = h.length;

        while (i < n) {
            if (s.empty() || h[s.peek()] <= h[i]) {
                s.push(i++);
            } else {
                int top = s.pop();
                int area = h[top] * (s.empty() ? i : i - s.peek() - 1);
                maxHistArea = Math.max(maxHistArea, area);
            }
        }

        while (!s.empty()) {
            int top = s.pop();
            int area = h[top] * (s.empty() ? i : i - s.peek() - 1);
            maxHistArea = Math.max(maxHistArea, area);
        }
        return maxHistArea;
    }
}