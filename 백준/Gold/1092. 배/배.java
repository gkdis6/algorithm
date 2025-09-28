import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] cranes = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] boxes = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes);
        Arrays.sort(boxes);
        
        int[] count = new int[N];
        int ptr = 0;
        for(int i = 0; i < M; i++) {
            if(boxes[i] > cranes[ptr]) {
                ptr++;
                if(ptr == N) {
                    System.out.println(-1);
                    return;
                }
                i--;
            }else {
                count[ptr]++;
            }
        }

        while(true){
            boolean done = true;
            for(int i = 0; i < N - 1; i++) {
                if(count[i] > count[i + 1]) {
                    count[i + 1]++;
                    count[i]--;
                    done = false;
                }
            }
            if(done) {
                break;
            }
        }

        int time = 0;
        while(true) {
            boolean done = true;
            for(int i = 0; i < N; i++) {
                if(count[i] > 0) {
                    count[i]--;
                    done = false;
                }
            }
            if(done) {
                break;
            }
            time++;
        }
        System.out.println(time);
    }
}