import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] times = new long[n];
        for(int i = 0; i < n; i++) {
            times[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length-1]*m;
        long answer = 0;
        while(left<=right){
        	long mid = (left+right)/2;
            long pointer = 0;
            for(int i = 0; i<times.length; i++){
                pointer += mid/times[i];
                if(pointer >= m) break;
            }
            if(pointer >= m) {
            	right = mid-1;
            	answer = mid;
            }
            else left = mid+1;
        }
        System.out.println(answer);
    }
}