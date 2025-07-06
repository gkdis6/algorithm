import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> availableNumbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            availableNumbers.add(i);
        }

        Stack<Integer> stack = new Stack<>();
        boolean possible = true;
        for (int i = N - 1; i >= 0; i--) {
            int smallerCount = arr[i];

            if (smallerCount >= availableNumbers.size()) {
                possible = false;
                break;
            }

            int value = availableNumbers.remove(smallerCount);
            
            stack.push(value);
        }

        if (!possible) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}