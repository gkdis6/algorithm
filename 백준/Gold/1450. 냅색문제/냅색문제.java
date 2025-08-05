import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mid = N / 2;
        List<Integer> left = new ArrayList<>();
        for(int i = 0; i < (1 << mid); i++) {
            long sum = 0;
            for(int j = 0; j < mid; j++) {
                if((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
            }
            if(sum <= C) left.add((int) sum);
        }
        Collections.sort(left);

        long result = 0;
        for(int i = 0; i < (1 << (N - mid)); i++) {
            long sum = 0;
            for(int j = 0; j < N - mid; j++) {
                if((i & (1 << j)) != 0) {
                    sum += arr[mid + j];
                }
            }
            if(sum <= C) {
                int target = (int) (C - sum);
                int count = upperBound(left, target);
                result += count;
            }
        }
        System.out.println(result);
    }

    static int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}