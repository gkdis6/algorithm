import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] command = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> que = new ArrayDeque<>();
            String line = br.readLine();
            line = line.substring(1, line.length() - 1);
            String[] split = line.split(",");
            for (int i = 0; i < N; i++) {
                que.add(Integer.parseInt(split[i]));
            }

            boolean reverse = false;
            boolean error = false;
            
            for (char c : command) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (que.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reverse) {
                        que.removeLast();
                    } else {
                        que.removeFirst();
                    }
                }
            }
            
            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (!que.isEmpty()) {
                    if (reverse) {
                        Iterator<Integer> it = que.descendingIterator();
                        while (it.hasNext()) {
                            sb.append(it.next());
                            if (it.hasNext()) sb.append(",");
                        }
                    } else {
                        Iterator<Integer> it = que.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next());
                            if (it.hasNext()) sb.append(",");
                        }
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}