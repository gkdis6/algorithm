import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int K = Integer.parseInt(br.readLine());
        
        Map<String, Integer> patternCount = new HashMap<>();

        for(String pattern : arr) {
            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
        }

        int maxCount = 0;
        for(Map.Entry<String, Integer> entry : patternCount.entrySet()) {
            String pattern = entry.getKey();
            int count = entry.getValue();

            int needSwitches = (int) pattern.chars().filter(c -> c == '0').count();

            if(K >= needSwitches && (K - needSwitches) % 2 == 0) {
                maxCount = Math.max(maxCount, count);
            }
        }
        System.out.println(maxCount);
    }
}