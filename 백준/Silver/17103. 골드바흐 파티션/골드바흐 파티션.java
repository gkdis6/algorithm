import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
//        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] num = new boolean[1000001];
        num[0] = num[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!num[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                    num[j] = true;
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            int cur = Integer.parseInt(br.readLine());
            int ans = 0;
            for(int j = 2; j<=cur/2; j++){
                if(!num[j] && !num[cur-j]) ans++;
            }
            System.out.println(ans);
        }
    }
}

