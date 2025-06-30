import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] workTime = new int[N + 1];
        int[] finishTime = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            workTime[i] = time;

            int maxPreTime = 0;
            for (int j = 0; j < M; j++) {
                int preWork = Integer.parseInt(st.nextToken());
                maxPreTime = Math.max(maxPreTime, finishTime[preWork]);
            }
            finishTime[i] = maxPreTime + time;
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, finishTime[i]);
        }
        System.out.println(result);
    }
}