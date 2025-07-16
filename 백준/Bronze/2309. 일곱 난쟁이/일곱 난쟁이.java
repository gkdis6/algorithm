import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        dfs(arr, 0, 0, new int[7], 0);
    }

    static boolean dfs(int[] arr, int start, int count, int[] selected, int sum) {
        if (count == 7) {
            if (sum == 100) {
                for (int num : selected) {
                    System.out.println(num);
                }
                return true;
            }
            return false;
        }

        for (int i = start; i < arr.length; i++) {
            selected[count] = arr[i];
            if (dfs(arr, i + 1, count + 1, selected, sum + arr[i])) {
                return true;
            }
        }
        return false;
    }
}