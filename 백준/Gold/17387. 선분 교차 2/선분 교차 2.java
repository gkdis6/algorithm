import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long[][] a = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = Long.parseLong(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        long[][] b = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                b[i][j] = Long.parseLong(st.nextToken());
            }
        }

        int abc = ccw(a[0], a[1], b[0]);
        int abd = ccw(a[0], a[1], b[1]);
        int cda = ccw(b[0], b[1], a[0]);
        int cdb = ccw(b[0], b[1], a[1]);

        if (abc * abd == 0 && cda * cdb == 0) {
            if (Math.min(a[0][0], a[1][0]) <= Math.max(b[0][0], b[1][0]) &&
                Math.min(b[0][0], b[1][0]) <= Math.max(a[0][0], a[1][0]) &&
                Math.min(a[0][1], a[1][1]) <= Math.max(b[0][1], b[1][1]) &&
                Math.min(b[0][1], b[1][1]) <= Math.max(a[0][1], a[1][1])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(abc * abd <= 0 && cda * cdb <= 0 ? 1 : 0);
        }
    }

    static int ccw(long[] p1, long[] p2, long[] p3) {
        long cross = (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p2[1] - p1[1]) * (p3[0] - p1[0]);
        if (cross > 0) return 1;
        if (cross < 0) return -1;
        return 0;
    }
}