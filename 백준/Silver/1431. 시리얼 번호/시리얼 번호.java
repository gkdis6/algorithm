import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            int aSum = 0, bSum = 0;
            for (char c : a.toCharArray()) {
                if(Character.isDigit(c)) {
                    aSum += c - '0';
                }
            }
            for (char c : b.toCharArray()) {
                if(Character.isDigit(c)) {
                    bSum += c - '0';
                }
            }
            if (aSum != bSum) {
                return aSum - bSum;
            }
            
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }
}