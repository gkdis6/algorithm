import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        for(int i = 0; i <arr[0].length(); i++) {
            char c = arr[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < N; j++) {
                if (arr[j].charAt(i) != c) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                System.out.print(c);
            } else {
                System.out.print("?");
            }
        }
    }
}