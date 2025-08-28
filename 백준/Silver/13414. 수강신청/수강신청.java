import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Boolean> waitingList = new LinkedHashMap<>();

        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();

            if (waitingList.containsKey(studentId)) {
                waitingList.remove(studentId);
            }
            waitingList.put(studentId, true);
        }

        int count = 0;
        for (String studentId : waitingList.keySet()) {
            if (count >= K) break;
            System.out.println(studentId);
            count++;
        }

        br.close();
    }
}